CREATE TABLE salgrade(
grade CHAR(2)PRIMARY KEY,
losal NUMBER(7),
hisal NUMBER(7)
);

CREATE TABLE emp(
empno CHAR(4) PRIMARY KEY,
ename VARCHAR2(30),
job VARCHAR2(20),
mgr CHAR(4),
hiredate DATE,
sal NUMBER(7,2),
comm NUMBER(7,2),
deptno CHAR(2),
FOREIGN KEY(mgr) REFERENCES emp(empno),
FOREIGN KEY(deptno) REFERENCES dept(deptno)  
);

DROP TABLE dept;
CREATE TABLE dept(
deptno CHAR(2)PRIMARY KEY,
dname VARCHAR2(14),
loc VARCHAR2(13)
);

INSERT INTO dept
VALUES(10, 'ACCOUNTING','NEW YORK');
INSERT INTO dept
VALUES(20, 'RESEARCH','DALLAS');
INSERT INTO dept
VALUES(30, 'SALSE','CHICAGO');
INSERT INTO dept
VALUES(40, 'OPERATIONS', 'BOSTON');


INSERT INTO emp 
VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('17-11-1981', 'dd-mm-yyyy'), 5000, NULL, 10);

INSERT INTO emp 
VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('2-4-1981', 'dd-mm-yyyy'), 2975, NULL, 20);

INSERT INTO emp 
VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1-5-1981', 'dd-mm-yyyy'), 2850, NULL, 30);

INSERT INTO emp 
VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('9-6-1981', 'dd-mm-yyyy'), 2450, NULL, 10);

INSERT INTO emp 
VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('13-7-1987', 'dd-mm-yyyy'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('3-12-1981', 'dd-mm-yyyy'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('20-2-1981', 'dd-mm-yyyy'), 1600, 300, 30);

INSERT INTO emp 
VALUES (7521, 'WORD', 'SALESMAN', 7698, TO_DATE('22-2-1981', 'dd-mm-yyyy'), 1250, 500, 30);

INSERT INTO emp 
VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('28-9-1981', 'dd-mm-yyyy'), 1250, 1400, 30);

INSERT INTO emp 
VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('8-9-1981', 'dd-mm-yyyy'), 1500, 0, 30);

INSERT INTO emp 
VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('3-12-1981', 'dd-mm-yyyy'), 950, NULL, 30);

INSERT INTO emp 
VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('23-1-1982', 'dd-mm-yyyy'), 1300, NULL, 10);

INSERT INTO emp 
VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('17-12-1980', 'dd-mm-yyyy'), 800, NULL, 20);

INSERT INTO emp 
VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('13-7-1987', 'dd-mm-yyyy'), 1100, NULL, 20);

INSERT INTO emp 
VALUES (7876, '홍길동', 'CLERK', 7788, TO_DATE('13-7-2024', 'dd-mm-yyyy'), 500, NULL, 10);
--외래키를 사용 시 제약조건이 생성, 테이블에 저장된 데이터가 있어야만, 제약조건에 위배되지않음



select * from emp;


INSERT INTO salgrade VALUES(1, 700, 1200);
INSERT INTO salgrade VALUES(2, 1201, 1400);
INSERT INTO salgrade VALUES(3, 1401, 2000);
INSERT INTO salgrade VALUES(4, 2001, 3000);
INSERT INTO salgrade VALUES(5, 3001, 9999);

select * from salgrade;

SELECT ROUND(345.678),ROUND(345.678, 0), ROUND(345.678, 1),ROUND(345.678, -1)
FROM DUAL;--더미테이블(SELECT문을 완성시키기 위해서 오라클에서 제공하는 더미테이블)
SELECT ABS(-19) FROM DUAL;--부호 변환
SELECT CEIL(3.14) FROM DUAL;--올림
SELECT FLOOR(3.99) FROM DUAL;--버림
SELECT TRUNC(160.123452, 2) FROM DUAL;
SELECT MOD(10,3) FROM DUAL;
SELECT POWER(2,3) FROM DUAL;--제곱근
SELECT SQRT(16) FROM DUAL; --???
SELECT SIGN(50) FROM DUAL;--숫자 부호 반환(-1:음수, 0:0, 1:양수)

