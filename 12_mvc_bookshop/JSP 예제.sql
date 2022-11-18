-- 사용자 테이블
CREATE TABLE member(
  name VARCHAR2(20),
  userid VARCHAR2(10),
  pwd VARCHAR2(10),
  email VARCHAR2(20),
  phone char(13),
  admin NUMBER(1) default 0, -- 사용자는 0, 관리자는 1
  PRIMARY KEY(userid)
);

insert into member values('이순신', 'sslee', '1234', 'sslee@email.com', '010-
2220-2332', 0);
insert into member values('유관순', 'ksyou', '1234', 'ksyou@email.com', '010-
8847-5633', 1);
insert into member values('장보고', 'bkjang', '1234', 'bkjang@email.com',
'010-5574-7868', 0);
commit;

SELECT * FROM member;
DROP TABLE member;

-- 상품정보 테이블
CREATE TABLE item(
  name VARCHAR2(20),
  price NUMBER(8),
  description VARCHAR2(100)
);

SELECT * FROM item;

-- 상품정보 테이블
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

INSERT INTO product VALUES(product_sqe.NEXTVAL, '작별인사', 12600, 'book1.jpg', 
'김영하 장편소설');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '흔한남매10', 12150, 'book2.jpg', 
'웃음과 공감을 자아내는 흔한남매의 활기찬 일상');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '불편한 편의점', 12600, 'book3.jpg', 
'김호년 작가의 장편소설');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '마음의 법칙', 14400, 'book4.jpg', 
'사람의 마음을 사로잡는 51가지 심리학');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '변화하는 세계질서', 34200, 'book5.jpg', 
'김영하 장편소설');
commit;

SELECT * FROM product;

-- 게시판 테이블
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
    VALUES(board_seq.NEXTVAL, '1234', '장보고', 'bkjang@email.com', '정기모임', '금주 금요일에 모여요!');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '강감찬', 'kckang@email.com', '게시글 제목', '첫번째 게시글입니다.');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '안창호', 'chahn@email.com', '제목1', '제목1 게시글입니다.');

commit;

SELECT * FROM board;
SELECT * FROM board ORDER BY num desc;
drop table board;
drop sequence board_seq;

