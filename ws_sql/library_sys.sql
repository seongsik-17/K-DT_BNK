CREATE TABLE member(
memberno NUMBER(5) PRIMARY KEY,
name VARCHAR2(6),
phone VARCHAR2(20)
);

CREATE TABLE brrow(
rentno NUMBER(5)PRIMARY KEY,
memberno NUMBER(5),
redate DATE,
FOREIGN KEY(memberno) REFERENCES member(memberno)
);

CREATE TABLE book(
bookno NUMBER(5) PRIMARY KEY,
title VARCHAR2(20),
writer VARCHAR2(4),
rentno NUMBER(5),
FOREIGN KEY(rentno) REFERENCES brrow(rentno)
);

DESC book;



