from django.urls import path
from . import views

app_name = "board"

urlpatterns = [
    # http://127.0.0.1:8000/board/
    path("", views.question_list, name="question_list"),
    # http://127.0.0.1:8000/board/1
    path("<int:qid>/", views.question_detail, name="question_detail"),
    # http://127.0.0.1:8000/board/question/create
    path("question/create/", views.question_create, name="question_create"),
    # http://127.0.0.1:8000/board/question/modify/1
    path("question/create/modify/<int:qid>/", views.question_modify, name="question_modify"),
    # http://127.0.0.1:8000/board/question/delete/1
    path("question/create/delete/<int:qid>/", views.question_delete, name="question_delete"),

    # 답변
    # http://127.0.0.1:8000/board/answer/create/2 (질문번호)
    path("answer/create/<int:qid>/", views.answer_create, name="answer_create"),
    # http://127.0.0.1:8000/board/answer/modify/2 (질문번호)
    path("answer/create/modify/<int:aid>/", views.answer_modify, name="answer_modify"),
    # http://127.0.0.1:8000/board/answer/delete/2 (질문번호)
    path("answer/create/delete/<int:aid>/", views.answer_delete, name="answer_delete"),

    # 댓글
    # http://127.0.0.1:8000/board/comment/create/question/1 <question_id>
    path("comment/create/question/<int:qid>/", views.comment_create_question, name="comment_create_question"),
    # http://127.0.0.1:8000/board/comment/modify/question/1 <comment_id>
    path("comment/modify/question/<int:cid>/", views.comment_modify_question, name="comment_modify_question"),
    # http://127.0.0.1:8000/board/comment/delete/question/1
    path("comment/delete/question/<int:cid>/", views.comment_delete_question, name="comment_delete_question"),


    # http://127.0.0.1:8000/board/comment/create/answer/1 <answer_id>
    path("comment/create/answer/<int:aid>/", views.comment_create_answer, name="comment_create_answer"),
    # http://127.0.0.1:8000/board/comment/modify/answer/1 <comment_id>
    path("comment/modify/answer/<int:cid>/", views.comment_modify_answer, name="comment_modify_answer"),
    # http://127.0.0.1:8000/board/comment/delete/answer/1
    path("comment/delete/answer/<int:cid>/", views.comment_delete_answer, name="comment_delete_answer"),
     

    # 추천
    # http://127.0.0.1:8000/board/vote/question/1 <question id> : 질문추천
    path("vote/question/<int:qid>/", views.vote_question, name="vote_question"),
    # http://127.0.0.1:8000/board/vote/answer/1 <answer id> : 답변추천
     path("vote/answer/<int:aid>/", views.vote_answer, name="vote_answer")
]

