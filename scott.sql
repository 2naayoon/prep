-- scott

-- SELECT (데이터 조회)
-- e : 별칭(임의 지정 가능) / 없어도 됨
-- * : 전체 필드(컬럼)를 의미함
SELECT * FROM EMP;

-- 특정 컬럼에 해당하는 내용 보기
SELECT	EMPNO, ENAME, JOB
FROM EMP;

-- emp 테이블
-- empno(사원번호), ename(사원명), job(직책), mgr(매니저번호), hiredate(고용일), sal(급여), comm(보너스)
-- deptno(부서번호)

-- emp 테이블에서 사원번호, 매니저번호, 부서번호만 조회
SELECT	Empno, mgr, deptno
FROM emp;
	
-- emp 테이블에서 부서번호(중복 데이터 제거) 조회
SELECT DISTINCT deptno
FROM EMP e ;
	
-- 데이터 출력 시 필드명 별칭 부여
-- 쌍따옴표는 별칭에 공백이 있는 경우 무조건 사용
-- as 생략 가능
SELECT 
    empno AS 사원번호,
	mgr 매니저번호,
	deptno "부서 번호"
FROM
	emp;
	
-- 연봉 계산
-- 월급 * 12 + 수당
-- sal * 12 + comm
SELECT empno, sal, sal * 12 + comm AS "연봉"
FROM EMP e;

-- 정렬
-- order by 정렬기준 컬럼명 DESC(내림차순) or ASC(오름차순 - default)
SELECT *
FROM EMP
ORDER BY SAL DESC;

-- emp 테이블에서 empno, ename, sal 조회 (단, empno 내림차순)
SELECT empno, ename, sal
FROM EMP
ORDER BY EMPNO DESC;

-- 전체조회, 부서번호 오름차순, sal 내림차순
SELECT *
FROM EMP e
ORDER BY DEPTNO, SAL DESC;

-- 조건
-- 부서번호가 30번인 사원 조회
-- sal > 1000 이상인 사원 조회
-- = (같다), 산술연산자(>, <, >=, <=)
SELECT *
FROM EMP e 
WHERE DEPTNO = 30;

SELECT *
FROM EMP e 
WHERE SAL >= 1000;

SELECT *
FROM EMP e 
WHERE SAL >= 1000
ORDER BY SAL DESC;

-- empno 가 7782 인 사원 조회
SELECT *
FROM EMP e 
WHERE empno = 7782;

-- deptno 가 30이고, job 이 SALESMAN 사원 조회
-- 데이터는 대소문자 구별 함
SELECT *
FROM EMP e 
WHERE DEPTNO = 30 AND job = 'SALESMAN';

-- 사원번호가 7499 이고 부서번호가 30인 사원 조회
SELECT *
FROM  EMP e 
WHERE EMPNO = 7499 AND DEPTNO = 30;

-- 이거나(혹은) : or
-- 부서번호가 30 이거나 job이 SALESMAN 사원 조회
SELECT *
FROM EMP e 
WHERE DEPTNO = 30 OR job = 'SALESMAN';

-- 연봉이 36000인 사원 조회
-- 연봉 SAL * 12 + COMM
SELECT *
FROM EMP e 
WHERE SAL * 12 + COMM = 36000;

-- 문자 비교도 가능 - 산술연산 기호 가능
-- 알파벳 순서로 F 다음에 있는 
SELECT *
FROM EMP e 
WHERE ENAME >= 'F';

-- SAL 이 3000 이 아닌 사원 조회
-- ~이 아닌 : !=(java), <>, ^=
SELECT *
FROM EMP e 
WHERE SAL != 3000;

SELECT *
FROM EMP e 
WHERE SAL <> 3000;

SELECT *
FROM EMP e 
WHERE SAL ^= 3000;

-- job이 MANAGER or SALESMAN or CLERK
SELECT *
FROM EMP e 
WHERE JOB = 'MANAGER' OR JOB = 'SALESMAN' OR JOB = 'CLERK';

-- IN
SELECT *
FROM EMP e 
WHERE JOB IN ('MANAGER', 'SALESMAN', 'CLERK');

SELECT *
FROM EMP e 
WHERE JOB NOT IN ('MANAGER', 'SALESMAN', 'CLERK');

-- HIREDATE 가 1981 10 31 이후에 고용된 사원 조회
-- 날짜 데이터 산술 연산 가능, 날짜 데이터 '' 로 처리
SELECT *
FROM EMP e 
WHERE HIREDATE > '1981-10-31';

-- BEWEEN A AND B
-- SAL 2000 이상 3000 이하인 사원 조회
SELECT *
FROM EMP e 
WHERE SAL >= 2000 AND SAL  <= 3000;

SELECT *
FROM EMP e 
WHERE SAL BETWEEN 2000 AND 3000;

-- NOT BEWEEN A AND B
SELECT *
FROM EMP e 
WHERE SAL NOT BETWEEN 2000 AND 3000;
