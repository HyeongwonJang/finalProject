<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<script type="text/javascript">

	function findPetListByTelAjax(){
		$.ajax({
			type:"post",
			data:"petOwnerTel="+$("#petOwnerTel").val(),
			url:"findPetListByPetOwnerTel.do",
			success: function(PetOwnerVO){//전화번호로 검색하여 PetOwnerVO를 가져온다.
				var petVO=PetOwnerVO.petVO;
				var result="";
				 if(PetOwnerVO == ""){
					$("#checkTel").html("초진입니다.");
					$("#checkTel").attr('class','text-danger');
				}else{	//if-end ,else-begin		
					$.each(petVO, function(pi) {
						result+="<option>"+petVO[pi].petName+"</option>"
					});
					$("#checkTel").html("전화번호가 확인되었습니다. 다음 단계로 진행하세요");
					$("#checkTel").attr('class','text-primary');
					$("#petOwnerNo").attr('value', PetOwnerVO.petOwnerNo);
					$("#selectPet").append(result);
				}//else 
			}//success
		});//ajax종료
		/* if($("input[name=loginCommand]:checked").val()=="nonMember"){
			$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "checkPetOwnerTelAjax.do", // 이동할 url 설정
			    data: "petOwnerTel=" +$("#petOwnerTel").val(),
			    success: function(searchResult){
			    	if(searchResult == "ok"){
			    		$("#checkTel").html("초진입니다");
						$("#checkTel").attr('class','text-danger');
			   			submitFlag = true;
			   		} else if (searchResult == "ok_update"){
			   			$("#checkTel").text("방문 기록이 있는 비회원입니다");
			   			$("#checkTel").attr('class', 'text-primary');
			   			submitFlag = true;
			   		} else {
			   			$("#checkTel").text("회원의 전화번호입니다 회원 메뉴를 이용해주세요");
			   			$("#checkTel").attr('class', 'text-danger');
			   			submitFlag = false;
			   		}
			    }
			});
		}else{
			$.ajax({
				type:"post",
				data:"petOwnerTel="+$("#petOwnerTel").val(),
				url:"findPetListByPetOwnerTel.do",
				success: function(PetOwnerVO){//전화번호로 검색하여 PetOwnerVO를 가져온다.
					var petVO=PetOwnerVO.petVO;
					var result="";
					 if(PetOwnerVO == ""){
						$("#checkTel").html("초진입니다.");
						$("#checkTel").attr('class','text-danger');
					}else{	//if-end ,else-begin		
						$.each(petVO, function(pi) {
							result+="<option>"+petVO[pi].petName+"</option>"
						});
						$("#checkTel").html("전화번호가 확인되었습니다. 다음 단계로 진행하세요");
						$("#checkTel").attr('class','text-primary');
						$("#petOwnerNo").attr('value', PetOwnerVO.petOwnerNo);
						$("#selectPet").append(result);
					}//else 
				}//success
			});//ajax종료
		} */
	}
