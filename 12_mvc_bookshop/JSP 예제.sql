-- ����� ���̺�
CREATE TABLE member(
  name VARCHAR2(20),
  userid VARCHAR2(10),
  pwd VARCHAR2(10),
  email VARCHAR2(20),
  phone char(13),
  admin NUMBER(1) default 0, -- ����ڴ� 0, �����ڴ� 1
  PRIMARY KEY(userid)
);

insert into member values('�̼���', 'sslee', '1234', 'sslee@email.com', '010-
2220-2332', 0);
insert into member values('������', 'ksyou', '1234', 'ksyou@email.com', '010-
8847-5633', 1);
insert into member values('�庸��', 'bkjang', '1234', 'bkjang@email.com',
'010-5574-7868', 0);
commit;

SELECT * FROM member;
DROP TABLE member;

-- ��ǰ���� ���̺�
CREATE TABLE item(
  name VARCHAR2(20),
  price NUMBER(8),
  description VARCHAR2(100)
);

SELECT * FROM item;

-- ��ǰ���� ���̺�
CREATE TABLE product(
  code number(5),
  name varchar2(100),
  price number(8),
  pictureurl varchar(50),
  description varchar(1000),
  primary key(code)
);

CREATE SEQUENCE product_sqe
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO product VALUES(product_sqe.NEXTVAL, '�ۺ��λ�', 12600, 'book1.jpg', 
'�迵�� ����Ҽ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '���ѳ���10', 12150, 'book2.jpg', 
'������ ������ �ھƳ��� ���ѳ����� Ȱ���� �ϻ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '������ ������', 12600, 'book3.jpg', 
'��ȣ�� �۰��� ����Ҽ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '������ ��Ģ', 14400, 'book4.jpg', 
'����� ������ ������ 51���� �ɸ���');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '��ȭ�ϴ� ��������', 34200, 'book5.jpg', 
'�迵�� ����Ҽ�');
commit;

SELECT * FROM product;

-- �Խ��� ���̺�
CREATE TABLE board (
  num NUMBER(5) PRIMARY KEY,
  pass VARCHAR(30),
  name VARCHAR2(30),
  email VARCHAR2(30),
  title VARCHAR2(50),
  content VARCHAR2(1000),
  readcount NUMBER(4) default 0,
  writedate DATE default SYSDATE
);

CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '�庸��', 'bkjang@email.com', '�������', '���� �ݿ��Ͽ� �𿩿�!');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '������', 'kckang@email.com', '�Խñ� ����', 'ù��° �Խñ��Դϴ�.');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '��âȣ', 'chahn@email.com', '����1', '����1 �Խñ��Դϴ�.');

commit;

SELECT * FROM board;
SELECT * FROM board ORDER BY num desc;
drop table board;
drop sequence board_seq;

-- ��ȭ ���̺�
CREATE TABLE movie(
  code NUMBER(4) PRIMARY KEY,
  title VARCHAR2(50),
  price NUMBER(10),
  director VARCHAR2(20),
  actor VARCHAR2(20),
  poster VARCHAR2(100),
  synopsis VARCHAR2(3000)
);

