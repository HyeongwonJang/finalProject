<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="	button" class="close" id="dismiss"
					name="selectHospitalBtn" aria-hidden="true">×</button>
				검색: <input type='text' id='txtFilter' class="form-control"
					onkeyup='{filter();return false}'
					onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}'>
			</div>
			<div class="modal-body">

				<table
					class="table table-striped responsive-utilities jambo_table bulk_action"
					id="hospitalList">
					<thead>
						<tr class="headings">
							<th class="column-title">No</th>
							<th class="column-title">병원명</th>
							<th class="column-title">주소</th>
							<th class="column-title">전화번호</th>
							<th class="column-title">선택</th>
						</tr>
					</thead>
					<tbody id="modalTableInfo">

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>