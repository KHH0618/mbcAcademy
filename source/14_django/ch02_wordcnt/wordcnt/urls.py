from django.urls import path
from wordcnt import views

app_name = 'wordcnt'

urlpatterns = [
    path('', views.wordinput, name='wordinput'),
]