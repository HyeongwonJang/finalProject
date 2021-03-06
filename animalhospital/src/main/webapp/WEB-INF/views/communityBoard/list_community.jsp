<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<script type="text/javascript">
	$(document).ready(function(){
		$("#writeBtn").click(function(){
			location.href="${initparam.root}writeCommunityView.do";
		});
	});
</script>


<div class="x_panel" style="height: 800px;">
	<!-- 타이틀 -->
	<div class="x_title">
		<h2>Q&A</h2> 
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<!-- 데이터 입력부분 -->
	<!-- <form action="getCommunityBoardList.do" method="post" id="recordSearchForm">
			<input type="hidden" id="page" name="page">
		</form> -->
			<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead>
				<tr class="headings">
					<th class="column-title">No.</th>
					<th class="column-title">글제목</th>
					<th class="column-title">글쓴이</th>
					<th class="column-title">작성날짜</th>
					<th class="column-title">조회수</th>
				</tr>
			</thead>
		<tbody>
			<c:forEach items="${requestScope.lvo.boardList}" var="qbvo">
				<tr>
					<td>${ qbvo.questionBoardNo }</td>
					<td><c:choose>
							<c:when test="${sessionScope.loginVO!=null}">
								<a
									href="${initParam.root}showCommunityBoardContent.do?questionBoardNo=${qbvo.questionBoardNo}">
									${ qbvo.questionBoardTitle  }</a>
							</c:when>
							<c:otherwise>
              					${ qbvo.questionBoardTitle  }
              				 </c:otherwise>
								</c:choose></td>
									<td>${ qbvo.petOwnerVO.petOwnerName}</td>
									<td>${ qbvo.questionBoardHours }</td>
									<td>${ qbvo.questionBoardHit}</td>
						</tr>
			</c:forEach>
		</tbody>
	</table>
		<input type="button" value="새글쓰기" id="writeBtn">
   </div>
	
