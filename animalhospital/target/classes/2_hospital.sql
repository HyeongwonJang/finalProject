/*
 * 병원 파트(Hospital, Vet_License, Vet)
 */

-- Hospital
create sequence Hospital_id_seq nocache;
create table Hospital(
	Hospital_id varchar2(50) primary key,
	Hospital_name varchar2(50) not null,
	Hospital_address varchar2(200) not null,
	Hospital_tel varchar2(50) not null
);
select * from Hospital;


-- Vet_License
create sequence Vet_License_no_seq nocache;
create table Vet_License(
	Vet_License_no number(10) primary key,
	Vet_name varchar2(50) not null,
	resident_no number(15),
	get_License_date date not null
);
select * from Vet_License;

-- Vet
create table Vet(
	Vet_id varchar2(50) primary key,
	Vet_password varchar2(50) not null,
	Vet_tel varchar2(50) not null,
	Vet_License_no number(10),
	Hospital_id varchar2(50),
	constraint fk_Vet_License_no foreign key(Vet_License_no) references Vet_License,
	constraint fk_Hospital_id foreign key(Hospital_id) references Hospital
);
select * from Vet;