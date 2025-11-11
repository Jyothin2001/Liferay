from sqlmodel import select
from .models import User, Post

def create_user(session, name, email, is_admin=False):
    u = User(name=name, email=email, is_admin=is_admin)
    session.add(u)
    session.commit()
    session.refresh(u)
    return u

def get_users(session):
    return session.exec(select(User)).all()

def create_post(session, title, content, author_id=None):
    p = Post(title=title, content=content, author_id=author_id)
    session.add(p)
    session.commit()
    session.refresh(p)
    return p

def get_posts(session):
    return session.exec(select(Post)).all()
