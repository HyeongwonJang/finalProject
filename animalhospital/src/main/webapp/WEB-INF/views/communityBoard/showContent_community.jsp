<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(document).ready(function(){
       $("#deleteBtn").click(function(){ 
          if(confirm("게시물을 삭제하시겠습니까?"))
          location.href="deleteCommunityBoard.do?communityBoardNo=${requestScope.cbvo.communityBoardNo}";
       });
       $("#updateBtn").click(function(){  
          location.href="updateCommunityView.do?communityBoardNo=${requestScope.cbvo.communityBoardNo}";
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
         <td>NO : ${cbvo.communityBoardNo } </td>
         <td colspan="2">제목 : ${cbvo.communityBoardTitle} </td>
      </tr>
      <tr>
         <td>작성자 :  ${cbvo.communityBoardUserType }</td>
         <td> 작성날짜 : ${cbvo.communityBoardHours }</td>
         <td>조회수 : ${cbvo.communityBoardHit }</td>
      </tr>
      <tr>
         <td colspan="3">
         <pre class="pre-scrollable">${requestScope.cbvo.communityBoardContent}</pre>
         </td>
      </tr>
      
      <tr>
         <td valign="middle" align="center" colspan="3">
            <a class="btn btn-default" href="${initparam.root}findCommunityBoardList.do" role="button">목록</a>
               <input class="btn btn-default" type="button" value="수정" id="updateBtn">   
               <input class="btn btn-default" type="button" value="삭제" id="deleteBtn">
         </td>
      </tr>
   </table>