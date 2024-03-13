const txtYear = document.querySelector("#txtYear");
const selMon = document.querySelector("#selMon");
const selDay = document.querySelector("#selDay");

// 어제 날짜 구하기
const init = () => {
  // 오늘 날짜 구하기
  const today = new Date();

  // 년, 월, 일 변수에 담기
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  let day = today.getDate() - 1;

  // 화면에 보여주기
  txtYear.value = year;
  // selMon.value = month;
  // 1~9월 : "0"+month → 01, 02, ...
  // 1~9일 : "0"+day → 01, 02, ...

  //   if (month < 10) {
  //     month = "0" + month;
  //   }
  //   if (day < 10) {
  //     day = "0" + day;
  //   }
  //   selMon.value = month;
  //   selDay.value = day;
  selMon.value = month < 10 ? "0" + month : month;
  selDay.value = day < 10 ? "0" + day : day;
};

init();

function show(movieCd) {
  console.log(movieCd);

  url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
  url += movieCd;

  // 영화한글제목(movieNm), 영어제목(movieNmEn), 상영시간(showTm), 감독(directors), 배우(actors)
  fetch(url)
    .then((response) => {
      if (!response.ok) throw new Error();
      return response.json();
    })
    .then((data) => {
      console.log(data);
      let result = "";

      let movieInfo = data.movieInfoResult.movieInfo;
      let movieNm = movieInfo.movieNm;
      let movieNmEn = movieInfo.movieNmEn;
      let showTm = movieInfo.showTm;
      // 감독, 배우 배열
      let directors = "";
      movieInfo.directors.forEach((director) => {
        directors += `${director.peopleNm} `;
      });
      let actors = "";
      movieInfo.actors.forEach((actor) => {
        actors += `${actor.peopleNm} `;
      });

      result += `<ul><li> 영화제목 : ${movieNm}</li>`;
      result += `<li> 영어제목 : ${movieNmEn}</li>`;
      result += `<li> 상영시간 : ${showTm}분</li>`;
      result += `<li> 감독 : ${directors}</li>`;
      result += `<li> 출연배우 : ${actors}</li>`;
      result += `</ul>`;
      document.querySelector(".box2").innerHTML = result;
    })
    .catch(() => console.log("오류"));
}

document.querySelector("button").addEventListener("click", (e) => {
  // 영화진흥위원회 사용자가 선택한 날짜의 박스 오피스 가져오기
  let url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
  url += txtYear.value + selMon.value + selDay.value;
  console.log(url);

  fetch(url)
    .then((response) => {
      if (!response.ok) throw new Error();
      return response.json();
    })
    .then((data) => {
      console.log(data);

      // json 데이터의 필요한 요소 추출 ( . 찍고 접근)
      let boxofficeList = data.boxOfficeResult.dailyBoxOfficeList;
      console.log(boxofficeList);

      let result = "";
      boxofficeList.forEach((movie) => {
        // 순위
        // 1위(▲1 / 0 / ▼1) : 파묘
        let rankInten = movie.rankInten;
        if (rankInten > 0) {
          rankInten = "▲";
        } else if (rankInten < 0) {
          rankInten = "▼";
        }

        result += `${movie.rank}위 (`;
        result += `${rankInten + movie.rankInten}) : `;
        result += `<a href="#" onclick='javascript:show(${movie.movieCd})'>${movie.movieNm}</a><br>`;
      });
      // 박스 안에 넣기
      document.querySelector("#msg").innerHTML = result;
    })
    .catch(() => console.log("주소 확인"));
});
