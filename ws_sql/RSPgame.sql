CREATE TABLE memberinfo(
id varchar2(20) primary key,
pw varchar2(20),
win number,
lose number,
draw number
);

INSERT INTO memberinfo VALUES('mss','1234',0,0,0);
select id,pw from memberinfo;
commit;