<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	// ajax로 진료기록조회 번호를 기준으로 진료기록을 검색하여 
	// 각 테이블에 값들을 세팅하는 스크립트 문
	$(document).ready(function() {
		$(".detailView").click(function() {
			
			alert($(this).parent().siblings().eq(0).text());
			$("#modalRecordHours").text("테스트 종료");
			$("#modalHospitalName").text();
			$("#modalHospitalTel").text();
			$("#modalVetName").text();
			$("#modalPetName").text();
			$("#modalPetGender").text();
			$("#modalPetKind").text();
			$("#modalPetWeight").text();
			$("#modalPetBirthDay").text();
			$("#modalPetOwnerName").text();
			$("#modalPetOwnerTel").text();
			$("#modalRecordContent").text();
			$('div.modal').modal({});
		});
	});
</script>    
<div class="modal fade bs-example-modal-lg">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
           	<h4 class="modal-title">진료기록상세</h4>
           	<p class="text-right">진료일시: 
           		<strong id="modalRecordDate"></strong>
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