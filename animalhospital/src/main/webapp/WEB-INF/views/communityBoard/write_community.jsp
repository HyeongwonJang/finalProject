<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function() {
	$("#writeSubmit").click(function(){
		var f = document.writeForm;
		if(f.communityBoardTitle.value=""){
			return;
		}
		if(f.communityBoardContent.value=""){
			return;
		}
		$("#writeForm").submit();
	});
});



</script>
<div class="x_panel">

	<div class="x_title">
		<h2>글쓰기</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li></li>
		</ul>
		<div class="clearfix"></div>
	</div>

	<div class="x_content">
		<br>
		<form id="writeForm" class="form-horizontal form-label-left"
			action="writeCommunity.do" method="post">

			<!-- 제목 -->
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12">* 제목 
				<span class="required"></span>
				</label>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<input type="text" id="communityBoardTitle" required="required"
						class="form-control col-md-7 col-xs-12" name="communityBoardTitle"/>
					<p class="help-block"></p>
				</div>
			</div>

			<!-- 글쓴이 -->
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12">
					글쓴이 <span class="required"></span>
				</label>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<input type="password" id="communityBoardUserType" required="required"
						class="form-control col-md-7 col-xs-12" name="communityBoardUserType" readonly>
				</div>
			</div>

			<!-- 작성날짜 -->
		<!-- 	<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12">
					작성날짜 <span class="required"></span>
				</label>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<input type="date" id="communityBoardHours" required="required"
						class="form-control col-md-7 col-xs-12" name="communityBoardHours"
						>
				</div>
			</div> -->


			<!-- 내용  -->
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="last-name">* 내용 <span class="required"></span>
				</label>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<textarea class="form-control" rows="8" name="communityBoardContent" 
					required="required"  placeholder="내용을 입력해주세요"></textarea>
				</div>
			</div>

			<div class="ln_solid"></div>

			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<!-- 등록과 취소 버튼 -->
					<button type="submit" class="btn btn-success" id="writeSubmit">등록</button>
					<button type="button" class="btn btn-primary"
						onClick="location.href='findCommunityBoardList.do'">취소</button>
				</div>
			</div>


		</form>
	</div>
</div>
