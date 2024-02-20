CREATE TABLE emp(
	empno number
);

INSERT INTO emp values(1);


-- java 연동 1일차


-- booktbl 생성
-- code, title, writer, price 컬럼 생성
-- 숫자4자리(PK), 문자, 문자, 숫자
CREATE TABLE bookTBL(
	code number(4) PRIMARY KEY,
	title nvarchar2(50) NOT NULL,
	writer nvarchar2(10) NOT NULL,
	price number(8) NOT NULL 
);

INSERT INTO BOOKTBL(code, title, writer, price)
VALUES(1001,'자바의 정석','남궁성',30500); 

INSERT INTO BOOKTBL(code, title, writer, price)
VALUES(1002,'오라클','홍길동',32000);

INSERT INTO BOOKTBL(code, title, writer, price)
VALUES(1003,'HTML','장은석',22500);

INSERT INTO BOOKTBL(code, title, writer, price)
VALUES(1004,'CSS','김현주',25500);

-- 전체 조회
SELECT * FROM BOOKTBL;

-- 특정 조회
SELECT * FROM BOOKTBL WHERE code=1000;
SELECT * FROM BOOKTBL WHERE writer='장은석';

-- 자바로 시작하는 책 검색
SELECT * FROM BOOKTBL WHERE title LIKE '자바%';


-- -- java 연동 2일차


-- 수정
UPDATE BOOKTBL SET PRICE = 35000 WHERE CODE = 1000;

UPDATE BOOKTBL SET PRICE = 35000, TITLE = '' WHERE CODE =1000;

-- 삭제
DELETE  FROM BOOKTBL WHERE  CODE = 1004;

-- memberTBL 생성
-- 회원정보 저장
-- userid(숫자, 문자, 특수문자 20), password(20), name(10), email(50) 
CREATE TABLE memberTBL(
	userid nvarchar2(20) PRIMARY KEY,
	password nvarchar2(20) NOT NULL,
	name nvarchar2(10) NOT NULL,
	email nvarchar2(50) NOT NULL
);

INSERT  INTO MEMBERTBL m (userid, password, name, email)
values('hong123', 'hong123', '홍길동', 'hong123@gmail.com');

INSERT  INTO MEMBERTBL m (userid, password, name, email)
values('kong123', 'kong123', '공길동', 'kong123@gmail.com');

SELECT * FROM  MEMBERTBL m  WHERE  USERID  = 'hong123';

SELECT * FROM MEMBERTBL m  WHERE  USERID = 'hon123' AND  PASSWORD  = 'hong123';

SELECT * FROM MEMBERTBL m;

UPDATE  MEMBERTBL
SET PASSWORD = 'hong456'
WHERE USERID = 'hong123';

DELETE FROM MEMBERTBL m 
WHERE  userid = 'hong123';


