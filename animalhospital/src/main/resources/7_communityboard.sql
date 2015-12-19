drop sequence Question_board_no_seq;
drop table Answer_board;
drop table Question_board;

create sequence Question_board_no_seq nocache;
create table Question_board (
	Question_board_no number primary key,
	Question_board_title varchar2(100),
	Question_board_writer varchar2(50),
	Question_board_content clob,
	Question_board_hours date,
	Question_board_hit number,
	constraint Question_writer_id foreign key(Question_board_writer) references Pet_Owner(Pet_Owner_id)
);
create sequence Answer_board_no_seq nocache;
create table Answer_board(
	Answer_board_no number primary key,
	Answer_board_title varchar2(100),
	Answer_board_writer varchar2(50),
	Answer_board_content clob,
	Answer_board_hours date,
	Answer_board_hit number,
	ref number not null,  --답변글묶음 번호, 원게시글 번호 
	restep number not null,  --답변글묶음내 글순서(정렬 오름차순)
	relevel number not null,  --답변글레벨 , 답변의 단계 
	constraint Answer_writer_id foreign key(Answer_board_writer) references Vet
);

select q.Question_board_no, q.Question_board_title, p.pet_Owner_name, q.Question_board_hours,
		q.Question_board_hit
from Question_board q, PET_OWNER p
where p.Pet_Owner_id = q.Question_board_writer
order by Question_board_no desc;


select * from Question_board;
select * from Answer_board;

update Question_board 
		set Question_board_hit = Question_board_hit+1 
		where Question_board_no=14
		