create table student (
STU_NO CHAR(9) PRIMARY KEY,
STU_NAME VARCHAR2(30),
SUT_DEPT VARCHAR2(20),
STU_GRADE NUMBER(1),
STU_CLASS CHAR(1),
STU_GENDER CHAR(1),
STU_HEIGHT NUMBER(5,2),
STU_WEIGHT NUMBER(5,2)
);



CREATE TABLE subject(
SUB_NO CHAR(3) PRIMARY KEY,
SUB_NAME VARCHAR2(30),
SB_PROF VARCHAR2(20),
SUB_GRADE NUMBER(1),
SUB_DEPT VARCHAR2(20)
);

CREATE TABLE enroll(
SUB_NO CHAR(3),
STU_NO CHAR(9),
ENR_GRADE NUMBER(3),
CONSTRAINT p_course PRIMARY KEY(SUB_NO,STU_NO)
);

INSERT INTO student VALUES (20153075,'옥한빛','기계',1,'C','M',177,80);
INSERT INTO student VALUES (20153088,'이태연','기계',1,'C','F',165,50);
INSERT INTO student VALUES (20143054,'유가인','기계',2,'C','F',154,47);
INSERT INTO student VALUES (20152088,'조민우','전기전자',1,'C','M',188,90);
INSERT INTO student VALUES (20142021,'심수정','전기전자',2,'A','F',168,48);
INSERT INTO student VALUES (20132003,'박희철','전기전자',3,'B','M',NULL,63);
INSERT INTO student VALUES (20151062,'김인중','컴퓨터정보',1,'B','M',166,67);
INSERT INTO student VALUES (20141007,'진현무','컴퓨터정보',2,'A','M',166,64);
INSERT INTO student VALUES (20131001,'김종현','컴퓨터정보',3,'C','M',NULL,72);
INSERT INTO student VALUES (20131025,'옥성우','컴퓨터정보',3,'A','F',172,63);
//모든 컬럼에 자료를 넣을때는 컬럼 명을 생락해도 테이블에 데이터가 들어간다.

INSERT INTO subject VALUES ('111','데이터베이스','이재영',2,'컴퓨터정보');
INSERT INTO subject VALUES ('110','자동제어','정순정',2,'전기전자');
INSERT INTO subject VALUES ('109','자동화설계','박민영',3,'기계');
INSERT INTO subject VALUES ('101','컴퓨터개론','김종영',3,'컴퓨터정보');
INSERT INTO subject VALUES ('102','기계공작법','김태영',1,'기계');
INSERT INTO subject VALUES ('103','기초전자실험','김유석',1,'전기전자');
INSERT INTO subject VALUES ('104','시스템분석설계','강석현',3,'컴퓨터정보');
INSERT INTO subject VALUES ('105','기계요소설계','김명성',1,'기계');
INSERT INTO subject VALUES ('106','전자회로실험','최영민',3,'전기전자');
INSERT INTO subject VALUES ('107','CAD응용실습','구봉규',2,'기계');
INSERT INTO subject VALUES ('108','소프트웨어공학','권민성',1,'컴퓨터정보');

SELECT * FROM subject;

INSERT INTO enroll VALUES ('101','20131001',80);
INSERT INTO enroll VALUES ('104','20131001',56);
INSERT INTO enroll VALUES ('106','20132003',72);
INSERT INTO enroll VALUES ('103','20152088',45);
INSERT INTO enroll VALUES ('101','20131025',65);
INSERT INTO enroll VALUES ('104','20131025',65);
INSERT INTO enroll VALUES ('108','20151062',81);
INSERT INTO enroll VALUES ('107','20143054',41);
INSERT INTO enroll VALUES ('102','20143075',66);
INSERT INTO enroll VALUES ('105','20153075',56);
INSERT INTO enroll VALUES ('102','20153088',61);
INSERT INTO enroll VALUES ('105','20153088',78);

drop table enroll;

