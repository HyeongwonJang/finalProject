<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- select2 -->
<script>
	$(document).ready(function() {
		$(".select2_single").select2({
			placeholder : "해당 항목을 선택해주세요",
			allowClear : true
		});
		$(".select2_group").select2({});
		$(".select2_multiple").select2({
			maximumSelectionLength : 4,
			placeholder : "With Max Selection limit 4",
			allowClear : true
		});
	});
</script>
<!-- /select2 -->

    
<div class="x_panel" style="height: 600px;">
	<!-- 타이틀 -->
	<div class="x_title">
		<h2>진료기록조회</h2>
		<ul class="nav navbar-right panel_toolbox"></ul>
		<div class="clearfix"></div>
	</div>
	<!-- 데이터 입력부분 -->
	<div class="x_content">
		<label>반려동물명</label>
			<select class="select2_single form-control" tabindex="-1">
				<c:forEach items="${findPetResult.petVO }" var="pet">
					<option value="${pet.petName }">${pet.petName }</option>
				</c:forEach>
			</select> 	
		<hr>
		<table
			class="table table-striped responsive-utilities jambo_table bulk_action">
			<thead>
				<tr class="headings">
					<th class="column-title">No.</th>
					<th class="column-title">증상</th>
					<th class="column-title">질병명</th>
					<th class="column-title">진료시간</th>
					<th class="column-title">반려동물명</th>
					<th class="column-title">보호자명</th>
					<th class="column-title no-link last"><span class="nobr">상세조회</span>
					</th>
					<th class="bulk-actions" colspan="7"><a class="antoo"
						style="color: #fff; font-weight: 500;">Bulk Actions ( <span
							class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr class="odd pointer">
					<td class=" ">121000037</td>
					<td class=" ">May 26, 2014 10:52:44 PM</td>
					<td class=" ">121000204</td>
					<td class=" ">Mike Smith</td>
					<td class=" ">Paid</td>
					<td class="a-right a-right ">$333.21</td>
					<td class=" last"><a href="#">View</a></td>
				</tr>
				<tr class="even pointer">
					<td class=" ">121000040</td>
					<td class=" ">May 27, 2014 11:47:56 PM</td>
					<td class=" ">121000210</td>
					<td class=" ">John Blank L</td>
					<td class=" ">Paid</td>
					<td class="a-right a-right ">$7.45</td>
					<td class=" last"><a href="#">View</a></td>
				</tr>
				<tr class="odd pointer">
					<td class=" ">121000039</td>
					<td class=" ">May 28, 2014 11:30:12 PM</td>
					<td class=" ">121000208</td>
					<td class=" ">John Blank L</td>
					<td class=" ">Paid</td>
					<td class="a-right a-right ">$741.20</td>
					<td class=" last"><a href="#">View</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>