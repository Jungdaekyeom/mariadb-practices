-- 기본 SQL 문제입니다.

-- 문제1.
-- 사번이 10944인 사원의 이름은(전체 이름)
-- select first_name, last_name : 퍼스트 네임과 라스트 네임을 골라라
-- from : employees 테이블에서
-- emp_no = 10944 : emp_no(사원번호)가 10944 인 사람을.
select first_name, last_name from employees where emp_no = 10944;

-- 문제2. 
-- 전체직원의 다음 정보를 조회하세요. 가장 선임부터 출력이 되도록 하세요. 출력은 이름, 성별,  입사일 순서이고 “이름”, “성별”, “입사일로 컬럼 이름을 대체해 보세요.
-- select first_name, last_name, gender, hire_date : ~를 골라라
-- from : employees 테이블에서
-- order by hire_date asc :  hire_date(입사일)을 asc(오름차순)으로
select first_name, last_name, gender, hire_date from employees order by hire_date asc;

-- 문제3.
-- 여직원과 남직원은 각 각 몇 명이나 있나요?
-- 집계 함수 사용


-- 문제4.
-- 현재 근무하고 있는 직원 수는 몇 명입니까? (salaries 테이블을 사용합니다.) 

select * from salaries;

-- 문제5.
-- 부서는 총 몇 개가 있나요?
-- count 함수 사용 / 중복 제거(distinct)



-- 문제6.
-- 현재 부서 매니저는 몇 명이나 있나요?(역임 매너저는 제외)
-- count, 현재(9999-01-01) 


-- 문제7.
-- 전체 부서를 출력하려고 합니다. 순서는 부서이름이 긴 순서대로 출력해 보세요.



-- 문제8.
-- 현재 급여가 120,000이상 받는 사원은 몇 명이나 있습니까?
-- 현재 / 급여


-- 문제9.
-- 어떤 직책들이 있나요? 중복 없이 이름이 긴 순서대로 출력해 보세요.



-- 문제10
-- 현재 Enginner 직책의 사원은 총 몇 명입니까?



-- 문제11
-- 사번이 13250(Zeydy)인 지원이 직책 변경 상황을 시간순으로 출력해보세요.


