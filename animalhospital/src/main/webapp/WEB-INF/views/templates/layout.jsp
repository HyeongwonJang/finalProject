<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ah! 동물!</title>
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
<!-- jQuery 플러그인 -->
<script src="${initparam.root}resources/js/jquery.min.js"></script>
<!-- select2 -->
<script src="${initparam.root}resources/js/select/select2.full.js"></script>
<!-- select2 -->
<link href="${initparam.root}resources/css/select/select2.min.css"
	rel="stylesheet">
<!-- jquery 달력 css -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.7.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- form validation 플러그인-->
<script type="text/javascript"
	src="${initparam.root}resources/js/parsley/parsley.min.js"></script>
<!-- textarea resize -->
<script src="${initparam.root}resources/js/textarea/autosize.min.js"></script>
<!--[if lt IE 9]>
      <script src="../assets/js/ie8-responsive-file-warning.js"></script>
    <![endif]-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media
    queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col">
					<div class="navbar nav_title" style="border: 0;">
						<a href="${initparam.root}home.do" class="site_title"><i class="fa fa-paw"></i>
							<span>Ah! 동물!</span></a>
					</div>
					<div class="clearfix"></div>
					<!-- menu prile quick info -->
					<div class="profile"></div>
					<!-- /menu prile quick info -->
					<br>
					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">

							<!-- 왼쪽 메뉴 -->
							<ul class="nav side-menu">
								<li><a href="${initparam.root}findHospitalView.do"><i
										class="fa fa-search"></i> 병원검색 </a></li>
								<li><a href="${initparam.root}testTreatmentView.do"> <i
										class="fa fa-search"></i> 테스트 페이지
								</a></li>
								<li><a><i class="fa fa-clipboard"></i> 진료관리 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<c:choose>
											<c:when test="${sessionScope.userLevel == 'vet' }">
												<li><a
													href="${initparam.root}registerTreatmentRecordView.do">진료등록</a>
												</li>
											</c:when>
											<c:when test="${sessionScope.userLevel == 'petOwner' }">
												<li><a
													href="${initparam.root}registerVaccinationRecordView.do">예방접종등록</a>
												</li>
												<li><a
													href="${initparam.root}viewTreatmentRecordPage.do">진료기록조회</a>
												</li>
											</c:when>
										</c:choose>

									</ul></li>
							</ul>
						</div>
						<div class="menu_section">
							<ul class="nav side-menu"></ul>
						</div>
					</div>
					<!-- /sidebar menu -->
					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small"></div>
					<!-- /menu footer buttons -->
				</div>
			</div>
			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav class="" role="navigation">
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>
						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <c:choose>
										<c:when test="${sessionScope.userLevel == 'vet' }">
                    		${sessionScope.loginVO.vetList[0].vetLicenseVO.vetName}님 환영합니다
                    	</c:when>
										<c:when test="${sessionScope.userLevel == 'petOwner' }">
                    		${sessionScope.loginVO.petOwnerName}님 환영합니다	
                    	</c:when>
									</c:choose> <span class=" fa fa-angle-down"></span>
							</a>
								<ul
									class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">

									<c:choose>
										<c:when test="${sessionScope.userLevel == 'vet' }">
											<li><a href="${initparam.root}vetUpdateView.do"><i class="fa fa-user"></i>
													회원정보수정</a></li>
										</c:when>
										<c:when test="${sessionScope.userLevel == 'petOwner' }">
											<li><a href="${initparam.root}updatePetOwnerView.do"><i
													class="fa fa-user"></i> 회원정보수정</a></li>
										</c:when>
									</c:choose>
									<li><a href="${initparam.root}logout.do"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left"></div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<!-- 타일즈 테스트 -->
							<tiles:insertAttribute name="main" />
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
		</div>
	</div>
	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group"></ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>
	<!-- 부트스트랩 자바스크립트 -->
	<script src="${initparam.root}resources/js/bootstrap.min.js"></script>
	<!-- chart js -->
	<script src="${initparam.root}resources/js/chartjs/chart.min.js"></script>
	<!-- icheck -->
	<script
		src="${initparam.root}resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="${initparam.root}resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="${initparam.root}resources/js/icheck/icheck.min.js"></script>
	<script src="${initparam.root}resources/js/custom.js"></script>


</body>

</html>