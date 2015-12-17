create table reservation_time(
Time_no number(2) primary key,
Reservation_time varchar2(6) unique
);

select * from reservation_time

drop sequence reservation_seq;
create sequence reservation_seq nocache;
drop table reservation;
create table reservation(
Reservation_no number(10) primary key,
Reservation_date date not null,
Time_no number(2) not null,
Vet_License_no number(10) not null,
Pet_name varchar2(50) not null,
Pet_Owner_no number(15) not null,
reservation_content clob not null,
constraint fk_reservation_timeList foreign key (Time_no) references reservation_time,
constraint fk_reservation_vetlicenseno foreign key (Vet_License_no) references Vet_License,
constraint fk_reservation_pet foreign key(pet_Owner_no, pet_name) references Pet,
constraint reservation_unique unique (Reservation_date,Time_no,Vet_License_no)
)

select * from reservation_time

insert into reservation_time values(1,'09:00');
insert into reservation_time values(2,'09:30');
insert into reservation_time values(3,'10:00');
insert into reservation_time values(4,'10:30');
insert into reservation_time values(5,'11:00');
insert into reservation_time values(6,'11:30');
insert into reservation_time values(7,'12:00');
insert into reservation_time values(8,'12:30');
insert into reservation_time values(9,'13:00');
insert into reservation_time values(10,'13:30');
insert into reservation_time values(11,'14:00');
insert into reservation_time values(12,'14:30');
insert into reservation_time values(13,'15:00');
insert into reservation_time values(14,'15:30');
insert into reservation_time values(15,'16:00');
insert into reservation_time values(16,'16:30');
insert into reservation_time values(17,'17:00');
insert into reservation_time values(18,'17:30');


insert into reservation (Reservation_no ,Reservation_date,Time_no,Vet_License_no,Pet_name,Pet_Owner_no,reservation_content )
values(reservation_seq.nextval,to_date('2015/12/23'),2,1,'비지',1,'예방접종');
insert into reservation (Reservation_no ,Reservation_date,Time_no,Vet_License_no,Pet_name,Pet_Owner_no,reservation_content )
values(reservation_seq.nextval,to_date('2015/12/23'),3,2,'매주',2,'정기검진');
insert into reservation (Reservation_no ,Reservation_date,Time_no,Vet_License_no,Pet_name,Pet_Owner_no,reservation_content )
values(reservation_seq.nextval,to_date('2015/12/27'),3,1,'비지',1,'정기검진');
insert into reservation (Reservation_no ,Reservation_date,Time_no,Vet_License_no,Pet_name,Pet_Owner_no,reservation_content )
values(reservation_seq.nextval,to_date('2015/12/27'),4,1,'두부',1,'정기검진');
insert into reservation (Reservation_no ,Reservation_date,Time_no,Vet_License_no,Pet_name,Pet_Owner_no,reservation_content )
values(reservation_seq.nextval,to_date('2015/12/23'),8,1,'비지',1,'정기검진');


select t.timeNo,t.timeList
from reservation r, ttime t
where r.timeNo(+)= t.timeNo
and r.reserveDate='2015/01/01'
and r.timeNo is null
order by t.timeNo asc

select t.timeNo,t.timeList
from (select timeNo
		 from reservation
		 where reserveDate='2015/01/02')r, ttime t
where r.timeNo(+)= t.timeNo
and r.timeNo is null
order by t.timeNo asc

