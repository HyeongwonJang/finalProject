<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
var submitFlag;
	$(document).ready(function(){
		 $(".form-control col-md-7 col-xs-12").keyup(function(){
			// alert("petOwnerNo="+$("#petOwnerNo").val()+"&petVO[0].petName="+$(this).val());
			$.ajax({
				type: "post",
				url: "checkPetNameAjax.do",
				data: "petOwnerNo="+$("#petOwnerNo").val()+"&petVO[0].petName="+$(this).val(),
				success: function(checkResult){
					if(checkResult=="ok"){
						$("#nameCheck").text("");
						submitFlag=true;
					}else{
						$("#nameCheck").text("반려동물 이름이 중복됩니다");
						submitFlag=false;
					}
				}
			});
		});
		$("#petForm").submit(function(){
			
			return submitFlag;
		}); 
	});
</script>
<div class="x_panel">
		<div class="x_title">
			<h2>펫 등록</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form id="petForm" class="form-horizontal form-label-left" action="registerPet.do" method="get">
			<input type="hidden" id="petOwnerNo" name = "petOwnerNo" value="${sessionScope.loginVO.petOwnerNo }">
			
			 <!-- 펫 Name -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-12' for='first-name'>* 이름 
					<span class='required' id="nameCheck"></span></label>
					<div class='col-md-2 col-sm-6 col-xs-12'>
						<input type='text' class='form-control col-md-7 col-xs-12_petName' 
						id='first-name' required='required' name="petVO[0].petName">
					</div>
				</div>
			
				
				<!-- 펫 birthday -->
			<div class='form-group'>
				<label class='control-label col-md-3 col-sm-3 col-xs-3'>생일</label>	
					<div class='birthday col-md-2 col-sm-9 col-xs-9'>
						<input class='form-control' type='date' name="petVO[0].petBirthday">
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
						<input class=' form-control col-md-7 col-xs-12' type='text' name='petVO[0].petNote'>
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
				<!-- 동물 추가 및 삭제 -->
				<div class="form-group" id="addAndDel">
					<label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">
						반려 동물
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<input id="add-pet" type="button" value="+"> 
						<input id="del-pet" type="button" value="-">
					</div>
				</div>
				
				
					
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success" id="regist">등록</button>
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
	<!-- /input mask -->

	<!-- form validation -->

	<script type="text/javascript">
		$(document).ready(function() {
			var petCount = 1;
			$("#add-pet").click(function() {
				alert(petCount);
				var str = "<div id='pet-index-" + petCount + "' class='form-group'><hr>";
				str += "<div class='form-group'><label class='control-label col-md-3 col-sm-3 col-xs-12' for='first-name'>이름 <span class='required'>*</span></label><div class='col-md-2 col-sm-6 col-xs-12'><input type='text' class='form-control col-md-7 col-xs-12' id='first-name' required='required' name='petVO[" + (petCount) + "].petName'></div></div>";
				str += "<div class='form-group'><label class='control-label col-md-3 col-sm-3 col-xs-3'>생일</label>	<div class='birthday col-md-2 col-sm-9 col-xs-9'><input class='form-control' type='date' name='petVO[" + (petCount) + "].petBirthday'></div></div>";
				str += "<div class='form-group'><label class='control-label col-md-3 col-sm-3 col-xs-12'>성별</label><div class='col-md-6 col-sm-6 col-xs-12'><div id='gender' class='btn-group' data-toggle='buttons'><label class='btn btn-default' data-toggle-class='btn-default' data-toggle-passive-class='btn-default active'><input type='radio' name='petVO[" + (petCount) + "].petGender' value='수컷'>&nbsp; Male &nbsp;</label><label class='btn btn-default' data-toggle-class='btn-default' data-toggle-passive-class='btn-default'><input type='radio' name='petVO[" + (petCount) + "].petGender' value='암컷'>Female</label></div></div></div>";
				str += "<div class='form-group'><label class='control-label col-md-3 col-sm-3 col-xs-12' for='middle-name'>비고</label><div class='col-md-6 col-sm-6 col-xs-12'><input class=' form-control col-md-7 col-xs-12' type='text' name='petVO[" + (petCount) + "].petNote'></div></div>";
				str += "<div class='form-group'><label class='control-label col-md-3 col-sm-3 col-xs-12'>동물종류</label><div class='col-md-4 col-sm-9 col-xs-12'><select class='form-control' name='petVO[" + (petCount) + "].animalKindName'><option>개</option><option>고양이</option></select></div></div>";
				str += "</div>";
				$("#pet-input").append(str);
				petCount++;
			});
			$("#del-pet").click(function() {
				petCount--;
				$("#pet-index-"+petCount).remove();
			});
		});
		$(document).ready(function() {
			$.listen('parsley:field:validate', function() {
				validateFront();
			});
			$('#demo-form .btn').on('click', function() {
				$('#demo-form').parsley().validate();
				validateFront();
			});
			var validateFront = function() {
				if (true === $('#demo-form').parsley().isValid()) {
					$('.bs-callout-info').removeClass('hidden');
					$('.bs-callout-warning').addClass('hidden');
				} else {
					$('.bs-callout-info').addClass('hidden');
					$('.bs-callout-warning').removeClass('hidden');
				}
			};
		});

		$(document).ready(function() {
			$.listen('parsley:field:validate', function() {
				validateFront();
			});
			$('#demo-form2 .btn').on('click', function() {
				$('#demo-form2').parsley().validate();
				validateFront();
			});
			var validateFront = function() {
				if (true === $('#demo-form2').parsley().isValid()) {
					$('.bs-callout-info').removeClass('hidden');
					$('.bs-callout-warning').addClass('hidden');
				} else {
					$('.bs-callout-info').addClass('hidden');
					$('.bs-callout-warning').removeClass('hidden');
				}
			};
		});
		try {
			hljs.initHighlightingOnLoad();
		} catch (err) {
		}
	</script>
	<!-- /form validation -->
	
