CREATE TABLE USERS (
    ID VARCHAR2(20) PRIMARY KEY,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(30),
    ROLE VARCHAR2(5)
);
INSERT INTO USERS VALUES ('test', 'test', '관리자', 'Admin');
INSERT INTO USERS VALUES ('user1', 'user1', '홍길동', 'User');
commit;
-------------
CREATE TABLE BOARD (
    SEQ NUMBER(5) PRIMARY KEY,
    TITLE VARCHAR2(200),
    WRITER VARCHAR2(20),
    CONTENT VARCHAR2(2000),
    REGDATE DATE DEFAULT SYSDATE,
    CNT NUMBER(5) DEFAULT 0
);
INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)
VALUES (1, '가입인사', '관리자', '잘 부탁드립니다~~');
COMMIT;

