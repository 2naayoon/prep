from django.urls import path
from django.contrib.auth import views as auth_views
from django.urls import reverse_lazy

from . import views

# views 안 만들고 auth views 사용
app_name = "common"

urlpatterns = [
    path("register/", views.register, name="register"),
    # 로그인, 로그아웃 만드는 대신 이렇게 장고 것 불러와서 사용
    # login 처리를 하는 뷰가 함수형뷰가 아니라 클래스뷰임
    # 클래스뷰를 함수형처럼 사용하려면 as_view() 사용
    path("login/", auth_views.LoginView.as_view(), name="login"),
    path("logout/", auth_views.LogoutView.as_view(), name="logout"),
    # 기존 비밀번호 변경 후 세션 값 다시 담아줌
    # common:password_reset_done 내 거랑 연결
    path("password_change/", auth_views.PasswordChangeView.as_view(template_name="registration/password_change.html",
                                                                   success_url=reverse_lazy("common:password_reset_done")), name="password_change"),
    # 비밀번호 초기화
    # 장고 reset 가는 거
    # path("password_reset/", auth_views.PasswordResetView.as_view(), name="password_reset"),
    # 내 reset html 가기
    path("password_reset/", auth_views.PasswordResetView.as_view(template_name="registration/password_reset.html",
                                                                 email_template_name="registration/password_reset_email.txt",
                                                                   success_url=reverse_lazy("common:password_reset_done")), name="password_reset"),
    path("password_reset/done", auth_views.PasswordResetDoneView.as_view(template_name="registration/password_reset_done.html"), name="password_reset_done"),
    path("reset/<uidb64>/<token>/", auth_views.PasswordResetConfirmView.as_view(template_name="registration/password_reset_confirm.html", success_url=reverse_lazy("common:password_reset_complete")), name="password_reset_confirm"),
    path("reset/done/", auth_views.PasswordResetCompleteView.as_view(), name="password_reset_complete")
]