CREATE SEQUENCE movie_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO movie
       VALUES(movie_seq.NEXTVAL, 'ù Ű���� 50�� °', 9900, '���� �ð�', '�ƴ� ���鷯', 'movie1.jfif', '�(�ƴ� ���鷯)�� ������ �Ͽ��� ���������� �������� ������, �㿡�� ���ఴ����� ȭ���� �Ϸ���� ���� ����� �۾���. �쿬�� ��ø� ������ �� �״� ��������� �׳࿡�� ù ���� ���� �ٰ�����. �׷��� ��� ȭ���� �Դ㿡 �Ѿ�� �ٷθ� �˾Ҵ� ��ô� ���� �� �׸� �ķ�ġ�� ����ϸ� ������� ���� ���Ѵ�. ��� �׳డ �ܱ� ��������� �ɷ�����, ���� ��ħ�̸� ��� ����� 10�� 13�� �Ͽ��� ������ ���Ϸ� ���ư������ٴ� ����� �˰� �ȴ�. ������ �ڽŰ��� ù ������ ����á��� ������ ������ ���� ��� �Ź� ���õ���� �۾��� �õ��ϰ�, �Ϸ� �Ϸ� ������ ù ����Ʈ�� ������ ��� ��, ��ô� �ڽ��� �ܱ� ��������� �ɷȴٴ� ����� ���ݰ� ����� �ް� �Ǵµ�... ����, �� ����� ����� �̷��� �� ������?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '�ظ��� ������ ������ ��', 9900, '�� ���̳�', '�� ���̾�', 'movie2.jfif', '"�츰 ģ���� �� �� ���ڳ׿�." ���� ���� �� �������� �Բ� �ϰ� �� �ظ��� ����. ���ڿ� ���ڴ� ģ���� �� �� ���١��� ������ �� ����� ������ ���̰�, ���ݵ� ���⵵ ���ݴ��� ���θ� �����̶� �����Ѵ�. ���忡 ������ �� ����� ª�� �λ縦 ������ ��ٷ� �������. "�ʶ� ���� �� �ϱ� õ�������̾�." �� �� ��, �쿬�� �������� ��ȸ�� �� ���. ������ ���ΰ� �̺��߰� �ظ��� �Ƴ����� ��ȥ�� �뺸 �޾Ҵ�. �� ����� �̺��� ���� �̾߱��ϸ� �޼ӵ��� ��������� ��μ� �ѵ� ���� ģ���� �ȴ�. "���ݸ� �� �Ⱦ���." ��� �� ������ ����� ������ ��ȥ �ҽ��� ��� �ǰ� �ڴ��� �̺��� ���Ŀ� �����Ѵ�. �ظ��� �׷� �׳ฦ ������ �Ⱦ��ְ� ������ Ű���� ����� �Ϸ������ �̾����µ��� ���� �� ��ħ, �츰 ģ���ϱ�, �����ϱ�?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '������ ����� ������ �ȴ�', 9900, '�� ��ƿ��', '�� ��ƿ��', 'movie3.jfif', '������ �����翡�� 16��° �ٹ� ���� ���� ��Ƽ. �ݺ��Ǵ� �ϻ������� ����� ���� Ư���� ������ �޲ٴ� �׿��� ���� �յ� ���������� ������ ȣ ǥ�� ������ ã�ƿ��� �̼��� �����. ��� ������ ��� �� �� ���� ���ʹ� ������ ������ ã�� �׸�����, ���̽����� ���� �ѳ���� ��� �ڽ��� ������ ���� �� ���� �Ŵ��� ��庥ó�� �����Ѵ�. �������� ����� �ϻ��� ��� ����, �� ������ ���� �� ���� Ư���� ���� �ְ��� ������ �����ϰ� �ȴ�!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '�׸� ����Ʈ', 9900, '���̺� �ο���', '���� ����', 'movie4.jfif', 'ũ�������� �̺�, �Ƽ��հ� ��Ź�� ���� �տ� ��Ÿ�� ��� ���, "���� ����� ��, ���� ���� ����ġ�� ���� �繰�� �ְڴ�"�� �����Ѵ�. ��, 1�� �� ��� ����翡 ã�ƿ� �Ȱ��� �ڽ��� �������� �޴´ٴ� ��������. �Ƽ����� ��ī �������� ������ ���ϰ� ��ħ�� 1�� ��, 5���� ���� ������ ��ġ�� ������ �����ϴµ��� ������ �� ���ο� ����, ���� �� ���� �ɾ��!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '����� ���', 9900, '������', '������', 'movie5.jfif', '�� ���󿡼� �߶��� �� ������ ���� ���. ��� ���� ����(������)�� ������� �Ƴ� ����(������)�� �����ϰ� �ȴ�. "�꿡 ���� �� ���� �����߾��, ��ħ�� ������ ��." ������ ���� �տ��� Ư���� ���並 ������ �ʴ� ����. ������ ������ ���������� �ٸ� ������ ���Ǽ��� �ø���. ������ ��� ������ �˸����� Ž���� �Ź�, �ẹ���縦 ���� ������ �˾ư��鼭 �׳࿡ ���� ������ ���� Ŀ������ ���� ������. ����, ��ó�� ���� �����ϱ� ����� ������ ��밡 �ڽ��� �ǽ��Ѵٴ� ���� �˸鼭�� ������ �����ӵ� ���� ������ ���ϴµ���. ������ ����� ������ �����ڿ��� �ǽɰ� ������ ���ÿ� ������ ���� �׵��� <����� ���>');
