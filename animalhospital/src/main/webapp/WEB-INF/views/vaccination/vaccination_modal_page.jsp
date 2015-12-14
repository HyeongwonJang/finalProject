<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	// ajax로 진료기록조회 번호를 기준으로 진료기록을 검색하여 
	// 각 테이블에 값들을 세팅하는 스크립트 문
	$(document).ready(function() {
		$(".detailView").click(function() {
			var vaccinationRecordNo=$(this).parent().siblings().eq(0).text();
			$.ajax({
				type: "post",
				url: "findDetailVaccinationRecordByVaccinationRecordNo.do",
				data: "vaccinationRecordNo="+vaccinationRecordNo,
				dataType: "json",
				success: function(findVaccinationRecordDetailResult){
					if(findVaccinationRecordDetailResult.hospitalVO.hospitalName == null){
						$("#modalHospitalName").text("보호자 등록");
						$("#modalHospitalTel").text("보호자 등록");
						$("#modalVetName").text("보호자 등록");		
					} else {
						$("#modalHospitalName").text(findVaccinationRecordDetailResult.hospitalVO.hospitalName);
						$("#modalHospitalTel").text(findVaccinationRecordDetailResult.hospitalVO.hospitalTel);
						$("#modalVetName").text(findVaccinationRecordDetailResult.hospitalVO.vetList[0].vetLicenseVO.vetName);
					}
					$("#modalRecordHours").text(findVaccinationRecordDetailResult.vaccinationHours);
					$("#modalPetName").text(findVaccinationRecordDetailResult.petOwnerVO.petVO[0].petName);
					$("#modalPetGender").text(findVaccinationRecordDetailResult.petOwnerVO.petVO[0].petGender);
					$("#modalPetKind").text(findVaccinationRecordDetailResult.petOwnerVO.petVO[0].animalKindName);
					$("#modalPetWeight").text(findVaccinationRecordDetailResult.petWeight);
					$("#modalPetBirthDay").text(findVaccinationRecordDetailResult.petOwnerVO.petVO[0].petBirthday);
					$("#modalPetOwnerName").text(findVaccinationRecordDetailResult.petOwnerVO.petOwnerName);
					$("#modalPetOwnerTel").text(findVaccinationRecordDetailResult.petOwnerVO.petOwnerTel);
					$("#modalRecordContent").text(findVaccinationRecordDetailResult.vaccinationContent);
					$("#modalVaccinationName").text(findVaccinationRecordDetailResult.vaccinationVO.vaccinationName);
				}
			});
			$('div.modal').modal({});
		});
	});
</script>    
<div class="modal fade bs-example-modal-lg">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
           	<h4 class="modal-title">예방접종상세</h4>
           	<p class="text-right">예방접종일시: 
           		<strong id="modalRecordHours"></strong>
           	</p>
          </div>
          <div class="modal-body" id="modalBody">
          	  	<table class="table table-bordered">
              <tbody>
                <tr>
                  <td align="center">
                    <strong>병원</strong>
                  </td>
                  <td>
                    <b>병원이름</b>
                  </td>
                  <td colspan="2" id="modalHospitalName"></td>
                  <td>
                    <b>병원 전화번호</b>
                  </td>
                  <td colspan="2" id="modalHospitalTel"></td>
                  <td>
                    <b>수의사명</b>
                  </td>
                  <td colspan="2" id="modalVetName"></td>
                </tr>
                <tr>
                  <td rowspan="2" align="center">
                    <p></p>
                    <p>
                      <b>반려동물</b>
                    </p>
                  </td>
                  <td>
                    <b>이름</b>
                  </td>
                  <td colspan="2" id="modalPetName"></td>
                  <td>
                    <b>성별</b>
                  </td>
                  <td colspan="2" id="modalPetGender"></td>
                  <td>
                    <b>분류</b>
                  </td>
                  <td colspan="2" id="modalPetKind"></td>
                </tr>
                <tr>
                  <td>
                    <b>몸무게</b>
                  </td>
                  <td colspan="2" id="modalPetWeight"></td>
                  <td>
                    <b>생년월일</b>
                  </td>
                  <td colspan="5" id="modalPetBirthDay"></td>
                </tr>
                <tr>
                  <td align="center">
                    <b>보호자</b>
                  </td>
                  <td>
                    <b>이름</b>
                  </td>
                  <td colspan="2" id="modalPetOwnerName"></td>
                  <td>
                    <b>전화번호</b>
                  </td>
                  <td colspan="5" id="modalPetOwnerTel"></td>
                </tr>
                <tr>
                  <td align="center">
                    <b>예방접종</b>
                  </td>
                  <td>
                    <b>예방접종명</b>
                  </td>
                  <td colspan="2" id="modalVaccinationName"></td>
                  <td colspan="1">
                    <b>예방접종상세내용</b>
                  </td>
                  <td colspan="4" id="modalRecordContent">
                    
                  </td>
                </tr>
            </table>
          </div>
        </div>
      </div>
    </div>