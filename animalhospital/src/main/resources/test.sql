select l.vet_name
		from Vet v, Vet_License l
		where v.Vet_License_no = l.Vet_License_no
		and l.Vet_License_no = 4
		
select
	vr.Vaccination_hours, vr.Vaccination_name, 
	po.Pet_Owner_name, po.Pet_Owner_tel, 
	vr.Pet_weight, vl.vet_name 
from VACCINATION_RECORD vr, PET_OWNER po, Pet p, VET_LICENSE vl, VET v
where vr.pet_owner_no = po.pet_owner_no
and po.pet_owner_no = p.pet_owner_no
and vr.pet_name = p.pet_name
--and vr.Vet_License_no= vl.Vet_License_no 
--and vl.Vet_License_no = v.Vet_License_no 
and vr.Vet_License_no = vl.Vet_License_no(+)
and vl.Vet_License_no = v.Vet_License_no(+)
and 
and Vaccination_Record_no = 1;


select sys from dual;

select p.pet_name, p.pet_gender, p.Animal_kind_name
from PET p, TREATMENT_RECORD t
where t.pet_owner_no = p.pet_owner_no
and t.pet_name = p.pet_name
and Treatment_Record_no = 42






select 
		
			t.Treatment_hours,
			t.Treatment_content,
			t.Disease_name,
			d.Disease_symptom,
			po.Pet_Owner_name,
			po.Pet_Owner_tel,
			t.pet_weight,
			vl.vet_name,
			h.hospital_name,
			h.hospital_tel
		from Treatment_Record t, PET_OWNER po, VET_LICENSE vl, VET v, HOSPITAL h, disease d
		where t.pet_owner_no = po.pet_owner_no
		and t.Disease_name = d.Disease_name
		and t.Vet_License_no = vl.Vet_License_no
		and vl.Vet_License_no = v.Vet_License_no
		and v.hospital_id = h.hospital_id
		and Treatment_Record_no = 42

		
		
select  t.Treatment_hours,
		t.Treatment_content,
		t.Disease_name,
		po.Pet_Owner_name,
		po.Pet_Owner_tel,
		p.pet_name,
		p.pet_gender,
		t.pet_weight,
		p.Animal_kind_name,
		vl.vet_name,
		h.hospital_name,
		h.hospital_tel
from Treatment_Record t, PET_OWNER po, PET p, VET_LICENSE vl, VET v, HOSPITAL h
where t.pet_owner_no = po.pet_owner_no
and t.pet_owner_no = p.pet_owner_no
and t.pet_name = p.pet_name
and t.Vet_License_no = vl.Vet_License_no
and vl.Vet_License_no = v.Vet_License_no
and v.hospital_id = h.hospital_id
and Treatment_Record_no = 42

--and p.animal_kind_name = a.animal_kind_name


select t.Vet_License_no
from (
	select  t.Treatment_Record_no as a,
			t.Treatment_hours,
			t.Treatment_content,
			t.Disease_name,
			po.Pet_Owner_name,
			po.Pet_Owner_tel,
			p.pet_name,
			p.pet_gender,
			t.pet_weight,
			vl.vet_name,
			vl.Vet_License_no as Vet_License_no,
			p.Animal_kind_name
	from Treatment_Record t, PET_OWNER po, PET p, VET_LICENSE vl, DISEASE d
	where t.pet_owner_no = po.pet_owner_no
	and t.pet_owner_no = p.pet_owner_no
	and t.pet_name = p.pet_name
	and t.Vet_License_no = vl.Vet_License_no
	and t.disease_name = d.disease_name
	and Treatment_Record_no = 5
) t

--where v.Vet_License_no = t.Vet_License_no

select *
from vet


select vl.vet_name, 
from Treatment_Record t, VET_LICENSE vl
where t.Vet_License_no = vl.Vet_License_no
and Treatment_Record_no = 5
--and vl.Vet_License_no = v.Vet_License_no






Treatment_Record t, PET_OWNER po, PET p, VET_LICENSE vl
where t.pet_owner_no = po.pet_owner_no
and t.pet_owner_no = p.pet_owner_no
and t.pet_name = p.pet_name
and t.Vet_License_no = vl.Vet_License_no
and Treatment_Record_no = 5
		


, VET v, HOSPITAL h

, VET_LICENSE vl, VET v
, vl.vet_name

select t.Treatment_Record_no, t.Treatment_hours, t.Treatment_content,
	t.Disease_name, d.Disease_symptom, h.hospital_name, h.hospital_tel,
	vl.vet_name, p.pet_name, p.pet_gender, t.pet_weight, 
	po.Pet_Owner_name, po.Pet_Owner_tel
from Treatment_Record t, PET p, PET_OWNER po, HOSPITAL h, VET v, DISEASE d, VET_LICENSE vl
-- 보호자 join
where t.Pet_Owner_no = po.Pet_Owner_no
-- 반려동물 join
and t.Pet_Owner_no = p.Pet_Owner_no
-- 수의사 join
and t.Vet_License_no = vl.Vet_License_no
-- 병원 join
and v.Hospital_id = h.Hospital_id
-- 질병 join
and t.Disease_name = d.Disease_name
-- 검색조건
and t.Treatment_Record_no = 5;



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
		
select 
			vr.Vaccination_hours, vr.Vaccination_name, 
			po.Pet_Owner_name, po.Pet_Owner_tel, 
			vr.Pet_weight, vl.Vet_name,  
			h.Hospital_name, h.Hospital_tel 
		from VACCINATION_RECORD vr, PET_OWNER po, VET_LICENSE vl, VET v, HOSPITAL h, VACCINATION va 
		where vr.pet_owner_no = po.pet_owner_no 
			and vr.Vaccination_name = va.Vaccination_name 
			and vr.Vet_License_no= vl.Vet_License_no (+)
			and vl.Vet_License_no = v.Vet_License_no(+)
			and v.Hospital_id = h.Hospital_id(+)
			and vr.Vaccination_Record_no = 1;
			
select * from VACCINATION_RECORD
where ;
