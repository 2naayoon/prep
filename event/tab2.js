// tab.js 수정 (간략화)

// 세 개의 li, div 찾기 : querySelectorAll()
const allLi = document.querySelectorAll(".tap-button");
const allDiv = document.querySelectorAll(".tab-content");

allLi.forEach((li, idx) => {
  li.addEventListener("click", (e) => {
    // 모든 li 에 orange 클래스명 제거
    // 현재 이벤트가 일어난 li orange 클래스명 추가
    allLi.forEach((item) => {
      item.classList.remove("orange");
    });
    e.target.classList.add("orange");

    // 모든 div 의 show 제거
    // 현재 이벤트가 일어난 li 와 순서가 일치하는 div show 추가
    allDiv.forEach((item) => {
      item.classList.remove("show");
    });
    allDiv[idx].target.classList.add("show");
  });
});
