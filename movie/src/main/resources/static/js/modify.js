const form = document.querySelector("#actionForm");

document.querySelector(".btn-danger").addEventListener("click", () => {
  if (!confirm("삭제하시겠습니까?")) {
    return;
  }

  form.submit();
});
