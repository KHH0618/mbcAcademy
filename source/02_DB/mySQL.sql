-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건FK, 시퀀스 없음)
-- DML (OUTER JOIN, AND &&, OR = ||, 일부단일행함수, ROWNUM이 없어 TOP-N구문이 다름)

-- java에서 쓸 데이터 넣어보고 연습해보기alter
show databases;
-- ★ ★ ★ DCL (계정 생성, 권한부여, 계정 삭제)
create user user01 identified by 'password'; -- 계정 생성
grant all on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한 박탈
drop user user01; -- 계정 삭제
show databases;
use world; --  world 데이터 베이스 영역으로 들어감
show tables; -- 현재 들어와 있는 데이터베이스 안의 테이블들
create database dev_user; -- 데이터베이스 생성(dev_user)
show databases;
use dev_user;
show tables;
select database(); -- 현재 들어와 있는 데이터베이스 명

-- ★ ★ ★ DDL
create table emp (
	empno numeric(4) primary key,
    ename varchar(6) not null,
    nickname varchar(6) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
);
desc emp;
insert into emp (empno, ename, nickname, sal)
	values (1111, '김수한무거북', '두루미거북이', 20);
select * from emp;
drop table if exists emp;

-- major : mCode(학과번호,인위적pk), mName(학과이름), mOffice(학과사무실)
-- student : sNo(학번,pk), sName(이름), mCode(학과번호, fk)

create table major(
	mCode int primary key auto_increment, -- 자동증가되는 pk (int형)
    mName varchar(10),
    mOffice varchar(30)
);
drop table student;
create table student(
	sNo numeric(4) primary key,
	sName varchar(10),
    mCode int references major(mCode)
);

insert into major (mName, mOffice) values ('컴공', '201호');
insert into major (mName, mOffice) values ('빅데이터', '202호');
insert into major (mName, mOffice) values ('웹디자인', '203호');
select * from major;

insert into student values (1001, '홍길동', 1);
insert into student values (1002, '신길동', 2);
insert into student values (1011, '박길동', 4);
select * from student;

drop table if exists student;
drop table if exists major;

create table major(
	mCode int primary key auto_increment, -- 자동증가되는 pk (int형)
    mName varchar(10),
    mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
	sName varchar(10),
    mCode int,
    foreign key (mCode) references major(mCode)
);

insert into major (mName, mOffice) values ('컴공', '201호');
insert into major (mName, mOffice) values ('빅데이터', '202호');
insert into major (mName, mOffice) values ('웹디자인', '203호');
select * from major;

insert into student values (1001, '홍길동', 1);
insert into student values (1002, '신길동', 2);
insert into student values (1011, '박길동', 4);
select * from student;

-- 학번, 이름, 학과번호, 학과명, 학과 사무실
select sno, sname, s.mcode, mname, moffice
	from student s right outer join major m
    on s.mcode = m.mcode;


-- 자바(JDBC) 수업시간에 쓸 테이블
drop table if exists personal;
drop table if exists division;

create table division(
	dno int,
    dname varchar(20) not null,
    phone varchar(20) unique,
    position varchar(20),
    primary key(dno)
);
insert into division values (10, 'finance', '02-888-8888','신림');
insert into division values (20, 'research', '02-777-8888','용산');
insert into division values (30, 'sales', '02-666-8888','강서');
insert into division values (40, 'cs', '02-555-8888','강남');
select * from division;

create table personal(
	pno int,
    pname varchar(20) not null,
    job varchar(20) not null,
    manager int,
    startdate date,
    pay int,
    bonus int,
    dno int,
    primary key(pno), foreign key(dno) references division(dno)
);
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
-- ifnull() 매개변수 2개의 타입은 일치하지 않아도됨
select pno, pname, pay, bonus, pay + ifnull(bonus, 0) sum
	from personal;
-- if(조건, 조건이 참일때 반환값, 조건이 참이 아닐때 반환값)
select pname, pay + if(bonus is null, 0, bonus) sum
	from personal;


-- DML
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select *
	from personal
    where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno
	from personal
    where dno = 10
		or dno = 20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    where bonus is null;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
    order by dno, pay desc;

-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal p, division d
    where d.dno = p.dno;
    
-- 7. 사번, 이름, 상사이름
select p1.pno, p1.pname, p2.pname
	from personal p1, personal p2
	where p1.manager = p2.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) – 우선
select p1.pno, p1.pname, ifnull(p2.pname, '★CEO★') manager
	from personal p1 left outer join personal p2
	on p1.manager = p2.pno; 

