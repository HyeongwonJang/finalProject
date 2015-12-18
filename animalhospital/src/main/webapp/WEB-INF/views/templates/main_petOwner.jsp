<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<script type="text/javascript">
	$(document).ready(function() {
		$(".month").text(moment().month()+1 + "월");
		$(".day").text(moment().date());
	});
</script>     
<div class="row">
	<div class="col-md-4">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					진료예약현황
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li>
						<a href="${initparam.root}findPetOwnerReservation.do">
							<i class="fa fa-chevron-down"></i>&nbsp;더 보기
						</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<c:forEach var="reservationList" items="${requestScope.reservationList}">
					<article class="media event">
					<a class="pull-left date">
						<p class="month"></p>
						<p class="day"></p>
					</a>
					<div class="media-body">
						<a class="title">진료시간 : ${ reservationList.reservationTimeVO.reservationTime }</a>
						<p>진료의사: ${ reservationList.hospitalVO.vetList[0].vetLicenseVO.vetName }</p>
						<p>내 반려동물: ${reservationList.petOwnerVO.petVO[0].petName} </p>
					</div>
				</article>	
				</c:forEach>
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
					<c:forEach var="petList" items="${ requestScope.petList.petVO }">
						<div class="col-md-6 col-sm-4 col-xs-12 animated fadeInDown">
							<div class="well profile_view">
								<div class="col-sm-12">
									<div class="left col-xs-7">
										<h2>${ petList.petName }</h2>
										<p>
											<strong>생일: </strong> ${ petList.petBirthday }
										</p>
										<p>
											<strong>About: </strong> ${ petList.petNote }
										</p>

									</div>
									<div class="right col-xs-5 text-center">
										<img src="${initparam.root}resources/img/paw.png" alt=""
											class="img-circle img-responsive">
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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