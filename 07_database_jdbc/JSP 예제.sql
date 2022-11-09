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