INSERT INTO enroll VALUES ('101','20131001',80);
INSERT INTO enroll VALUES ('104','20131001',56);
INSERT INTO enroll VALUES ('106','20132003',72);
INSERT INTO enroll VALUES ('103','20152088',45);
INSERT INTO enroll VALUES ('101','20131025',65);
INSERT INTO enroll VALUES ('104','20131025',65);
INSERT INTO enroll VALUES ('108','20151062',81);
INSERT INTO enroll VALUES ('107','20143054',41);
INSERT INTO enroll VALUES ('102','20143075',66);
INSERT INTO enroll VALUES ('105','20153075',56);
INSERT INTO enroll VALUES ('102','20153088',61);
INSERT INTO enroll VALUES ('105','20153088',78);

select * from enroll;

--학생 테이블의 구조 확인
DESC student;
--과목 테이블의 구조 확인
DESC subject;
--수강 테이블의 구조 확인
DESC enroll;

--학생테이블 학번 학생이름 조회
SELECT STU_NO, STU_NAME FROM student;

select * from subject;

--학생테이블에서 학과를 중복데이터 없이 조회하시오
SELECT DISTINCT STU_DEPT
FROM student;

--학생테이블에서 학년돠 반을 중복 없이 조회
SELECT DISTINCT STU_GRADE, STU_CLASS 
FROM student;

--수강테이블에서 학번, 과목번호, 점수, 기존 점수에 10을 더한 점수를 조회
SELECT STU_NO, SUB_NO, ENR_GRADE, ENR_GRADE+10
FROM enroll;

--수강테이블에서 학버느 과목번호ㅡ, 점수--- 이때,  디존 점수에 10을 더한 점수의 열 제목은 PLUSE 10으로 하시오
SELECT STU_NO, SUB_NO, ENR_GRADE, ENR_GRADE+10 AS plus10
FROM enroll;

--연결연산자 사용 : 두 개이상의 열을 합쳐서 조회할 수 있음.
SELECT STU_DEPT || STU_NAME AS 학과성명 FROM student;
SELECT STU_DEPT || ', ' || STU_NAME || '입니다' AS 학과성명 FROM student;

--학과가 컴퓨터정보인 학생의 이름 학과 학년 반 조회
SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT = '컴퓨터정보';

--학과가 컴퓨터정보가 아닌학생들
SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT != '컴퓨터정보';

SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT <> '컴퓨터정보';

SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT ^= '컴퓨터정보';

--힉과가 컴퓨터장보이고 2학년인 학생의 모든 정보
SELECT * FROM student
WHERE STU_DEPT = '컴퓨터정보' AND STU_GRADE = 2;

--1,2학년 학생의 모든 정보를 조회
SELECT * FROM student
WHERE STU_GRADE = 1 OR STU_GRADE = 2;

--체중이 60이상 70이하인 학생의 이름 학과 학년 조회
SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_WEIGHT >= 60  AND STU_WEIGHT <=70;

SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_WEIGHT BETWEEN 50 AND 72;

SELECT * FROM STUDENT;

--키가 180 이상인 학생의 이름과 학과 학년을 조회
SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_HEIGHT >=170;

UPDATE student 
SET STU_HEIGHT = 176
WHERE STU_NAME = '진현무';

--like를 이용한 검색
--like와 함께 쓰리는갛호  % _
--% = 0개 이상의 문자
--_ = 1개의 문자
--학생중 성이 김씨인 학생정보
SELECT *
FROM student
WHERE STU_NAME LIKE '김%';

--두번째 글짜가 수인 학생의 이름
SELECT *
FROM student
WHERE STU_NAME LIKE '_수%';
--학생이름이 우로 끝나는 학생의 수가 몇명인지 검색
SELECT COUNT(*)
FROM student
WHERE STU_NAME LIKE '%우';

--학번이 2014번인 학생의 정보를 조회
SELECT * FROM student
WHERE STU_NO LIKE '2014%';

--학생정보 중 키 값이 없는 핛ㅇ의 학번 이름 키를 조회
SELECT STU_NO, STU_NAME, STU_HEIGHT
FROM student
WHERE STU_HEIGHT IS NULL;

