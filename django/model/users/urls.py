from django.urls import path
from . import views

urlpatterns = [
    path("register/", views.register, name="register"),
    path("lgoin/", views.common_login, name="login"),
]
