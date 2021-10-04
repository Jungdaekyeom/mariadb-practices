-- practice03




-- 문제 1.
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.
select emp_no as '사번', concat(first_name, ' ', last_name) as '이름', salary as '연봉' from salaries a natural join employees b where to_date = '9999-01-01' order by salary desc;

-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
select emp_no as '사번', concat(first_name, ' ', last_name) as '이름', title as '현재 직책'
from employees natural join titles
order by 이름 asc;

select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', b.title as '현재 직책'
from employees a natural join titles b 
order by 이름 asc;



-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요..

-- 테이블 세 개를 합쳐야 합니다. employees, departments, dept_emp를 전부 join합니다.
select emp_no as '사번', concat(first_name, ' ', last_name) as '이름', dept_name as '현재 직책'
from employees natural join (departments natural join dept_emp)
order by 이름 asc;




-- 문제4.
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

select emp_no as '사번', concat(first_name, ' ', last_name) as '이름', dept_name as '현재 직책'
order by 이름 asc;




-- 문제5.
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의
-- 사번과 이름을 출력하세요. (현재 ‘Technique Leader’의 직책(으로 근무하는
-- 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력
-- 합니다.





-- 문제6.
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명,
-- 직책을 조회하세요.





-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가
-- 큰 순서대로 출력하세요.





-- 문제8.
-- 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오





-- 문제9.
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.





-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.