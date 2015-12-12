<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<script type="text/javascript">
	$(document).ready(function() {
		// 페이지 로딩 시 자동으로 ajax를 실행하여 petList를 가져온다
		$.ajax({
			    type: "post", // get 또는 post로 설정
			    url: "findPetListById.do", // 이동할 url 설정
			    dataType:"json",      
			    success: function(petList){
			   		var searchPetList = '';
			    	$.each(petList.petVO, function(li) {
			    		searchPetList += "<option value=" + petList.petVO[li].petName +">"+ petList.petVO[li].petName +"</option>";
			    	});
			    	$("#petListSelect").html(searchPetList);
			    	// 검색조건(petName)을 유지시킨다
			    	$("#petListSelect").val("${continueParam['povo'].petVO[0].petName}").attr("selected", "selected");
			    	$(".select1_single").select2({
						placeholder : "정보 수정할 동물을 선택하세요",
						allowClear : false
					});
			    }	
		}); 
	});	
</script>

<!-- 동물 정보 수정 -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#petListSelect").change(function(){
			$("#petListForm").submit();
		});
	});
</script>    

<div class="x_panel">
	<div class="x_title">
		<h2>동물 정보 수정 페이지</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<form action="findPetByPetName.do" method="get" id="petListForm" >
		<input type="hidden" name="petOwnerNo" value="${sessionScope.loginVO.petOwnerNo }">
			<label>반려동물명</label>
			<select class="select1_single form-control" id="petListSelect" name="petVO[0].petName" required="required">
			</select>
		</form>
	</div>
</div>
