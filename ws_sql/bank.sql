CREATE TABLE accounts(
account_id varchar2(10) primary key,
owner_name varchar2(50) not null,
balance DECIMAl(10,2) not null
);

INSERT INTO accounts VALUES('A001','김철수',1000000);
INSERT INTO accounts VALUES('A002','이영희',500000);

select * from accounts;

commit;