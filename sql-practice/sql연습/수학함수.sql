-- 함수: 수학

-- abs : 절대값
select abs(-1), abs(1);

-- mod : 
select mod(10, 3);

-- floor : 내림
select floor(3.14);

-- ceil : 올림
select ceil(3.14);
select ceiling(3.14);

-- round(x) : 반올림. x에 가장 근접한 정수
-- round(x, d) : x값 중에 소수점 d 자리에 가장 근접한 실수
select round(1.298); -- 1
select round(1.598); -- 2

select round(1.498), round(1.498, 1); -- 소수점 첫째 자리까지 반올림
select round(1.498), round(1.498, 0); -- 실수자리 반올림

-- pow(x, y), power(x, y) x의 y승
select pow(2, 10) ,power(10, 2);

-- sign(x)
select sign(20), sign(-100), sign(0);

-- greatest(x. y, ...), least(x, y, ....) : min, max 값 찾기
select greatest(10, 40, 20, 30), least(10, 40, 20, 30);
select greatest('b', 'A', 'C'), greatest('hello', 'hellp', 'hellq');
