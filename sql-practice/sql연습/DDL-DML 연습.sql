drop table member;

create table member(
no int(11) not null auto_increment,
email varchar(200) not null,
password varchar(64) not null,
name varchar(100) not null,
department varchar(100),
primary key(no)
);

-- 
-- after 뒤에 이메일 만들겠다
alter table member add juminbunho char(13) not null after email;
desc member;

alter table member drop juminbunho;
desc member;

alter table member add join_date datetime not null;
desc member;

alter table member change department department varchar(100) not null;
desc member;

alter table member add self_intro text;
desc member;

-- transaction
select @@autocommit; -- 1로 커밋됨

select password('query');
select * from member;

delete from member;

-- insert
insert into member
values(null, 'pocpoc0202@naver.com', password('1234'), '정대겸', '오타쿠', now(), null);

-- insert
insert into member
values(null, 'whguswls@naver.com', password('1234'), '조현진', '카드광', now(), null);

-- update
update member
	set email='pocpoc0202@gmail.com', password=password('5678')
    where no = 3;
    
select * from member;

-- delete
delete from member
where no = 2;

select * from member;


-- transaction
select @@autocommit; -- 1로 커밋됨
set autocommit = 1;

insert into member
values(null, 'pocpoc0202@naver.com', password('1234'), '정대겸', '오타쿠', now(), null);