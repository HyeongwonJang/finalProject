<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>보호자 회원가입</title>
<!-- Bootstrap core CSS -->
<link href="${initparam.root}resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${initparam.root}resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${initparam.root}resources/css/animate.min.css"
	rel="stylesheet">
<!-- Custom styling plus plugins -->
<link href="${initparam.root}resources/css/custom.css" rel="stylesheet">
<link href="${initparam.root}resources/css/icheck/flat/green.css"
	rel="stylesheet">
<!-- Jquery core js -->
<script src="${initparam.root}resources/js/jquery.min.js"></script>
<!-- Bootstrap core js -->
<script src="${initparam.root}resources/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	$(document).ready(function() {
		var submitFlag = false;
		var registerType = "insert";
		$("#petOwnerId").keyup(function() {
			if($(this).val().length > 0) {
				$.ajax({
				    type: "post", // get 또는 post로 설정
				    url: "findPetOwnerById.do", // 이동할 url 설정
				    data: "petOwnerId=" + $(this).val(),
				    success: function(searchResult){
				    	if(searchResult == "ok"){
				   			$("#idSearchMessage").text("사용하지 않은 아이디입니다!");
				   			$("#idSearchMessage").attr('class', 'text-primary');
				   			submitFlag = true;
				   		} else {
				   			$("#idSearchMessage").text("이미 사용하고 있는 아이디입니다!");
				   			$("#idSearchMessage").attr('class', 'text-danger');
				   			submitFlag = false;
				   		}
				    }
				});
			} else {
				$("#idSearchMessage").text("");
			}
		});
		$("#petOwnerTel").keyup(function() {
			if($(this).val().length == 11) {
				$.ajax({
				    type: "post", // get 또는 post로 설정
				    url: "telCheckAjax.do", // 이동할 url 설정
				    data: "petOwnerTel=" + $(this).val(),
				    success: function(searchResult){
				    	if(searchResult == "ok"){
				   			$("#telSearchMessage").text("사용가능");
				   			$("#telSearchMessage").attr('class', 'text-primary');
				   			submitFlag = true;
				   		} else if (searchResult == "ok_update"){
				   			$("#telSearchMessage").text("진료 기록이 있는 회원입니다 반려동물 추가는 가입 후 수정기능을 이용하여 주세요");
				   			$("#telSearchMessage").attr('class', 'text-primary');
				   			$("#addPetView").html("");
				   			submitFlag = true;
				   			registerType = "update";
				   		} else {
				   			$("#telSearchMessage").text("사용불가");
				   			$("#telSearchMessage").attr('class', 'text-danger');
				   			submitFlag = false;
				   		}
				    }
				});
			} else {
				$("#telSearchMessage").text("");
			}
		});
		
		$("#registerForm").submit(function() {
			if(submitFlag==false)
				return false;
			if(registerType == "update") {
				$('#registerForm').attr('action', "registerPetOwnerByTel.do");
			}
				
		});
	});
</script>

<body style="background: #F7F7F7;">
	<div class="">
		<a class="hiddenanchor" id="toregister"></a>
		<a class="hiddenanchor" id="tologin"></a>
		<div id="wrapper">
			<div id="login" class="animate form"></div>
			<div id="register" class="animate form"></div>
		</div>
	</div>
	<div class="x_panel">
		<div class="x_title">
			<h2>보호자 회원가입</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form id="registerForm" class="form-horizontal form-label-left" action="registerPetOwner.do" method="post">
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">
						<span class="required">* </span>아이디 
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<!-- 아이디 input 입력란 -->
						<input type="text" id="petOwnerId" required="required" class="form-control col-md-7 col-xs-12" name="petOwnerId">
					</div>
					<div>
							<!-- 텍스트 색깔은 text-primary text-danger 이거 사용-->
							<h3></h3>
							<span class="text-danger" id="idSearchMessage"
								style="font-weight: bold"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">
						<span class="required">* </span>비밀번호
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<!-- 비밀번호 input 입력란 -->
						<input type="password" id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="petOwnerPassword">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">
						<span class="required">* </span>이름 
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<!-- 이름 input 입력란 -->
						<input type="text" id="last-name" required="required" class="form-control col-md-7 col-xs-12" name="petOwnerName">
					</div>
				</div>
				<div class="form-group">
					<label for="last-name" class="control-label col-md-3 col-sm-3 col-xs-12">
						<span class="required">* </span>휴대폰 번호
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<!-- 휴대폰 번호 input 입력란 -->
						<input id="petOwnerTel" class="form-control col-md-7 col-xs-12" type="text" required="required" name="petOwnerTel">
					</div>
					<div>
							<!-- 텍스트 색깔은 text-primary text-danger 이거 사용-->
							<h3></h3>
							<span class="text-danger" id="telSearchMessage"
								style="font-weight: bold"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">
						주소
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<!-- 주소 input 입력란 -->
						<input id="temp_address" class="form-control col-md-7 col-xs-12" type="text" name="petOwnerAddress">
					</div>
				</div>
				<div class="form-group" id="addPetView">
					<label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">
						반려동물
					</label>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<input id="add-pet" type="button" value="+"> 
						<input id="del-pet" type="button" value="-">
					</div>
				</div>
				<div class="form-group" id="pet-input">
					
				</div>
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="submit" class="btn btn-success">등록</button>
						<button type="button" class="btn btn-primary" onClick="location.href='home.do'">취소</button>
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
			var petCount = 0;
			$("#add-pet").click(function() {
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



</body>
</html>