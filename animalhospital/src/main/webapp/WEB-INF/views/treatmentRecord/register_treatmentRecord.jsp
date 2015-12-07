<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 달력 -->
<script type="text/javascript">
$(function(){
		$("#datepicker").datepicker({
			dateFormat:"yy-mm-dd",
			dayNamesMin:['일','월','화','수','목','금','토']
		});
});		
</script>
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
<script>
	autosize($('.resizable_textarea'));
</script>

<div class="x_panel">
	<div class="x_title">
		<h2>
			진료등록
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		  
		<!-- 폼 시작부 -->
		<form id="treatmentForm">
			<label for="inputInfo">진료일시:</label> 
			<input type="text"  id="datepicker" class="form-control" />
			<label for="inputInfo">보호자 전화번호:</label> 
			<input type="text" id="petOwnerTel" class="form-control" name="" />
			<label>반려동물 - 보호자 전화번호로 검색</label>
				<select class="select2_single form-control" tabindex="-1">
					<option>ajax로 가져오면 되겠지</option>
					<option>귀찮음</option>
					<option>졸림</option>
					<option>배고픔</option>
				</select> 
			<label for="inputInfo">몸무게:</label> 
			<input type="text" id="petWeight" class="form-control" name="" />
			<label>진료종류</label>
				<select class="select2_single form-control" tabindex="-1">
					<option>내과</option>
					<option>외과</option>
					<option>치과</option>
					<option>신경외과</option>
					<option>예방접종</option>
				</select>
			<label>진료내용</label>
			<textarea class="form-control" rows="8" placeholder="진료내용을 입력해주세요"></textarea>
			
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<p align="center">
						<button type="submit" class="btn btn-primary">제출</button>
						<button type="button" class="btn btn-success">취소</button>
					</p>
				</div>
			</div>
		</form>
		<!-- end form for validations -->

	</div>
</div>

