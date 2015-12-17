<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<div class="row">
	<div class="col-md-4">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					진료예약 현황<small></small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<article class="media event">
					<a class="pull-left date">
						<p class="month">12월</p>
						<p class="day">23</p>
					</a>
					<div class="media-body">
						<a class="title">의사: 뭐더라</a>
						<p>진료시간: 14:30</p>
					</div>
				</article>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="x_panel">
			<div class="x_title">
				<h2>내 반려동물 목록</h2>
				<small></small>
				
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="row">
					<div class="col-md-6 col-sm-4 col-xs-12 animated fadeInDown">
					<div class="well profile_view">
						<div class="col-sm-12">
							<h4 class="brief">
								<i>동물 종류</i>
							</h4>
							<div class="left col-xs-7">
								<h2>이름</h2>
								<p>
									<strong>About: </strong> 특이사항
								</p>
								
							</div>
							<div class="right col-xs-5 text-center">
								<img src="${initparam.root}resources/img/samplePet.jpg" alt=""
									class="img-circle img-responsive">
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-4 col-xs-12 animated fadeInDown">
					<div class="well profile_view">
						<div class="col-sm-12">
							<h4 class="brief">
								<i>수의사</i>
							</h4>
							<div class="left col-xs-7">
								<h2>의사이름</h2>
								<p>
									<strong>About: </strong> 외과/내과
								</p>
							</div>
							<div class="right col-xs-5 text-center">
								<img src="${initparam.root}resources/img/paw.png" alt=""
									class="img-circle img-responsive">
							</div>
						</div>
					</div>
				</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<div class="x_panel">
	<div class="x_title">
		<h2>진료기록 조회</h2>
		<small></small>
		<ul class="nav navbar-right panel_toolbox">
			<li><a href="${initparam.root}findTreatmentRecordPagePetOwnerView.do">
			<i class="fa fa-chevron-down"></i>&nbsp;더 보기</a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead>
				<tr class="headings">
					<th class="column-title">No.</th>
					<th class="column-title">질병명</th>
					<th class="column-title">증상</th>
					<th class="column-title">진료시간</th>
					<th class="column-title">반려동물명</th>
					<th class="column-title">보호자명</th>
				</tr>
			</thead>
			<!-- 페이지 부분 -->
			<tbody id='treatmentRecordInfo'>
				<c:forEach items="${ requestScope.treatmentList }" var="recordList">
					<tr class="odd pointer">
			    	<td>${ recordList.treatmentRecordNo }</td>
			    	<td>${ recordList.diseaseVO.diseaseName }</td>
			    	<td>${ recordList.diseaseVO.diseaseSymptom }</td>
			    	<td>${ recordList.treatmentHours }</td>
			    	<td>${ recordList.petVO.petName }</td>
			    	<td>${sessionScope.loginVO.petOwnerName}</td>
			    	</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</div>