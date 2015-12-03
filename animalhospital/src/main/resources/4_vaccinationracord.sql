/*
 * 예방접종 파트(Vaccination, Vaccination_Record) 
 */
-- Vaccination
create table Vaccination (
	Vaccination_name varchar2(50) primary key
);
select * from Vaccination;

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
	Vaccination_name varchar2(50) not null,
	constraint fk_vr_Pet_id foreign key(pet_Owner_no, pet_name) references Pet,
	constraint fk_vr_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_vr_Vaccination_name foreign key(Vaccination_name) references Vaccination
);
select * from Vaccination_Record;
