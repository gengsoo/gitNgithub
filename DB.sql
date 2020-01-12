drop table member
drop table depart
drop table depart cascade constraints --depart를 참조 하고 있을때는 삭제가 안되기 때문에 이렇게 해줘야함(순차적으로 제약조건 해제)


create table member(
id varchar2(6) primary key,
name varchar2(12) not null,     
did varchar2(6) primary key,
age number(3) default 0, 
constraint check_member_age_200_down check (age < 200),
constraint fk_member_did_depart_did foreign key(did) references depart(did)               
)
--primary key: unique, notnull 제약조건이 자동으로 들어가면서 특정 레코드를 가리키게 하는 키
--컬럼 값이 중복되지 않고 또 null 값을 같지 않으면서 특정 레코드를 가리키게 하는 컬럼을 primary key(=pk = 기본키 = 주키) 라고 한다
--foregin key(=외래 키): 참조 무결성 제약조건 (null값, 복수값은 허용됨), 참조하는 테이블의 컬럼값 입력도 가능(부모로 인식됨)
--foreign key(did)얘한테 데이터를 주겠다 
--depart에 있는 did를 참조 한다! 기본키
--member테이블의 did컬럼을 foregin key로 지정하는데, depart테이블에 있는 did컬럼을 참조하도록

create table depart(
did varchar2(6)   primary key,--멤버테이블의 did의 크기와 같게하여 오류 방지
dname varchar2(21) not null
)


insert into member(id, name, did, age)
values('m001', 'kim', null, 22)	-- member테이블의 not null 제약조건때문에 안들어감
delete from member where id = 'm001'

insert into member(id, name, did, age)
values('m001', 'kim', 'd001', 22)


insert into member(id, name, did, age)
values('m002', 'lee', 'd001', 44)

insert into member values('m003', 'park', 'd002', 55)
insert into member values('m004', 'choi', 'd003', 11)
insert into member values('m005', 'shim', 'd001', 33)
insert into member values('m006', 'lim', 'd004', 22)
insert into member values('m007', 'cha', 'd005', 18)

insert into member values('m003', 'park', 'd009', 55) --참조 무결성 제약조건에 위반(d009가 depart에 없음)


insert into depart values('d001', '영문학과')
insert into depart values('d002', '기계공학과')
insert into depart values('d003', '법학과')
insert into depart values('d004', '철학과')
insert into depart values('d005', '간호학과')
commit

select * from member
select * from depart

--natural join 조회를 함에 있어서 각각의 테이블을 합치는데, 중복됨이 없이 합쳐주는 것 (그냥 join은 중복되게 나옴)
select m.id, m.name, m.age, d.dname	-- member테이블의 id, name 등등 을 선택
from DEPART d natural join MEMBER m	-- depart는 d member는 m으로 칭한다는 뜻

select m.id, m.name, m.age, d.dname from depart d natural join member m
select * from depart member m, depart d where m.did = d.did