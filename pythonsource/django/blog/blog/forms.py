from django import forms
from .models import Post

class PostForm(forms.ModelForm):
    class Meta:
        model = Post
        # title, content, user, image, created_at, modified_at 전부 포함
        # user 막아놨을 때 오류 발생
        # fields = '__all__'
        # user 제외하고 나열 (~at 은 자동생성이라 제외)
        fields = ["title","content","image", "tags"]