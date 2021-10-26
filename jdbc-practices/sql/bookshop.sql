delete from board;
select * from board;

select * from board a join user b on a.user_no = b.no where delete_bool = 1 and a.name like 'c';

select max(group_no) from board;
select max(group_no) from board;
DROP TABLE IF EXISTS `webdb`.`guestbook` ;

CREATE TABLE IF NOT EXISTS `webdb`.`guestbook` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `message` VARCHAR(45) NOT NULL,
  `reg_date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;

select * from guestbook;

select no, name, password, message, reg_date from guestbook order by no asc;

insert into guestbook values (1, "asdf", "asdf", "asdf", now());


-- schema 확인
desc book;
desc author;

-- insert author
-- insert into author values(null, '스테파니메이어');
select * from author;

-- insert book
-- insert into book values(null, '이클립스', 1, '대여가능');
select * from book;

-- select book
select a.no, a.title, a.status, b.name as authorName
from book a, author b
where a.author_no = b.no
order by no desc;

-- update book's status(no, status)
update book
set status = '대여중'
where no=1;

select * from book;


CREATE TABLE IF NOT EXISTS `webdb`.`user` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `gender` ENUM('male', 'female') NOT NULL,
  `join_date` DATE NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `new_schema1`.`guestbook`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `webdb`.`guestbook` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `message` VARCHAR(45) NOT NULL,
  `reg_date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;


select no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, group_no, order_no, depth from board;
insert into board values(null, "test title", "test context", 1, now(), 1, 1, 1);

insert into board
values(null, "test title", "test context", default, now(), ifnull((select max(group_no) from board), 0)+1, 1, 2);

select * from board;

select * from emaillist;
insert into emaillist values (1, "가가", "나나", "pocpoc0202@naver.com");

select * from user;
select count(no) from board;
select no, title, contents, hit, reg_date, group_no, order_no, depth, user_no from board where no=1;
select no, title, contents, hit, reg_date, group_no, order_no, depth, user_no from board limit 20, 10;

update board set title = "운명2", contents="케토";

delete from user where no=5;
select * from user;

update board set order_no = order_no + 1 where group_no = 1 and order_no >= 1;
select * from emaillist;

-- ---------------------------------------------

select * from user a join board b on a.no = b.user_no;

insert into test values (1, max(group_no)+1);

select * from test;
select m from test;
update test set group_no = group_no + 1 where no=2;
select max(group_no) from test;


select no from board;

update board set title='삭제된 메시지입니다' where no=11;

select * from board;

delete from board where no=1;

create table testbool(
sometext varchar(10),
is_checked bit(1)
);

select * from testbool;

insert into testbool(sometext, is_checked) values('a', 1);
insert into testbool(sometext, is_checked) values('b', 0);



select * from board;
update board set hit=1 where no=1;



-- 10/22
-- enum 추가
alter table user add column role enum('USER', 'ADMIN') not null default 'USER';
select * from user;

insert into user values(null, '관리자', 'admin@mysite.com', '1234', 'male', now(), 'ADMIN');
select * from user;

desc site;

select * from site;

insert into site values (null, 'MySite', '안녕하세요. 정대겸의 사이트에 오신 것을 환영한다 이쉬키야', '', '이 사이트는 정대겸이 JSP 및 Spring의 고문을 받아가는 사이트입니다.');



select * from user a join board b on a.no = b.user_no;
select * from user a join board b on a.no = b.user_no where title like '%a%' order by group_no desc, order_no asc;




select b.no, a.name, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, group_no, order_no, depth, user_no, delete_bool from user a join board b on a.no = b.user_no where delete_bool = '1' and title like '%a%' order by group_no desc, order_no asc limit 0, 10;

select b.no, a.name, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, group_no, order_no, depth, user_no, delete_bool from user a join board b on a.no = b.user_no where delete_bool = '1' and name like 'c' order by group_no desc, order_no asc limit 0, 10;