-- 집계(통계) SQL 문제입니다.
-- 4번의 연봉과 1번의 임금의 차이는 무엇인가? / salary와 an annual salary ? 아니면 단순히 오타?


-- 문제 1. 
-- 최고임금(salary)과 최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해 보세요.
-- 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해 보세요.
select max(salary) as '최고임금' , min(salary) as '최저임금', (max(salary)-min(salary)) as '최고임금 - 최저임금' from salaries;



-- 문제2.
-- 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select date_format(hire_date, '%Y년 %m월 %d일') as '신입사원이 마지막으로 입사한 날짜' from employees order by hire_date desc limit 1;


-- 문제3.
-- 가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
-- 테스트 겸 조인 사용(dept_emp 쓰면 됨.)
select emp_no, hire_date as '가장 오래된 고인물의 입사일'
from titles natural join employees
group by emp_no
order by if(max(to_date) = '9999-01-01', curdate(), max(to_date)) - min(from_date) desc;

    
-- 내꺼아님. 공부용으로 둥근 태양이 퍼다준거ㅋㅋㅋㅋ1
select t1.from_date
from dept_emp t1, (
   select emp_no, timestampdiff(DAY, min(from_date), if(max(to_date)='9999-01-01', curdate(), max(to_date))) as count_day
   from dept_emp 
   group by emp_no
   order by count_day desc
   limit 1
) t2
where t1.emp_no=t2.emp_no;

-- 내꺼아님. 공부용으로 둥근 태양이 퍼다준거ㅋㅋㅋㅋ2
select t1.from_date
from dept_emp t1, (
   select emp_no, timestampdiff(DAY, min(from_date), if (max(to_date)='9999-01-01', curdate(), max(to_date))) as count_day
   from dept_emp 
   group by emp_no
   order by count_day desc
) t2
where t1.emp_no=t2.emp_no
order by from_date asc
limit 1;
    
-- 문제4.
-- 현재 이 회사의 평균 연봉은 얼마입니까?
select avg(salary) as '회사평균연봉' from salaries;

-- 문제5.
-- 현재 이 회사의 최고/최저 연봉은 얼마입니까?
select max(salary) as '최고연봉', min(salary) as '최저연봉' from salaries;

-- 문제6.
-- 최고 어린 사원의 나이와 최연장자의 나이는?
-- '년'으로 계산
select
concat(date_format(curdate(), '%Y') - date_format(max(birth_date), '%Y'), '세') as '최연소자',
concat(date_format(curdate(), '%Y') - date_format(min(birth_date), '%Y'), '세') as '최연장자'
from employees;

-- floor : 소숫점 버림
-- datediff : 날짜 차이 구하기
-- '일' 로 계산
select min(birth_date) as '최연장자 생년월일',
floor(datediff(now(), min(birth_date)) / 365) as '최연장자 나이',
max(birth_date) as '최연소자 생년월일',
floor(datediff(now(), max(birth_date)) / 365) as '최연소자 나이'
from employees;


-- period_diff : 개월 수 차이 구하기.
-- '월' 로 계산
select min(birth_date) as '최연장자 생년월일',
floor(period_diff(date_format(now(), '%Y%m'), date_format(min(birth_date), '%Y%m'))/12) as '최연장자 나이',
max(birth_date) as '최연소자 생년월일',
floor(period_diff(date_format(curdate(), '%Y%m'), date_format(max(birth_date), '%Y%m'))/12) as '최연소자 나이'
from employees;

-- select (period_diff(date_format(curdate(), '%Y'), date_format(max(birth_date), '%Y'))) as '어린놈의쉬키' from employees;