SELECT LENGTH('ORACLE') FROM DUAL;
SELECT SUBSTR('ORALE',2,3)FROM DUAL;--문자열 길이
SELECT INSTR('ORACL','A') FROM DUAL;
SELECT UPPER('oracle') FROM DUAL;
SELECT LOWER('ORACLE') FROM DUAL;
SELECT INITCAP('hello oracle') FROM DUAL;
SELECT TRIM('O' FROM 'ORACLEO')FROM DUAL;
SELECT LTRIM('***ABC','*') FROM DUAL;
SELECT RTRIM('ABC***','*') FROM DUAL;
SELECT REPLACE('a-b-c','-','+') FROM DUAL;
SELECT CONCAT('Hi','oracle') FROM DUAL;
SELECT LPAD('99',5,'0') FROM DUAL;
SELECT RPAD('Hi',5,'!') FROM DUAL;--Hi포함 5자리 인디 없음 !로 채우기
SELECT TRANSLATE ('12345','123','ABC') FROM DUAL;--123 자리에 ABC로 바꾸기

--오라클 날짜 함수\
SELECT SYSDATE AS 현재시간 FROM DUAL;
SELECT CURRENT_DATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 3) AS 세달후 FROM DUAL;
SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2025-01-01','YYYY-MM-DD')) AS 개월차이 FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'화요일') AS 다음월요일 FROM DUAL;
SELECT LAST_DAY(SYSDATE) AS 이달마지막날 FROM DUAL;
SELECT ROUND(SYSDATE, 'MONTH') AS 반올림결과 FROM DUAL;--15일 이상이면 다음달
SELECT EXTRACT (YEAR FROM SYSDATE) AS 년도 FROM DUAL;--년
SELECT EXTRACT (MONTH FROM SYSDATE) AS 월 FROM DUAL;--월
SELECT EXTRACT (DAY FROM SYSDATE) AS 일 FROM DUAL;--일
SELECT TO_DATE('2025-03-24','YYYY-MM-DD')AS 날짜변환 FROM DUAL;


SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(TO_NUMBER(1234.5678),'9999.999') FROM DUAL;
SELECT TO_CHAR(TO_NUMBER(1234.5678),'9999.9999') FROM DUAL;
SELECT TO_CHAR(TO_NUMBER(1234.5678),'9999.999') FROM DUAL;
SELECT empno, ename,TO_CHAR(TO_NUMBER(sal),'$9999') salary FROM emp;

SELECT ename, NVL(MGR, 0) FROM emp;--NVL: 값이 NULL이면 두번째 값을 넣어서 표시해라 아니면 앞에꺼
select ename, mgr from emp;

select ename,job,comm from emp;
select ename,job,NVL2(comm,sal+comm,sal)from emp;--comm값이 NULL이면 sal, 아님 comm+sal을 표시

