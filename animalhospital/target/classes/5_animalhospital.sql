-- Animal_Kind
insert into Animal_kind(Animal_kind_name)
values('고양이');
insert into Animal_kind(Animal_kind_name)
values('개');
insert into Animal_kind(Animal_kind_name)
values('새');
insert into Animal_kind(Animal_kind_name)
values('쥐');
insert into Animal_kind(Animal_kind_name)
values('거북이');
insert into Animal_kind(Animal_kind_name)
values('뱀');
insert into Animal_kind(Animal_kind_name)
values('도마뱀');
insert into Animal_kind(Animal_kind_name)
values('고슴도치');

/*
 * 보호자 파트 회원관리 디비 샘플
 */
--비회원이 병원에 방문했을 경우에는 병원측에서 고객의 Pet_Owner_no를 시퀀스로 부여하고
--이름과 전화번호만 입력시켜주고 나머지는 null값으로 입력한 후에 
--Pet의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01011111111','정우성',null,null,null);
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'두부','2014-07-07','암컷','두부를 잘 빚음','개');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(1,'비지','2014-09-15','수컷','비지를 잘 먹음','개');
--비회원이 회원으로 전환할 경우 전화번호로 조회하여 해당 회원의 id, 비밀번호, 주소를 유효한 값으로 수정한다.
update Pet_Owner set Pet_Owner_id='tp1', Pet_Owner_password='1234', Pet_Owner_address='서울'
where Pet_Owner_tel='01011111111';
--웹사이트를 통해 회원가입을 할 경우 Pet_Owner_no를 시퀀스로 부여받고 나머지 정보를 입력한 뒤 펫의 정보를 입력한다.
insert into Pet_Owner(Pet_Owner_no, Pet_Owner_tel, Pet_Owner_name, Pet_Owner_id, Pet_Owner_password, Pet_Owner_address)
values(Pet_Owner_no_seq.nextval,'01022222222','아이유','tp2','1234','판교');
insert into Pet(Pet_Owner_no,Pet_name, Pet_birthday, Pet_gender, Pet_note, Animal_kind_name)
values(2,'매주','2012.06.07','암컷','매주를 냄새가 남','고양이');
--회원 탈퇴를 할 경우 회원의 id로 조회하여 
-- id와 비밀번호와 주소를 null값으로 수정한다.
update Pet_Owner
set Pet_Owner_id=null, Pet_Owner_password=null, Pet_Owner_address=null
where Pet_Owner_id = 'tp2';

-- Hospital
insert into Hospital values(Hospital_id_seq.nextval, 'KOSTA 동물병원', '성남시 분당구 백현동', '0311234567');
insert into Hospital values(Hospital_id_seq.nextval, 'TOMCAT 동물병원', '성남시 분당구 운중동', '0311234568');
insert into Hospital values(Hospital_id_seq.nextval, 'EXCEPTION 동물병원', '서울시 마포구 상암동', '021234569');


