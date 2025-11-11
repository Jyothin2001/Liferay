from fastapi import FastAPI, Depends, HTTPException
from sqlmodel import Session
from .database import init_db, engine, get_session
from .models import User, Post
from .crud import create_user, get_users, create_post, get_posts

app = FastAPI(title='CompetitionSite API')

@app.on_event('startup')
def on_startup():
    init_db()
    with Session(engine) as session:
        users = session.exec('SELECT * FROM user').all()
        if not users:
            create_user(session, 'Admin', 'admin@example.com', is_admin=True)
            create_user(session, 'Alice', 'alice@example.com')
            create_post(session, 'Welcome', 'This is a sample post', author_id=1)

@app.get('/health')
def health():
    return {'status': 'ok'}

@app.get('/users')
def api_get_users(session: Session = Depends(get_session)):
    return get_users(session)

@app.post('/users')
def api_create_user(payload: dict, session: Session = Depends(get_session)):
    if not payload.get('name') or not payload.get('email'):
        raise HTTPException(status_code=400, detail='name & email required')
    user = create_user(session, payload['name'], payload['email'], payload.get('is_admin', False))
    return user

@app.get('/posts')
def api_get_posts(session: Session = Depends(get_session)):
    return get_posts(session)

@app.post('/posts')
def api_create_post(payload: dict, session: Session = Depends(get_session)):
    return create_post(session, payload.get('title', 'Untitled'), payload.get('content', ''), payload.get('author_id'))
