drop table member
drop table depart
drop table depart cascade constraints --depart�� ���� �ϰ� �������� ������ �ȵǱ� ������ �̷��� �������(���������� �������� ����)


create table member(
id varchar2(6) primary key,
name varchar2(12) not null,     
did varchar2(6) primary key,
age number(3) default 0, 
constraint check_member_age_200_down check (age < 200),
constraint fk_member_did_depart_did foreign key(did) references depart(did)               
)
--primary key: unique, notnull ���������� �ڵ����� ���鼭 Ư�� ���ڵ带 ����Ű�� �ϴ� Ű
--�÷� ���� �ߺ����� �ʰ� �� null ���� ���� �����鼭 Ư�� ���ڵ带 ����Ű�� �ϴ� �÷��� primary key(=pk = �⺻Ű = ��Ű) ��� �Ѵ�
--foregin key(=�ܷ� Ű): ���� ���Ἲ �������� (null��, �������� ����), �����ϴ� ���̺��� �÷��� �Էµ� ����(�θ�� �νĵ�)
--foreign key(did)������ �����͸� �ְڴ� 
--depart�� �ִ� did�� ���� �Ѵ�! �⺻Ű
--member���̺��� did�÷��� foregin key�� �����ϴµ�, depart���̺� �ִ� did�÷��� �����ϵ���

create table depart(
did varchar2(6)   primary key,--������̺��� did�� ũ��� �����Ͽ� ���� ����
dname varchar2(21) not null
)


insert into member(id, name, did, age)
values('m001', 'kim', null, 22)	-- member���̺��� not null �������Ƕ����� �ȵ�
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

insert into member values('m003', 'park', 'd009', 55) --���� ���Ἲ �������ǿ� ����(d009�� depart�� ����)


insert into depart values('d001', '�����а�')
insert into depart values('d002', '�����а�')
insert into depart values('d003', '���а�')
insert into depart values('d004', 'ö�а�')
insert into depart values('d005', '��ȣ�а�')
commit

select * from member
select * from depart

--natural join ��ȸ�� �Կ� �־ ������ ���̺��� ��ġ�µ�, �ߺ����� ���� �����ִ� �� (�׳� join�� �ߺ��ǰ� ����)
select m.id, m.name, m.age, d.dname	-- member���̺��� id, name ��� �� ����
from DEPART d natural join MEMBER m	-- depart�� d member�� m���� Ī�Ѵٴ� ��

select m.id, m.name, m.age, d.dname from depart d natural join member m
select * from depart member m, depart d where m.did = d.did