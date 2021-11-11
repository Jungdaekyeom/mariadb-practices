select * from user;
select no, title, welcome, profile, description from site;
-- 테이블 비우는 함수
truncate gallery;
truncate site;
select * from gallery;
select * from site;
insert into site values (null, "MySite", "안녕하세요. 정대겸의 mysite에 오신 것을 환영합니다.", "/upload/images/2021102101155113.png", "이 사이트는 정대겸이 죽어가는 과정입니다.<br> 메뉴는 서블릿 고문, 스프링 고문, 마이바티스 고문 등이 있규요.
						Java수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운게 너무 빨라서 울며 겨자먹기로 복습하면서 잠도 못 자고 만드..쿨럭... 살려주세요..."); 
