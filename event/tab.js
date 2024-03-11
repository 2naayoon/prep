// orange
// li 클릭 시 orange 클래스명 움직이기

// show
// 첫번째 li 클릭 시 척번째 div 보여주기

// 세 개의 li 찾기
const firstLi = document.querySelector(".list li:first-child");
const secondLi = document.querySelector(".list li:nth-child(2)");
const thirdLi = document.querySelector(".list li:last-child");

// 세 개의 div 찾기
const firstDiv = document.querySelector(".container div:nth-child(2)");
const secondDiv = document.querySelector(".container div:nth-child(3)");
const thirdDiv = document.querySelector(".container div:last-child");

firstLi.addEventListener("click", (e) => {
  // 다른 li 에 orange 클래스명 제거
  // firstLi orange 클래스명 추가
  secondLi.classList.remove("orange");
  thirdLi.classList.remove("orange");
  firstLi.classList.add("orange");

  // 다른 div 의 show 제거
  // 첫번째 div show 추가
  secondDiv.classList.remove("show");
  thirdDiv.classList.remove("show");
  firstDiv.classList.add("show");
});
secondLi.addEventListener("click", (e) => {
  firstLi.classList.remove("orange");
  thirdLi.classList.remove("orange");
  secondLi.classList.add("orange");

  firstDiv.classList.remove("show");
  thirdDiv.classList.remove("show");
  secondDiv.classList.add("show");
});
thirdLi.addEventListener("click", (e) => {
  secondLi.classList.remove("orange");
  firstLi.classList.remove("orange");
  thirdLi.classList.add("orange");

  secondDiv.classList.remove("show");
  firstDiv.classList.remove("show");
  thirdDiv.classList.add("show");
});
