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
                     
SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) SALE
                    FROM EMP
                    GROUP BY DEPTNO) AVGSAL
    WHERE E.DEPTNO = AVGSAL.DEPTNO
        AND SAL > AVGSAL.SALE;

-- 24. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT E1.DEPTNO, E1.ENAME, E1.SAL, E1.JOB
    FROM EMP E1
    WHERE E1.SAL <= (SELECT AVG(E2.SAL)
                     FROM EMP E2
                     WHERE E2.JOB = E1.JOB);

SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) SALE
                    FROM EMP
                    GROUP BY DEPTNO) AVGSAL
    WHERE E.DEPTNO = AVGSAL.DEPTNO
        AND SAL < AVGSAL.SALE;

-- 3. 다중행 서브쿼리 : IN, ALL, ANY(=SOME), EXISTS
--EX. 30번 부서 직원의 모든 급여들보다 큰 직원의 모든필드
--(1) ALL : 서브쿼리 결과가 모두 만족하면 참
SELECT SAL 
    FROM EMP 
    WHERE DEPTNO = 30;

SELECT *
    FROM EMP
    WHERE SAL > ALL(SELECT SAL
                    FROM EMP
                    WHERE DEPTNO=30);

SELECT *
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                 FROM EMP
                 WHERE DEPTNO=30);

--(2) ANY(=SOME) : 서브쿼리 결과가 하나라도 만족하면 참
--EX. 30번부서에 누구 한명보다 급여보다 큰 직원의 모든 필드

SELECT *
    FROM EMP
    WHERE SAL > ANY(SELECT SAL
                    FROM EMP
                    WHERE DEPTNO = 30);

SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                 FROM EMP
                 WHERE DEPTNO = 30);

--(3) IN
--EX. 부서별 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호
SELECT DEPTNO, MAX(HIREDATE)
    FROM EMP
    GROUP BY DEPTNO;

SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN(SELECT DEPTNO, MAX(HIREDATE)
                                  FROM EMP
                                  GROUP BY DEPTNO);

-- 급여가 3000이상 받는 사원이 소속된 부서 직원의 모든 필드
SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE SAL >= 3000);

--(4) EXISTS : 서브쿼리 결과가 존재하면 참
--EX. 직속부하가 있는 직원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP M
    WHERE EXISTS(SELECT *
                 FROM EMP
                 WHERE M.EMPNO=MGR);

--직속부하가 없는 직원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP M
    WHERE NOT EXISTS(SELECT *
                        FROM EMP
                        WHERE M.EMPNO = MGR); 

-- 탄탄1. 부서별로 가장 급여를 많이 받는 사원의 모든 정보를 출력(IN 연산자 이용)
--SELECT * FROM EMP WHERE (SAL) IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO); 
SELECT *
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL)
                                FROM EMP
                                GROUP BY DEPTNO);

-- 부서번호별 가장 큰 급여인 사원
SELECT E.*, DNAME, LOC, GRADE
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO
        AND E.SAL BETWEEN LOSAL AND HISAL
        AND SAL IN (SELECT MAX(SAL)
                        FROM EMP
                        GROUP BY DEPTNO)
    ORDER BY E.DEPTNO;


-- 탄탄2. 직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력(IN)
SELECT E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND E.DEPTNO IN (SELECT DEPTNO
                            FROM EMP
                            WHERE E.JOB = 'MANAGER'
                            GROUP BY DEPTNO);

-- 탄탄3. 급여가 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 급여를 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급을 출력
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND SAL IN (SELECT MAX(SAL)
                        FROM EMP, SALGRADE
                        WHERE SAL BETWEEN LOSAL AND HISAL
                            AND SAL >= 3000
                        GROUP BY GRADE)
    ORDER BY GRADE;

-- 탄탄4. 응용심화 : 입사일 분기별로 가장 높은 급여를 받는 사람들의 분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요
SELECT TO_CHAR(HIREDATE,'Q')||'분기' QUARTER, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) COMM
    FROM EMP E
    WHERE  (TO_CHAR(HIREDATE,'Q'),SAL) IN (SELECT TO_CHAR(HIREDATE,'Q'),MAX(SAL)
                                            FROM EMP
                                            GROUP BY TO_CHAR(HIREDATE,'Q'))
    ORDER BY QUARTER;

-- 탄탄5. 급여가 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 급여, 입사일을 출력
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE)
                        FROM EMP
                        WHERE SAL<3000);

-- 탄탄6. SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ALL이용)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL(SELECT SAL
                       FROM EMP
                       WHERE JOB = 'SALESMAN')
        AND JOB <> 'SALESMAN';

SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                    FROM EMP
                    WHERE JOB = 'SALESMAN');

-- 탄탄7. SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원도 출력(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY(SELECT SAL
                       FROM EMP
                       WHERE JOB = 'SALESMAN')
        AND JOB <> 'SALESMAN';

SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                    FROM EMP
                    WHERE JOB = 'SALESMAN')
         AND JOB <> 'SALESMAN';


-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM EMP
                        WHERE UPPER(ENAME) LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND LOC IN (SELECT LOC
                        FROM EMP
                        WHERE INITCAP(LOC) = 'Dallas');
                        
-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR IN (SELECT EMPNO
                    FROM EMP
                    WHERE UPPER(ENAME) = 'KING');

-- 17. SALES부서 사원의 이름, 업무
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM DEPT
                        WHERE UPPER(DNAME) = 'SALES');

-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                    FROM EMP
                    WHERE DEPTNO = 30);

-- 19.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL
                            FROM EMP
                            WHERE UPPER(ENAME) = 'FORD')
        AND ENAME <> 'FORD';

-- 20. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB IN (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'JONES')
        OR SAL > (SELECT SAL
                   FROM EMP
                   WHERE ENAME = 'FORD')
        AND ENAME <> 'FORD'
        AND ENAME <> 'JONES'
    ORDER BY JOB, SAL DESC;

-- 21. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL
                    FROM EMP
                    WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
        AND ENAME <> 'SCOTT'
        AND ENAME <> 'WARD';

-- 22. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO IN(SELECT DEPTNO
                        FROM DEPT
                        WHERE UPPER(LOC) = 'CHICAGO');

-- 25. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, DEPTNO
    FROM EMP
    WHERE EMPNO IN (SELECT MGR
                        FROM EMP)
    ORDER BY DEPTNO;

-- 26.  말단 사원의 사번, 이름, 업무, 부서번호
SELECT JOB, ENAME, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT MGR
                            FROM EMP
                            WHERE MGR IS NOT NULL)
    ORDER BY ENAME;









