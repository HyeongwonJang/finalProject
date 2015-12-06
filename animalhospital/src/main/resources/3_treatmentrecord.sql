/*
 * 진료기록 파트(Disease, Treatment_Record)
 */

-- Disease
drop table Disease
create table Treatment(
	Disease_name varchar2(50) primary key,
	Disease_symptom varchar2(200) not null
);
select * from Disease;

-- Treatment_Record
create sequence Treatment_Record_no nocache;
create table Treatment_Record(
	Treatment_Record_no number(15) primary key,
	Treatment_hours date not null,
	Treatment_content clob not null,
	Pet_weight float(10) not null,
	Pet_Owner_no number(15) not null,
	Pet_name varchar2(50) not null,
	Vet_License_no number(10),
	Disease_name varchar2(50) not null,
	constraint fk_tr_Pet_id foreign key(pet_Owner_no, pet_name) references Pet,
	constraint fk_tr_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_tr_Disease_name foreign key(Disease_name) references Disease
);
select * from Treatment_Record;