--키 값이 있는 학생의 정보
--학생정보 중 키 값이 없는 핛ㅇ의 학번 이름 키를 조회
SELECT STU_NO, STU_NAME, STU_HEIGHT
FROM student
WHERE STU_HEIGHT IS NOT NULL;


--학과가 컴퓨터정보이거나 기계과인 학생의 학번 이름을 검색
SELECT STU_NO,STU_NAME
FROM student
WHERE STU_DEPT = '컴퓨터정보' OR STU_DEPT = '기계';
--IN으로도 위와같은 결과를 얻을 수 있다.
SELECT STU_NO,STU_NAME,STU_DEPT
FROM student
WHERE STU_DEPT IN ('컴퓨터정보','기계');

--정렬하기(오름차순, 내림차순 - ASC(기본값), DESC)
SELECT * FROM student
ORDER BY STU_NO ASC;

SELECT * FROM student
ORDER BY STU_NO DESC;

SELECT STU_NO, STU_DEPT, STU_WEIGHT -5 AS target
FROM student
ORDER BY target ASC; 

SELECT STU_NO, STU_DEPT, STU_WEIGHT -5 AS target
FROM student
ORDER BY STU_DEPT, target DESC; 

SELECT STU_NO, STU_DEPT, STU_WEIGHT -5 AS target
FROM student
ORDER BY STU_HEIGHT; --SELECT에 없어도 정렬 컬럼으로 지정이 가능하다.

CREATE TABLE enroll(
SUB_NO CHAR(3),
STU_NO CHAR(9),
ENR_GRADE NUMBER(3),
CONSTRAINT p_course PRIMARY KEY(SUB_NO,STU_NO)
);

--남학생 정보 출력
SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_GENDER = 'M';
--학생들의 이름,현재 체중, 현재 체중+5 AS plus5
SELECT STU_NAME, STU_WEIGHT, STU_WEIGHT+5 AS plus5
FROM student;
--수강 테이블의 모든 정보 as 한글로 별칭 부여
SELECT SUB_NO AS 과목명,STU_NO AS 학번, ENR_GRADE AS 성적 FROM enroll;
SELECT * FROM enroll;

--학생의 이름과 학과를 컴퓨터정보과 옥한빛 입ㄴ디ㅏ, 식으로 검색
SELECT STU_DEPT || ' ' || STU_NAME || '입니다.'
FROM student;
--'전기전자'과 이외 학생
SELECT * FROM student WHERE STU_DEPT != '전기전자';
--기계이면서 2학년 학생
SELECT * FROM student WHERE STU_DEPT = '기계' AND STU_GRADE = 2;
--여학생 중 체중이 60이하인 학생
SELECT * FROM student WHERE STU_WEIGHT <= 60;
--키가 160이상 170이하인 학생 학번 이름
SELECT * FROM student WHERE STU_HEIGHT BETWEEN 160 AND 170;
--이름에 옥이 들어가는 학생
SELECT * FROM student WHERE STU_NAME LIKE '%옥%';
--키가null인 학생
--키가 null이 아닌 학생
--학번이 ****20**인 학생
--학번이 2014인 학생들을 이름순으로 조회
--학과 정보를 이름기준으로 내림차순(DESC)
--MAX MIN
SELECT MAX(STU_HEIGHT) FROM student;
--SUM
SELECT SUM(ENR_GRADE) FROM enroll;
--COUNT
SELECT COUNT(*),COUNT(STU_HEIGHT) FROM student;
--GROUP BY
SELECT STU_DEPT, AVG(STU_WEIGHT) FROM student GROUP BY STU_DEPT;
--학생테이블에서 체중이 50 이상인 학생들의 학과별 인원수를 구하시오
SELECT STU_DEPT, COUNT(*)
FROM student
WHERE STU_WEIGHT >= 50
GROUP BY STU_DEPT;

