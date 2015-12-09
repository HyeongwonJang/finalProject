<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<script>

	$(document).ready(function() {
	
		$("#petOwnerTel").keyup(function(){
			if($("#petOwnerTel").val().length<10){
				$("#checkTel").html("전화번호입력해라");
				$("#checkTel").attr('class', 'text-danger');
			}else{
				$.ajax({
					type:"get",
					data:"petOwnerTel="+$("#petOwnerTel").val(),
					url:"findPetListByPetOwnerTel.do",
					success: function(PetOwnerVO){//전화번호로 검색하여 PetOwnerVO를 가져온다.
						var petVO=PetOwnerVO.petVO;
						var result="";
						 if(PetOwnerVO == ""){
								$("#checkTel").html("정확히 입력하세요");
								$("#checkTel").attr('class','text-danger');
						}else{	//if-end ,else-begin			
							$.each(petVO, function(pi) {
								result+="<option>"+petVO[pi].petName+"</option>"
							});
								$("#checkTel").html(PetOwnerVO.petOwnerName);
								$("#checkTel").attr('class','text-primary');
								$("#petOwnerNo").attr('value', PetOwnerVO.petOwnerNo);
								
							}//else 
								$("#selectPet").append(result); 
					}//success
				})//ajax종료
				
			}
			//
		})
		$("#cancelBtn").click(function(){
			location.href="home.do";
		})
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
<script>
	autosize($('.resizable_textarea'));
</script>

<div class="x_panel">
	<div class="x_title">
		<h2>
			진료등록   
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		  
		<!-- 폼 시작부 -->
		<form id="treatmentForm" action="registerTreatmentRecord.do" method="post">
			<label for="inputInfo">보호자 전화번호:</label> <span id="checkTel"></span>
			<input type="text" id="petOwnerTel" class="form-control" name="" required="required"/>
			<input type="hidden" id="petOwnerNo" name="petOwnerVO.petOwnerNo" >
			<input type="hidden" id="vetLicenseNo" 
			name="hospitalVO.vetList[0].vetLicenseVO.vetLicenseNo"
			value="${sessionScope.loginVO.vetList[0].vetLicenseVO.vetLicenseNo }">
			<label>반려동물 - 보호자 전화번호로 검색</label>
				 <select class="select2_single form-control" tabindex="-1" id="selectPet" 
				 name="petOwnerVO.petVO[0].petName" required="required">
					<option></option>
				</select>  
			<label for="inputInfo" >몸무게:</label> 
			<input type="text" id="petWeight" class="form-control" name="petWeight" required="required"/>
			<label>질병종류</label>
				<select class="select2_single form-control" tabindex="-1" name="diseaseVO.diseaseName"required="required">
				<option></option>
					<c:forEach var="disease" items="${requestScope.DiseaseList }">
						<option>${disease.diseaseName }</option>
					</c:forEach> 
				</select>
			<label>진료내용</label>
			<textarea class="form-control" rows="8" name="treatmentContent" required="required"  placeholder="진료내용을 입력해주세요"></textarea>
			
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<p align="center">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="button" class="btn btn-success" id="cancelBtn">Cancel</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->

	</div>
</div>

