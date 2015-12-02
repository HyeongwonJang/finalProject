<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>수의사 회원가입</title>
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
<%-- <script src="${initparam.root}resources/js/input_mask/jquery.inputmask.js"></script> --%>
<script src="${initparam.root}resources/js/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${initparam.root}resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#popbutton").click(function() {
			$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "findAllHospitalAjax.do", // 이동할 url 설정
			    success: function(hospitalList){
			    	var tableInfo = "";
			    	$.each(hospitalList, function(index) {
			    		tableInfo += "<tr class='odd pointer' name="+ hospitalList[index].hospitalName.toLowerCase() +">";
			    		tableInfo += "<td>" + hospitalList[index].hospitalId +"</td>";
			    		tableInfo += "<td>" + hospitalList[index].hospitalName +"</td>";
			    		tableInfo += "<td>" + hospitalList[index].hospitalAddress +"</td>";
			    		tableInfo += "<td>" + hospitalList[index].hospitalTel +"</td>";
			    		tableInfo += "<td> " + 
			    					" <button type='button' class='btn btn-info' id='testBtn'>선택</button>" +
			    					"</td>";
			    		tableInfo += "</tr>";
					});
			    	$("#modalTableInfo").html(tableInfo)
			    	
			    }
			});
			$('div.modal').modal({
			});
		});
		
		
		
		$("#testBtn").click(function() {
			alert("테스트");
			
			$('div.modal').modal('hide');
			})
		
		
	});
</script>

<script type='text/javascript'>
	function filter(){
		if($('#txtFilter').val()=="")
			$("#modalTableInfo tr").css('display','');			
		else{
			$("#modalTableInfo tr").css('display','none');
			$("#modalTableInfo tr[name*='"+$('#txtFilter').val().toLowerCase()+"']").css('display','');
		}
		return false;
	}
</script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#testBtn").click(function() {
			alert("만세");
			$("#vetId").val("형원이형 약 빠는 중");
		});
	});
</script>

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
        <h2>수의사 회원가입
        </h2>
        <ul class="nav navbar-right panel_toolbox">
          <li></li>
        </ul>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <br>
        <form id="vetForm" class="form-horizontal form-label-left" action="registerVet.do" method="get">
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">아이디
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	<!-- 수의사 id에 대한 input -->
            	<input type="text" id="vetId" required="required" class="form-control col-md-7 col-xs-12"
              	name="vetList[0].vetId">
            </div>
            <div>
            	<!-- 텍스트 색깔은 text-primary text-danger 이거 사용-->
              <h3></h3><span class="text-danger" style="font-weight: bold">중복체크 ajax</span>
          	</div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">패스워드
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	<!-- 수의사 password에 대한 input -->
              	<input type="password" id="vetPassword" required="required" class="form-control col-md-7 col-xs-12"
              	name="vetList[0].vetPassword">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">전화번호
              <span class="required">*</span>
            </label>
            <div class="col-md-4 col-sm-6 col-xs-12">
            	<!-- 수의사 tel에 대한 input -->
              	<input type="text" id="vetTel" required="required" class="form-control col-md-7 col-xs-12"
              	name="vetList[0].vetTel">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">면허증번호
              <span class="required">*</span>
            </label>
            <div class="col-md-2 col-sm-6 col-xs-12">
            	<!-- 수의사 면허증 번호에 대한 input -->
              	<input type="text" id="vetLicenseNo" required="required" 
              	class="form-control col-md-7 col-xs-10" placeholder="면허증번호를 입력해주세요" 
              	name="vetList[0].vetLicenseVO.vetLicenseNo">
            </div>
            <div>
              <h3></h3>면허증 번호가 조회되면 ajax로 연동</div>
          	</div>
          <div class="form-group">
            <label for="last-name" class="control-label col-md-3 col-sm-3 col-xs-12">이름
              <span class="required">*</span>
            </label>
            <div class="col-md-2 col-sm-6 col-xs-12">
            	<!-- 수의사 이름에 대한 input -->
              	<input id="vetName" class="form-control col-md-7 col-xs-10" type="text" name="vetList[0].vetLicenseVO.vetLicenseName" 
              	required="required">
            </div>
          </div>
          <div class="form-group">
            <label for="last-name" class="control-label col-md-3 col-sm-3 col-xs-12">병원이름
              <span class="required">*</span>
            </label>
            <div class="col-md-2 col-sm-6 col-xs-12">
            	<!-- 병원 이름에 대한 input -->
              	<input id="hospitalName" class="form-control col-md-7 col-xs-10" type="text" name="hospitalName"
              	required="required" readonly>
            </div>
            <div>
              <button type="button" class="btn btn-info" id="popbutton">조회</button>
            </div>
            <div class="ln_solid"></div>
            <div class="form-group">
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
              	<!-- 등록과 취소 버튼 -->
                <button type="submit" class="btn btn-success" >등록</button>
                <button type="button" class="btn btn-primary" onClick="location.href='home.do'">취소</button>
              </div>
            </div>
          </div>
   		</form>
      </div>
    </div>
  	<!-- Modal Page data-dismiss="modal"-->
	<div class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" id="testBtn"
						aria-hidden="true">×</button>
					검색: <input type='text' id='txtFilter' class="form-control"
					  		onkeyup='{filter();return false}' 
					  		onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
				</div>
				<div class="modal-body">
					
					<table 	class="table table-striped responsive-utilities jambo_table bulk_action" id=modalTable>
				<thead>
				<tr class="headings">
					<th class="column-title">No</th>
					<th class="column-title">병원명</th>
					<th class="column-title">주소</th>
					<th class="column-title">전화번호</th>
					<th class="column-title">선택</th>
				</tr>
			</thead>
			<tbody id="modalTableInfo">
				
			</tbody>	
			</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
<!-- 특수문자 포함되면 지우는 스크립트 추가 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#vetTel").keyup(function() {
			$("#vetTel").bind("keyup", function() {
				var re = /[~!@\#$%^&*\()\-=+./,;_']/gi;
				var temp = $("#vetTel").val();
				if (re.test(temp)) { //특수문자가 포함되면 삭제하여 값으로 다시셋팅
					$("#vetTel").val(temp.replace(re, ""));
				}
			});	
		});
	});
</script>
</html>