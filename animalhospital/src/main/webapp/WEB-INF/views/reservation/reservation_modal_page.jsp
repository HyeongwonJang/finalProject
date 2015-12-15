<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#hospitalFindBtn").click(function() {
		$.ajax({
		    type: "post", // get 또는 post로 설정
		    url: "findHospital.do", // 이동할 url 설정
		    data: $("#findHospitalForm").serialize(),
		    dataType:"json",      
		    success: function(hospitalList){
		    	var str = "";
		    	$.each(hospitalList, function(index) {
		    		//alert(hospitalList[index].hospitalName);
					str += "<tr class='odd pointer'>";
					str += "<td style ='display:none;'>" + ( hospitalList[index].hospitalId) + "</td>";
		    		str += "<td>" + ( hospitalList[index].hospitalName ) + "</td>";
		    		str += "<td>" + ( hospitalList[index].hospitalAddress ) + "</td>";
		    		str += "<td>" + ( hospitalList[index].hospitalTel ) + "</td>";
			    	str += "<td class='detailView'><button type='button' class='btn btn-primary' id='selectHospitalBtn'>선택</a></td></tr>";
			    	
		    	});
		    	$("#hospitalInfo").html("<tr class='headings'><th class='column-title' style ='display:none;'>병원 번호</th><th class='column-title'>병원 이름</th><th class='column-title'>주소</th><th class='column-title'>전화번호</th><th class='column-title no-link last'><span class='nobr'></span></th></tr>");
				$("#hospitalListInfo").html(str);
		    }
		});
	});
	$("#hospitalListInfo").on("click", "#selectHospitalBtn", function() {
		//alert($(this).parent().siblings().eq(0).text());
		$("#hospitalName").val($(this).parent().siblings().eq(1).text());
		$("#hospitalId").val($(this).parent().siblings().eq(0).text());
		$('div.modal').fadeOut();
	});
});
</script>

<div class="modal fade bs-example-modal-lg">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">병원검색</h4>
			</div>

			<div class="modal-body" id="modalBody">
				<form method="post" id="findHospitalForm">
					<label>병원 이름 : </label> <input type="text" name="hospitalName"
						id="hospitalName"> &nbsp;&nbsp; <label> 병원 주소 : </label> <input
						type="text" name="hospitalAddress" id="hospitalAddress">
					<input type="hidden" id="page" name="page">
					<button type="button" class="btn btn-default" id="hospitalFindBtn">검색</button>
				</form>
				<hr>
				<table
					class="table table-striped responsive-utilities jambo_table bulk_action">
					<thead id='hospitalInfo'>
					</thead>
					<!-- 페이지 부분 -->
					<tbody id='hospitalListInfo'>

					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>