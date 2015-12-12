<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	// ajax로 진료기록조회 번호를 기준으로 진료기록을 검색하여 
	// 각 테이블에 값들을 세팅하는 스크립트 문
	$(document).ready(function() {
		$("#hospitalListInfo").on("click", ".detailView", function() {
			var hospitalId=$(this).siblings().eq(0).text();
			$("#modalHospitalName").text($(this).siblings().eq(1).text());
			$("#modalHospitalAddress").text($(this).siblings().eq(2).text());
			$("#modalHospitalTel").text($(this).siblings().eq(3).text());
			
			$.ajax({
				type: "post",
				url: "findVetLicenseByHospitalId.do",
				data: "hospitalId="+hospitalId,
				success: function(vetLicenseVOList){
			    	//alert(vetLicenseVOList[0].vetName);
					var str = "";
			    	$.each(vetLicenseVOList, function(index) {
						str += "<tr>";
						str += "<td>" + ( vetLicenseVOList[index].vetLicenseNo) + "</td>";
			    		str += "<td>" + ( vetLicenseVOList[index].vetName ) + "</td>";
			    		str += "<td>" + ( vetLicenseVOList[index].getLicenseDate ) + "</td>";
			    		str += "</tr>"
			    	});
					$("#detailVet").html(str);
					
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
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">병원 정보 상세</h4>
			</div>
			<div class="modal-body" id="modalBody">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td><b>병원 이름</b></td>
							<td colspan="2" id="modalHospitalName"></td>
							<td><b>주소</b></td>
							<td colspan="2" id="modalHospitalAddress"></td>
							<td><b>전화번호</b></td>
							<td colspan="2" id="modalHospitalTel"></td>
						</tr>
				</table>
			</div>
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">의사 정보</h4>
			</div>
			<div class="modal-body" id="modalBody">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><b>의사 번호</b></th>
							<th><b>이름</b></th>
							<th><b>면허취득일</b></th>
						</tr>
					</thead>
					<tbody id="detailVet">
						
					</tbody>
				</table>					
			</div>
		</div>
	</div>
</div>