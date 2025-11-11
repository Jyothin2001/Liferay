from flask import Flask, jsonify, request
from flask_cors import CORS
from sqlmodel import SQLModel, create_engine, Session, select, Field
from typing import Optional

app = Flask(__name__)
CORS(app)
engine = create_engine('sqlite:///./flask.db', connect_args={'check_same_thread': False})

class User(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    email: str

SQLModel.metadata.create_all(engine)

@app.route('/users')
def users():
    with Session(engine) as s:
        rows = s.exec(select(User)).all()
        return jsonify([r.dict() for r in rows])

@app.route('/users', methods=['POST'])
def create_user():
    data = request.json
    with Session(engine) as s:
        u = User(name=data['name'], email=data['email'])
        s.add(u)
        s.commit()
        s.refresh(u)
        return jsonify(u.dict())

if __name__ == '__main__':
    app.run(port=8000, debug=True)
