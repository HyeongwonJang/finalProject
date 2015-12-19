<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
$(document).ready(function() {
	$("#updateSubmit").click(function() {
		if(confirm("게시물을 수정하시겠습니까?")){
			$("#updateForm").submit();
		}else{
			return false;
		}
	});
});
</script>

<form action="updateCommunityBoard.do" method="post" id="updateForm">
<input type="hidden" name="questionBoardNo" value="${qbvo.questionBoardNo }">
   <div class="x_title">
      <h2>글 수정</h2>
      <ul class="nav navbar-right panel_toolbox">
         <li></li>
      </ul>
      <div class="clearfix"></div>
   </div>

   <table class="table table-bordered">
	<tr>
		<td>제목</td>
		<td colspan="3">
		<input type="text" class="form-control" name="questionBoardTitle" 
				  value="${qbvo.questionBoardTitle}" required='required' ></td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${sessionScope.loginVO.petOwnerName}님</td>
	</tr>
	<tr>
		<td colspan="4" align="left">&nbsp;&nbsp; 
		<textarea cols="53" rows="15" name="questionBoardContent" class="form-control" 
						id="contentArea" required='required' >
     		${qbvo.questionBoardContent} 
     	</textarea>
		</td>
	</tr>
	<tr>
    	<td valign="middle" align="center" colspan="3">
			<input class="btn btn-default" type="submit" value="수정완료" id="updateSubmit">
			<a class="btn btn-default" 
			href="${initParam.root}findCommunityBoardList.do" 
			role="button">작성취소</a>
		</td>
    </tr>
   </table>
  </form>
