-- 함수 : 날짜 함수

-- CURDATE(), CURRENT_DATE(), CURRENT_TIME()
select CURDATE(), current_date, current_time;

-- now() vs sysdate
-- now : 쿼리 기점으로 갱신된 시간.
-- sysdate : 실시간.
select now(), sysdate();
select now(), sleep(2), now();
select now(), sleep(2), sysdate();

-- date_format(date, format)
select date_format(now(), '%Y %m %d %h %i %s');
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초');

-- period_diff
-- YYMM, YYYYMM
-- 예) 근무 개월 수를 출력
-- alias as를 이용해서 as 앞을 month로 치환
select first_name,
	   period_diff(date_format(curdate(), '%Y%m'), date_format(hire_date, '%Y%m')) as month
from employees
order by month desc;

-- date_add(= adddate), data_sub(= subdate)
-- 날짜를 date에 type(day, month, year) 형식의 표현식(expr)으로 더하거나 뺀다.
-- 예제) 각 사원들의 근무 년수가 5년이 되는 날은 언제인가?
select first_name, hire_date, date_add(hire_date, interval 5 year)
from employees;

-- cast
select '12345' + 10, cast('12345' as int) + 10;
select date_format(cast('2021-10-01' as date), '%Y-%m-%d');
select cast(1-2 as unsigned); -- 18446744073709551615
select cast(cast(1-2 as unsigned) as signed); -- -1

-- mysql type
-- varchar, char, text, CLOB(Character Large OBject)
-- signed(unsigned), int(integer), medium int, big int, int(11)
-- float, double
-- time, date, datetime
-- LOB: CLOB, BLOB