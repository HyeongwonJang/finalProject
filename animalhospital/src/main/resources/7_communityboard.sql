drop sequence Community_Board_no_seq;
drop table Community_Board;

create sequence Community_Board_no_seq nocache;
create table Community_Board(
   Community_Board_no number(15) primary key,
   Community_Board_title varchar2(100) not null,
   Community_Board_content clob not null,
   Community_Board_hours date not null,
   Community_Board_hit number default 0,
   Community_Board_user_type varchar2(20)   
);

select * from Community_Board;