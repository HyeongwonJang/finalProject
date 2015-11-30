<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>인덱스 페이지</title>
<!-- Bootstrap Core CSS -->
<link href="${initparam.root}resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${initparam.root}resources/css/stylish-portfolio.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${initparam.root}resources/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- Custom styling plus plugins -->
<link href="${initparam.root}resources/css/custom.css" rel="stylesheet">
<link href="${initparam.root}resources/css/icheck/flat/green.css" rel="stylesheet">
<script src="${initparam.root}resources/js/jquery.min.js"></script>
<!-- 스크립트 구간 -->
	<!-- jQuery -->
	<script src="${initparam.root}resources/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${initparam.root}resources/js/bootstrap.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<!-- 모달을 띄우기 위한 스크립트 -->
<script type="text/javascript">
		$(document).ready(function() {
			$("#popbutton").click(function() {
				$('div.modal').modal({					
				});
			});
		});
	</script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements
    and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file://
    -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Header -->
	<header id="top" class="header">
		<div class="text-vertical-center">
			<h1>Ah! 동물</h1>
			<h3></h3>
			<!-- 로그인 버튼 링크 -->
			<br> <a href="${initparam.root}login_view.do" class="btn btn-dark btn-lg">Login</a>
			<br>
			<!-- 회원가입 버튼 링크 -->
			<button class="btn btn-info btn-sm" id="popbutton">회원가입</button>
			<br>
		</div>
		<br>
	</header>
	<!-- Modal Page -->
	<div class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">가입 한 번으로 Ah! 동물의 다양한 서비스를 이용하세요!</h4>
				</div>
				<div class="modal-body">
					<p align="center" class="text-success">
					<!-- 버튼 링크 -->
						<a class="btn btn-primary" href="${initparam.root}registerVetView.do">
						수의사</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-success" href="${initparam.root}registerPetownerView.do">보호자</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<aside class="callout"></aside>
	
	
	



</body>
</html>