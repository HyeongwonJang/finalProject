select * from Treatment_Record
where Pet_Owner_no=1;





--
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');


-- 진료기록을 보호자 회원번호(시퀀스)와 반려동물 이름으로 조회, 페이징 적용
select Treatment_Record_no, Treatment_hours, Treatment_content,
		Pet_name, Disease_name, Disease_symptom
from(
	select Treatment_Record_no, Treatment_hours, Treatment_content,
			Pet_name, Disease_name, Disease_symptom, ceil(rownum/5) as page from(
			select t.Treatment_Record_no, to_char(t.Treatment_hours, 'YYYY-MM-DD') as Treatment_hours, 
					t.Treatment_content, t.Pet_name, t.Disease_name, d.Disease_symptom
			from TREATMENT_RECORD t, DISEASE d
			where t.Disease_name = d.Disease_name
			and Pet_Owner_no = 1
			and Pet_name = '도트'
			and t.Treatment_hours 
			between to_date('2010-03-01', 'YYYY-MM-DD') and to_date('2015-12-06', 'YYYY-MM-DD')
			order by t.Treatment_Record_no desc
	)
) where page = 1





select t.Treatment_Record_no, to_char(t.Treatment_hours, 'YYYY-MM-DD') as Treatment_hours, 
	t.Treatment_content, t.Pet_name, t.Disease_name, d.Disease_symptom
from TREATMENT_RECORD t, DISEASE d
where t.Disease_name = d.Disease_name
and Pet_Owner_no = 1
and Pet_name = '도트'
and t.Treatment_hours 
between to_date('2010-03-01', 'YYYY-MM-DD') and to_date('2015-12-06', 'YYYY-MM-DD')
order by t.Treatment_Record_no desc

select p.Pet_name, p.Pet_birthday, p.Pet_gender, p.Pet_note, p.Animal_kind_name, po.Pet_Owner_no
		from Pet_Owner po, Pet p
		where po.Pet_Owner_no = p.Pet_Owner_no
		and po.Pet_Owner_tel = 01011112222	

select v.vet_id, v.vet_tel, vl.vet_name, vl.vet_license_no, h.Hospital_id, h.Hospital_name
		from vet v, Vet_License vl, HOSPITAL h
		where v.Vet_License_no = vl.Vet_License_no
		and v.Hospital_id = h.Hospital_id
		and v.vet_id = 'YUNA'
		and v.vet_password = '1234'

-- 이미 사용하고 있는 면허증 번호
select count(*)
from Vet v, Vet_License l
where v.Vet_License_no = l.Vet_License_no
and l.Vet_License_no = 22;

-- 로그인 테스트
select Pet_Owner_no, Pet_Owner_id, Pet_Owner_name, Pet_Owner_tel, Pet_Owner_address
		from  Pet_Owner
		where Pet_Owner_id = 'java' and Pet_Owner_password = '1234' 
		
select po.Pet_Owner_no, po.Pet_Owner_id, po.Pet_Owner_name, po.Pet_Owner_tel, po.Pet_Owner_address
		from  Pet_Owner po, Pet p
		where po.Pet_Owner_id = 'java' and po.Pet_Owner_password = '1234'  
			and po.Pet_Owner_no = p.Pet_Owner_no;


select * from Pet_Owner;
select * from Member_Pet_Owner;
select * from Pet;

create table test_null(
	test_no number primary key,
	id varchar2(50) unique
);

select * from test_null;
insert into test_null(test_no, id) values(1, null);
insert into test_null(test_no, id) values(2, null);

insert into test_null(test_no, id) values(3, 'a');
insert into test_null(test_no, id) values(4, 'a');

drop table test_null


-- 일반 수정, 무결성 제약조건
update Pet_Owner set Pet_Owner_tel='01011113333';

-- 제약조건 유효성 검사 하지 않기로 설정 변경, 순서는 가장 낮은 단위부터 시작
alter table Pet modify constraints pk_Pet_id disable novalidate;
alter table Pet modify constraints fk_Pet_Owner_tel disable novalidate;
alter table Member_Pet_Owner modify constraints fk_Member_Pet_Owner_tel disable novalidate;
alter table Member_Pet_Owner modify constraints pk_member_Pet_Owner_tel disable novalidate;
alter table Pet_Owner modify constraints pk_Pet_Owner_tel disable novalidate;

-- update Pet_Owner 
update Pet_Owner 
set Pet_Owner_tel='01011115555' 
where Pet_Owner_tel='01011112222'; 

-- update Member_Pet_Owner 
update Member_Pet_Owner 
set Pet_Owner_tel='01011115555' 
where Pet_Owner_tel='01011112222'; 

-- update Pet_Owner
update Pet 
set Pet_Owner_tel='01011115555' 
where Pet_Owner_tel='01011112222'; 

-- 커밋하여 적용
commit

-- 다시 제약조건 유효성 검사 시작
alter table Pet_Owner modify constraints pk_Pet_Owner_tel enable validate;
alter table Member_Pet_Owner modify constraints fk_Member_Pet_Owner_tel enable validate;
alter table Member_Pet_Owner modify constraints pk_member_Pet_Owner_tel enable validate;
alter table Pet modify constraints pk_Pet_id enable validate;
alter table Pet modify constraints fk_Pet_Owner_tel enable validate;


from(
			select Treatment_Record_no, Treatment_hours, Treatment_content, Pet_owner_name, 
				Disease_name, Disease_symptom, ceil(rownum/5) as page from(
				select t.Treatment_Record_no, to_char(t.Treatment_hours, 'YYYY-MM-DD')
				as Treatment_hours,
				t.Treatment_content, t.Disease_name, d.Disease_symptom, po.Pet_owner_name 
				from TREATMENT_RECORD t, DISEASE d, PET_OWNER po 
				where t.Disease_name = d.Disease_name
				and t.Pet_Owner_no = po.Pet_Owner_no 
				and t.Pet_name = '송이' 
				and po.Pet_Owner_tel = '01011112222' 
				and t.Treatment_hours
				between to_date('2011-11-11') and to_date('2015-12-08')
			order by t.Treatment_Record_no desc
			);
		) 



select Treatment_Record_no, Treatment_hours, Treatment_content,
				Disease_name, Disease_symptom, Pet_Owner_name 
		from(
			select Treatment_Record_no, Treatment_hours, Treatment_content, Pet_Owner_name, 
				Disease_name, Disease_symptom, ceil(rownum/5) as page from(
				select t.Treatment_Record_no, to_char(t.Treatment_hours, 'YYYY-MM-DD')
				as Treatment_hours,
				t.Treatment_content, t.Disease_name, d.Disease_symptom, po.Pet_Owner_name 
				from TREATMENT_RECORD t, DISEASE d, PET_OWNER po 
				where t.Disease_name = d.Disease_name
				and t.Pet_Owner_no = po.Pet_Owner_no 
				and t.Pet_name = '송이' 
				and po.Pet_Owner_tel = '01011112222'
				and t.Treatment_hours
				between to_date('2010-11-11') and to_date('2015-11-11')
			order by t.Treatment_Record_no desc
			)
		) where page = 1;