--학과테이블에서 학과별, 학년별 인원수를 구하시오
SELECT STU_DEPT,STU_GRADE, COUNT(*) FROM student 
GROUP BY STU_DEPT,STU_GRADE
ORDER BY STU_DEPT;--학과로 정렬(오름차순)
--기계과 학생들 중에 학년별 평균 신장이 160이상인 학년과 평균 신장을 구하시오
SELECT STU_GRADE, AVG(STU_HEIGHT)
FROM student
WHERE STU_DEPT = '기계'
GROUP BY STU_GRADE
HAVING AVG (STU_HEIGHT) >= 160;

--최대 신장이 175 이상인 학과와 학과별 최대 신장을 구하시오
SELECT STU_DEPT, MAX(STU_HEIGHT) FROM student
GROUP BY STU_DEPT
HAVING MAX(STU_HEIGHT) >= 175;

--학과별 평균 신장 중 가장 높은 평균 신장을 구하시오
--GROUP는 집계와 함께 사용된다.
SELECT to_char(MAX(AVG(STU_HEIGHT)),'999.99') FROM student GROUP BY STU_DEPT;



CREATE TABLE t_student
AS SELECT * FROM student WHERE STU_DEPT = '기계';--기존에 있는 테이블을 활용하여 새로운 테이블을 생성*************

desc t_student;

SELECT * FROM t_student;

