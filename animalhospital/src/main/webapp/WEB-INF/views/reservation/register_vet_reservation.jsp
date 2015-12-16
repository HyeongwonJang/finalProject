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
			
			<label for="inputInfo">예약일</label> 
            <input type="text"  id="datepicker" class="form-control" name="Reservation_date"/>
            <label for="inputInfo">예약시간</label>
            	 <select class="select2_single form-control" tabindex="-1" id="selectPet" 
				 		name="petOwnerVO.petVO[0].petName" required="required">
					<option></option>
				</select>
            <label>예약내용</label>
			<textarea class="form-control" rows="2" name="treatmentContent" required="required" 
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
