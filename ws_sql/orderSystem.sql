CREATE TABLE tbl_product_202101(
pcode char(4) primary key,
pname varchar2(30),
cost number(7)
);
DESC tbl_product_202101;

INSERT INTO tbl_product_202101 VALUES('AA01','삼각김밥',1000);
INSERT INTO tbl_product_202101 VALUES('AA02','도시락',2500);
INSERT INTO tbl_product_202101 VALUES('AA03','봉지만두',3000);
INSERT INTO tbl_product_202101 VALUES('AA04','컵라면',1500);
INSERT INTO tbl_product_202101 VALUES('AA05','아메리카노',2000);
INSERT INTO tbl_product_202101 VALUES('AA06','콜라',800);

SELECT * from tbl_product_202101;

CREATE TABLE tbl_shop_202101(
shopno char(4) primary key,
shopname char(20),
discount number(3)
);

DESC tbl_shop_202101;

INSERT INTO tbl_shop_202101 VALUES('S001','AA할인점',10);
INSERT INTO tbl_shop_202101 VALUES('S002','BB할인점',15);
INSERT INTO tbl_shop_202101 VALUES('S003','CC할인점',10);
INSERT INTO tbl_shop_202101 VALUES('S004','DD할인점',15);

SELECT * FROM tbl_shop_202101;

CREATE TABLE tbl_order_202101(
orderno char(8) primary key,
shopno char(4),
orderdate char(8),
pcode char(4),
amount number(5),
FOREIGN KEY (shopno) REFERENCES tbl_shop_202101(shopno),
FOREIGN KEY (pcode) REFERENCES tbl_product_202101(pcode)
);

DROP TABLE tbl_order_202101;

INSERT INTO tbl_order_202101 VALUES('20210001','S001','20210302','AA01',50);
INSERT INTO tbl_order_202101 VALUES('20210002','S001','20210302','AA02',30);
INSERT INTO tbl_order_202101 VALUES('20210003','S001','20210302','AA03',20);
INSERT INTO tbl_order_202101 VALUES('20210004','S002','20210303','AA01',50);
INSERT INTO tbl_order_202101 VALUES('20210005','S002','20210303','AA02',40);
INSERT INTO tbl_order_202101 VALUES('20210006','S002','20210303','AA03',60);
INSERT INTO tbl_order_202101 VALUES('20210007','S001','20210304','AA01',60);
INSERT INTO tbl_order_202101 VALUES('20210008','S001','20210304','AA02',70);
INSERT INTO tbl_order_202101 VALUES('20210009','S001','20210304','AA03',80);
INSERT INTO tbl_order_202101 VALUES('20210010','S002','20210305','AA01',30);
INSERT INTO tbl_order_202101 VALUES('20210011','S002','20210305','AA02',40);
INSERT INTO tbl_order_202101 VALUES('20210012','S002','20210305','AA03',50);
INSERT INTO tbl_order_202101 VALUES('20210013','S001','20210306','AA01',30);
INSERT INTO tbl_order_202101 VALUES('20210014','S001','20210306','AA02',20);
INSERT INTO tbl_order_202101 VALUES('20210015','S001','20210306','AA03',50);

select * from tbl_order_202101;
DELETE FROM tbl_order_202101 WHERE orderno IN(20210016,20210017);

commit;

SELECT s.shopno, s.shopname, o.orderno, o.orderdate, p.pcode, p.pname,o.amount, p.cost,(o.amount*p.cost)AS MSRP
,((o.amount*p.cost)-(p.cost * o.amount/s.discount))AS DISMSRP
FROM tbl_product_202101 p, tbl_order_202101 o, tbl_shop_202101 s
WHERE s.shopno = o.shopno AND o.pcode = p.pcode
ORDER BY o.orderno;


SELECT o.shopno, p.pcode, p.pname,SUM(o.amount)AS totalorder
FROM tbl_product_202101 p, tbl_order_202101 o
WHERE o.pcode = p.pcode 
GROUP BY o.shopno, p.pcode, p.pname;

SELECT pcode,pname,cost,(cost*0.9)AS ten, (cost*0.85)AS fiftin
FROM tbl_product_202101 ;









