select * from student;

select * from(
select rownum num, student.* from student) where num between 1 and 5;
--rownum 범위를 지정하여 가져오는 쿼리

select RANK() OVER (ORDER BY stu_height) rank, stu_name, stu_height
from student;--순위를 키 순으로 뽑아오는 쿼리(중복되는 값은 같은 순위로 설정)

UPDATE student SET stu_height = 166 WHERE stu_name = '심수정';

select DENSE_RANK() OVER(ORDER BY stu_height) rank, stu_name, stu_height
from student;--순위를 키 순으로 뽑아오는 쿼리(중복되어도 순서대로 순위를 매긴다)
select * from t1;
select * from emp1;
DESC emp1;
DESC student1;
select * from student1;
drop table tbl_board;
CREATE TABLE tbl_board(
bno number primary key,
title varchar2(50),
content varchar2(1000),
writer varchar2(50),
regdate date
);
INSERT INTO tbl_board VALUES(seq_board.nextval,'TITLE01','CONTENT01','user1',SYSDATE)