commit;
SELECT * FROM movie;

DROP TABLE movie;

-- ���� ���θ� ���̺�
-- member
CREATE TABLE member (
  id VARCHAR2(50) PRIMARY KEY,
  pwd VARCHAR2(16) NOT NULL,
  name VARCHAR2(30) NOT NULL,
  reg_date DATE DEFAULT SYSDATE,
  address VARCHAR2(255) NOT NULL,
  tel VARCHAR2(20) NOT NULL
);

insert into member(id, pwd, name, reg_date, address, tel)
values('hongkd@email.com', 1111, 'ȫ�浿', sysdate, '��õ�� ������ ������ 29', '010-2222-1234');
insert into member(id, pwd, name, reg_date, address, tel)
values('aaaa@email.com', 1234, '������', sysdate, '����� ������ ��ȭ��6�� 9', '010-1111-1234');
insert into member(id, pwd, name, reg_date, address, tel)
values('kingdora@email.com', 2222, '�̼���', sysdate, '��⵵ ������ ������� 439', '010-3333-1234');
commit;

DROP TABLE member;

-- manager
CREATE TABLE manager (
  managerId VARCHAR2(50) PRIMARY KEY,
  managerPwd VARCHAR2(16) NOT NULL
);

insert into manager(managerId, managerPwd) values('bookmaster@shop.com', '123456');
commit;

DROP TABLE manager;

-- book
CREATE TABLE book (
  book_id NUMBER PRIMARY KEY,
  book_kind VARCHAR2(3) NOT NULL,
  book_title VARCHAR2(255) NOT NULL,
  book_price NUMBER NOT NULL,
  book_count NUMBER NOT NULL,
  author VARCHAR2(40) NOT NULL,
  publishing_com VARCHAR2(30) NOT NULL,
  publishing_date VARCHAR2(16) NOT NULL,
  book_image VARCHAR2(255) NOT NULL,
  book_content VARCHAR2(2000) NOT NULL,
  discount_rate NUMBER DEFAULT 10 NOT NULL,
  reg_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE book_seq
START WITH 1
INCREMENT BY 1;

-- bank
CREATE TABLE bank(
  account VARCHAR2(30) NOT NULL,
  bank VARCHAR2(15) NOT NULL,
  name VARCHAR2(30) NOT NULL
);

insert into bank(account, bank, name) values('11111-111-11111', '��������', 'ȫ�浿');
commit;

-- cart
CREATE TABLE cart(
  cart_id NUMBER PRIMARY KEY,
  buyer VARCHAR2(30) NOT NULL,
  book_id NUMBER NOT NULL,
  book_title VARCHAR2(100) NOT NULL,
  buy_price NUMBER NOT NULL,
  buy_count NUMBER NOT NULL,
  book_image VARCHAR2(16) DEFAULT 'nothing.jpg'
);

CREATE SEQUENCE cart_seq
START WITH 1
INCREMENT BY 1;

DROP TABLE cart;

-- buy
CREATE TABLE buy(
  buy_id NUMBER NOT NULL,
  buyer VARCHAR2(50) NOT NULL,
  book_id VARCHAR2(12) NOT NULL,
  book_title VARCHAR2(100) NOT NULL,
  buy_price NUMBER NOT NULL,
  buy_count NUMBER NOT NULL,
  book_image VARCHAR2(16) DEFAULT 'nothing.jpg',
  buy_date DATE NOT NULL,
  account VARCHAR2(50) NOT NULL,
  deliveryName VARCHAR2(10) NOT NULL,
  deliveryTel VARCHAR2(20) NOT NULL,
  deliveryAddress VARCHAR2(100) NOT NULL,
  sanction VARCHAR2(100) DEFAULT '��ǰ �غ���'
);