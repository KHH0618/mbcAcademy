-- [X] VIEW, IN-LINE VIEW, ★TOP-N★
-- 1. VIEW : 가상의 테이블 (1)단순뷰 (2)복합뷰
-- (1)단순뷰 : 하나의 테이블을 이용해서 만든 뷰(가상의 테이블은 물리공간과 데이터가 따로 없음)
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO
        FROM EMP;

SELECT * FROM EMP;
SELECT * FROM EMPV0;
SELECT * FROM TAB;
SELECT * FROM USER_TABLES;
SELECT * FROM USER_VIEWS;
INSERT INTO EMPV0
    VALUES (1111, '홍', 'MANAGER', NULL, NULL, 40);
ROLLBACK;

CREATE OR REPLACE VIEW EMPV0 -- 특정 행만 VIEW로 생성
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 30;

INSERT INTO EMPV0
    VALUES (1111, '홍', 'MANAGER', NULL, NULL, 9000, NULL, 40);

--단순뷰에서 INSERT가 불가한 경우 : 뷰 생성시 NOT NULL 필드를 미포함한 경우
CREATE OR REPLACE VIEW EMPV0
    AS SELECT ENAME, JOB
        FROM EMP;

INSERT INTO EMPV0
    VALUES ('HONG', 'MANAGER');

--VIEW의 제한 조건
--WITH CHECK OPTION 추가 : 뷰의 조거에 해당되는 데이터만 삽입, 수정, 삭제가 가능
--WITH READ ONLY 추가 : 읽기 전용 뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 30
        WITH CHECK OPTION;

SELECT * 
    FROM EMPV0 E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO)
    VALUES (1114, '홍', 30); -- ABLE
INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO)
    VALUES (1113, '홍', 40); -- NOT ABLE
DELETE FROM EMPV0 
    WHERE ENAME = '홍';
DELETE FROM EMPV0 
    WHERE ENAME = 'SMITH';

-- 읽기 전용 단순뷰(WITH READ ONLY 추가)
CREATE OR REPLACE VIEW EMPV0
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 20
        WITH READ ONLY;

INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO)
    VALUES (1114, '홍', 20);

-- (2)복합뷰 : 2개 이상의 테이블로 구상한 뷰, 가상의 필드를 이용한 뷰 DML문을 제한적으로만 이용(SELECT) INSERT불가
-- ① 2개 이상의 테이블로 구상한 복합뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, JOB, DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;

SELECT * FROM EMPV0;

-- ② 가상의 필드를 이용한 복합뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, SAL * 12 SALYEAR
        FROM EMP
        WHERE DEPTNO = 10;

CREATE OR REPLACE VIEW EMPV0 (NO, NAME, SALYEAR)
    AS SELECT EMPNO, ENAME, SAL * 12
        FROM EMP
        WHERE DEPTNO = 10;

    -- EX1. 사번, 이름, 10의 자리에서 반올림한 급여를 뷰로 생성
CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) SAL
        FROM EMP;
SELECT * FROM EMPV0;
    
    -- EX2. 중복이 제거된 JOB, DEPTNO를 뷰로 생성
CREATE OR REPLACE VIEW EMPV0
    AS SELECT DISTINCT JOB, DEPTNO
        FROM EMP;
SELECT * FROM EMPV0;

    -- EX3. 부서번호 최소급여, 최대급여, 부서평균(소수점 1자리에서 반올림)을 포함한 뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT DEPTNO, MIN(SAL) MINSAL, MAX(SAL) MAXSAL, ROUND(AVG(SAL),1) AVGSAL
        FROM EMP
        GROUP BY DEPTNO;
SELECT * FROM EMPV0;

    -- EX3. 부서명 최소급여, 최대급여, 부서평균(소수점 1자리에서 반올림)을 포함한 뷰
CREATE OR REPLACE VIEW EMPV0
    AS SELECT DNAME, MIN(SAL) MINSAL, MAX(SAL) MAXSAL, ROUND(AVG(SAL),1) AVGSAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
        GROUP BY DNAME;
