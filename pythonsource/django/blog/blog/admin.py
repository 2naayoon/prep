from django.contrib import admin
from .models import Post, Comment


# 간단하게 admin 설정
# admin.site.register(Post)
# admin.site.register(Comment)

# admin 사이트 변경
class PostAdmin(admin.ModelAdmin):
    # 보여줄 리스트
    list_display = ('title','created_at')
    # 링크 걸 항목
    list_display_links = ['title']
    # 검색
    search_fields = ['title']

class CommentAdmin(admin.ModelAdmin):
    list_display = ('user', 'created_at')

admin.site.register(Post, PostAdmin)
admin.site.register(Comment, CommentAdmin)