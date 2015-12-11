<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	// ajax로 진료기록조회 번호를 기준으로 진료기록을 검색하여 
	// 각 테이블에 값들을 세팅하는 스크립트 문
	$(document).ready(function() {
		$("#hospitalListInfo").on("click", ".detailView", function() {
			var hospitalId=$(this).siblings().eq(0).text();
			$("#modalHospitalName").text($(this).siblings().eq(1).text());
			$.ajax({
				type: "post",
				url: "findHospitalDetail.do",
				data: "hospitalId="+hospitalId,
				success: function(findHospitalDetailResult){
					$("#modalHospitalAddress").text("hello");
					/* $("#modalRecordHours").text(findTreatmentRecordDetaileResult.treatmentHours);
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
					$("#modalRecordContent").text(findTreatmentRecordDetaileResult.treatmentContent);  */
				}
			}); 
			$('div.modal').modal({
				
			});
		});
	});
</script>    
<div class="modal fade bs-example-modal-lg">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
           	<h4 class="modal-title">병원 정보 상세</h4>
           	<p class="text-right">
           		<strong id="modalRecordHours"></strong>
           	</p>
          </div>
          <div class="modal-body" id="modalBody">
          	  	<table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <b>병원 이름</b>
                  </td>
                  <td colspan="2" id="modalHospitalName"></td>
                  <td>
                    <b>주소</b>
                  </td>
                  <td colspan="2" id="modalHospitalAddress"></td>
                  <td>
                    <b>전화번호</b>
                  </td>
                  <td colspan="2" id="modalHospitalTel"></td>
                </tr>
            </table>
          </div>
        </div>
      </div>
    </div>