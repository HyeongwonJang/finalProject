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
     		 data:"vetLicenseNo="+$("#vetListSelect").val()+"&reservationDate="+$("#datepicker").val(),
     		 dataType:"json",
     		 success:function(possableTime){
     			 var possable="";
     			 $.each(possableTime,function(t){
     				possable+="<option value="+possableTime[t].timeNo+">"
     						+possableTime[t].reservationTime+"</option>";
     			 })
     			$("#selectPet").html(possable);
     			 
     		 }
     	 })
     }
 }
function changeVet(){
	 $("#datepicker").val("");
	 $("#selectPet").val("");
}
 </script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#hospitalName").click(function() {
			$('div.modal').fadeIn();
			$('div.modal').modal({
			});
		});
		$("#cancelBtn").click(function(){
			location.href="home.do";
		});
	})
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
		<form id="treatmentForm" action="registerReservation.do" method="post">
			<input type="hidden" id="petOwnerNo"  value="${sessionScope.loginVO.petOwnerNo }" name="petOwnerVO.petOwnerNo">
			<label for="inputInfo">병원검색</label> <span id="checkTel"></span>
			<input type="text" id="hospitalName" class="form-control" required="required"  readonly value='클릭하여 병원을 검색하여 주세요.'/>
			<input type="hidden" id="hospitalId" name="hospitalVO.hospitalId"  >
			<label>담당 의사 선택</label>
				 <select class="select2_single form-control" tabindex="-1" id="vetListSelect" 
				 		name="hospitalVO.vetList[0].vetLicenseVO.vetLicenseNo" required="required"
				 		onchange="changeVet()" >
				 		<option>담당 의사를 선택하세요</option>
				</select>
			<label>반려동물 - 보호자 전화번호로 검색</label>
				 <select class="select2_single form-control" tabindex="-1" id="petListSelect" 
				 		name="petOwnerVO.petVO[0].petName" required="required">
				 		<option></option>
				 	 	<c:forEach items="${requestScope.petList.petVO }" var="petList">
				 			<option >${petList.petName }</option>
				 		</c:forEach> 
				</select>
			<label for="inputInfo">예약일</label> 
            <input type="text"  id="datepicker" class="form-control" name="reservationDate"
            onchange="return checkDate()"/>
            <label for="inputInfo">예약시간</label>
            	 <select class="select2_single form-control" tabindex="-1" id="selectPet" 
				 		name="reservationTimeVO.timeNo" required="required" >
					<option></option>
				</select>
            <label>예약내용</label>
			<textarea class="form-control" rows="2" name="reservationContent" required="required" 
				 placeholder="예약내용을 입력해주세요"></textarea>	<div class="ln_solid"></div>
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