-- Vet
insert into Vet_License values(Vet_License_no_seq.nextval, '강소라', 881001, to_date('1999-12-20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '임창정', 731130, to_date('1993-11-30'));
insert into Vet_License values(Vet_License_no_seq.nextval, '김옥빈', 730605, to_date('2005-11-26'));
insert into Vet_License values(Vet_License_no_seq.nextval, '송일국', 710625, to_date('2013-9-2'));
insert into Vet_License values(Vet_License_no_seq.nextval, '김가영', 920905, to_date('2014-12-20'));
insert into Vet_License values(Vet_License_no_seq.nextval, '박보검', 930616, to_date('2014-12-20'));
-- Vet_License
insert into Vet values('tv1', '1234', '01011112222', 1, '1');
insert into Vet values('tv2', '1234', '01011113333', 2, '1');
insert into Vet values('tv3', '1234', '01011114444', 3, '2');
insert into Vet values('tv4', '1234', '01011115555', 4, '3');
insert into Vet values('tv5', '1234', '01011116666', 5, '3');
insert into Vet values('tv6', '1234', '01011117777', 6, '3');
/*
 * 병원 파트 샘플 디비
 */
-- 몇년 되었나 , ex) 나이, 근속연수,
select trunc(months_between(sysdate,get_License_date)/12)
from Vet_License;

-- Disease
insert into Disease(Disease_name, Disease_symptom)
values('감기','고열, 몸살, 식욕저하, 호흡곤란');
insert into Disease(Disease_name, Disease_symptom)
values('광견병','전구기, 광조기, 마비기');
insert into Disease(Disease_name, Disease_symptom)
values('골절','뼈가 부러짐');
insert into Disease(Disease_name, Disease_symptom)
values('결막염','눈에 염증, 눈이 붉어짐');
insert into Disease(Disease_name, Disease_symptom)
values('벼룩','복부, 넙적다리 안쪽 등에 구진');
insert into Disease(Disease_name, Disease_symptom)
values('습진','습성, 건성, 알레르기성으로 피부에 염증');
insert into Disease(Disease_name, Disease_symptom)
values('위염','구토, 신음');
insert into Disease(Disease_name, Disease_symptom)
values('식중독','갑작스런 구토, 설사, 점혈변, 체온저하');
insert into Disease(Disease_name, Disease_symptom)
values('변비','이급후증증, 식욕부진, 탈수');
insert into Disease(Disease_name, Disease_symptom)
values('기관지염','기침, 체온저하, 신음소리');
insert into Disease(Disease_name, Disease_symptom)
values('치주질환','식욕저하, 신음소리');
insert into Disease(Disease_name, Disease_symptom)
values('심장사상충','폐성고혈압, 기침, 고열');

-- Treatment_Record
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2014-10-10', '주사 처방', 2.4, 1, '두부', 4, '감기');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2015-12-27', '주사 처방, 약 처방', 2.3, 1, '두부', 4, '감기');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2014-10-20', '입원 치료(주사, 약 처방)', 1.8, 1, '비지', 4, '식중독');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2012-8-12', '약 처방', 3.4, 2, '매주', 2, '습진');
insert into Treatment_Record(Treatment_Record_no, Treatment_hours, Treatment_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Disease_name)
values(Treatment_Record_no.nextval, '2013-2-12', '약 처방', 3.4, 2, '매주', 2, '벼룩');

-- Vaccination
insert into Vaccination(Vaccination_name) values('DHPPL');
insert into Vaccination(Vaccination_name) values('Corona');
insert into Vaccination(Vaccination_name) values('Kennel Cough');
insert into Vaccination(Vaccination_name) values('Rabies');
insert into Vaccination(Vaccination_name) values('Feline Panleukopenia');
insert into Vaccination(Vaccination_name) values('Feline Viral Rhinotracheitis');
insert into Vaccination(Vaccination_name) values('Feline Calicivirus');
insert into Vaccination(Vaccination_name) values('Feline Leukemia');
insert into Vaccination(Vaccination_name) values('Chlamydia');
insert into Vaccination(Vaccination_name) values('Feline Infectious Peritonitis');
-- Vaccination_Record
insert into Vaccination_Record(
Vaccination_Record_no,
Vaccination_hours,
Vaccination_content,
Pet_weight,
Pet_Owner_no,
Pet_name,
Vet_License_no,
Vaccination_no,
Vaccination_current_section)
values(
Vaccination_Record_no.nextval,
sysdate,
'알림 기능 추가 테스트 2 6차까지 끝남',
2.4,
1,
'두부',
null,
1,
6);
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2004_12_1', '2차', 2.8, 1, '송이', null, 'DHPPL');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2005_1_15', '1차', 3.1, 1, '송이', 2, 'Corona');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2005_1_15', '1차', 3.1, 1, '송이', 2, 'Rabies');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2014_11_15', '1차', 2.4, 1, '도트', 5, 'Feline Panleukopenia');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2014_11_15', '1차', 2.4, 1, '도트', 5, 'Feline Viral Rhinotracheitis');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2015_3_1', '1차', 3.2, 1, '도트', null, 'Rabies');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2015_3_1', '1차', 3.2, 1, '도트', null, 'Feline Calicivirus');
insert into Vaccination_Record(Vaccination_Record_no, Vaccination_hours, Vaccination_content, Pet_weight, Pet_Owner_no, Pet_name, Vet_License_no, Vaccination_name)
values(Vaccination_Record_no.nextval, '2015_3_1', '1차', 3.2, 1, '도트', null, 'Chlamydia');