-- 영화 테이블
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
       VALUES(movie_seq.NEXTVAL, '첫 키스만 50번 째', 9900, '피터 시걸', '아담 샌들러', 'movie1.jfif', '헨리(아담 샌들러)는 낮에는 하와이 수족관에서 동물들을 돌보고, 밤에는 여행객들과의 화끈한 하룻밤을 즐기는 노련한 작업남. 우연히 루시를 만나게 된 그는 사랑스러운 그녀에게 첫 눈에 반해 다가간다. 그러나 헨리의 화려한 입담에 넘어온 줄로만 알았던 루시는 다음 날 그를 파렴치한 취급하며 기억조차 하지 못한다. 헨리는 그녀가 단기 기억상실증에 걸렸으며, 매일 아침이면 모든 기억이 10월 13일 일요일 교통사고 당일로 돌아가버린다는 사실을 알게 된다. 매일이 자신과의 첫 만남인 ‘루시’의 마음을 사로잡기 위해 헨리는 매번 기상천외한 작업을 시도하고, 하루 하루 달콤한 첫 데이트를 만들어가던 어느 날, 루시는 자신이 단기 기억상실증에 걸렸다는 사실을 깨닫고 충격을 받게 되는데... 과연, 두 사람의 사랑은 이뤄질 수 있을까?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '해리가 샐리를 만났을 때', 9900, '롭 라이너', '맥 라이언', 'movie2.jfif', '"우린 친구가 될 수 없겠네요." 대학 졸업 후 뉴욕행을 함께 하게 된 해리와 샐리. 남자와 여자는 친구가 될 수 없다’는 명제로 두 사람은 설전을 벌이고, 성격도 취향도 정반대인 서로를 별종이라 생각한다. 뉴욕에 도착한 두 사람은 짧은 인사를 나누고 곧바로 헤어진다. "너랑 연애 안 하길 천만다행이야." 몇 년 뒤, 우연히 서점에서 재회한 두 사람. 샐리는 연인과 이별했고 해리는 아내에게 이혼을 통보 받았다. 두 사람은 이별에 대해 이야기하며 급속도로 가까워지고 비로소 둘도 없는 친구가 된다. "조금만 더 안아줘." 어느 날 샐리는 헤어진 연인의 결혼 소식을 듣게 되고 뒤늦은 이별의 아픔에 슬퍼한다. 해리는 그런 그녀를 말없이 안아주고 위로의 키스는 뜻밖의 하룻밤으로 이어지는데… 다음 날 아침, 우린 친구일까, 연인일까?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '월터의 상상은 현실이 된다', 9900, '벤 스틸러', '벤 스틸러', 'movie3.jfif', '라이프 잡지사에서 16년째 근무 중인 월터 미티. 반복되는 일상이지만 상상을 통해 특별한 순간을 꿈꾸는 그에게 폐간을 앞둔 라이프지의 마지막 호 표지 사진을 찾아오는 미션이 생긴다. 평생 국내를 벗어나 본 적 없는 월터는 문제의 사진을 찾아 그린란드, 아이슬란드 등을 넘나들며 평소 자신의 상상과는 비교할 수 없는 거대한 어드벤처를 시작한다. 누구보다 평범한 일상을 살던 월터, 그 누구도 겪은 적 없는 특별한 생애 최고의 순간을 맞이하게 된다!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '그린 나이트', 9900, '데이빗 로워리', '데브 파텔', 'movie4.jfif', '크리스마스 이브, 아서왕과 원탁의 기사들 앞에 나타난 녹색 기사, "가장 용맹한 자, 나의 목을 내리치면 명예와 재물을 주겠다"고 제안한다. 단, 1년 후 녹색 예배당에 찾아와 똑같이 자신의 도끼날을 받는다는 조건으로. 아서왕의 조카 가웨인이 도전에 응하고 마침내 1년 후, 5가지 고난의 관문을 거치는 여정을 시작하는데… 전설이 될 새로운 모험, 너의 목에 명예를 걸어라!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '헤어질 결심', 9900, '박찬욱', '탕웨이', 'movie5.jfif', '산 정상에서 추락한 한 남자의 변사 사건. 담당 형사 해준(박해일)은 사망자의 아내 서래(탕웨이)와 마주하게 된다. "산에 가서 안 오면 걱정했어요, 마침내 죽을까 봐." 남편의 죽음 앞에서 특별한 동요를 보이지 않는 서래. 경찰은 보통의 유가족과는 다른 서래를 용의선상에 올린다. 해준은 사건 당일의 알리바이 탐문과 신문, 잠복수사를 통해 서래를 알아가면서 그녀에 대한 관심이 점점 커져가는 것을 느낀다. 한편, 좀처럼 속을 짐작하기 어려운 서래는 상대가 자신을 의심한다는 것을 알면서도 조금의 망설임도 없이 해준을 대하는데…. 진심을 숨기는 용의자 용의자에게 의심과 관심을 동시에 느끼는 형사 그들의 <헤어질 결심>');
commit;
SELECT * FROM movie;

DROP TABLE movie;

-- 도서 쇼핑몰 테이블
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
values('hongkd@email.com', 1111, '홍길동', sysdate, '인천시 남동구 정각로 29', '010-2222-1234');
insert into member(id, pwd, name, reg_date, address, tel)
values('aaaa@email.com', 1234, '유관순', sysdate, '서울시 마포구 양화로6길 9', '010-1111-1234');
insert into member(id, pwd, name, reg_date, address, tel)
values('kingdora@email.com', 2222, '이순신', sysdate, '경기도 구리시 아차산로 439', '010-3333-1234');
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

insert into bank(account, bank, name) values('11111-111-11111', '내일은행', '홍길동');
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
  sanction VARCHAR2(100) DEFAULT '상품 준비중'
);