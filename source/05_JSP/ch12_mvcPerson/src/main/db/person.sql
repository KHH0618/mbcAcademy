-- 테이블 및 시퀀스 제거
DROP TABLE PERSON;
DROP SEQUENCE PERSON_ID_SEQ;
-- 테이블 및 시퀀스 생성
CREATE SEQUENCE PERSON_ID_SEQ 
    MAXVALUE 999999 
    NOCACHE NOCYCLE;

CREATE TABLE PERSON(
ID NUMBER(6) PRIMARY KEY, -- 순번
NAME VARCHAR2(50) NOT NULL, -- 이름
TEL VARCHAR2(50) UNIQUE, -- 전화
ADDRESS VARCHAR2(250), -- 주소
BIRTH DATE, -- 생년월일
MEMO VARCHAR2(4000), -- 메모
RDATE DATE DEFAULT SYSDATE NOT NULL -- 등록 시점
);
--더미데이터 생성
INSERT INTO PERSON(ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
    VALUES(PERSON_ID_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울', NULL, NULL);
INSERT INTO PERSON(ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
    VALUES(PERSON_ID_SEQ.NEXTVAL, '김길동', '010-8888-9999', '서울', NULL, NULL);
INSERT INTO PERSON(ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
    VALUES(PERSON_ID_SEQ.NEXTVAL, '구길동', '010-8888-7777', '서울', NULL, NULL);
COMMIT;
-- DAO들어갈 QUERY
-- 1.LIST : public ArrayList<Person> getPersonList()
SELECT * FROM PERSON;

-- 2.LIST(paging 추가) : public ArrayList<Person> getPersonList(int startRow, int endRow) : 몇등 ~ 몇등
SELECT * 
  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A)
  WHERE RN BETWEEN 2 AND 3;
    
-- 2. getCount (paging 처리시 필요한 전체 갯수)
SELECT COUNT(*) CNT FROM PERSON;

-- 3. 추가 : public int insertPerson(Person person)
INSERT INTO PERSON(ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
    VALUES(PERSON_ID_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울', NULL, NULL);
-- 4. 한명출력 : public Person getPerson(int id)
SELECT *
    FROM PERSON
    WHERE ID = '1';

-- 5. 수정 : public int updatePerson(Person person)
UPDATE PERSON
    SET ID = '1', NAME='신길동',TEL = '010-8888-8888', ADDRESS='부산', BIRTH='', MEMO=''
    WHERE ID = 1;

-- 6. 삭제 : public int deletePerson(int id)
DELETE PERSON
    WHERE ID = 1;