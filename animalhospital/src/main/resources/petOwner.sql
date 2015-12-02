---------------------------------------- 회원 ----------------------------------------
select po.Pet_Owner_no, po.Pet_Owner_id, po.Pet_Owner_name, po.Pet_Owner_tel, po.Pet_Owner_address, p.Pet_name
		from  Pet_Owner po, Pet p
		where po.Pet_Owner_id = 'java' and po.Pet_Owner_password = '1234'  
commit		

-- 동물 종륲
drop table Animal_Kind cascade constraint;
drop table Pet_Owner cascade constraint;
drop sequence Pet_Owner_no_seq;

create table Animal_kind(
   Animal_kind_name varchar2(50) primary key
);
insert into Animal_kind(Animal_kind_name)
values('고양이');
insert into Animal_kind(Animal_kind_name)
values('개');

select * from Animal_kind;

-- 반려 동물 주인
drop sequence Pet_Owner_no_seq;
create sequence Pet_Owner_no_seq;
drop table Pet_Owner ;
create table Pet_Owner(
   Pet_Owner_no number(15) primary key,
   Pet_Owner_tel varchar2(50) unique,
   Pet_Owner_name varchar2(50) not null,
   Pet_Owner_id varchar2(50) unique,
   Pet_Owner_password varchar2(50),
   Pet_Owner_address varchar2(50)
);
select * from Pet_Owner
-- 반려 동물

drop table pet;
create table Pet(
   Pet_Owner_no number(15) not null,
   Pet_name varchar2(50) not null,
   Pet_birthday date,
   Pet_gender varchar2(50) not null,
   Pet_note varchar2(50),
   Animal_kind_name varchar2(50),
   constraint pk_Pet_id primary key(Pet_Owner_no , Pet_name),
   constraint fk_Pet_Owner_no  foreign key(Pet_Owner_no) references Pet_Owner,
   constraint fk_Animal_Kind_name foreign key(Animal_Kind_name) references Animal_Kind
);


--비회원이 병원에 방문했을 경우에는 병원측에서 고객의 Pet_Owner_no를 시퀀스로 부여하고
--이름과 전화번호만 입력시켜주고 나머지는 null값으로 입력한 후에 
--Pet의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01011112222','장형원',null,null,null);
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'송이','2004.07.07','암컷','예쁨','개');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'도트','2014.09.17','수컷','발랄함','고양이');

--비회원이 회원으로 전환할 경우 전화번호로 조회하여 해당 회원의 id, 비밀번호, 주소를 유효한 값으로 수정한다.
update Pet_Owner set Pet_Owner_id='jsp', Pet_Owner_password='1234', Pet_Owner_address='수원'
where Pet_Owner_tel='01011112222';

--웹사이트를 통해 회원가입을 할 경우 Pet_Owner_no를 시퀀스로 부여받고 나머지 정보를 입력한 뒤 펫의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01011113333','강신후','java','1234','인천');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'코디','2012.06.07','암컷','귀여움','개');

--회원 탈퇴를 할 경우 회원의 id로 조회하여 
-- id와 비밀번호와 주소를 null값으로 수정한다.
update Pet_Owner
set Pet_Owner_id=null, Pet_Owner_password=null, Pet_Owner_address=null
where Pet_Owner_id = 'java'
      
      


delete Pet where Pet_Owner_tel = '01012341234';
delete Member_Pet_owner where Pet_Owner_tel = '01012341234';
delete Pet_owner where Pet_Owner_tel = '01012341234';

select * from Animal_Kind;
select * from Pet_Owner;
select * from Pet;

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

drop table Vet cascade constraint
drop table Hospital cascade constraint
drop sequence Hospital_id_seq;
drop table Vet_License cascade constraint

create sequence Hospital_id_seq;
-- 병원
create table Hospital(
   Hospital_id varchar2(50) primary key,
   Hospital_name varchar2(50) not null,
   Hospital_address varchar2(200) not null,
   Hospital_tel varchar2(50) not null
)
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
insert into Vet values('ImChangJung', '1234','111-1111',2 ,'4');
insert into Vet values('ParBG', '1234', '111-1111', 6, '2');
insert into Vet values('YUNA',  '1234', '111-1111',4,'2');
insert into Vet values('DoctorSong', '1234','111-1111',1, '5');


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