-- 8-1 사번, 이름, 상사사번(상사가 없으면 ceo로 출력. ifnull함수의 매개변수의 타입이 상이해도 상관없음)
select pno, pname, ifnull(manager, '★CEO★') manager
	from personal ; 

-- 8-2. 사번, 이름, 상사이름, 부서명(상사가 없는 사람도 출력) – 같이 합시다
select p1.pno, p1.pname, ifnull(p2.pname, '★CEO★') manager, dname
	from division d, personal p1 left outer join personal p2
	on p1.manager = p2.pno
    where d.dno = p1.dno; 

-- 9. 이름이 s로 시작하는 사원 이름 (like 이용, substr함수이용, instr함수 이용등 다양하게 사용 가능)
select pname
	from personal
    where upper(pname) like 'S%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p1.pno, p1.pname, p1.pay, dname, ifnull(p2.pname, '★CEO★') manager
	from division d, personal p1 left outer join personal p2
	on p1.manager = p2.pno
    where d.dno = p1.dno;
    
-- 11. 부서코드, 급여합계, 최대급여
select d.dno, sum(pay) sum, max(pay) max
	from personal p, division d
    where p.dno = d.dno
    group by d.dno;

-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay) avgpay, count(pno) count
	from personal p, division d
    where p.dno = d.dno
    group by d.dno;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select d.dno, sum(pay) sumpay, count(pno) count
	from personal p, division d
    where p.dno = d.dno
    group by d.dno
		having count >= 4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay >= (select max(pay) from personal);
    
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
    where pay >= (select avg(pay) from personal);

-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal p, division d
    where p.dno = d.dno
		and pay >= (select avg(pay) from personal)
	order by dname, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, p.dno, round(avgpay)
	from personal p, (select avg(pay) avgpay, d.dno divino 
						from personal p, division d 
                        where p.dno = d.dno 
                        group by d.dno) d
    where p.dno = d.divino
		and p.pay >= d.avgpay;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname
	from personal p, division d
	where p.dno = d.dno
		and startdate <= (select min(startdate) from personal);
    
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, avgpay.ap
	from personal p, (select avg(pay) ap, d.dno divino 
						from personal p, division d 
                        where p.dno = d.dno 
                        group by d.dno) avgpay
    where p.dno = avgpay.divino;

-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, dname, avgpay.ap
	from personal p, division d, (select avg(pay) ap, d.dno divino 
									from personal p, division d 
                                    where p.dno = d.dno 
                                    group by d.dno) avgpay
    where p.dno = d.dno
		and p.dno = avgpay.divino;


-- Oracle에서의 단일행 함수와 다른부분
	-- ex. pname는 job다
select concat(pname, '는', job, '이다') massage from personal;
select round(35.78, 1) massage;

-- 시스템으로부터 현재시점, 현재날짜, 현재시간
select sysdate(), now();
select curdate(), curtime();

-- to_char(날짜형, 포맷) -> date_format(날짜/시간, 포멧) : 날짜/시간형을 문자형으로 변환
-- date_format(문자, 포맷) : 문자를 날짜/시간형으로 변환
	-- 포맷 : %Y(년도 4자리), %y(년도 2자리), %m(01,02.. 월이 두자리로), %c(1,2,.. 월 한자리), %d(01,02.. 날짜 2자리), %e(1,2,.. 일 한자리)
    --		%H(24) %h(12) %p(오전오후) %i(분) %s(초) 
select date_format(now(), '%Y년%m월%e일, %p %h시 %i분 %s초');
select year(now()), weekday(now()) "요일";
select case weekday(startdate)
		when '0' then '월요일'
		when '1' then '화요일'
		when '2' then '수요일'
		when '3' then '목요일'
		when '4' then '금요일'
		when '5' then '토요일'
		when '6' then '일요일' end "요일" from personal;


-- format(숫자, 소숫점자리수)
select format(pay, 0) from personal;
select format(pay, 2) from personal;

-- Top-N 구문(rownum이 없어 대신 limit이용)
select pname, pay
	from personal
    order by pay desc limit 5; -- 0은 생략가능
-- limit n == limit 0, n(1~n등까지)
-- limit n1, n2(n1~n2등까지)

-- pay 순으로 1page(1~3등)
select pname, pay
	from personal
    order by pay desc
    limit 3;

-- 2page(4~6)
select pname, pay
	from personal
    order by pay desc
    limit 4,3;

-- 3page(6~9)
select pname, pay
	from personal
    order by pay desc
    limit 6,3;












