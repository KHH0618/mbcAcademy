--1. EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE SAL >= 3000;

--2. EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE EMPNO = 7788;

--3. 연봉(SAL*12+COMM)이 24000 이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE (SAL*12+NVL(COMM,0)) >= 24000;

--4. 입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 이름, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE
    FROM EMP
    WHERE HIREDATE BETWEEN '81,02,20' AND '81,05,01'
    ORDER BY HIREDATE;

--5. deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT *
    FROM EMP
    WHERE DEPTNO IN(10,20)
    ORDER BY ENAME;

--6. sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력(단 TITLE을 employee과 Monthly Salary로 출력)
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL>=1500
        AND DEPTNO IN (10,30);

--7. hiredate가 1982년인 사원의 모든 정보를 출력
SELECT *
    FROM EMP
    WHERE HIREDATE LIKE '82%';

--8. 이름의 첫자가 C부터 P로 시작하는 사람의 이름, 급여 출력(이름순 정렬)
SELECT ENAME, SAL
    FROM EMP
    WHERE ENAME BETWEEN 'C' AND 'Q'
        AND ENAME != 'Q'
    ORDER BY ENAME;

--9. comm이 sal보다 10%이상 많은 모든 사원에 대하여 이름, 급여, 상여금을 출력
SELECT ENAME, SAL, COMM
    FROM EMP
    WHERE (SAL *1.1)<COMM;

--10. job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT *
    FROM EMP
    WHERE JOB IN ('CLERK', 'ANALYST')
        AND SAL NOT IN (1000,3000,5000);

--11. ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 모든 정보를 출력
SELECT *
    FROM EMP
    WHERE ENAME LIKE '%L%L%'
        AND DEPTNO = 30
        OR MGR = 7782;
        
--12. 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 업무, 급여를 출력.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
    FROM EMP
    WHERE HIREDATE LIKE '81%'
        AND JOB <> 'SALESMAN';
        
--13. 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 급여가 같으면 입사일이 빠른 사원으로 정렬하여 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
    FROM EMP
    ORDER BY SAL DESC, HIREDATE;

--14. 사원명의 세 번째 알파벳이 ＇N＇인 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME
    FROM EMP
    WHERE ENAME LIKE '__N%';

--15. 사원명에 ‘A’가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME
    FROM EMP
    WHERE ENAME LIKE '%A%';

--16. 연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색
SELECT EMPNO, ENAME, (SAL * 12) ANNUALINCOM
    FROM EMP;



--1. 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

--2. NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND D.LOC = 'NEW YORK';

--3. 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND COMM IS NOT NULL;

--4. 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND ENAME LIKE '%L%';

--5. 사번, 사원명, 부서코드, 부서명을 검색하라(단, 사원명기준으로 오름차순 정렬)
SELECT EMPNO, ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;

--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정렬하시오
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND SAL >= 2000
    ORDER BY SAL DESC;

--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정렬하시오.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND JOB = 'MANAGER'
        AND SAL >= 2500
    ORDER BY SAL;

--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오(단, 급여기준 내림차순으로 정렬)
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;

SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
--1. 이름, 직속상사명
SELECT E1.ENAME WORKER, E2.ENAME MANAGER
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--2. 이름, 급여, 업무, 직속상사명
SELECT E1.ENAME WORKER, E1.SAL, E1.JOB, E2.ENAME MANAGER
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO;

--3. 이름, 급여, 업무, 직속상사명 . (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT E1.ENAME WORKER, E1.SAL, E1.JOB, NVL(E2.ENAME, '없다') MANAGER
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);
    
--4. 이름, 급여, 부서명, 직속상사명
SELECT E1.ENAME, E1.SAL, D.DNAME, E1.ENAME
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.MGR = E2.EMPNO
        AND E1.DEPTNO = D.DEPTNO;

--5. 상사가 없는 직원과 상사가 있는 직원 모두에 대해 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명을 출력하시오(단, 직속상사가 없을 경우 직속상사명에는 ‘없음’으로 대신 출력하시오)
SELECT E1.ENAME, E1.SAL, D.DEPTNO,D.DNAME, D.LOC, NVL(E2.ENAME,'없음')
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.MGR = E2.EMPNO(+)
        AND E1.DEPTNO = D.DEPTNO;

--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT E1.ENAME, E1.SAL, GRADE, D.DNAME, E2.ENAME
    FROM EMP E1, EMP E2, SALGRADE, DEPT D
    WHERE E1.DEPTNO = D.DEPTNO
        AND E1.MGR = E2.EMPNO
        AND E1.SAL BETWEEN LOSAL AND HISAL
        AND E1.SAL >= 2000;

--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT E1.ENAME, E1.SAL, GRADE, D.DNAME, NVL(E2.ENAME,'없다')
    FROM EMP E1, EMP E2, SALGRADE, DEPT D
    WHERE E1.MGR = E2.EMPNO(+)
        AND E1.DEPTNO = D.DEPTNO
        AND E1.SAL BETWEEN LOSAL AND HISAL
        ORDER BY D.DNAME;

--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12으로 계산
SELECT E1.ENAME, E1.SAL, GRADE, D.DNAME, (E1.SAL+NVL(E1.COMM,0))*12, E2.ENAME
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.MGR = E2.EMPNO
        AND E1.DEPTNO = D.DEPTNO
        AND E1.SAL BETWEEN LOSAL AND HISAL;

--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
SELECT E1.ENAME, E1.SAL, GRADE, D.DNAME, (E1.SAL+NVL(E1.COMM,0))*12, E2.ENAME
    FROM EMP E1, EMP E2, DEPT D, SALGRADE
    WHERE E1.MGR = E2.EMPNO
        AND E1.DEPTNO = D.DEPTNO
        AND E1.SAL BETWEEN LOSAL AND HISAL
        ORDER BY D.DNAME, E1.SAL DESC;

--10. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체).
SELECT E1.ENAME, E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO(+);

--11. 사원명, 상사명, 상사의 상사명을 검색하시오(self join)
SELECT E1.ENAME, E2.ENAME, E3.ENAME
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+)
        AND E2.MGR = E3.EMPNO(+);
        
--12. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오(outer join)
SELECT E1.ENAME, E2.ENAME, E3.ENAME
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+)
        AND E2.MGR = E3.EMPNO(+);

