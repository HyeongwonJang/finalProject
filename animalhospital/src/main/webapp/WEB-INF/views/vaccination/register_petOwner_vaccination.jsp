<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- select2 -->
<script>
	$(document).ready(function() {
		$(".select2_single").select2({
			placeholder : "해당 항목을 선택해주세요",
			allowClear : false
		});
	});
</script>
<!-- /select2 -->
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
			    	// 검색조건(petName)을 유지시킨다
			    	$("#petListSelect").val("${continueParam['povo'].petVO[0].petName}").attr("selected", "selected");
			    	
			    	$(".select2_single").select2({
						placeholder : "해당 항목을 선택해주세요",
						allowClear : false
					});
					
			    }	
		});
	});
</script>

<div class="x_panel">
	<div class="x_title">
		<h2>
			예방접종등록 
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<form id="vaccinationForm" action="registerVaccination.do" method="post">
		<label for="inputInfo">예방접종일시:</label> 
			<input type="text"  id="datepicker" class="form-control" name="vaccinationHours"/>
			<hr><label>반려동물 이름을 선택해주세요 </label> 
			<select class="select2_single form-control" id="petListSelect" name="petOwnerVO.petVO[0].petName">
			</select>
			<br><br>
			<label for="inputInfo" >몸무게:</label> 
			<input type="text" id="petWeight" class="form-control" name="petWeight" required="required" />
			<input type="hidden" id="petOwnerNo" name="PetOwnerVO.petOwnerNo" value="${sessionScope.loginVO.petOwnerNo }" >
			
			 <hr> <label>예방접종종류</label> <select class="select2_single form-control" 
			 name="vaccinationVO.vaccinationName"	required="required" tabindex="-1">
				<c:forEach var="vaccination" items="${requestScope.VaccinationList }">
					<option>${vaccination.vaccinationName }</option>
				</c:forEach>
			</select>
			
			<hr><label>특이사항</label>
			<textarea class="form-control" name="vaccinationContent" rows="8" placeholder="특이사항을 입력해주세요"></textarea>

<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<p align="center">
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-success" id="cancelbtn">취소</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->

	</div>
</div>
