from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
    context = {'msg':'WordCount Welcome Page', 'greeting':'Hello, Django(장고)'}
    return  render(request,
                   'home/index.html',
                   context)

def test(request):
    return HttpResponse(""" <h1> 테스트 페이지 </h1>
        <button onclick="location='/'"> 뒤로가기 </button>
    """)

def showIntId(request:HttpResponse, id:int):
    msg = "숫자 ID는" + str(id)
    id_type = "숫자입니다"
    return render(request, 'home/showId.html', {'msg':msg, 'type':id_type})

def showStrId(request, id):
    msg = "문자 ID 는" + id
    id_type = "문자입니다"
    return render(request, 'home/showId.html', {'msg': msg, 'type': id_type})