</script>
<script type="text/javascript">
	//var submitFlag=false;
	$(document).ready(function() {
		//숫자만 입력할 수 있도록 정의
		$("#petOwnerTel").keyup(function(){
			$(this).val( $(this).val().replace(/[^0-9]/g,""));
			if($(this).val().length > 11){
				$(this).val($(this).val().replace($(this).val(),$(this).val().substring(0,11)));
				alert("전화번호 양식에 맞게 작성해주세요!");
			}
			$("#selectPet").html("<option></option>");
			//보호자 전화번호값이 9자 이하인 경우
			if($("#petOwnerTel").val().length<10){
				$("#checkTel").html("전화번호를 9자리 이상 입력해주세요");
				$("#checkTel").attr('class', 'text-danger');
			}else{
			//보호자 전화번호값이 10자 이상인 경우 전화번호를 이용하여 petList를 불러옴
				findPetListByTelAjax();
			}
		});
		$("#cancelBtn").click(function(){
			location.href="home.do";
		});
 		$(".select2_single").select2({
			placeholder : "해당 항목을 선택해주세요",
			allowClear : false
		});
 		
 		$("#nonMemberViewDiv").hide();
 		$(".commandRadio").change(function(){
 			var checkMember=$("input[name=loginCommand]:checked").attr('value');
 			if(checkMember=="member"){
 				$("#memberViweDiv").show();
 				$("#nonMemberViewDiv").hide();
 				
 				$("#writePet").removeAttr("required");
 				$("#petOwnerName").removeAttr("required");
 				$("#writePet").attr("name","");
 				
 				$("#selectPet").attr("required")
 				$("#selectPet").attr("name","petOwnerVO.petVO[0].petName");
 				

				$("#treatmentForm").attr("action", "registerTreatmentRecord.do"); 				
 			}else{
 				$("#memberViweDiv").hide();
 				$("#nonMemberViewDiv").show();
 				
 				$("#writePet").attr("required");
 				$("#petOwnerName").attr("required");
 				$("#writePet").attr("name","petOwnerVO.petVO[0].petName");

 				$("#selectPet").removeAttr("required");
 				$("#selectPet").attr("name","");
 				
				$("#treatmentForm").attr("action","registerNonMemberTreatmentRecord.do");
 			}
 		});
 		/* $("#treatmentForm").submit(function(){
 			return submitFlag;
 		}); */
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
		  	<div class="commandRadio" >
				<label>
					<input type="radio" name="loginCommand"value="member" checked="checked"> 회원</label> &nbsp;&nbsp;
				<label>
					<input type="radio" name="loginCommand"value="nonMember" > 비회원</label>
			</div>
		<!-- 폼 시작부 -->
		<form id="treatmentForm" action="registerTreatmentRecord.do" method="post">
			<label for="inputInfo">보호자 전화번호:</label> <span id="checkTel"></span>
			<input type="text" id="petOwnerTel" class="form-control" name="petOwnerVO.petOwnerTel" required="required"/>
			<!-- Member가 진료시 보여지는 div  -->
			<div id="memberViweDiv">
			<label>반려동물 - 보호자 전화번호로 검색</label>
				 <select class="select2_single form-control" tabindex="-1" id="selectPet" 
				 		name="petOwnerVO.petVO[0].petName" >
					<option></option>
				</select>
			</div>
			<!--회원가입이 되지 않은 Member가 진료시 보여지는 Div  -->
			<div id="nonMemberViewDiv">
				<label for ="inputInfo"> 보호자 이름</label>
				<input type="text" id="petOwnerName" class="form-control" name="petOwnerVO.petOwnerName"  placeholder="이름을 입력해 주세요"/>
				
				<label>반려동물 - 비회원 PetName입력</label>
				<input type="text" id="writePet"  class="form-control" 
					name=""  placeholder="동물 이름을 입력해 주세요" >
				
				<label>
					<input type="radio" name="petOwnerVO.petVO[0].petGender"value="male" checked> 수컷</label> &nbsp;&nbsp;
				<label>
					<input type="radio" name="petOwnerVO.petVO[0].petGender"value="female" > 암컷</label>
					
			</div>
			
			<label for="inputInfo" >몸무게:</label> 
			<input type="text" id="petWeight" class="form-control" name="petWeight" required="required"/>
			
			<input type="hidden" id="petOwnerNo" name="petOwnerVO.petOwnerNo" value=0 >
			<input type="hidden" id="vetLicenseNo" 
			name="hospitalVO.vetList[0].vetLicenseVO.vetLicenseNo"
			value="${sessionScope.loginVO.vetList[0].vetLicenseVO.vetLicenseNo }">
			
			<label>질병종류</label>
				<select class="select2_single form-control" tabindex="-1" name="diseaseVO.diseaseName"required="required">
					<option></option>
					<c:forEach var="disease" items="${requestScope.DiseaseList }">
						<option>${disease.diseaseName }</option>
					</c:forEach> 
				</select>
			<label>진료내용</label>
			<textarea class="form-control" rows="8" name="treatmentContent" required="required" 
				 placeholder="진료내용을 입력해주세요"></textarea>
			
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<p align="center">
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-success" id="cancelBtn">취소</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->

	</div>
</div>