--새로운 열 추가
ALTER TABLE t_student ADD (army CHAR(1));--컬럼을 추가한다(추가된 컬럼은 NULL로 세팅이 된다.

SELECT * FROM t_student;

ALTER TABLE t_student ADD (age NUMBER(3) DEFAULT 20);

ALTER TABLE t_student DROP COLUMN age;//칼럼을 삭제하는 명령어

UPDATE t_student SET age = 22 WHERE STU_NAME = '이태연';
UPDATE t_student SET age = 25 WHERE STU_NO = 20143054;

ALTER TABLE t_student DROP (army);--COLUMN대신 ()로 대체 가능

--테이블 이름 변경
RENAME t_student TO test_student;--테이블 이름을 변경

desc test_student;

TRUNCATE TABLE test_student;
select * from test_student;

--DDL로 작업하면 커밋을 안해도 DB를 영구적으로 저장 가능
--DML은 커밋을 해야만 DB에 반영된다.
--DML을 사용했다가 커밋을 안해도 DDL을 실행하면 자동으로 커밋된다.

DROP TABLE test_student;
DELETE FROM  test_student;
ROLLBACK;


--제약조건
--데이터베이스 상태(인스턴스)가 항상 만족해야할 규칙

CREATE TABLE members(
mno NUMBER PRIMARY KEY,--기본키로 설정한다는건 다른 요소와 구별하기 위한 기준이라는 것, 중복은 안된다, 값이 비어도 안된다는 제약조건이 존재한다 UNIQUE + NOT NULL
mobile CHAR(13) UNIQUE NOT NULL,
gender CHAR(1) CHECK (gender IN ('M','F')),
hobby VARCHAR2(30) NOT NULL--빈 값 ㄴㄴ
);

INSERT INTO members VALUES(1,'010-1111-1111','M','축구');
INSERT INTO members VALUES(2,'','','축구');
INSERT INTO members VALUES(3,'3333-3333','M','축구');
INSERT INTO members VALUES(4,'4444-4444','','축구');
INSERT INTO members VALUES(5,'5555-5555','s','축구');


select * from members;

UPDATE members SET gender = 'M' WHERE mno = 5;

ALTER TABLE members DISABLE CONSTRAINT SYS_C007537;
ALTER TABLE members ENABLE CONSTRAINT SYS_C007538;

ALTER TABLE members ENABLE CONSTRAINT SYS_C007534;
 
DROP TABLE members;

CREATE TABLE student1 AS SELECT * FROM student WHERE STU_GRADE IN(1,2);
SELECT * FROM student1
ORDER BY STU_GRADE, STU_NO;

CREATE TABLE subject1 AS SELECT * FROM subject;
CREATE TABLE enroll1 AS SELECT * FROM ENROLL;

--1.학번 20101059, 이름 조병준, 학과 컴퓨터정보, 학년 1, 반 B,키 164, 몸무게 70인 남학생이 추가되었다.
INSERT INTO student VALUES (20153075,'옥한빛','기계',1,'C','M',177,80);
INSERT INTO student1 VALUES(20101059,'조병준','컴퓨터정보',1,'B','M',164,70);
--2.학번 20102038, 이름 남지선, 학과 전기전자, 학년 1, 반 C, 여학생이 추가되었다.
INSERT INTO student1 VALUES(20102038,'남지선','전기전자',1,'C','F',NULL,NULL);
--3.학번 20103009, 이름 박소신, 학과 기계 ,20153075 학생과 같은 학년, 반을 갖는 남학생이 추가되었다.
INSERT INTO student1 VALUES(20103009,'박소신','기계',(SELECT STU_GRADE FROM student1 WHERE STU_NO = 20153075),(SELECT STU_CLASS FROM student1 WHERE STU_NO = 20153075),'M',NULL,NULL);
--4.student1 테이블에 학생(student)테이블의 3학년 학생들 데이터를 입력하시오
INSERT INTO student1 SELECT * FROM student WHERE STU_GRADE = 3; 
select * from student1;
--5.학번 20141007의 반을 B로 바꾸시오
UPDATE student1 SET STU_CLASS = 'B' WHERE STU_NO = 20131001; 
--6.20072088 학생의 키가 2cm 자랐다
UPDATE student1 SET STU_HEIGHT = STU_HEIGHT + 2 WHERE STU_NO = 20152088;
--7.모든 학생의 학년이 올랐다.
UPDATE student1 SET STU_GRADE = STU_GRADE + 1;
--8. 20142021의 학생의 학과정보를 컴퓨터정보로 바꾸시오, (단, 학번은 입학년도+학과코드+일련번로, 학과코드 1: 컴퓨터 2:전기전자 3:기계)
--9.전자회로 과목의 점수를 1점 감하시오
UPDATE enroll1
SET ENR_GRADE = ENR_GRADE -1
WHERE SUB_NO = (SELECT SUB_NO FROM subject WHERE SUB_NAME = '전자회로실험');
SELECT SUB_NO FROM subject WHERE SUB_NAME = '전자회로실험';
--10.20151062학생이 소프트웨어공학 시험 중 부정행위로 0점이 되었다.
UPDATE enroll1
SET ENR_GRADE = 0
WHERE STU_NO = (SELECT STU_NO FROM student1 WHERE STU_NO = 20151062);
--11. 20153088 학생이 자퇴하였다.
DELETE FROM student1 WHERE STU_NO = 20153088;
--12. 과목번호112, 과목이름 자동화시스템 교수명 고종민 학년 3 학과 기계를 추가
INSERT INTO subject1 VALUES(112,'자동화시스템','고종민',3,'기계');
--13.과목번호가 110에서 501로 변경되었다
UPDATE subject1 SET SUB_NO = 501 WHERE SUB_NO = 110;
--14.과목번호 101이 폐강되었다.
DELETE FROm subject1 WHERE SUB_NO = 101;
--15.enroll1 테이블에서 subject1에 없는 과목번호를 999로 변경하시오
UPDATE enroll1 SET SUB_NO = 999
WHERE SUB_NO NOT IN (SELECT SUB_NO FROM subject1);
--16.enroll1 테이블에서 student1에 없는 학생번호를 99999999로 변경하시오
UPDATE enroll1 SET STU_NO = 99999999 WHERE STU_NO NOT IN (SELECT STU_NO FROM student1);
--17.enrol1테이블에서 과목번호 999를 삭제하시오
SELECT * FROM enroll1 ;
UPDATE enroll1 SET SUB_NO = NULL WHERE SUB_NO = 999;
--18. enrol1네이블에서 학번99999999을 삭제하시오
UPDATE enroll1 SET STU_NO = NULL WHERE STU_NO = 99999999;

--19. enrol1테이블의 전체 데이터 삭제
TRUNCATE TABLE enroll1;
select * from enroll1;


--Cross JOIN
--두 개이상의 테이블을 조건없이 합치는 연산 수행.

SELECT student.*, enroll.*
FROM student CROSS JOIN enroll;
SELECT * FROM student;

--EQIT JOIN
--두 개 이상의 테이블에 관련 있는 공통 열의 값을 이용하여 논리적으로 결합하는 연산 수행
--WHERE절에서 '=' 사용.
SELECT student.STU_NO,STU_DEPT,STU_GRADE, enr_grade
FROM student , enroll 
WHERE student.STU_NO = enroll.STU_NO;

--NATURAL JOIN ->자동으로 두 테이블의 공통 열을 찾아서 WHERE부분을 자동으로 맞춰준다.     
--※하지만 공통 된 열이 2개 이상이면 사용이 불가능 하다.
SELECT STU_NO,STU_NAME,STU_DEPT,ENR_GRADE
FROM STUDENT NATURAL JOIN ENROLL;

--공통된 열이 2개 이상일 경우 - JOIN ~ USING
SELECT stu_no, stu_name,stu_dept,enr_grade
FROM student JOIN enroll USING(stu_no);

--JOIN ~ ON
SELECT student.stu_no, stu_name,stu_dept,enr_grade
FROM student JOIN enroll ON student.stu_no = enroll.stu_no;

--101번 과목을 수강하는 학생들의 학번과 이름을 검색하시오
SELECT student.stu_no, stu_name
FROM student,enroll
WHERE student.stu_no = enroll.stu_no
AND sub_no = 101;

--101번 또는 102번 과목을 수강하는 학생의 학번과 이름을 검색하시오
SELECT student.stu_no,stu_name
FROM student, enroll
WHERE student.stu_no = enroll.stu_no
AND sub_no IN (101,102);

SELECT stu_no, stu_name FROM student JOIN enroll USING(stu_no);

--'컴퓨터개론' 과목을 수강하는 학생들의 학번, 이름, 과목이름을 검색하시오
SELECT student.stu_no,stu_name, sub_name
FROM student,enroll,subject
WHERE enroll.stu_no = student.stu_no
AND enroll.sub_no = subject.sub_no
AND sub_no = 101;

--Non-equl JOIN
--'='연산자를 사용하지 안호는다
--기본키와 외래키 관계가 아닌 열값들의 의미있는 관계로 조인하는 경우

--인사관리 DB에서 사원 테이블의 급여 열 값이 급여테이블의 하위급여와 상위급여 사이에 사원의 급여등급을 결정하는 질의문.
SELECT empno, ename,sal,grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal;

--OUTHER JOIN : LEFT RIGHT FULL
--조인 조건을 만족하지 않는 행들도 결과에 포함시키기 위한 조인
SELECT e.*, sub_name
FROM enroll e, subject s
WHERE e.sub_no = s.sub_no;

select * from enroll order by sub_no;
select * from subject;

SELECT e.*, sub_name
FROM enroll e RIGHT OUTER JOIN subject s --왼쪽에 없는 값이 오른쪽에 있음
ON e.sub_no = s.sub_no;

SELECT e.*, sub_name
FROM enroll e FULL OUTER JOIN subject s --왼쪽에 없는 값이 오른쪽에 있음
ON e.sub_no = s.sub_no;

--집합 연산자
--UNION : 두 질의 결과값의 합. 중복을 제거함
--UNION ALL: 두 질의 결과값의 합. 중복 포함
--INTERSECT : 두 질의 결과 공통되는 값(교집합)
--MINUS :  첫 번쨰 질의 결과에서 두 번째 결과에 있는 행을 제거함(차집합)

CREATE TABLE a_student
AS SELECT * FROM student WHERE stu_dept IN ('기계','전기전자');

SELECT * FROM a_student;

CREATE TABLE b_student
AS SELECT * FROM student WHERE stu_dept IN ('전기전자','컴퓨터정보');

--UNION : 두 질의 결과값의 합. 중복을 제거함
SELECT * FROM a_student
UNION
SELECT * FROM b_student;

--UNION ALL: 두 질의 결과값의 합. 중복 포함
SELECT * FROM a_student
UNION ALL
SELECT * FROM b_student;

--INTERSECT : 두 질의 결과 공통되는 값(교집합)
SELECT * FROM a_student
INTERSECT
SELECT * FROM b_student;

--MINUS :  첫 번쨰 질의 결과에서 두 번째 결과에 있는 행을 제거함(차집합)
SELECT * FROM a_student
MINUS
SELECT * FROM b_student;


--부질의(subQuery)
--SELECT 문 안에 포함된 또 다른 SELECT 문을 서브쿼리라고 한다.

--'옥성우' 학생보다 신장이 큰 학생들의 학번 이름 신장을 구하시오

SELECT stu_no,stu_name,stu_height
FROM student
WHERE stu_height > (SELECT stu_height FROM student WHERE stu_name = '옥성우');

--SELF JOIN
--자기 자신 테이블과 조인
--사원의 상급자 사원을 구하는 질의문
SELECT a.empno as 사원번호, a.ename as 사원이름, b.empno as 상급자사원번호, b.ename as 상급자이름
FROM emp a, emp b
WHERE a.mgr = b.empno; 

SELECT  a.stu_name,a.stu_height
FROM student a, student b
WHERE a.stu_height > b.stu_height 
AND b.stu_name = '옥성우';

SELECT stu_height FROM student;


--학생테이블에서 '박희철' 학생과 같은 ㅊ중인 학생의 정보를 구하시오
SELECT * 
FROM student
WHERE stu_weight = (SELECT stu_weight FROM student WHERE stu_name = '박희철')
AND stu_name <> '박희철';

--학생테이블에서 '컴퓨터정보' 학과와 같은 반인 다른 학과 학생정보를 구하시오
SELECT *
FROM student
WHERE stu_class IN('A','B','C') AND stu_dept <> '컴퓨터정보';

--최대 신장이 175 이상인 학과와 학과별 최대 신장을 구하시오
SELECT STU_DEPT, MAX(STU_HEIGHT) FROM student
GROUP BY STU_DEPT
HAVING MAX(STU_HEIGHT) >= 175;


--전체 학생들의 평균 신장보다 큰 학생을 구하시오
SELECT *
FROM student
WHERE stu_height >(SELECT AVG(stu_height) FROM student);

--모든 학과들의 평균 신장보다 큰 학생의 정보를  구하시오
SELECT MAX(AVG(stu_height))
FROM student
GROUP BY stu_dept;

SELECT stu_dept, ROUND(AVG(stu_height),2) AS AVG_height
FROM student
GROUP BY stu_dept;


--컴퓨터정보과의 최소신장과 비교하여 최소신장이 더 큰 학과의 학과명과 최소 신장을 구하시오
SELECT stu_dept, MIN(stu_height)
FROM student
GROUP BY stu_dept
HAVING MIN(stu_height) > (SELECT MIN(stu_height) FROM student GROUP BY stu_dept HAVING stu_dept = '컴퓨터정보');

--101번 과목을 수강하는 학생들의 학번과 이름을 검색
SELECT stu_no, stu_name
FROM student
WHERE stu_no IN (SELECT stu_no FROM enroll WHERE sub_no = 101);

--101번 과목을 수강한 학생들의 학번, 이름, 점수를 검색하시오
SELECT s.stu_no,s.stu_name,e.enr_grade
FROM student s, enroll e
WHERE s.stu_no = e.stu_no
AND sub_no = 101;


--모든 학과들의 평균 신장보다 큰 학생의 정보를 구하시오
SELECT * FROM student
WHERE stu_height > (SELECT AVG(AVG(stu_height)) FROM student GROUP BY stu_dept);

