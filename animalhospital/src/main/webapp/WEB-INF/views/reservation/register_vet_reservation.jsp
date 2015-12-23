<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 
 <script type="text/javascript">
 $(function(){
     $("#datepicker").datepicker({
        dateFormat:"yy-mm-dd",
        dayNamesMin:['일','월','화','수','목','금','토']
     });
});  
 function checkDate(){
	 var date= new Date();
	 var mm = date.getMonth() + 1;
     var dd = date.getDate();
     var yyyy = date.getFullYear();
     var sysdate= yyyy+"-"+ mm + "-" + dd ;
     if($("#datepicker").val()<sysdate){
    	 alert("날짜를 다시 선택해 주세요.");
    	  $("#datepicker").val("");
     }else{
    	  $.ajax({
     		 type:"get",
     		 url:	"findPossableReservationTime.do",
     		 data:"vetLicenseNo="+$("#vetLicenseNo").val()+"&reservationDate="+$("#datepicker").val(),
     		 dataType:"json",
     		 success:function(possableTime){
     			 var possable="";
     			 $.each(possableTime,function(t){
     				possable+="<option value="+possableTime[t].timeNo+">"
     						+possableTime[t].reservationTime+"</option>";
     			 })
     			$("#selectTime").html(possable);
     			 
     		 }
     	 })
     }
 }
function changePet(){
	 $("#datepicker").val("");
	 $("#selectTime").text("");
}

 </script>
 
<script>

	$(document).ready(function() {
		var submitFlag = false;
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
				submitFlag = false;
			}else{
			//보호자 전화번호값이 10자 이상인 경우 전화번호를 이용하여 petList를 불러옴
				$.ajax({
					type:"post",
					data:"petOwnerTel="+$("#petOwnerTel").val(),
					url:"findPetListByPetOwnerTel.do",
					success: function(PetOwnerVO){//전화번호로 검색하여 PetOwnerVO를 가져온다.
						var petVO=PetOwnerVO.petVO;
						var result="";
						 if(PetOwnerVO == ""){
							$("#checkTel").html("전화번호가 맞지 않습니다");
							$("#checkTel").attr('class','text-danger');
							submitFlag = false;
						}else{	//if-end ,else-begin		
							$.each(petVO, function(pi) {
								result+="<option>"+petVO[pi].petName+"</option>"
							});
							$("#checkTel").html("전화번호가 확인되었습니다. 다음 단계로 진행하세요");
							$("#checkTel").attr('class','text-primary');
							$("#petOwnerNo").attr('value', PetOwnerVO.petOwnerNo);
							$("#selectPet").append(result);
							submitFlag = true;
						}//else 
					}//success
				});//ajax종료
			}
		});
		$("#cancelBtn").click(function(){
			location.href="home.do";
		});
 	
  		$("#treatmentForm").submit(function() {
			return submitFlag;
		});  
	});
</script>
<div class="x_panel">
	<div class="x_title">
		<h2>
			진료예약 
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		  
		<!-- 폼 시작부 -->
		<form id="vetReservationForm" action="registerReservation.do" method="post">
			<label for="inputInfo">보호자 전화번호:</label> <span id="checkTel"></span>
			<input type="text" id="petOwnerTel" class="form-control" name="" required="required"/>
			<input type="hidden" id="petOwnerNo" name="petOwnerVO.petOwnerNo" >
			<input type="hidden" id="vetLicenseNo" 
			name="hospitalVO.vetList[0].vetLicenseVO.vetLicenseNo"
			value="${sessionScope.loginVO.vetList[0].vetLicenseVO.vetLicenseNo }">
			<label>반려동물 - 보호자 전화번호로 검색</label>
				 <select class="select2_single form-control" tabindex="-1" id="selectPet" 
				 		name="petOwnerVO.petVO[0].petName" required="required"
				 		onchange="changePet()">
					<option></option>
				</select>
			
			<label for="inputInfo">예약일</label> 
            <input type="text"  id="datepicker" class="form-control" name="reservationDate"
            onchange="return checkDate()"/>
            <label for="inputInfo">예약시간</label>
            	 <select class="select2_single form-control" tabindex="-1" id="selectTime" 
				 		name="reservationTimeVO.timeNo" required="required">
					<option></option>
				</select>
            <label>예약내용</label>
			<textarea class="form-control" rows="2" name="reservationContent" required="required" 
				 placeholder="예약내용을 입력해주세요"></textarea>
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<p align="center">
						<button type="submit" class="btn btn-primary">예약등록</button>
						<button type="button" class="btn btn-success" id="cancelBtn">취소</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->

	</div>
</div>
