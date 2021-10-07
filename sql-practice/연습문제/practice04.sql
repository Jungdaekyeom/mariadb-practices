-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?



select count(*) + '명' as '평균 연봉보다 많은 월급을 받는 직원' 
from employees a
join salaries b on a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
where salary > (
	select avg(salary)
	from salaries
	where to_date = '9999-01-01'
);

-- 문제2. 
-- 현재 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서, 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
-- 서브 쿼리를 쓰지 않고 품
select a.emp_no as 사번, concat(a.first_name, ' ', a.last_name) as 이름, c.dept_name as 부서, max(d.salary) as 연봉
from employees a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
join salaries d on a.emp_no = d.emp_no
and b.to_date='9999-01-01'
and d.to_date='9999-01-01'
group by dept_name
order by 연봉 desc;

-- 서브 쿼리를 써서 품
-- 1. 각 부서별로 급여를 받는 사람들 목록
-- 2. 그 중에서 max값을 출력
select a.emp_no as 사번, concat(a.first_name, ' ', a.last_name) as 이름, c.dept_name as 부서, max(d.salary) as 연봉;


select * from employees a join salaries b on a.emp_no = b.emp_no;


-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 



-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.

-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 

-- 문제7.
-- 평균 연봉이 가장 높은 직책?

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
