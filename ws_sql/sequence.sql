--SEQUENCE
--자동으로 증가하는 숫자 생성.
CREATE SEQUENCE seq_test --호출 만으로도 생성 사능
START WITH 1 --처음 시작할 숫자
INCREMENT BY 1 --증가할 값
 --최소값
 --최대값
NOCYCLE --최대값 도달 시 순환 여부
NOCACHE; --시퀀스 번호 캐시할지 여부

SELECT seq_test.NEXTVAL FROM dual;--호출마다 INCREMENT 만큼 증가

SELECT seq_test.CURRVAL FROM dual;--직전에 NEXTVAL로 생성된 번호를 확인, NEXTVAL을 실행하지 않으면 동작하지 않음

DROP SEQUENCE seq_test;
DROP TABLE t2;

CREATE TABLE t2(
tno NUMBER PRIMARY KEY,
tname VARCHAR2(20)
);

INSERT INTO t2(tno,tname) VALUES(seq_test.nextval,'test7');
select * from t2;

CREATE TABLE t2_cpy
AS SELECT * FROM t2 WHERE tno = 1;

select * from t2_cpy;
--병합하기
MERGE INTO t2_cpy --병합 대상
USING t2 --병합 할 테이블
ON(t2.tno = t2_cpy.tno)--병합 조건
WHEN MATCHED THEN--맞으면
UPDATE SET t2_cpy.tname = t2.tname--실행
WHEN NOT MATCHED THEN--안 맞으면
INSERT VALUES (t2.tno, t2.tname);--실행

   
UPDATE t2 SET tname= 'xxx' WHERE tno = 2;   

select * from t2_cpy;

--SELECT * FROM WHERE --- 뒤에 FOR UPDATE 를 붙이면 다른 사용자들에게 UPDATE 할 예정이라고 알리는 것\


select * from t2;
 
 drop table parent;
 create table parent(
 id NUMBER primary key,
 name varchar2(100)
 );
 drop table child;
 create table child(
 id number primary key,
 parent_id number,
 constraint fk_parent FOREIGN KEY (parent_id)
 REFERENCES parent(id)
 ON DELETE CASCADE
 );
 
 INSERT INTO parent VALUES (1, 'AAA');
 INSERT INTO child VALUES (1, 1);
 
 delete from parent where id = 1;
 
 delete  from child where id = 1;
