--[XI] 인덱스 : 조회를 빠르게 하는 인덱스

DROP TABLE EMP01;
CREATE TABLE EMP01
    AS SELECT * FROM EMP;

SELECT * FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01;
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO)
    VALUES (1111,'HONH',40);
INSERT INTO EMP01 SELECT * FROM EMP01;
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;

--인덱스 없이 조회
SELECT * FROM EMP01
    WHERE ENAME = 'HONH';

--인덱스 생성
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);

--인덱스 생성후 조회
SELECT * FROM EMP01
    WHERE ENAME = 'HONH';
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01;
ROLLBACK;
DROP INDEX IDX_EMP01_ENAME;
DROP TABLE EMP01;