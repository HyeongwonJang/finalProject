/*
 * 보호자 파트(Animal_Kind, Pet_Owner, Pet)
 */

-- Animal_Kind
create table Animal_kind(
	Animal_kind_name varchar2(50) primary key
);
select * from Animal_Kind;

-- Pet_Owner
create sequence Pet_Owner_no_seq nocache;
create table Pet_Owner(
	Pet_Owner_no number(15) primary key,
	Pet_Owner_tel varchar2(50) unique,
	Pet_Owner_name varchar2(50) not null,
	Pet_Owner_id varchar2(50) unique,
	Pet_Owner_password varchar2(50),
	Pet_Owner_address varchar2(50)
);
select * from Pet_Owner;

-- Pet
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
select * from Pet;
