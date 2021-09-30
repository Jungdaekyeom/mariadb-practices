-- Basic Query 

-- 테이블 삭제
drop table pet;

-- 테이블 만들기
create table pet(
	name varchar(20),
    owner varchar(20),
    sepecies varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);

-- schema 확인
desc pet;

-- 조회
select name, owner, species, birth, death from pet;

-- 데이터 넣기(생성, create)
insert into pet value('마오', '정대겸', 'cat', 'w', '2018-08-05', null);

-- 데이터 삭제(delete)
delete 	from pet where name = '정대겸';

-- load data local infile
load data local infile 'C:\douzone2021\03.자료\MySQL\pet.txt' into table pet;