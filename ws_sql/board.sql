CREATE TABLE tbl_member(
id VARCHAR2(20) PRIMARY KEY,
pw VARCHAR2(10),
name VARCHAR2(50),
phone CHAR(13),
grade CHAR(1)--'A','B','C'
);

CREATE TABLE tbl_board(
bno NUMBER PRIMARY KEY,
title VARCHAR2(100),
content VARCHAR2(1000),
writer VARCHAR2(20),
regdate DATE,
FOREIGN KEY(writer) REFERENCES tbl_member(id)
);

DESC tbl_board;

INSERT INTO tbl_member VALUES ('id1','1111','일식','010-1111-1111','A');
INSERT INTO tbl_member VALUES ('id2','2222','이식','010-2222-2222','B');
INSERT INTO tbl_member VALUES ('id3','3333','삼식','010-3333-3333','C');
INSERT INTO tbl_member VALUES ('id4','4444','사식','010-4444-5555','A');
INSERT INTO tbl_member VALUES ('id5','3333','오식','010-5555-5555','B');
INSERT INTO tbl_member VALUES ('id6','3333','육식','010-6666-6666','C');

INSERT INTO tbl_board VALUES (1,'일식이가 말아주는 첫 게시글','여긴 뭐하는 게시판인가요?','id1',SYSDATE);
UPDATE tbl_board
SET regdate = SYSDATE
WHERE writer = 'id1';

select * from tbl_board;

SELECT bno,title,content,writer,regdate 
FROM (SELECT tbl_member.*,tbl_board.*
    FROM tbl_member, tbl_board
    WHERE tbl_member.id = tbl_board.writer);
    

INSERT INTO tbl_board VALUES(2,'일식이는 봐라','저번에 빌려간 1000원 언제 갚냐?','id2',SYSDATE);
INSERT INTO tbl_board VALUES(3,'어쩔TV','언제 준다고 말 안했잖아 기다려봐','id1',SYSDATE);

commit;
select * from tbl_member;
