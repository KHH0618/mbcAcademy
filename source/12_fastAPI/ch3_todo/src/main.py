from os.path import abspath

from fastapi import FastAPI
from fastapi import Request # 특정 요청경로에서 template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse # redirect
# from pydantic import BaseModel # 자동 타입 체크
from models import ToDoRequest
from fastapi import Form
from fastapi import HTTPException
import os

BASE_DIR = os.path.dirname(os.path.abspath(__file__))

app = FastAPI()
app.mount('/static', StaticFiles(directory=os.path.join(BASE_DIR, '../static')), name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR, '../templates'))

todo_data = {
    1:{
        'id':1,
        'contents':'딥러닝 공부',
        'is_done' : True
    },
    2:{
        'id':2,
        'contents':'fast API 공부',
        'is_done' : False
    },
    3:{
        'id':3,
        'contents':'머신러닝 공부',
        'is_done' : False
    },
    4:{
        'id':4,
        'contents':'Django 공부',
        'is_done' : False
    }
}

@app.get('/')
# async def health_check_handler():
#     return  {'status':'ok'}

# /todos(할일 1부터 출력) 또는 /todos?order=desc(할일 역순으로 출력)
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request, order:str|None=None):
    todos = list(todo_data.values())
    if order and order.lower() == 'desc':
        todos = todos[::-1]
    next_id = max(todo_data.keys())+1
    return templates.TemplateResponse('todos.html', # todo 목록, todo 입력 form
                                      {'request':request,
                                       'todos':todos,
                                       'next_id':next_id,
                                       'order':order.lower() if order else ''}
                                      )

@app.get('/todos/{todo_id}')
async def  get_todo_detail_handler(request:Request, todo_id:int):
    todo = todo_data.get(todo_id, {})
    return templates.TemplateResponse('todo.html', {'request':request, 'todo':todo})

@app.post('/create')
async def create_todo_handler(todo:ToDoRequest=Form()):
    # print('form태그로 부터 입력된 todo', todo)
    todo_data[todo.id] = todo.dict()
    return RedirectResponse('/todos')

@app.delete('/delete/{todo_id}')
async def delete_todo_handler(todo_id:int):
    # key가 없는 todo_id를 이력할 경우 None
    todo = todo_data.pop(todo_id,None)
    if todo:
        return f'{todo_id}번 todo 삭제 성공'
    else:
        return f'{todo_id}는 등록되지 않는 todo여서 삭제 실패'