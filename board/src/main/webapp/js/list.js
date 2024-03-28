// page 영역 가져오기
const pagination = document.querySelector(".pagination");
console.log(pagination);

// 검색 폼
// criteria, keyword 비어있는지 확인
document.querySelector("[name='search']").addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector("[name='criteria']");
  const keyword = document.querySelector("[name='keyword']");

  if (criteria.value == "n") {
    alert("검색조건을 선택해주세요");
    criteria.focus();
    return;
  } else if (!keyword.value) {
    alert("검색어를 확인해주세요");
    keyword.focus();
    return;
  }
  e.target.submit();
});
