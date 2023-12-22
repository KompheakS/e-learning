CREATE TABLE TB_CATEGORY
(
    C_ID   SERIAL PRIMARY KEY,
    C_NAME VARCHAR(100) UNIQUE -- Adding UNIQUE constraint to C_NAME
);
drop table tb_category;

SELECT *
FROM TB_CATEGORY;

INSERT INTO TB_CATEGORY(C_NAME)
VALUES ('Spring Boot');

CREATE TABLE TB_COURSE
(
    CO_ID            SERIAL PRIMARY KEY,
    CO_NAME          VARCHAR(100) UNIQUE,
    CO_CATEGORY_NAME VARCHAR(100),
    CO_USER_ID       INT,
    CONSTRAINT FK_CATEGROY FOREIGN KEY (CO_CATEGORY_NAME) REFERENCES TB_CATEGORY (C_NAME),
    CONSTRAINT FK_USER_ID FOREIGN KEY (CO_USER_ID) REFERENCES TB_USERS (U_ID)
);

DROP TABLE TB_COURSE;

select *
from tb_course;

CREATE TABLE TB_USERS
(
    U_ID            SERIAL PRIMARY KEY,
    U_USERNAME      VARCHAR(100),
    U_PASSWORD      VARCHAR(250),
    U_EMAIL         VARCHAR(100),
    U_PHONE_NUMBER  INT,
    U_DATE_OF_BIRTH TIMESTAMP,
    U_GENDER        VARCHAR(10),
    U_PHOTO         BYTEA,
    U_JOIN_DATE     TIMESTAMP
);

SELECT *
FROM TB_USERS;

CREATE TABLE TB_VIDEO
(
    V_ID                 SERIAL PRIMARY KEY,
    V_TITILE             VARCHAR(100) unique,
    V_DESCRIPTION        VARCHAR(200),
    V_VIDEO_LINK         VARCHAR(200),
    V_DATE_DATE_CREATED  TIMESTAMP,
    V_DATE_DATE_MODIFIED TIMESTAMP,
    V_USER_ID            INT,
    CONSTRAINT FK_TITLE FOREIGN KEY (V_TITILE) REFERENCES TB_COURSE (CO_NAME)
)

SELECT *
FROM TB_VIDEO;