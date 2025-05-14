CREATE TABLE member_tbl_02(
custno NUMBER(6) primary key,
custname VARCHAR2(20),
phone VARCHAR2(13),
address VARCHAR2(60),
joindate DATE,
grade CHAR(1),
city CHAR(2)
);
DESC member_tbl_02;

INSERT INTO member_tbl_02 VALUES(100001,'김행복','010-1111-2222','서울 동대문구 휘경1동','20151202','A','01');
INSERT INTO member_tbl_02 VALUES(100002,'이축복','010-1111-3333','서울 동대문구 휘경2동','20151206','B','01');
INSERT INTO member_tbl_02 VALUES(100003,'정믿음','010-1111-4444','울릉군 울릉읍 독도1리','20151001','B','30');
INSERT INTO member_tbl_02 VALUES(100004,'최사랑','010-1111-5555','울릉군 울릉읍 독도2리','20151113','A','30');
INSERT INTO member_tbl_02 VALUES(100005,'진평화','010-1111-6666','제주도 제주시 외나무골','20151225','B','60');
INSERT INTO member_tbl_02 VALUES(100006,'차공단','010-1111-7777','제주도 제주시 외나무골','20151211','C','60');
select * from member_tbl_02;

CREATE TABLE money_tbl_02(
custno NUMBER(6) NOT NULL,
saleno NUMBER(8) primary key,
pcost NUMBER(8),
amount NUMBER(4),
price NUMBER(8),
pcode VARCHAR2(4),
sdate DATE,
FOREIGN KEY (custno) REFERENCES member_tbl_02(custno)
);
DESC money_tbl_02;
INSERT INTO money_tbl_02 VALUES(100001,20160001,500,5,2500,'A001','20160101');
INSERT INTO money_tbl_02 VALUES(100001,20160002,1000,4,4000,'A002','20160101');
INSERT INTO money_tbl_02 VALUES(100001,20160003,500,3,1500,'A008','20160101');
INSERT INTO money_tbl_02 VALUES(100002,20160004,2000,1,2000,'A004','20160102');
INSERT INTO money_tbl_02 VALUES(100002,20160005,500,1,500,'A001','20160103');
INSERT INTO money_tbl_02 VALUES(100003,20160006,1500,2,3000,'A003','20160103');
INSERT INTO money_tbl_02 VALUES(100004,20160007,500,2,1000,'A001','20160104');
INSERT INTO money_tbl_02 VALUES(100004,20160008,300,1,300,'A005','20160104');
INSERT INTO money_tbl_02 VALUES(100004,20160009,600,1,600,'A006','20160104');
INSERT INTO money_tbl_02 VALUES(100004,20160010,3000,1,3000,'A007','20160106');

select * from money_tbl_02;
select * from member_tbl_02;
--시퀀스 시작부분
CREATE SEQUENCE seq_custno --호출 만으로도 생성 사능
START WITH 100007 --처음 시작할 숫자
INCREMENT BY 1 --증가할 값
NOCYCLE --최대값 도달 시 순환 여부
NOCACHE; --시퀀스 번호 캐시할지 여부

DROP sequence seq_custno;

commit;
--회원번호, 회원성명, 고객등급, 매출
SELECT member.custno, SUM(price)
FROM member_tbl_02 member, money_tbl_02 money
WHERE member.custno = money.custno
GROUP BY member.custno;

SELECT 
    member.custno, 
    member.custname, 
    member.grade, 
    SUM(money.price) AS total_price
FROM 
    member_tbl_02 member
JOIN 
    money_tbl_02 money ON member.custno = money.custno
GROUP BY 
    member.custno, member.custname, member.grade
ORDER BY 
    total_price DESC;


SELECT custno, SUM(price)
FROM money_tbl_02
GROUP BY custno;



