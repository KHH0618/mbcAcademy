--com.lec.ex1selectAll;
SELECT * FROM EMP;


--com.lec.ex2selectWhere
-- Ex1. 부서번호를 받아 부서정보를 출력
SELECT * FROM DEPT WHERE DEPTNO=10;
INSERT INTO DEPT VALUES (50, 'IT', '서울');
SELECT * FROM DEPT;
COMMIT;

--ex.2 부서번호 입력받아 부서정보와 사원정보 출력
SELECT * FROM DEPT WHERE DEPTNO = 40;
SELECT W.EMPNO WORKEREMPNO, W.ENAME WORKER, W.SAL WORKERSAL, NVL(M.ENAME,'CEO') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+)
        AND W.DEPTNO = 10;
        
--Ex.3 부서 이름으로 부서정보 출력
SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('SALES');

--com.lec.ex3insert
insert into dept values (60,upper('computerscience'), upper('busan'));
INSERT INTO DEPT VALUES (60, UPPER('COMPUTERSCIENCE'), UPPER('BUSAN'));

--com.lec.ex4update
UPDATE DEPT 
    SET DNAME = UPPER(''),
        LOC = UPPER('')
    WHERE DEPTNO = 10 ;
    
select * from dept;
select * from emp;