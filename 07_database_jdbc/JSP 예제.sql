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