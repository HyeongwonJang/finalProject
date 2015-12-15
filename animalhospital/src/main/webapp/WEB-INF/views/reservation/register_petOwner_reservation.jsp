<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function () {
		$("#hospitalName").click(function() {
			$('div.modal').fadeIn();
			$('div.modal').modal({
			});
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
			<label for="inputInfo">병원검색</label> <span id="checkTel"></span>
			<input type="text" id="hospitalName" class="form-control" required="required" readonly value='클릭하여 병원을 검색하여 주세요.'/>
			<input type="hidden" id="hospitalId" name="hospitalId">
			<input type="hidden" id="vetLicenseNo" 
			name="hospitalVO.vetList[0].vetLicenseVO.vetLicenseNo"
			value="">
			<label>반려동물 - 보호자 전화번호로 검색</label>
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
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-success" id="cancelBtn">취소</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->
	</div>
</div>