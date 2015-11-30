<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원탈퇴 페이지</title>
    <!-- Bootstrap core CSS -->
    <link href="${initparam.root}resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${initparam.root}resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="${initparam.root}resources/css/animate.min.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="${initparam.root}resources/css/custom.css" rel="stylesheet">
    <link href="${initparam.root}resources/css/icheck/flat/green.css" rel="stylesheet">
    <script src="${initparam.root}resources/js/jquery.min.js"></script>
    <script type="text/javascript">
    	/*
    		submit이 공백이면 항목을 채우라는 alert를 띄어준다(내부 js 사용)
    		수의사, 보호자 라디오 버튼을 체크했을 시 
    		if문에 따라서 각각 다른 action을 택하여 페이지가 다르게 넘어가게 된다.
    		동시에 name도 변경되어 가기 때문에 VetVO, memberPetOwnerVO를 사용하면 된다.
    	*/
    	$(document).ready(function() {
			$("#deleteAccountForm").submit(function() {
				var command = $("input[name=deleteCommand]:checked").attr('value');
				if(command == "vet"){
					$("input[name=userId]").attr('name', 'vetId');
					$("input[name=userPass]").attr('name', 'vetPassword');
				} else if(command == "petowner"){
					$("input[name=userId]").attr('name', 'petOwnerId');
					$("input[name=userPass]").attr('name', 'petOwnerPassword');
				}
				// 다른 액션으로 변경시켜주는 코드
				// vetLogin.do 와 petownerLogin.do로 넘어가게 된다
				$("#deleteAccountForm").attr('action', command + "Delete.do");
				
			});
		});
    </script>
    </head>
  
  <body style="background:#F7F7F7;">
    <div class="">
      <a class="hiddenanchor" id="toregister"></a>
      <a class="hiddenanchor" id="tologin"></a>
      <div id="wrapper">
       <div id="login" class="animate form">
          <h1>
            <i class="fa fa-paw" style="font-size: 40px;"></i>Ah! 동물!</h1>
          <p>
            <i class="fa fa-check fa-fw fa-lg"></i>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;불가하오니
            신중하게 선택하시기 바랍니다.
            <br>
            <br>
            <br><i class="fa fa-check fa-fw fa-lg"></i>
            회원정보는 모두 삭제되며, 삭제된 데이터는 복구되지 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;않습니다.&nbsp;</p>
          <section class="login_content">
            <form id="deleteAccountForm" >
              <h1>회원탈퇴</h1>
              <div>
                <input type="text" class="form-control" placeholder="아이디를 입력해주세요" 
                required="required" name="userId">
              </div>
              <div>
                <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요"
                required="required" name="userPass">
              </div>
					<div>
						<div class="commandRadio">
							<label>
								<input type="radio" name="deleteCommand"
									value="vet" > 수의사
							</label> &nbsp;&nbsp;
							<label>
								<input type="radio" name="deleteCommand"
									value="petowner" > 보호자
							</label>
						</div>
				<button type="submit" class="btn btn-default btn-sm">삭제</button>
				
					</div>
			<div class="clearfix"></div>
              <div class="separator">
                
                <div class="clearfix"></div>
                <br>
                <div>
                  <h1>
                    <i class="fa fa-paw" style="font-size: 26px;"></i>&nbsp; Ah! 동물</h1>
                </div>
              </div>
            </form>
            <!-- form -->
          </section>
          <!-- content -->
        </div>
        
      </div>
    </div>
  

</body>
</html>