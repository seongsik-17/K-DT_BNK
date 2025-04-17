--거래정보 테이블
CREATE TABLE customer(
c_code VARCHAR2(10)PRIMARY KEY,
c_name VARCHAR2(20),
c_ceo VARCHAR2(10),
c_addr VARCHAR2(30),
c_phone VARCHAR2(13)
);

--상품정보 테이블
CREATE TABLE product(
p_code VARCHAR2(10) PRIMARY KEY,
p_name VARCHAR2(20),
p_cost NUMBER,
p_group VARCHAR2(10)
);

--상품 재고 테이블
CREATE TABLE stock(
p_code VARCHAR2(10) PRIMARY KEY,
s_qty NUMBER,
FOREIGN KEY(p_code) REFERENCES product(p_code)
);

--입고 테이블
CREATE TABLE store(
p_code VARCHAR2(10) PRIMARY KEY,
s_sto NUMBER,
FOREIGN KEY(p_code) REFERENCES product(p_code)
);
--출고 테이블
CREATE TABLE delivery(
p_code VARCHAR2(10) PRIMARY KEY,
s_del NUMBER,
FOREIGN KEY(p_code) REFERENCES product(p_code)
);

--거래내역 테이블
CREATE TABLE trade(
t_seq VARCHAR2(10) PRIMARY KEY, --거래내역 일련번호
p_code VARCHAR2(10),--FK
c_code VARCHAR2(10),--FK
t_date DATE,
t_qty NUMBER,
t_cost NUMBER,
FOREIGN KEY(p_code) REFERENCES product(p_code),
FOREIGN KEY(c_code) REFERENCES customer(c_code)
);

--영업사원 테이블
CREATE TABLE employee(
e_no NUMBER PRIMARY KEY,
e_name VARCHAR2(10),
e_rank VARCHAR2(10),
e_date DATE
);

--판매실적 테이블
CREATE TABLE sales(
e_no NUMBER PRIMARY KEY,--FK
s_sales NUMBER,
p_code VARCHAR2(10),--FK
FOREIGN KEY(e_no) REFERENCES employee(e_no),
FOREIGN KEY(p_code) REFERENCES product(p_code)
);

--1.거래처 정보
INSERT INTO customer VALUES('sm','s사','이*용','서울특별시 서초구', '02-2255-0114');
INSERT INTO customer VALUES('lg','l사','구*모','서울특별시 영등포구', '02-3777-1114');

UPDATE customer SET c_ceo = '이*용' WHERE c_code = 'sm';
UPDATE customer SET c_ceo = '구*모' WHERE c_code = 'lg';
select * from customer;


--2.입 출고 재고 -> 구매팀
--상품코드
INSERT INTO product VALUES('m-f-01','냉장고01',100,'냉장고');
INSERT INTO product VALUES('m-f-02','냉장고02',200,'냉장고');
INSERT INTO product VALUES('m-f-03','냉장고03',300,'냉장고');

INSERT INTO product VALUES('m-a-01','에어컨01',100,'에어컨');
INSERT INTO product VALUES('m-a-02','에어컨02',200,'에어컨');
INSERT INTO product VALUES('m-a-03','에어컨03',300,'에어컨');

INSERT INTO product VALUES('m-r-01','세탁기01',100,'세탁기');
INSERT INTO product VALUES('m-r-02','세탁기02',200,'세탁기');
INSERT INTO product VALUES('m-r-03','세탁기03',300,'세탁기');
--select * from product where p_group = '에어컨';
--1.입고 2.재고확인 3.출고(자바에서 구현예정)

INSERT INTO stock VALUES('m-f-01',1);
INSERT INTO stock VALUES('m-f-02',2);
INSERT INTO stock VALUES('m-f-03',3);

INSERT INTO stock VALUES('m-a-01',1);
INSERT INTO stock VALUES('m-a-02',2);
INSERT INTO stock VALUES('m-a-03',3);

INSERT INTO stock VALUES('m-r-01',1);
INSERT INTO stock VALUES('m-r-02',2);
INSERT INTO stock VALUES('m-r-03',3);

select * from stock where p_code = 'm-f-01'; --재고 확인

--3.영업사원 고용
INSERT INTO employee VALUES(202501,'김사원','사원','2025-01-01'); 
INSERT INTO employee VALUES(202502,'이대리ㄴ','대리','2024-01-01'); 
INSERT INTO employee VALUES(202503,'박팀장','팀장','2022-01-01'); 
INSERT INTO employee VALUES(202504,'최사원','사원','2025-01-01'); 
INSERT INTO employee VALUES(202505,'문대리','대리','2023-01-01'); 
select * from employee;
--4.구매 -> 거래단가 + 10% --> 자바에서 구현
--INSERT INTO trade VALUES(2025041701,2025-04-17,1,select 

--5. 판매실적
