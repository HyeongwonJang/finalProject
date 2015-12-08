<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- select2 -->
<script>
	$(document).ready(function() {
		$(".select2_single").select2({
			placeholder : "해당 항목을 선택해주세요",
			allowClear : true
		});
		$(".select2_group").select2({});
		$(".select2_multiple").select2({
			maximumSelectionLength : 4,
			placeholder : "With Max Selection limit 4",
			allowClear : true
		});
	});
</script>
<!-- /select2 -->
<!-- <script type="text/javascript">
	$(document).ready(function() {
		$("#recordSearchBtn").click(function() {
			// Ajax로 진료기록 가져오기
			// 검색조건: 반려동물이름, 주인의 시퀀스 번호
			$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "findTreatmentRecordByPetOwner.do", // 이동할 url 설정
			    data: "petOwnerNo=" + ${sessionScope.loginVO.petOwnerNo} 
			    		+ "&petVO[0].petName=" + $("#petList option:selected").text()
			    		+ "&startDate=" + $('#startDate').val()
			    		+ "&endDate=" + $('#endDate').val(),
			    
			    dataType:"json",
			          
			    success: function(treatmentRecordList){
			   		var treatmentRecordInfo = '';
			    	$.each(treatmentRecordList, function(ti) {
			    		treatmentRecordInfo += '<tr class="odd pointer">';
			    		treatmentRecordInfo += '<td>'+ treatmentRecordList[ti].treatmentRecordNo +'</td>';
			    		treatmentRecordInfo += '<td>'+ treatmentRecordList[ti].diseaseVO.diseaseName +'</td>';
			    		treatmentRecordInfo += '<td>'+ treatmentRecordList[ti].diseaseVO.diseaseSymptom +'</td>';
			    		treatmentRecordInfo += '<td>'+ treatmentRecordList[ti].treatmentHours +'</td>';
			    		treatmentRecordInfo += '<td>'+ treatmentRecordList[ti].petVO.petName +'</td>';
			    		treatmentRecordInfo += '<td>'+ "${sessionScope.loginVO.petOwnerName}" +'</td>';
			    		treatmentRecordInfo += '<td class=" last"><a href="#">View</a></td>';
			    		treatmentRecordInfo += '</tr>';
			    		
					});
			    	$("#treatmentRecordInfo").html(treatmentRecordInfo);
			    	
			    	// paging 구현
			    	alert("게시물 개수:" + $("#treatmentRecordInfo tr").length)
			    	
			    }
			});
		
		});
	});
</script> -->
<script type="text/javascript">
	$(document).ready(function() {
		// 페이지 로딩 시 자동으로 ajax를 실행하여 petList를 가져온다
		$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "findPetListByTel.do", // 이동할 url 설정
			    dataType:"json",      
			    success: function(petList){
			    	//alert(petList.petVO[0].petName)
			     
			   		var searchPetList = '';
			    	$.each(petList.petVO, function(li) {
			    		searchPetList += "<option value=" + petList.petVO[li].petName +">"
			    						+ petList.petVO[li].petName +"</option>";
			    	});
			    	//alert("옵션 결과: " + searchPetList);
			    	$("#petListSelect").html(searchPetList);
			    }	
		});
		
		$("#recordSearchForm").submit(function() {
			
			$("#petName").val($("#petList option:selected").val());
			$("#page").val(1);
			//alert($("#petName").val());
			
		});
		
		$("a[name=pageNo]").click(function() {
			alert($(this).text());
		});
	});
	
	
	
</script>


<div class="x_panel" style="height: 600px;">
	<!-- 타이틀 -->
	<div class="x_title">
		<h2>진료기록조회</h2>
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<!-- 데이터 입력부분 -->
	<div class="x_content">
		<form action="findTreatmentRecordByPetOwner.do" method="get" id="recordSearchForm">
			<label>반려동물명:</label>
			<select class="select2_single form-control" tabindex="-1" id="petListSelect">
			</select>
			<br>
			
			<div class="form-group">
				<label>검색 기간: </label>	
				<div id="daterangePicker" class=""
					style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
					<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
					<span></span>
					<input type="hidden" id="startDate" name="startDate">
					<input type="hidden" id="endDate" name="endDate"> 
					<b 	class="caret"></b>
				</div>
			</div>
			<input type="hidden" name="petOwnerNo" value="${sessionScope.loginVO.petOwnerNo}">
			<input type="hidden" id ="petName" name="petVO[0].petName">
			<input type="hidden" id="page" name="page">
			<button type="submit" class="btn btn-default" id="recordSearchBtn">검색</button>
		</form>
		<hr>
		
		
		<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead>
				<tr class="headings">
					<th class="column-title">No.</th>
					<th class="column-title">질병명</th>
					<th class="column-title">증상</th>
					<th class="column-title">진료시간</th>
					<th class="column-title">반려동물명</th>
					<th class="column-title">보호자명</th>
					<th class="column-title no-link last"><span class="nobr">상세조회</span></th>
					<th class="bulk-actions" colspan="7"><a class="antoo"
						style="color: #fff; font-weight: 500;">Bulk Actions ( <span
							class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
					</th>
				</tr>
			</thead>
			<tbody id='treatmentRecordInfo'>
				
			</tbody>
		</table>
		<div class="row">
  			<div class="col-md-4"></div>
  			<div class="col-md-4">
  				<ul class="pagination">
	              <li>
	                <a id="pageNo" class="pageNo">이전</a>
	              </li>
	              <li>
	                <a href="#">1</a>
	              </li>
	              <li>
	                <a href="#">2</a>
	              </li>
	              <li>
	                <a href="#">3</a>
	              </li>
	              <li>
	                <a href="#">4</a>
	              </li>
	              <li>
	                <a href="#">5</a>
	              </li>
	              <li>
	                <a href="#">다음</a>
	              </li>
            	</ul>
            </div>
  			<div class="col-md-4"></div>
		</div>
        </div>
	</div>