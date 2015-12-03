commit

-- Animal_Kind
insert into Animal_kind(Animal_kind_name)
values('고양이');
insert into Animal_kind(Animal_kind_name)
values('개');

/*
 * 보호자 파트 회원관리 디비 샘플
 */
--비회원이 병원에 방문했을 경우에는 병원측에서 고객의 Pet_Owner_no를 시퀀스로 부여하고
--이름과 전화번호만 입력시켜주고 나머지는 null값으로 입력한 후에 
--Pet의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01011112222','장형원',null,null,null);
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'송이','2004.07.07','암컷','예쁨','개');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'도트','2014.09.17','수컷','발랄함','고양이');
--비회원이 회원으로 전환할 경우 전화번호로 조회하여 해당 회원의 id, 비밀번호, 주소를 유효한 값으로 수정한다.
update Pet_Owner set Pet_Owner_id='jsp', Pet_Owner_password='1234', Pet_Owner_address='수원'
where Pet_Owner_tel='01011112222';
--웹사이트를 통해 회원가입을 할 경우 Pet_Owner_no를 시퀀스로 부여받고 나머지 정보를 입력한 뒤 펫의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01011113333','강신후','java','1234','인천');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(2,'코디','2012.06.07','암컷','귀여움','개');
--회원 탈퇴를 할 경우 회원의 id로 조회하여 
-- id와 비밀번호와 주소를 null값으로 수정한다.
update Pet_Owner
set Pet_Owner_id=null, Pet_Owner_password=null, Pet_Owner_address=null
where Pet_Owner_id = 'java';

-- Hospital
insert into Hospital values(Hospital_id_seq.nextval, 'KOSTA 동물병원', '성남시 분당구 백현동', '031-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, 'TOMCAT 동물병원', '인천시 서구 검암동', '032-123-4568');
insert into Hospital values(Hospital_id_seq.nextval, 'EXCEPTION 동물병원', '서울시 마포구 상암동', '02-123-4569');
insert into Hospital values(Hospital_id_seq.nextval, '임박사동물병원', '성남시 분당구 운중동', '031-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, '송일국 동물병원', '인천시 연수구 송도동', '032-123-4567');
insert into Hospital values(Hospital_id_seq.nextval, 'Kal-Toi Anial Hospital', '서울시 서초구', '032-123-4567');
-- Vet
insert into Vet_License values(Vet_License_no_seq.nextval, '송일국', 711001, to_date('1999/12/20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '임창정', 731130, to_date('1973/11/30'));
insert into Vet_License values(Vet_License_no_seq.nextval, '서정우',730605, to_date('2015/11/26'));
insert into Vet_License values(Vet_License_no_seq.nextval, '이윤아', 880625, to_date('2013/9/2'));
insert into Vet_License values(Vet_License_no_seq.nextval, '칼퇴하조', 890905, to_date('1999/12/20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '박보검',930616, to_date('2011/12/20'));
-- Vet_License
insert into Vet values('ImChangJung', '1234','111-1111',2 ,'4');
insert into Vet values('ParBG', '1234', '111-1111', 6, '2');
insert into Vet values('YUNA',  '1234', '111-1111',4,'2');
insert into Vet values('DoctorSong', '1234','111-1111',1, '5');
/*
 * 병원 파트 샘플 디비
 */
-- 몇년 되었나 , ex) 나이, 근속연수,
select trunc(months_between(sysdate,get_License_date)/12)
from Vet_License

-- Disease
insert into Disease(Disease_name, Disease_symptom)
values('감기','고열, 몸살, 식욕저하, 호흡곤란');
insert into Disease(Disease_name, Disease_symptom)
values('광견병','전구기, 광조기, 마비기');
insert into Disease(Disease_name, Disease_symptom)
values('골절','뼈가 부러짐');
insert into Disease(Disease_name, Disease_symptom)
values('결막염','눈에 염증, 눈이 붉어짐');
-- Treatment_Record
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-10-15', '주사 처방', 3.4, 1, '송이', null, '감기');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2010-4-14', '안약 처방', 4.4, 1, '도트', 5, '결막염');
