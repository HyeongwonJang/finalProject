<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="x_panel" style="height: 800px;">
	<!-- 타이틀 -->
		<div class="x_title">
		<h2>예약조회</h2>
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<hr>
	<!-- 데이터 입력부분 -->
	<div class="x_content">
		<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead>
				<tr>
					<th class="column-title">No.</th>
					<th class="column-title">날짜</th>
					<th class="column-title">시간</th>
					<th class="column-title">병원</th>
					<th class="column-title">의사</th>
					<th class="column-title">반려동물</th>
					<th class="column-title">예약내용</th>
					<th class="column-title">Tel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${requestScope.reservationList}">
					<tr>
					<td>${list.reservationNo}</td>
					<td>${list.reservationDate}</td>
					<td>${list.reservationTimeVO.reservationTime}</td>
					<td>${list.hospitalVO.hospitalName}</td>
					<td>${list.hospitalVO.vetList[0].vetLicenseVO.vetName}</td>
					<td>${list.petOwnerVO.petVO[0].petName}</td>
					<td>${list.reservationContent}</td>
					<td>${list.hospitalVO.hospitalTel}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
