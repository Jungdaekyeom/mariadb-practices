-- 설명
-- inner join은 조인 조건을 만족하는 값에 대해서만 결과값이 출력 가능
-- outer join은 조인 조건을 만족하지 않아도 결과값 출력 가능
-- natural join : ansi / iso sql 1999를 따르는 ansi join 문법.
-- join~ using : 내추럴 조인을 보완하는 것

-- inner join
-- 예제1 : employees 테이블과 title 테이블을 join하여 직원의 이름과 직책을 모두 출력
select a.first_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no -- join 조건(n-1개의 조인 조건 필요)
and b.to_date = '9999-01-01'; -- row 선택 조건

-- 예제2 : employees 테이블과 titles 테이블을 join하여 직원의 이름과 직책을 출력하되, 여성 엔지니어만 출력하세요.
select a.first_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no -- join 조건(n-1개의 조인 조건 필요)
and b.to_date = '9999-01-01' -- row 선택 조건 1
and a.gender = 'f'			 -- row 선택 조건 2
and b.title = 'engineer';	 -- row 선택 조건 3

--
-- ANSI/ISO SQL1999 JOIN 표준 문법
--

-- 1) natural join
-- 두 테이블에 공통 컬럼이 있으면 별다른 조건 없이 암묵적으로 조인이 됨.
select a.first_name, b.title
from employees a natural join titles b
where b.to_date = '9999-01-01'; -- row 선택 조건
-- on a.emp_no = b.emp_no 생략
-- 같은 것 : from employees a join title b on a.emp_no = b.emp_no

-- 2) join ~ using
select a.fisrt_name, b.title
from employees a join titles b using(emp_no)
where b.to_date = '9999-01-01'; -- row 선택 조건

-- 3) join ~ on
select a.fisrt_name, b.title
from employees a join titles b on a.emp_no = b.emp_no
where b.to_date = '9999-01-01'; -- row 선택 조건


-- outer join
insert into dept values(null, '총무');
insert into dept values(null, '영업');
insert into dept values(null, '개발');
insert into dept values(null, '기획');
select * from dept;

insert into emp values(null, '둘리', 1);
insert into emp values(null, '마이콜', 2);
insert into emp values(null, '또치', 3);
insert into emp values(null, '길동', null);
select * from emp;

select a.name as '이름', b.name as '부서'
from emp.a join dept b on a.dept_no = b.no;

select a.name as '이름', ifnull(b.name, '없음') as '부서'
from emp.a left join dept b on a.dept_no = b.no;

select a.name as '이름', ifnull(b.name, '없음') as '부서'
from emp.a right join dept b on a.dept_no = b.no;


-- 실습문제 1
-- 현재 회사 상황을 반영한 직원별 근무부서를 사번, 이름, 근무 부서로 출력해보세요.

-- 예제 : 현재 직책별로 평균 연봉과 인원수를 구하되, 직책별로 인원이 100명 이상인 직책만 출력하세요.
select a.title, avg(salary), count(*)
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
having count(*) >= 100
order by avg(salary) desc;

-- 예제6 : 현재 부서별로 현재 직책이 Engineer인 직원들에 대해서만 평균급여를 구하세요.
select * from titles a, departments b where 
