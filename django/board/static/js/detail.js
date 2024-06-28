const deleteAll = document.querySelector(".delete");

deleteAll.forEach((item) => {
  item.addEventListener("click", (e) => {
    e.preventDefault();
    // href 가져오기
    const hred = e.target.getAttribute("href");
    if (confirm("정말로 삭제하시겠습니까?")) {
      location.href = "";
    }
  });
});
