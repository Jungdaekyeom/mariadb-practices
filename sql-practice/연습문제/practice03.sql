-- practice03

-- 문제 1.
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.
select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', b.salary as '연봉'
from employees a
join salaries b on a.emp_no = b.emp_no
join dept_emp c on a.emp_no = c.emp_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
order by 연봉 desc;


-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
-- sol1
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', t.title as '현재 직책'
from employees e join titles t on e.emp_no = t.emp_no
where t.to_date = '9999-01-01'
order by 이름 asc;


-- sol2
select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', b.title as '현재 직책'
from employees a
join titles b on a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
order by 이름 asc;



-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요..
-- 테이블 세 개를 합쳐야 합니다. employees, departments, dept_emp를 전부 join합니다.
select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', c.dept_name as '현재 부서'
from employees a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
and b.to_date = '9999-01-01'
order by 이름 asc;


-- 문제4.
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.
-- 사번, 이름 : employees;
select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', b.salary as '연봉', c.title as '직책', e.dept_name as '부서'
from employees a 
join salaries b on a.emp_no = b.emp_no
join titles c on a.emp_no = c.emp_no
join dept_emp d on a.emp_no = d.emp_no
join departments e on d.dept_no = e.dept_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
order by 이름 asc;

-- 문제5.
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의
-- 사번과 이름을 출력하세요. (현재 ‘Technique Leader’의 직책(으로 근무하는
-- 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력
-- 합니다.
select b.emp_no as '사번', concat(b.first_name, ' ', b.last_name) as '이름'
from titles a join employees b on a.emp_no = b.emp_no
and a.to_date != '9999-01-01'
where title = 'Technique Leader';

-- 문제6.
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.
select concat(a.first_name, ' ', a.last_name) as '이름', c.dept_name as '부서명', d.title as '직책'
from employees a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
join titles d on a.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
where substring(a.last_name, 1, 1) = 'S'
order by 이름 asc;

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가
-- 큰 순서대로 출력하세요.

select concat(c.first_name, ' ', c.last_name) as 사원,  a.salary as 급여
from salaries a
join titles b on a.emp_no = b.emp_no
join employees c on a.emp_no = c.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
where b.title = 'Engineer' and salary > 40000
order by 급여 desc;


-- 문제8.
-- 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오
-- 문제가 중의적이라고 생각됩니다. 따라서 두 가지 방법으로 풀어 보았습니다.

-- sol1 : 현재 '평균' 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오
select a.title as '직책', avg(b.salary) as '급여'
from titles a join salaries b on a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
where b.salary > 50000
group by a.title
order by 급여 desc;


-- sol2 : 현재 급여가 50000이 넘는 '직원'을 직책, 급여로 급여가 큰 순서대로 출력하시오
-- 보기 편하게 사원 이름도 출력하였습니다.
select concat(a.first_name, ' ', a.last_name) as '사원', b.title as '직책', c.salary as '급여'
from employees a
join titles b on a.emp_no = b.emp_no
join salaries c on a.emp_no = c.emp_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
where c.salary > 50000
order by 급여 asc;


-- 문제9.
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.
-- ~별 이 나오면 group by
-- 
select c.dept_name as '부서명', c.dept_no as '부서번호', avg(a.salary) as '부서별평균연봉'
from salaries a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by c.dept_name
order by 부서별평균연봉 desc;


-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.
select a.title as '직책', avg(salary) as '평균연봉'
from titles a
join salaries b on a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
order by 평균연봉 desc;