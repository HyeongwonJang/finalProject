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
    <link href="${initparam.root}resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${initparam.root}resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="${initparam.root}resources/css/animate.min.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="${initparam.root}resources/css/custom.css" rel="stylesheet">
    <link href="${initparam.root}resources/css/icheck/flat/green.css" rel="stylesheet">
    <!-- Jquery core js -->
    <script src="${initparam.root}resources/js/jquery.min.js"></script>
   <!-- Bootstrap core js -->
    <script src="${initparam.root}resources/js/bootstrap.min.js"></script>
    </head>
    
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
        <form id="pet-form" class="form-horizontal form-label-left">
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">아이디
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	
            	<!-- 아이디 input 입력란 -->
              <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">비밀번호
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	
            	<!-- 비밀번호 input 입력란 -->
              <input type="password" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">이름
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            
            	<!-- 이름 input 입력란 -->
              <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
            </div>
            
          </div>
          <div class="form-group">
            <label for="last-name" class="control-label col-md-3 col-sm-3 col-xs-12">휴대폰 번호
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            
				<!-- 휴대폰 번호 input 입력란 -->	            
              <input id="last-name" class="form-control col-md-7 col-xs-12" type="text" name="last-name" required="required">
            </div>
          </div>
          <div class="form-group">
            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">주소</label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	
            	<!-- 주소 input 입력란 -->
              <input id="temp_address" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
            </div>
          </div>
          <div class="form-group">
          		
          		<!-- "+" 버튼 -> 버튼을 누를시 폼이 동적으로 생성 -->
            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">펫
              <i class="fa fa-plus-circle"></i>
            </label>&lt;-이 버튼을 누를 시 아래의 폼이 뜨도록 구성할 예정</div>
          <hr>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">이름
              <span class="required">*</span>
            </label>
            <div class="col-md-2 col-sm-6 col-xs-12">
            	<!-- 펫 이름 input 입력란 -->
              <input type="text" class="form-control col-md-7 col-xs-12" id="first-name" required="required">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-3">생일</label>
            <div class="col-md-2 col-sm-9 col-xs-9">
            
            	<!-- 펫 생일 input 입력란 inputMask 걸려있음-->	
              <input class="form-control" type="text" data-inputmask="'mask': '9999/99'">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">몸무게</label>
            <div class="col-md-2 col-sm-6 col-xs-12">
            	
            	<!-- 펫 몸무게 input 입력란 -->
              <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" type="text">
            </div>
          </div>
          
          	<!-- 펫 성별 input 입력란, 버튼처럼 보이지만 라디오 타입 -->
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">성별</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <div id="gender" class="btn-group" data-toggle="buttons">
                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                  <input type="radio" name="gender" value="male">&nbsp; Male &nbsp;</label>
                <label class="btn btn-primary active" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                  <input type="radio" name="gender" value="female" >Female</label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="middle-name">비고</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<!-- 펫 비고 입력란 -->
              <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" type="text" required="required">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">동물 종류</label>
            <div class="col-md-4 col-sm-9 col-xs-12">
            	<!-- 동물종류를 선택하는 입력란 -->
              <select class="form-control">
                <option>개</option>
                <option>고양이</option>
                <option>말</option>
                <option>소</option>
                <option>돼지</option>
              </select>
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
              <button type="submit" class="btn btn-success">등록</button>
              <button type="submit" class="btn btn-primary">취소</button>
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