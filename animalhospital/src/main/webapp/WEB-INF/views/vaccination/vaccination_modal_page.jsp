<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	// ajax로 진료기록조회 번호를 기준으로 진료기록을 검색하여 
	// 각 테이블에 값들을 세팅하는 스크립트 문
	$(document).ready(function() {
		$(".detailView").click(function() {
			var treatmentRecordNo=$(this).parent().siblings().eq(0).text();
			$.ajax({
				type: "post",
				url: "findDetailTreatmentRecordByTreatmentNo.do",
				data: "treatmentRecordNo="+treatmentRecordNo,
				dataType: "json",
				success: function(findTreatmentRecordDetaileResult){
					$("#modalRecordHours").text(findTreatmentRecordDetaileResult.treatmentHours);
					$("#modalHospitalName").text(findTreatmentRecordDetaileResult.hospitalVO.hospitalName);
					$("#modalHospitalTel").text(findTreatmentRecordDetaileResult.hospitalVO.hospitalTel);
					$("#modalVetName").text(findTreatmentRecordDetaileResult.hospitalVO.vetList[0].vetLicenseVO.vetName);
					$("#modalPetName").text(findTreatmentRecordDetaileResult.petOwnerVO.petVO[0].petName);
					$("#modalPetGender").text(findTreatmentRecordDetaileResult.petOwnerVO.petVO[0].petGender);
					$("#modalPetKind").text(findTreatmentRecordDetaileResult.petOwnerVO.petVO[0].animalKindName);
					$("#modalPetWeight").text(findTreatmentRecordDetaileResult.petWeight);
					$("#modalPetBirthDay").text(findTreatmentRecordDetaileResult.petOwnerVO.petVO[0].petBirthday);
					$("#modalPetOwnerName").text(findTreatmentRecordDetaileResult.petOwnerVO.petOwnerName);
					$("#modalPetOwnerTel").text(findTreatmentRecordDetaileResult.petOwnerVO.petOwnerTel);
					$("#modalRecordContent").text(findTreatmentRecordDetaileResult.treatmentContent);
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
           	<p class="text-right">진료일시: 
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
                  <td colspan="7" id="modalVaccinationName"></td>
                </tr>
                <tr>
                  <td colspan="9" align="center">
                    <b>진료내용</b>
                  </td>
                </tr>
                <tr>
                  <td colspan="9">
                    <pre class="pre-scrollable" id="modalRecordContent">
                    </pre>
                  </td>
                </tr>
            </table>
          </div>
        </div>
      </div>
    </div>