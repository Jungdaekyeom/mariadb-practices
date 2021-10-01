-- 집계 쿼리: select 그룹 수가 적용된 경우
-- 집계 함수는 기본적으로 하나만(아래에는 오류와, 오류가 아닌 경우가 구분되어 있다.) 존재하는게 맞다.

-- 비즈니스적으로 avg의 의미를 부여하면, 전체 회사의 월급 평균
select avg(salary)
from salaries;

-- 오류!!!!!!!(<-내가 한거 아님, 강사님이 느낌표 붙인거임 ㅠ)
-- select 절에 그룹 함수가 있는 경우, 어떤 컬럼도 select 절에 올 수 없다.
-- emp_no는 아무 의미가 없다.
-- (10001번의 월급 평균이 63180은 아니므로, 아무 의미가 없다.(사실상 에러))
select emp_no, avg(salary)
from salaries;

-- query 실행 순서
-- (1) from : 접근 테이블 확인
-- (2) where : 조건에 맞는 row 선택
-- (3) 집계
-- (4) projection

select avg(salary)
from salaries
where emp_no = '10060';

-- group by : 각각의 그룹으로 묶는 것
-- '현재' 라는 단어에 집중할 것.
-- where절 삭제
-- group by에 참여하고 있는 컬럼은 projection이 가능하다(select 절에 올 수 있다)
select emp_no, avg(salary)
from salaries
group by emp_no;
-- order by avg(salary) desc; -- avg(salary) 로 묶었으니, 정렬 가능!

-- having
-- 집계결과(결과 임시 테이블) row를 선택해야 하는 경우
-- 이미 where절은 실행이 되었기 때문에, having절에서 조건을 줘야 한다.
select emp_no, avg(salary)
from salaries
-- where이 실행될 구간이지만, select -> from -> where -> group by -> 순으로 실행되어야 하나
-- 이미 where 절을 지나갔기 때문에, 더 이상 where을 쓸 수 없어서 having으로 정리한 것.
group by emp_no
having avg(salary) > 60000;

-- order by
select emp_no, avg(salary)
from salaries
group by emp_no
having avg(salary) > 60000
order by avg(salary) asc;

-- 예제
-- salaries 테이블에서 사번이 10060인 직원의 급여 평균과 총합을 출력하세요.
-- 문법적으로 오류
-- 의미적으로 맞다(where)
select avg(salary), sum(salary)
from salaries
where emp_no = '10060';

-- 따라서 서브쿼리를 써야함
