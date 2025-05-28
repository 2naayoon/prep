// * Error: Integer.parseInt("") → NumberFormatException 발생 - 클라이언트 단에서 막기
// submit 발생 시
// submit 기능 중지
document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector("#criteria");
  const keyword = document.querySelector("#keyword");

  console.log(criteria.value);

  // criteria, keyword 비어 있는지 확인
  if (criteria.value == "검색 조건 선택") {
    alert("조건을 선택해 주세요");
    code.focus();
    return;
  } else if (!keyword.value) {
    alert("검색어를 확인해 주세요.");
    keyword.focus();
    return;
  }
  // 값이 존재한다면 submit
  e.target.submit();
});
