/*
 * 예방접종 파트(Vaccination, Vaccination_Record) 
 */
-- Vaccination
create sequence Vaccination_No_seq;
create table Vaccination (
	Vaccination_no number(15) primary key,
	Vaccination_name varchar2(50) not null,
	Vaccination_Period_section number(15) not null,
	Vaccination_Basic_period number(15) not null,
	Vaccination_Add_period number(15)
);
insert into VACCINATION values(vaccination_no_seq.nextval, '종합백신', 30, 365);
insert into VACCINATION(Vaccination_no, Vaccination_name, Vaccination_Basic_period) 
	values(vaccination_no_seq.nextval, '광견병', 180);
insert into VACCINATION values(vaccination_no_seq.nextval, '코로나', 30, 365);
insert into VACCINATION(Vaccination_no, Vaccination_name, Vaccination_Basic_period) 
	values(vaccination_no_seq.nextval, '광견병', 180);

-- Vaccination_Record
create sequence Vaccination_Record_no nocache;
create table Vaccination_Record (
	Vaccination_Record_no number(15) primary key,
	Vaccination_hours date not null,
	Vaccination_content clob not null,
	Pet_weight float(10),
	Pet_Owner_no number(15) not null,
	Pet_name varchar2(50) not null,
	Vet_License_no number(10),
	Vaccination_no number(15) not null,
	constraint fk_vr_Pet_id foreign key(pet_Owner_no, pet_name) references Pet,
	constraint fk_vr_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_vr_Vaccination_no foreign key(Vaccination_no) references Vaccination
);
select * from Vaccination_Record;
