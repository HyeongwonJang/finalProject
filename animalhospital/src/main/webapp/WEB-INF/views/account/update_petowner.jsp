<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		// ajax를 이용하여 tel의 중복체크를 한다.
		var checkResultTel="";
		$("#petOwnerTel").keyup(function(){
			var petOwnerTel=$("#petOwnerTel").val().trim();
			
			$.ajax({
				type:"POST",
				url:"telCheckAjax.do",				
				data:"petOwnerTel=" + petOwnerTel,	
				success:function(data){						
					if(data=="fail"){
					$("#telCheckView").text(petOwnerTel+" 이미 있는 번호입니다!").css("background","red");
						checkResultTel="";
					}else{						
						$("#telCheckView").html(petOwnerTel+" 사용가능한 번호입니다!").css("background","yellow");		
						checkResultTel=petOwnerTel;
					}					
				}//callback			
			});//ajax
		});//keyup
		
		//숫자만 입력할 수 있도록 정의
		$("#petOwnerTel").keyup(function(){
			$(this).val( $(this).val().replace(/[^0-9]/g,""));
			if($(this).val().length > 11){
				$(this).val($(this).val().replace($(this).val(),$(this).val().substring(0,11)));
				alert("전화번호는 11자리까지의 숫자만 가능합니다!");
			}
		});
		
	});
</script>    
<div class="x_panel">

      <div class="x_title">
        <h2>보호자 회원정보수정 </h2>
        <ul class="nav navbar-right panel_toolbox">
          <li></li>
        </ul>
        <div class="clearfix"></div>
      </div>
      
      <div class="x_content">
        <br>
        <form id="petOwnerForm" class="form-horizontal form-label-left" action="updatePetOwner.do" method="post">
            	
            	
            	<!-- 보호자 id -->
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">* 아이디
              <span class="required"></span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	<input type="text" id="petOwnerId" class="form-control col-md-7 col-xs-12"
              	name="petOwnerId" value="${sessionScope.loginVO.petOwnerId}"required readonly/>
              	<p class="help-block"></p>
            </div>      
          </div>
          
            	<!-- 보호자 password -->
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">* 패스워드
              <span class="required"></span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
              	<input type="password" id="petOwnerPassword" required="required" class="form-control col-md-7 col-xs-12"
              	name="petOwnerPassword" >
            </div>
          </div>
          
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">* 전화번호
              <span class="required"></span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	<!-- 보호자 tel에 대한 input -->
              	<input type="text" id="petOwnerTel" required="required" class="form-control col-md-7 col-xs-12"
              	name="petOwnerTel"  value="${sessionScope.loginVO.petOwnerTel}">
            </div>
        	 <div>
              <span class="text-danger" id="telCheckView" style="font-weight: bold"></span>
          	</div>
          </div>
          
            	<!-- 보호자 address  -->
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">* 주소
              <span class="required"></span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
              	<input type="text" id="petOwnerAddress" required="required" 
              	class="form-control col-md-7 col-xs-10" name="petOwnerAddress" 
              	value="${sessionScope.loginVO.petOwnerAddress}">
            </div>
          </div>
          
            	<!-- 보호자 name -->
          <div class="form-group">
            <label for="last-name" class="control-label col-md-3 col-sm-3 col-xs-12">* 이름
              <span class="required"></span>
            </label>
            <div class="col-md-2 col-sm-6 col-xs-12">
              	<input id="petOwnerName" class="form-control col-md-7 col-xs-10 test" type="text" name="petOwnerName" 
              	required="required" value="${sessionScope.loginVO.petOwnerName}">
            </div>
          </div>
          
            
            <div class="ln_solid"></div>
            
            <div class="form-group">
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
              	<!-- 등록과 취소 버튼 -->
                <button type="submit" class="btn btn-success" >수정</button>
                <button type="button" class="btn btn-primary" onClick="location.href='home.do'">취소</button>
              </div>
            </div>
            
         
   		</form>
      </div>
    </div>  
