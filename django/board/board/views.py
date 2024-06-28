from django.shortcuts import render, redirect, get_object_or_404, resolve_url
from .models import Question, Answer, Comment
from .forms import QuestionForm, AnswerForm, CommentForm

from django.core.paginator import Paginator
from django.contrib.auth.decorators import login_required

from django.utils import timezone

from django.contrib import messages

# 로그인 권한 필요, 로그인 페이지로 이동
@login_required(login_url="common:login")
def question_create(request):
    if request.method == "POST":
        form = QuestionForm(request.POST)
        if form.is_valid():
            question = form.save(commit=False)
            # 작성자 = 로그인 유저
            question.author = request.user
            question.save()
            return redirect("board:question_list")
    else:
        form = QuestionForm()

    return render(request, "board/question_form.html", {"form":form})


@login_required(login_url="common:login")
def question_modify(request, qid):
    # qid 에 해당하는 question 찾은 후
    # 변경할 부분 수정 후 save()

    question = get_object_or_404(Question, id=qid)

    if request.method == "POST":
        form = QuestionForm(request.POST, instance=question)
        if form.is_valid():
            question = form.save(commit=False)
            question.modified_at = timezone.now()
            question.save()
            return redirect("board:question_detail", qid=qid)

    else:
        form = QuestionForm(instance=question)

    return render(request, "board/question_form.html", {"form":form})


@login_required(login_url="common:login")
def question_delete(request, qid):
    question = get_object_or_404(Question, id=qid)
    question.delete()
    return redirect("board:question_list")


def question_list(request):
    """전체 질문 추출"""

    # 현재 페이지 번호 가져오기
    page = request.GET.get("page",1)

    # question_list = Question.objects.all()
    question_list = Question.objects.order_by("-created_at")

    paginator = Paginator(question_list, 10)
    page_obj = paginator.get_page(page)

    context = {"question_list": page_obj}
    return render(request, "board/question_list.html", context)


def question_detail(request, qid):
    question = get_object_or_404(Question, id=qid)
    context = {"question": question}
    return render(request, "board/question_detail.html", context)


@login_required(login_url="common:login")
def answer_create(request, qid):
    """답변등록"""

    question = get_object_or_404(Question, id=qid)
    if request.method == "POST":
        form = AnswerForm(request.POST)
        if form.is_valid():
            # question 을 안 갖고 있음 → db 반영을 일단 끊음 → answer 로 form 을 사용하는 방식으로 바꿈
            answer = form.save(commit=False)
            answer.question = question
            # 작성자 정보 추가
            answer.author = request.user
            answer.save()
            # return redirect("board:question_detail", qid=qid)
            # 디테일의 특정 영역을 보여주기 (답변 달고 해당 답변 영역)
            return redirect("{}#answer_{}".format(resolve_url("board:question_detail", qid=qid), answer.id))
            
    else:
        form = AnswerForm()


    # 폼에 있는 content 가져오기 
    # 1. answer = Answer.objects.create(question=question, content=request.POST.get("content"))

    # 2. question.answer_set.create(content=request.POST.get("content"))

    # 3. answer =  Answer(question=question, content=request.POST.get("content"))
    #    answer.save()

    # return redirect("board:question_detail", qid=qid)

    # 실패 시(else) get 방식으로 처리
    context = {"question":question, "form":form}
    return render(request, "board/question_detail.html", context)

@login_required(login_url="common:login")
def answer_modify(request, aid):
    # 수정 성공 - detail 페이지
    answer = get_object_or_404(Answer, id=aid)

    if request.method == "POST":
        form = AnswerForm(request.POST, instance=answer)
        if form.is_valid():
            answer = form.save(commit=False)
            answer.modified_at = timezone.now()
            answer.save()
            # return redirect("board:question_detail", qid=answer.question.id)
            return redirect("{}#answer_{}".format(resolve_url("board:question_detail", qid=answer.question.id), answer.id))

    else:
        form = AnswerForm(instance=answer)

    return render(request, "board/answer_form.html", {"form":form})

@login_required(login_url="common:login")
def answer_delete(request, aid):
    answer = get_object_or_404(Answer, id=aid)
    answer.delete()

    # question id
    return redirect("board:question_detail", answer.question.id)


@login_required(login_url="common:login")
def comment_create_question(request, qid):
    question = get_object_or_404(Question, id=qid)
    if request.method == "POST":
        form = CommentForm(request.POST)
        comment = form.save(commit=False)
        comment.author = request.user
        comment.question = question
        comment.save()
        # return redirect("board:question_detail", qid)
        return redirect("{}#comment_{}".format(resolve_url("board:question_detail", qid=qid), comment.id))
    else:
        form = CommentForm()
    return render(request, "board/comment_form.html", {"form":form})

# 질문 댓글
@login_required(login_url="common:login")
def comment_modify_question(request, cid):
    comment = get_object_or_404(Comment, id=cid)
    if request.method == "POST":
        form = CommentForm(request.POST, instance=comment)
        comment = form.save(commit=False)
        comment.modified_at = timezone.now()
        comment.save()
        # return redirect("board:question_detail", comment.question.id)
        return redirect("{}#comment_{}".format(resolve_url("board:question_detail", qid=comment.question.id), comment.id))
    else:
        form = CommentForm(instance=comment)
    return render(request, "board/comment_form.html", {"form":form})

@login_required(login_url="common:login")
def comment_delete_question(request, cid):
    comment = get_object_or_404(Comment, id=cid)
    comment.delete()
    return redirect("board:question_detail", comment.question.id)

# 답변 댓글
@login_required(login_url="common:login")
def comment_create_answer(request, aid):
    answer = get_object_or_404(Answer, id=aid)
    if request.method == "POST":
        form = CommentForm(request.POST)
        comment = form.save(commit=False)
        comment.author = request.user
        comment.answer = answer
        comment.save()
        # return redirect("board:question_detail", answer.question.id)
        return redirect("{}#comment_{}".format(resolve_url("board:question_detail", qid=answer.question.id), comment.id))
    else:
        form = CommentForm()
    return render(request, "board/comment_form.html", {"form":form})

@login_required(login_url="common:login")
def comment_modify_answer(request, cid):
    comment = get_object_or_404(Comment, id=cid)
    if request.method == "POST":
        form = CommentForm(request.POST, instance=comment)
        comment = form.save(commit=False)
        comment.modified_at = timezone.now()
        comment.save()
        # return redirect("board:question_detail", comment.answer.question.id)
        return redirect("{}#comment_{}".format(resolve_url("board:question_detail", qid=comment.answer.question.id), comment.id))
    else:
        form = CommentForm(instance=comment)
    return render(request, "board/comment_form.html", {"form":form})

@login_required(login_url="common:login")
def comment_delete_answer(request, cid):
    comment = get_object_or_404(Comment, id=cid)
    comment.delete()
    return redirect("board:question_detail", comment.answer.question.id)


# 추천
@login_required(login_url="common:login")
def vote_question(request, qid):
    question = get_object_or_404(Question, id=qid)

    # 내가 작성한 글은 추천못함
    if question.author == request.user:
        messages.error(request, "본인이 작성한 글은 추천할 수 없습니다.")
    else:
        question.voter.add(request.user)
    return redirect("board:question_detail", qid)

@login_required(login_url="common:login")
def vote_answer(request, aid):
    answer = get_object_or_404(Answer, id=aid)

    # 내가 작성한 글은 추천못함
    if answer.author == request.user:
        messages.error(request, "본인이 작성한 글은 추천할 수 없습니다.")
    else:
        answer.voter.add(request.user)
    return redirect("board:question_detail", answer.question.id)