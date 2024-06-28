// 검색어 가져오기
// 없는 경우 alert()

// 있는 경우
// actionForm keyword value 에 삽입
//                      page value 1로 변경

const actionForm = document.querySelector("#actionForm");
document.querySelector("#btn_search").addEventListener("click", () => {
  const top_keyword = document.querySelector("#top_keyword");

  if (top_keyword.value === "") {
    alert("검색어를 입력해 주세요");
    top_keyword.focus();
    return;
  }

  actionForm.querySelector("#keyword").value = top_keyword.value;
  actionForm.querySelector("#page").value = 1;
  //   acitonForm.submit()
});
