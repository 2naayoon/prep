from django.db import models

# 테이블과 동일한 모델 정의
class Todo(models.Model):
    title = models.CharField(max_length=50)
    description = models.TextField()
    # auto_now_add : 새 글 등록 시 자동으로 날짜 추가
    created_at = models.DateTimeField(auto_now_add=True)
    completed = models.BooleanField(default=False)
    important = models.BooleanField(default=False)

    # toString() 과 같은 역할 (객체 안의 주소X 내용만 나오기) - 제목만 나옴
    def __str__(self) -> str:
        return self.title
    