--1.부서의 부서이름과 지역을 검색하시오
SELECT dname,loc FROM dept;
--2.사원들의 입사일 중복을 제거하고 검색하시오
SELECT DISTINCT hiredate FROM emp;
--3.사원들의 부서번호 중복을 제거하고 검색하시오(DISTINCT)
SELECT DISTINCT deptno FROM dept;
--4.사원들의 6개월 급여의 합을 검색하시오
SELECT sal*6 FROM emp; 
--5.사원 이름을 'name'으로 사원의 급여를 salary로 이름 부여하여 검색
SELECT ename  AS name, sal AS salary  FROM emp;
--6.부서번호, 부서이름, 지역을 한글 제목으로 검색하시오
SELECT deptno as 부서번호, dname as 부서이름, loc as 지역 FROM dept;
--7.사원의 직무와 사원이름을 합쳐서 검색하시오(ex.PRESIDENTKING)
SELECT job || ename from emp;
--8.WARD 사원의 모든 정보를 검색
SELECT * FROM emp WHERE ename ='WORD';
--9.10번 부서에 근무하는 MANAGER의 사원 이름을 검색
SELECT ename FROM emp WHERE deptno = 10 and job='MANAGER';
--10.급여가 2000이상이며 30번 부서에 근무하는 사원들의 사원번호와 사원이름을 검색하시오
SELECT empno, ename FROM emp WHERE sal >= 2000 AND deptno = 30;
--11.20번 부서 외에 근무하는 MANAGER 사원의 이름을 검색
SELECT ename FROM emp WHERE deptno <> 20;
--12.SALESMAN의 급여가 1500이상인 사원이름을 검색하시오
SELECT ename from emp where sal >= 1500 and job = 'SALESMAN';
--13.부서번호가 10 또는 30에 근무하는 사원들의 사원이름과 급여를 검색하시오
SELECT ename, sal from emp WHERE deptno=10 OR deptno=30;
--14.상급자 사원번호가 76으로 시작하는 사원들의 사원이름을 검색하시오
SELECT ename FROM emp WHERE empno like '76%';
--15.1981년 2월에 입사한 사원의 사원번호, 사원이름, 부서번호를 검색
SELECT empno, ename, deptno FROM emp WHERE EXTRACT(MONTH FROM hiredate)=2 AND EXTRACT(YEAR FROM hiredate) = 1981;
--16.사원이름 중간에'A'가 들어간 사원의 사원번호와 서사원이름을 검색
SELECT empno, ename FROM emp WHERE ename LIKE '%A%';
--17.상급자 사원번호가 NULL인 사원의 사원번호와 사원이름을 검색
SELECT empno, ename FROM emp WHERE  mgr is NULL;
--18.상급자 사원번호가 NULL이 아닌 사원의 사원번호와 사원이름을 검색
SELECT empno,ename FROM emp WHERE mgr  IS NOT NULL;
--19.사원들의 사원번호와 사원이름을 사원번호 순으로 검색(오름차순)
SELECT empno, ename FROM emp
ORDER BY  empno ASC;
--20.사원들의 정보를 사원직무별 급여가 많은 순으로 검색
SELECT * FROM emp
ORDER BY job, sal DESC;
--21.사원들의 이름을 소문자로 검색
SELECT LOWER (ename) FROM emp;
--22.사원들의 사원이름,사원직무를 대문자로 검색하시오
SELECT UPPER(ename),UPPER(job) FROM emp;
--23.사원들의 사원이름을 첫 자만 대문자로 검색하시오
SELECT INITCAP(ename) FROM emp;
--24.사원들의 사원이름과 사원직무를 연결하여 검색하시오
SELECT CONCAT(ename,job) FROM emp;
--사원들의 사원이름과 첫 두 글자를 검색하시오
SELECT SUBSTR('ORALE',2,3)FROM DUAL;
SELECT ename,SUBSTR(ename,1,2) FROM emp;
--사원들의 사원이름, 사원직무 그리고 사원직무의 두 번째부터 세 글자를 검색
SELECT ename,SUBSTR(job,2,3) FROM emp;
--사원들의 사원이름과 사원이름의 길이를 검색
SELECT ename, LENGTH(ename)FROM emp;
--사원들의 사원이름에 'A'가 몇번째에 위치하는지 검색
SELECT INSTR(ename,'A') FROM emp;
--사원이름을 15자리로 하고 뒤에 &를 채워넣기
SELECT RPAD('Hi',5,'!') FROM DUAL;
SELECT RPAD(ename,15,'&') FROM emp;
--사원직무를 20자리로 하고 앞에 %를 채워 검색하시오
SELECT LPAD(job,20,'%') FROM emp;
--37.사원의 사원번호, 사원이름 급여를 검색(급여는 두번째 자리에서 반올림함)
SELECT empno, ename, ROUND(sal) FROM emp;
--38.사원의 사원번호, 사원이름, 급여를 검색(급여는 두번째 자리에서 절삭)
SELECT empno, ename, TRUNC(sal,2) FROM emp;
--39.사원번호와 급여를 100으로 나눈 나머지를 검색하시오
SELECT MOD(empno,100),MOD(sal,100) FROM emp;
--40.사원번호, 사원이름, 입사일 일사 후 100일의 날짜를 검색하시오
SELECT empno, ename, hiredate+100 FROM emp;
--41.사원번호, 사원이름, 입사일 이후 근무 일자를 계산하여 검색하시오
SELECT empno, ename,SYSDATE - TO_DATE(hiredate,'YYYY-MM-DD') FROM emp;
--42.사원들의 입사일에서 3달째 되는 날짜를 검색
SELECT ADD_MONTHS(hiredate, 3) FROM emp;
--43.상급자 사원번호가 없는 사원의 경우 '상급자없음'을 나타내도록 하시오
SELECT NVL(MGR, '상급자없음') FROM emp;
--44.커미션을 포함한 급여를 사원번호,사원 이름과 함께 검색하시오
SELECT NVL(sal+comm,sal), empno, ename FROM emp;
--45.커미션을 포함한 연봉을 사원번호, 사원 이름과 함께 검색하시오
SELECT NVL((sal+comm)*12,sal*12),empno, ename FROM emp; 