SELECT * FROM EMPV0;

-- (2) INLINE-VIEW : FROM절의 서브쿼리를 INLINE-VIEW라 하며, FROM절에 오는 서브쿼리는 VIEW 작용
    --EX. 급여가 2000을 초과하나는 사원의 평균 급여
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL > 2000);

-- SELECT 필드1, 필드2,..
-- FROM (서브쿼리) 별칭, 테이블N
-- WHERE 조건
    -- EX. 부서평균의 월급보다 높은 월급을 받는 사원의 사번, 이름, 급여, 부서번호, 해당부서의 평균급여(반올림)

SELECT EMPNO, ENAME, SAL, E.DEPTNO, AVG.AVGSAL
    FROM EMP E,
         (SELECT DEPTNO, ROUND(AVG(SAL),1) AVGSAL
            FROM EMP
            GROUP BY DEPTNO) AVG
    WHERE E.DEPTNO = AVG.DEPTNO
        AND SAL > AVGSAL;

-- 3.TOP - N 구문(TOP 1~10등, 11~20등)
    -- ROWNUM : 테이블로부터 가져온 데이터 순서
SELECT ROWNUM, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = 20
    ORDER BY ENAME;

SELECT ROWNUM, ENAME, SAL
    FROM EMP
    ORDER BY SAL;

SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- 1등 ~ 꼴찌

-- SAL을 기준으로 1~5등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 1 AND 5;

-- SAL을 기준으로 6~10등
SELECT ROW.ROWNUM, ENAME, SAL
    FROM (SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC) ROW
    WHERE ROW.ROWNUM BETWEEN 6 AND 10; -- 에러

-- TOP - N
SELECT * 
    FROM (SELECT ROWNUM RN, S.*
            FROM (SELECT * FROM EMP ORDER BY SAL DESC) S)
    WHERE RN BETWEEN 6 AND 10;

--EX 이름 알파벳순으로 6 ~ 10번째 사원(순서, 이름, 사번 , JOB, MGR, HIREDATE)
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, N.*
                FROM (SELECT * FROM EMP ORDER BY ENAME) N)
    WHERE RN BETWEEN 6 AND 10;

--EX 입사순으로 11번째 ~ 15번째인 사원의 모든 필드 출력
SELECT *
    FROM(SELECT ROWNUM RN, N.*
            FROM (SELECT *
                    FROM EMP
                    ORDER BY HIREDATE) N)
    WHERE RN BETWEEN 11 AND 15;

-- ★ ★ ★ <총 연습문제> ★ ★ ★
-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT E.ENAME ENAME, E2.ENAME MGRNAME
        FROM EMP E, EMP E2
        WHERE E.MGR = E2.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). -- 학생 질문
SELECT DEPTNO, SUMSAL, RN
    FROM (SELECT ROWNUM RN, N.*
            FROM (SELECT SUM(SAL) SUMSAL, DEPTNO 
                    FROM EMP 
                    GROUP BY DEPTNO 
                    ORDER BY SUMSAL DESC) N);

-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT DEPTNO, SUMSAL, RN
    FROM (SELECT ROWNUM RN, N.*
            FROM (SELECT SUM(SAL) SUMSAL, DEPTNO 
                    FROM EMP 
                    GROUP BY DEPTNO 
                    ORDER BY SUMSAL DESC) N)
    WHERE RN BETWEEN 2 AND 3;

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM, N.* 
            FROM(SELECT *
                    FROM EMP 
                    ORDER BY HIREDATE DESC) N);

-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, N.* 
            FROM(SELECT * 
                    FROM EMP 
                    ORDER BY HIREDATE DESC) N)
    WHERE RN BETWEEN 1 AND 5;
            
-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, N.* 
            FROM(SELECT * 
                    FROM EMP 
                    ORDER BY HIREDATE DESC) N)
    WHERE RN BETWEEN 6 AND 10;


