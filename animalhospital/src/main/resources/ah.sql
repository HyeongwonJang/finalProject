---------------------------------------- 회원 ----------------------------------------


-- 동물 종륲
drop table Animal_Kind;
create table Animal_kind(
	Animal_kind_name varchar2(50) primary key
);
insert into Animal_kind(Animal_kind_name)
values('고양이');
insert into Animal_kind(Animal_kind_name)
values('개');

select * from Animal_kind;

-- 반려 동물 주인
drop table Pet_Owner cascade constraint;
create table Pet_Owner(
	Pet_Owner_tel varchar2(50),
	Pet_Owner_name varchar2(50) not null
);
insert into Pet_Owner(Pet_Owner_tel, Pet_Owner_name)
values('01011112222','장형원');
update Pet_Owner set Pet_Owner_tel='01011113333';
ALTER TABLE Pet_Owner
ADD CONSTRAINT pk_Pet_Owner_tel  PRIMARY KEY (Pet_Owner_tel);

SELECT * FROM USER_CONSTRAINTS;
-- 회원 가입한 반려 동물 주인
drop table Member_Pet_Owner;
create table Member_Pet_Owner(
	Pet_Owner_tel varchar2(50),
	Pet_Owner_id varchar2(50) unique,
	Pet_Owner_password varchar2(50) not null,
	Pet_Owner_address varchar2(50) not null,
	constraint fk_Member_Pet_Owner_tel foreign key(Pet_Owner_tel) references Pet_Owner
);
ALTER TABLE Member_Pet_Owner
ADD CONSTRAINT pk_member_Pet_Owner_tel  PRIMARY KEY (Pet_Owner_tel);

alter table Member_Pet_Owner
add constraint fk_Member_Pet_Owner_tel 
foreign key(Pet_Owner_tel) references Pet_Owner(Pet_Owner_tel);

-- 반려 동물
drop table pet cascade constraint;
create table Pet(
	Pet_name varchar2(50) not null,
	Pet_Owner_tel varchar2(50) not null,
	Pet_birthday date,
	Pet_gender varchar2(50) not null,
	Pet_note varchar2(50),
	Animal_kind_name varchar2(50),
	constraint pk_Pet_id primary key(Pet_name , Pet_Owner_tel),
	constraint fk_Pet_Owner_tel foreign key(Pet_Owner_tel) references Pet_Owner,
	constraint fk_Animal_Kind_name foreign key(Animal_Kind_name) references Animal_Kind
);

