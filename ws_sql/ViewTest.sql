--VIEW: 이미 존재하는 테이블을 논리적으로 병합해서 생성 가능(물리적인 생성은 없음)
--GRANT CREATE VIEW TO '사용자'; = 뷰를 만드는 권한을 부여
CREATE VIEW v_student
as SELECT * FROM student;

SELECT * FROM v_student;
--학생 과목 enroll
CREATE VIEW stu_sub_enr AS 
SELECT DISTINCT *--stu_no,stu_name,stu_dept,stu_grade,stu_class,stu_gender, stu_height,stu_weight,sub_no,sub_name,sub_prof,sub_grade,sub_dept,sub_no,stu_no,enr_grade
FROM student, subject, enroll
WHERE student.stu_no = enroll.stu_no AND enroll.sub_no = subject.sub_no;


SELECT s.stu_no, stu_name,su.sub_no,sub_name,enr_grade
FROM student s
JOIN enroll e ON s.stu_no = e.stu_no
JOIN subject su ON e.sub_no = su.sub_no;

CREATE VIEW v_stu
AS SELECT s.stu_no, stu_name,su.sub_no,sub_name,enr_grade
FROM student s
JOIN enroll e ON s.stu_no = e.stu_no
JOIN subject su ON e.sub_no = su.sub_no;

SELECT * FROM v_stu WHERE enr_grade >= 80;

SELECT * FROM student1;

INSERT INTO student1 VALUES(20250417,'홍길동','기계',1,'c','M',190,90);

SAVEPOINT spl;
INSERT INTO student1 VALUES(20250418,'임꺽정','기계',1,'c','M',190,90);

SAVEPOINT sp2;

INSERT INTO student1 VALUES(20250419,'james','기계',2,'c','M',170,90);

UPDATE student1 SET stu_height = 160 WHERE stu_no = 20250418;

ROLLBACK;
Commit;
ROLLBACK TO sp2;





