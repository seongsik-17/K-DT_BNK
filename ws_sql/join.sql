SELECT * FROM emp1;
DROP TABLE emp1;
CREATE TABLE emp1 AS SELECT * FROM emp;

CREATE TABLE student2 AS SELECT * FROM student;
CREATE TABLE enrol2 AS SELECT * FROM enroll;
CREATE TABLE subject2 AS SELECT * FROM subject;

SELECT * FROM  student2;
SELECT * FROM enrol2;
SELECT * FROM subject2;

SELECT s.stu_name, sub.sub_name
FROM student2 s, subject2 sub, enrol2 e;