--46.10,20번 부서의 사원 중 최고급여를 받는 사원의 사원번호, 사원이름, 급여를 검색하시오
SELECT empno,ename,sal FROM emp WHERE deptno IN(10,20) AND sal = (SELECT MAX(sal) FROM emp);
--47.30번 부서의 사원 중 최저급여를 받는 사원의 사원번호, 사원이름, 급여를 검색하시오
SELECT empno,ename,sal,deptno FROM emp WHERE sal = (SELECT MIN((SELECT sal FROM emp WHERE deptno = 30))); 


--48.전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 사원이름, 커미션을 검색하시오
SELECT empno, ename, comm FROM emp WHERE comm = (SELECT MAX(comm) FROM emp);
--49.전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 사원이름, 커미션을 검색하시오
SELECT empno, ename, comm FROM emp WHERE comm = (SELECT MIN(comm) FROM emp) AND comm IS NOT NULL;
--50전체 사원의 입사일 중 MAX와MIN 값을 검색하시오
SELECT MAX(hiredate), MIN(hiredate) FROM emp;
--51.사원번호의 MAX와 MIN 값을 검색하시오
SELECT MAX(empno),MIN(empno) FROM emp; 
--52.상급자 사원번호 열의 갯수를 검색하시오
SELECT COUNT(DISTINCT mgr) FROM emp;
--53.사원이름의 갯수를 검색하시오
SELECT COUNT(ename)||'명'  AS 사원이름의갯수 FROM emp;
--54.사원 테이블의 튜플 수를 검색하시오
SELECT COUNT(*) FROM emp;
--55.부서별 사원들의 인원수를 검색하시오
SELECT job,COUNT(*) FROM emp GROUP BY job;
--56.상급자 사원번호별 사원들의 인원수를 검색하시오
SELECT mgr,COUNT(*) FROM emp GROUP BY mgr HAVING mgr IS NOT NULL;
--57.부서별 사원들의 평균급여를 검색하시오
SELECT job,AVG(sal) FROM emp GROUP BY job;
--58.부서별 사원직무별 사원의 급여의 합을 검색하시오
SELECT deptno,job,SUM(sal) FROM emp GROUP BY deptno,job ORDER BY deptno;
--59부서별 사원직무별 사원들의 평균 급여를 검색하시오
SELECT deptno,job,AVG(sal) FROM emp GROUP BY deptno,job ORDER BY deptno;
--60.부서별 사원직무별 사원들의 입사일의 MAX와 MIN 값을 검색하시오.
SELECT deptno,job, MAX(hiredate),MIN(hiredate) FROM emp GROUP BY deptno,job ORDER BY deptno;


--JOIN: 두 개 이상의 테이블을 참조하여 결과를 내주는것 
SELECT e.empno,e.ename,d.dname,d.loc FROM emp e,dept d WHERE e.deptno = d.deptno; 

--JONES의 부서명, 부서 이름을 알려주는 쿼리를 작성하시오
SELECT e.ename, d.dname FROM emp e, dept d WHERE e.ename = 'JONES' AND e.deptno = d.deptno;

SELECT ename, dname FROM (SELECT emp.*,dept.* From emp, dept WHERE emp.deptno = dept.deptno) 
WHERE ename = 'JONES';



