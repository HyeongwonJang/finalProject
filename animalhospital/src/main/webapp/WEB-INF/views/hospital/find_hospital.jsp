<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#hospitalFindBtn").click(function() {
			$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "findHospital.do", // 이동할 url 설정
			    data: $(this).serialize(),
			    dataType:"json",      
			    success: function(hospitalList){
			    	var str = "";
			    	$.each(hospitalList, function(index) {
			    		//alert(hospitalList[index].hospitalName);
						str += "<tr class='odd pointer'>";
			    		str += "<td>" + ( hospitalList[index].hospitalName ) + "</td>";
			    		str += "<td>" + ( hospitalList[index].hospitalAddress ) + "</td>";
			    		str += "<td>" + ( hospitalList[index].hospitalTel ) + "</td>";
				    	str += "<td class='last'><a href='#'>View</a></td></tr>";
			    	});
			    	$("#hospitalInfo").html("<tr class='headings'><th class='column-title'>병원 이름</th>	<th class='column-title'>주소</th><th class='column-title'>전화번호</th><th class='column-title no-link last'><span class='nobr'>상세조회</span></th></tr>");
					$("#hospitalListInfo").html(str);
			    }
			});
		});
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
			$("#page").val("${requestScope.hospitalList2.pagingBean.endPageOfPageGroup+1}");
			$("#recordSearchForm").submit();	
		});
		
		// 이전 버튼 클릭시 이동
		// 이전 페이지로 이동한다
		$("#prevPage").click(function() {
			$("#page").val("${requestScope.hospitalList2.pagingBean.startPageOfPageGroup-1}");
			$("#recordSearchForm").submit();	
		});
	});
</script>

<div class="x_panel" style="height: 800px;">
	<!-- 타이틀 -->
	<div class="x_title">
		<h2>병원검색</h2>
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<!-- 데이터 입력부분 -->
	<div class="x_content">
		<form method="post" id="recordSearchForm">
			<label>병원 이름 : </label> <input type="text" name="hospitalName"
				id="hospitalName"><br> <label>병원 주소 : </label> <input
				type="text" name="hospitalAddress" id="hospitalAddress"><br>
			<%-- <input type="hidden" name="petOwnerNo" value="${sessionScope.loginVO.petOwnerNo}"> --%>
			<!-- <input type="hidden" id ="petName" name="petVO[0].petName"> -->
			<input type="hidden" id="page" name="page">
			<button type="button" class="btn btn-default" id="hospitalFindBtn">검색</button>
		</form>
		<hr>
		<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead id='hospitalInfo'>
				<!-- <th class="bulk-actions" colspan="7"><a class="antoo"
					style="color: #fff; font-weight: 500;">Bulk Actions ( <span
						class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
				</th> -->
			</thead>
			<!-- 페이지 부분 -->
			<tbody id='hospitalListInfo'>

			</tbody>
		</table>
	</div>
</div>

