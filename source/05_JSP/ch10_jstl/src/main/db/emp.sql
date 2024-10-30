--DB에 있는 모든 getEmpList
SELECT * FROM EMP;
-- Quiz에 쓸 쿼리 getEmpList(String schName, String schJob)
SELECT * 
    FROM EMP
    WHERE ENAME LIKE '%'||UPPER(TRIM(''))||'%'
        AND  JOB LIKE '%'||UPPER(TRIM(''))||'%';