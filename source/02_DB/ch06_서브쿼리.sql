--[VI] 서브쿼리 : 메인 QUERY(SQL문) 안에 QUERY를 내포된 QUERY
--1. 서브쿼리 개념과 종류
SELECT *
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL)
                 FROM EMP);

--(1) 단일행 서브쿼리는 서브쿼리 결과가 단일행 : =,>,<,<=,>=,!=
 --EX. SCOTT과 동일한 부서번호에서 근무하는 사원의 이름과 급여
SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';

SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';

--(2) 다중행 서브쿼리는 서브쿼리 결과가 2행이상 : IN, NOT IN, ANY, SOME, ALL, EXISTS
    --EX. SCOTT이나 KING과 동일한 부서번호에서 근무하는 사원의 정보
SELECT DEPTNO
    FROM EMP
    WHERE ENAME IN ('SCOTT', 'KING'); --서브쿼리가 될 SQL문

SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE ENAME IN ('SCOTT', 'KING'));

-- 2. 단일행 서브쿼리
    --EX. SCOTT과 동일한 근무지에서 근무하는 사원의 정보
SELECT LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND ENAME = 'SCOTT';
        
SELECT *
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND D.LOC = (SELECT LOC
                     FROM EMP E, DEPT D
                     WHERE E.DEPTNO = D.DEPTNO
                        AND ENAME = 'SCOTT')
        AND ENAME <> 'SCOTT';

--EX. 최초입사일과 최초입사한 사람의 정보
SELECT MIN(HIREDATE)
    FROM EMP;

SELECT *
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE)
                      FROM EMP);
                    
--EX. 최근입사일과 최근입사한 사람의 정보
SELECT *
    FROM EMP
    WHERE HIREDATE =(SELECT MAX(HIREDATE)
                     FROM EMP);
                     
--EX. 최초입사일, 최초입사자이름, 최근입사일, 최근입사자 이름
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.HIREDATE
    FROM EMP E1, EMP E2
    WHERE E2.HIREDATE = (SELECT MAX(HIREDATE)
                         FROM EMP)
      AND E1.HIREDATE = (SELECT MIN(HIREDATE)
                         FROM EMP);
                         
SELECT (SELECT MIN(HIREDATE) FROM EMP) FIRSTDAY,
       (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) FIRSTMAN,
       (SELECT MAX(HIREDATE) FROM EMP) LISTDAY,
       (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) LISTMAN
   FROM DUAL;
   
--EX. SCOTT과 같은 부서에 근무하는 사람들의 급여합
SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                      FROM EMP
                      WHERE ENAME = 'SCOTT');
                      
--EX. DALLAS에서 근무하는 사원의 이름, 부서번호를 출력
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM DEPT
                        WHERE LOC='DALLAS');

SELECT ENAME, E.DEPTNO
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND LOC = 'DALLAS';

--EX. 직속상관이 KING인 사원의 이름과 급여를 출력
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                    FROM EMP
                    WHERE ENAME = 'KING');

--EX. 평균급여 이하로 받는 사원의 이름, 급여를 출력
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                    FROM EMP);

--EX. 평균급여 이하로 받는 사원의 이름, 급여, 평균급여를 출력
SELECT ENAME, SAL,(SELECT TRUNC(AVG(SAL))
                    FROM EMP) 평균
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                    FROM EMP);

--EX. 사원이름, 급여, 평균급여와의 차이
SELECT ENAME, SAL, SAL - (SELECT TRUNC(AVG(SAL))
                            FROM EMP) DIFF
    FROM EMP;

--단일행 다중열 서브쿼리
--EX. SCOTT과 JOB도 같고, 부서번호도 같은 직원의 모든 필드 출력
SELECT *
    FROM EMP
    WHERE (DEPTNO, JOB) = (SELECT DEPTNO, JOB
                                FROM EMP
                                WHERE ENAME = 'SCOTT');


-- ★ 총 연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, TO_CHAR(HIREDATE, 'RR/MM/DD')
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE)
                        FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL)
                    FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL)
                    FROM EMP);

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                    FROM EMP);

--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT * FROM SALGRADE;

SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE
                            FROM EMP
                            WHERE ENAME = 'SCOTT')
        AND ENAME <> 'SCOTT';

--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D,SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND E.DEPTNO = D.DEPTNO
        AND HIREDATE < (SELECT HIREDATE
                            FROM EMP
                            WHERE ENAME = 'SCOTT')
        AND ENAME <> 'SCOTT'
    ORDER BY SAL DESC;

--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL
                    FROM EMP
                    WHERE ENAME ='BLAKE');

--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE
                         FROM EMP
                         WHERE ENAME ='MILLER');

--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL)
                    FROM EMP);

--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL >= (SELECT SAL
                    FROM EMP
                    WHERE EMPNO = 7698)
        AND DEPTNO = (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME = 'CLARK');

--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE  E.DEPTNO = D.DEPTNO
        AND SAL >= (SELECT SAL
                     FROM EMP
                     WHERE EMPNO = 7698)
        AND DNAME = (SELECT DNAME
                        FROM EMP E, DEPT D
                        WHERE E.DEPTNO = D.DEPTNO
                            AND ENAME = 'CLARK');

--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME = 'BLAKE');

--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL)
                    FROM EMP);
                    
-- 23. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호
SELECT E1.EMPNO, E1.ENAME, E1.SAL, E1.DEPTNO
    FROM EMP E1
    WHERE E1.SAL >= (SELECT AVG(E2.SAL)
                     FROM EMP E2
                     WHERE E2.DEPTNO = E1.DEPTNO);

-- 24. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT E1.DEPTNO, E1.ENAME, E1.SAL, E1.JOB
    FROM EMP E1
    WHERE E1.SAL <= (SELECT AVG(E2.SAL)
                     FROM EMP E2
                     WHERE E2.JOB = E1.JOB);


-- 3. 다중행 서브쿼리


































