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










