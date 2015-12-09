<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!-- 유지되는 매개변수가 있을 시 검색조건을 유지시킨다 -->
<c:if test="${continueParam['listVO'] ne null}">
	<script type="text/javascript">
		$(document).ready(function() {
			$('#daterangePicker span').html("${continueParam['listVO'].startDate}" 
					+ ' - ' + "${continueParam['listVO'].endDate}");
	        $('#startDate').attr('value', "${continueParam['listVO'].startDate}");
	  		$('#endDate').attr('value', "${continueParam['listVO'].endDate}");
	    	$("#petName").val("${ continueParam['povo'].petVO[0].petName }");
	    	$("#petOwnerTel").val("${continueParam['povo'].petOwnerTel}");
		});
	</script>
</c:if>
<!-- 유지되는 매개변수가 없을 시 moment.js를 이용하여 현재 시간에 맞추어서 날짜를 세팅한다 -->
<c:if test="${continueParam['listVO'] eq null}">
	<script type="text/javascript">
		$(document).ready(function() {
			$('#daterangePicker span').html(moment().subtract(29, 'days').format('YYYY-MM-DD') 
					+ ' - ' + moment().format('YYYY-MM-DD'));
	        $('#startDate').attr('value', moment().subtract(29, 'days').format('YYYY-MM-DD'));
	      	$('#endDate').attr('value', moment().format('YYYY-MM-DD'));

		});
	</script>
</c:if>
           
<script type="text/javascript">
	$(document).ready(function() {
		
		// submit 버튼 클릭시 실행되는 함수
		// 페이지 값이 공백이면 1페이지부터 시작한다
		$("#recordSearchForm").submit(function() {
			if($("#page").val() == ""){
				$("#page").val(1);	
			}
		});
		
		// 페이지 번호 클릭시 이동
		// 번호를 클릭할 시 해당 페이지로 이동한다
		$(".pageSelector").click(function() {
			$("#page").val($(this).text());
			$("#recordSearchForm").submit();	
		});
		
		// 다음 버튼 클릭시 이동
		// 다음 페이지로 이동한다
		$("#nextPage").click(function() {
			$("#page").val("${requestScope.recordList.pagingBean.endPageOfPageGroup+1}");
			$("#recordSearchForm").submit();	
		});
		
		// 이전 버튼 클릭시 이동
		// 이전 페이지로 이동한다
		$("#prevPage").click(function() {
			$("#page").val("${requestScope.recordList.pagingBean.startPageOfPageGroup-1}");
			$("#recordSearchForm").submit();	
		});
	});
</script>


<div class="x_panel" style="height: 800px;">
	<!-- 타이틀 -->
	<div class="x_title">
		<h2>진료기록조회</h2>
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<!-- 데이터 입력부분 -->
	<div class="x_content">
		<form action="findTreatmentRecordByPetOwnerTel.do" method="post" id="recordSearchForm">
			<label>반려동물명:</label>
			<input type="text" name="petVO[0].petName" id="petName">
			<p>
			<label>반려동물 보호자 전화번호:</label>
			<input type="text" name="petOwnerTel" id="petOwnerTel">
			<div class="form-group">
				<label>검색 기간: </label>	
				<div id="daterangePicker" class=""
					style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
					<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
					<span></span>
					<input type="hidden" id="startDate" name="startDate">
					<input type="hidden" id="endDate" name="endDate"> 
					<b 	class="caret"></b>
				</div>
			</div>
			<%-- <input type="hidden" name="petOwnerNo" value="${sessionScope.loginVO.petOwnerNo}"> --%>
			<!-- <input type="hidden" id ="petName" name="petVO[0].petName"> -->
			<input type="hidden" id="page" name="page">
			<button type="submit" class="btn btn-default" id="recordSearchBtn">검색</button>
		</form>
		<hr>
		<c:if test="${fn:length(recordList.list) == 0}">
			<p class="text-center"><h2>검색결과가 없습니다! 검색을 다시 해주세요!</h2></p>
		</c:if>
		
		<c:if test="${fn:length(recordList.list) != 0}">
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
					<th class="column-title no-link last"><span class="nobr">상세조회</span></th>
					<th class="bulk-actions" colspan="7"><a class="antoo"
						style="color: #fff; font-weight: 500;">Bulk Actions ( <span
							class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
					</th>
				</tr>
			</thead>
			<!-- 페이지 부분 -->
			<tbody id='treatmentRecordInfo'>
				<c:forEach items="${recordList.list}" var="recordList">
					<tr class="odd pointer">
			    	<td>${ recordList.treatmentRecordNo }</td>
			    	<td>${ recordList.diseaseVO.diseaseName }</td>
			    	<td>${ recordList.diseaseVO.diseaseSymptom }</td>
			    	<td>${ recordList.treatmentHours }</td>
			    	<td>${ recordList.petOwnerVO.petVO[0].petName }</td>
			    	<td>${recordList.petOwnerVO.petOwnerName}</td>
			    	<td class=" last"><a href="#">View</a></td>
			    	</tr>
				</c:forEach>	
			</tbody>
		</table>
		<!-- 페이징 라인 -->
		<div class="row">
  			<div class="col-md-4"></div>
  			<div class="col-md-4" align="center">
  				<ul class="pagination">
  					<c:set var="pb" value="${requestScope.recordList.pagingBean}"></c:set>
					<c:if test="${pb.previousPageGroup}">
						<li> <a id="prevPage">이전</a> </li>
					</c:if>	
					<c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
								end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<li> <a class="pageSelector">${i}</a> </li>
	              			</c:when>
							<c:otherwise>
								<li> <a><b>${i}</b></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pb.nextPageGroup}">
						<li><a id="nextPage">다음</a></li>
					</c:if>	 	  
            	</ul>
            </div>
  			<div class="col-md-4"></div>
		</div>
        </div>	
		</c:if>
		
		
	</div>