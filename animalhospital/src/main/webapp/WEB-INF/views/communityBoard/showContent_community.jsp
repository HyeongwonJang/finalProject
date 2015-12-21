<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function(){
       $("#deleteBtn").click(function(){ 
          if(confirm("게시물을 삭제하시겠습니까?"))
          location.href="deleteCommunityBoard.do?questionBoardNo=${requestScope.qbvo.questionBoardNo}";
       });
       $("#updateBtn").click(function(){  
          location.href="updateCommunityView.do?questionBoardNo=${requestScope.qbvo.questionBoardNo}";
       });
    });   
</script>

   <div class="x_title">
      <h2>상세 페이지</h2>
      <ul class="nav navbar-right panel_toolbox">
         <li></li>
      </ul>
      <div class="clearfix"></div>
   </div>

   <table class="table table-bordered">
      <tr>
         <td>NO : ${qbvo.questionBoardNo } </td>
         <td colspan="2">제목 : ${qbvo.questionBoardTitle} </td>
      </tr>
      <tr>
         <td>작성자 :  ${qbvo.petOwnerVO.petOwnerName }</td>
         <td> 작성날짜 : ${qbvo.questionBoardHours }</td>
         <td>조회수 : ${qbvo.questionBoardHit }</td>
      </tr>
      <tr>
         <td colspan="3">
         <pre class="pre-scrollable">${requestScope.qbvo.questionBoardContent}</pre>
         </td>
      </tr>
      
      <tr>
         <td valign="middle" align="center" colspan="3">
           <c:if test="${sessionScope.userLevel == 'vet' }">
             <a class="btn btn-default" href="${initparam.root}replyCommunityView.do?questionBoardNo=${requestScope.qbvo.questionBoardNo}" role="button">답글</a>	  
            </c:if>  
              <a class="btn btn-default" href="${initparam.root}findCommunityBoardList.do" role="button">목록</a>
				<c:if 	test="${sessionScope.userLevel == 'petOwner' 
				&& requestScope.qbvo.petOwnerVO.petOwnerId 
				== sessionScope.loginVO.petOwnerId }">
					<input class="btn btn-default" type="button" value="수정"
						id="updateBtn">
					<input class="btn btn-default" type="button" value="삭제"
						id="deleteBtn">
				</c:if>
		</td>
      </tr>
   </table>