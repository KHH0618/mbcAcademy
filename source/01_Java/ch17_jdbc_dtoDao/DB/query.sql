-- DEPT DAO에 들어갈 QUERY
--(1) 부서정보들 가져오는 함수 : getDeptList
SELECT * FROM DEPT;
--(2) deptno로 부서정보 가져오는 함수 : getDept
SELECT * FROM DEPT WHERE DEPTNO = 10;
--(3) dname으로 부서정보 가져오는 함수 : getDept
SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('SALES');
--(4) insertDept
INSERT INTO DEPT VALUES (60,UPPER('CS'),UPPER('BUSAN'));
--(5) updateDept
UPDATE DEPT 
    SET DNAME = UPPER('MARKETING'),
        LOC = UPPER('KYUNGJU')
    WHERE DEPTNO = 60;
--(6) deleteDept
DELETE DEPT WHERE DEPTNO = 60;


-- EMP DAO에 들어갈 QUERY
--(1) 사원정보들 가져오는 함수 : getEmpList
SELECT * FROM EMP;
--(2) deptno로 사원정보 가져오는 함수 : getEmpList
SELECT * FROM DEPT WHERE DEPTNO = 10;
--(3) dname으로 사원정보 가져오는 함수 : getEmpList
SELECT E.* 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND DNAME = UPPER('SALES');