-- 비회원일때 동물을 통해 주인을 검색 --> 비회원이 회원으로 가입
-- 비회원일 경우 비회원 정보를 등록한 후 회원 테이블에 비회원이 가진 동일한 컬럼의 값만 입력한다.
-- 동물 테이블의 pk_Pet_id는  Pet_name를 사용하고 Pet_Owner_tel을 참조한다
insert into Pet_Owner(Pet_Owner_tel, Pet_Owner_name)
values('01011112222','장형원');
insert into Member_Pet_Owner(Pet_Owner_tel, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values('01011112222',null,'null','null');
insert into Pet(Pet_name, Pet_Owner_tel, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values('송이','01011112222','2004.07.07','암컷','예쁨','개');
insert into Pet(Pet_name, Pet_Owner_tel, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values('도트','01011112222','2014.09.17','수컷','발랄함','고양이');
-- 비회원의 회원가입
update Member_Pet_Owner set Pet_Owner_id='jsp', Pet_Owner_password='1234', Pet_Owner_address='수원'
where Pet_Owner_tel='01011112222';

-- 회원일 경우
insert into Pet_Owner(Pet_Owner_tel, Pet_Owner_name)
values('01011113333','이윤아');
insert into Member_Pet_Owner(Pet_Owner_tel , Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values('01011113333','java','1234','인천');
insert into Pet(Pet_name, Pet_Owner_tel, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values('코디','01011113333','2012.06.07','암컷','귀여움','개');


insert into Pet_Owner(Pet_Owner_tel, Pet_Owner_name)
values('01012341234','강신후');
insert into Member_Pet_Owner(Pet_Owner_tel , Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values('01012341234','php','1111','인천');
insert into Pet(Pet_name, Pet_Owner_tel, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values('까미','01012341234','2010-5-13', '수컷', '겁쟁이', '개');
insert into Pet(Pet_name, Pet_Owner_tel, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values('백구','01012341234','2009-7-6', '암컷', '굉장히 순함', '개');

delete Pet where Pet_Owner_tel = '01012341234';
delete Member_Pet_owner where Pet_Owner_tel = '01012341234';
delete Pet_owner where Pet_Owner_tel = '01012341234';

select * from Animal_Kind;
select * from Pet_Owner;
select * from Member_Pet_Owner;
select * from Pet;

---- 전화번호 수정시 불가능?
alter table Pet_Owner modify constraints sys_c004347 disable novalidate;
commit;
update Pet_Owner set Pet_Owner_tel='01011113333';



select po.Pet_Owner_tel, po.Pet_Owner_name, mpo.Pet_Owner_id, mpo.Pet_Owner_address
from Pet_Owner po, Member_Pet_Owner mpo
where po.Pet_Owner_tel = mpo.Pet_Owner_tel and po.Pet_Owner_tel = '01011112222';

select p.Pet_name, po.Pet_Owner_name
from Pet p, Pet_Owner po
where p.Pet_Owner_tel = po.Pet_Owner_tel and po.Pet_Owner_tel = '01011112222';

select p.Pet_name, mpo.Pet_Owner_id
from Pet p, Member_Pet_Owner mpo
where p.Pet_Owner_tel = mpo.Pet_Owner_tel and mpo.Pet_Owner_tel = '01011112222';

select p.Pet_name, po.Pet_Owner_name, mpo.Pet_Owner_id, mpo.Pet_Owner_address
from Pet p, Member_Pet_Owner mpo, Pet_Owner po
where p.Pet_Owner_tel = '01011112222' and mpo.Pet_Owner_tel = '01011112222' and po.Pet_Owner_tel = '01011112222';


---------------------------------------- 의사 ----------------------------------------

drop table Vet cascade constraint;
drop table Hospital cascade constraint;
drop sequence Hospital_id_seq;
drop table Vet_License cascade constraint;

create sequence Hospital_id_seq;
-- 병원
create table Hospital(
	Hospital_id varchar2(50) primary key,
	Hospital_name varchar2(50) not null,
	Hospital_address varchar2(200) not null,
	Hospital_tel varchar2(50) not null
);
insert into Hospital values(Hospital_id_seq.nextval, 'KOSTA 동물병원', '성남시 분당구 백현동', '031-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, 'TOMCAT 동물병원', '인천시 서구 검암동', '032-123-4568');
insert into Hospital values(Hospital_id_seq.nextval, 'EXCEPTION 동물병원', '서울시 마포구 상암동', '02-123-4569');
insert into Hospital values(Hospital_id_seq.nextval, '임박사동물병원', '성남시 분당구 운중동', '031-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, '송일국 동물병원', '인천시 연수구 송도동', '032-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, 'Kal-Toi Anial Hospital', '서울시 서초구', '032-123-4567');

select * from Hospital;
delete Hospital where Hospital_id=4;

--수의사면허
create sequence Vet_License_no_seq;
create table Vet_License(
	Vet_License_no number(10) primary key,
	Vet_name varchar2(50) not null,
	resident_no number(15),
	get_License_date date not null
)
insert into Vet_License values(Vet_License_no_seq.nextval, '송일국', 711001, to_date('1999/12/20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '임창정', 731130, to_date('1973/11/30'));
insert into Vet_License values(Vet_License_no_seq.nextval, '서정우',730605, to_date('2015/11/26'));
insert into Vet_License values(Vet_License_no_seq.nextval, '이윤아', 880625, to_date('2013/9/2'));
insert into Vet_License values(Vet_License_no_seq.nextval, '칼퇴하조', 890905, to_date('1999/12/20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '박보검',930616, to_date('2011/12/20'));

select * from Vet_License;
delete Vet_License where Vet_License_no=2;

-- 몇년 되었나 , ex) 나이, 근속연수,
select trunc(months_between(sysdate,get_License_date)/12)
from Vet_License

select get_License_date
from Vet_License

--수의사회원
create table Vet(
	Vet_id varchar2(50) primary key,
	Vet_password varchar2(50) not null,
	Vet_tel varchar2(50) not null,
	Vet_License_no number(10),
	Hospital_id varchar2(50),
	constraint fk_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_Hospital_id foreign key(Hospital_id) references Hospital
)
drop table Vet;
insert into Vet values('ImChangJung', '1234','1111111',2 ,'4');
insert into Vet values('ParBG', '1234', '1111111', 6, '2');
insert into Vet values('YUNA',  '1234', '1111111',4,'2');
insert into Vet values('DoctorSong', '1234','1111111',1, '5');


select * from Vet;

---------------------------------------- 진료기록 ----------------------------------------

------- 질병 ---------
drop table Disease;
create table Disease(
	Disease_name varchar2(50) primary key,
	Disease_symptom varchar2(200) not null
)

insert into Disease(Disease_name, Disease_symptom)
values('감기','고열, 몸살, 식욕저하, 호흡곤란')
insert into Disease(Disease_name, Disease_symptom)
values('광견병','전구기, 광조기, 마비기')
insert into Disease(Disease_name, Disease_symptom)
values('골절','뼈가 부러짐')
insert into Disease(Disease_name, Disease_symptom)
values('결막염','눈에 염증, 눈이 붉어짐')

------ 진료 기록 -------
drop sequence Treatment_Record_no;
create sequence Treatment_Record_no;
drop table Treatment_Record;
create table Treatment_Record(
	Treatment_Record_no number(15) primary key,
	Treatment_hours date not null,
	Treatment_content clob not null,
	Pet_weight float(10) not null,
	Pet_name varchar2(50) not null,
	Pet_Owner_tel varchar2(50) not null,
	Vet_License_no number(10) not null,
	Disease_name varchar2(50) not null,
	constraint fk_tr_Pet_id foreign key(pet_name, pet_Owner_tel) references Pet,
	constraint fk_tr_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_tr_Disease_name foreign key(Disease_name) references Disease
)

insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_tel, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-10-15', '주사 처방', 3.4, '01011112222', '송이', 4, '감기')

select * from Disease
select * from Treatment_Record