<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	
</script>
<div class="x_panel">
		<div class="x_title">
			<h2>펫 정보 수정</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form id="petForm" class="form-horizontal form-label-left" action="updatePet.do" method="post">
			<input type="hidden" name = "petOwnerNo" value="${sessionScope.loginVO.petOwnerNo }">
			
			 <!-- 펫 Name -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-12' for='first-name'>이름 
					<span class='required'></span></label>
					<div class='col-md-2 col-sm-6 col-xs-12'>
						<input type='text' class='form-control col-md-7 col-xs-12' 
						id='first-name' required='required' name="petVO[0].petName"
						value="${requestScope.povo.petVO[0].petName}" required readonly />
					</div>
				</div>
			
				
				<!-- 펫 birthday -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-3'>생일</label>	
					<div class='birthday col-md-2 col-sm-9 col-xs-9'>
						<input class='form-control' type='date' name="petVO[0].petBirthday" 
						value="${requestScope.povo.petVO[0].petBirthday}" />
					</div>
			</div>
			
			
				<!-- 펫 성별 -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-12'>성별</label>
					<div class='col-md-6 col-sm-6 col-xs-12'>
						<div id='gender' class='btn-group' data-toggle='buttons'>
							<label class='btn btn-default' data-toggle-class='btn-default' data-toggle-passive-class='btn-default active'>
							<input type='radio' name='petVO[0].petGender' value='수컷'>&nbsp; Male &nbsp;</label>
							<label class='btn btn-default' data-toggle-class='btn-default' data-toggle-passive-class='btn-default'>
							<input type='radio' name='petVO[0].petGender' value='암컷' >Female</label>
						</div>
					</div>
				</div>
			
			
				<!-- 펫 Note -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-12' for='middle-name'>비고</label>
					<div class='col-md-6 col-sm-6 col-xs-12'>
						<input class=' form-control col-md-7 col-xs-12' type='text' name='petVO[0].petNote'
						value="${requestScope.povo.petVO[0].petNote}" required/>
					</div>
			</div>
			
			
				<!-- 동물 종류   -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-12'>동물종류</label>
					<div class='col-md-4 col-sm-9 col-xs-12'>
						<select class='form-control' name='petVO[0].animalKindName'>
							<option>개</option>
							<option>고양이</option>
						</select>
					</div>
				</div>
				<div class="form-group" id="pet-input"></div>
					
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success" id="regist">수정</button>
						<button type="button" class="btn btn-primary"
						onClick="location.href='home.do'">취소</button>
				</div>
			</div>
				
			
				
			</form>
		</div>
	</div>
	<!-- 스크립트 구문 -->
	<!-- form validation -->
	<!-- icheck -->
	<script
		src="${initparam.root}resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="${initparam.root}resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="${initparam.root}resources/js/icheck/icheck.min.js"></script>
	<script src="${initparam.root}resources/js/custom.js"></script>
	<script type="text/javascript"
		src="${initparam.root}resources/js/parsley/parsley.min.js"></script>
	<script src="${initparam.root}resources/js/custom.js"></script>
	<script
		src="${initparam.root}resources/js/input_mask/jquery.inputmask.js"></script>
	<!-- input_mask -->
	<script>
		$(document).ready(function() {
			$(":input").inputmask();
		});
	</script>


	
	
