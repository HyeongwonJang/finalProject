<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${initparam.root}resources/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">
<div class="x_content">

	<table id="example"
		class="table table-striped responsive-utilities jambo_table">
		<thead>
			<tr class="headings">
				<th><input type="checkbox" class="tableflat"></th>
				<th>Invoice</th>
				<th>Invoice Date</th>
				<th>Order</th>
				<th>Bill to Name</th>
				<th>Status</th>
				<th>Amount</th>
				<th class=" no-link last"><span class="nobr">Action</span></th>
			</tr>
		</thead>

		<tbody>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000040</td>
				<td class=" ">May 23, 2014 11:47:56 PM</td>
				<td class=" ">121000210 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$7.45</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000039</td>
				<td class=" ">May 23, 2014 11:30:12 PM</td>
				<td class=" ">121000208 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$741.20</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer selected">
				<td class="a-center "><input type="checkbox" checked
					class="tableflat"></td>
				<td class=" ">121000038</td>
				<td class=" ">May 24, 2014 10:55:33 PM</td>
				<td class=" ">121000203 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$432.26</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000037</td>
				<td class=" ">May 24, 2014 10:52:44 PM</td>
				<td class=" ">121000204</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$333.21</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000040</td>
				<td class=" ">May 24, 2014 11:47:56 PM</td>
				<td class=" ">121000210</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$7.45</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000039</td>
				<td class=" ">May 26, 2014 11:30:12 PM</td>
				<td class=" ">121000208 <i class="error fa fa-long-arrow-down"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$741.20</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000038</td>
				<td class=" ">May 26, 2014 10:55:33 PM</td>
				<td class=" ">121000203</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$432.26</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000037</td>
				<td class=" ">May 26, 2014 10:52:44 PM</td>
				<td class=" ">121000204</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$333.21</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>

			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000040</td>
				<td class=" ">May 27, 2014 11:47:56 PM</td>
				<td class=" ">121000210</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$7.45</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000039</td>
				<td class=" ">May 28, 2014 11:30:12 PM</td>
				<td class=" ">121000208</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$741.20</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000040</td>
				<td class=" ">May 23, 2014 11:47:56 PM</td>
				<td class=" ">121000210 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$7.45</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000039</td>
				<td class=" ">May 23, 2014 11:30:12 PM</td>
				<td class=" ">121000208 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$741.20</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer selected">
				<td class="a-center "><input type="checkbox" checked
					class="tableflat"></td>
				<td class=" ">121000038</td>
				<td class=" ">May 24, 2014 10:55:33 PM</td>
				<td class=" ">121000203 <i class="success fa fa-long-arrow-up"></i>
				</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$432.26</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000037</td>
				<td class=" ">May 24, 2014 10:52:44 PM</td>
				<td class=" ">121000204</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$333.21</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000040</td>
				<td class=" ">May 24, 2014 11:47:56 PM</td>
				<td class=" ">121000210</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$7.45</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="odd pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000039</td>
				<td class=" ">May 26, 2014 11:30:12 PM</td>
				<td class=" ">121000208 <i class="error fa fa-long-arrow-down"></i>
				</td>
				<td class=" ">John Blank L</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$741.20</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
			<tr class="even pointer">
				<td class="a-center "><input type="checkbox" class="tableflat">
				</td>
				<td class=" ">121000038</td>
				<td class=" ">May 26, 2014 10:55:33 PM</td>
				<td class=" ">121000203</td>
				<td class=" ">Mike Smith</td>
				<td class=" ">Paid</td>
				<td class="a-right a-right ">$432.26</td>
				<td class=" last"><a href="#">View</a></td>
			</tr>
		</tbody>

	</table>
</div>

<br />
<br />
<br />
<!-- Datatables -->
        <script src="${initparam.root}resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="${initparam.root}resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
        <script>
            $(document).ready(function () {
                $('input.tableflat').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
            });

            var asInitVals = new Array();
            $(document).ready(function () {
                var oTable = $('#example').dataTable({
                    "oLanguage": {
                        "sSearch": "검색:"
                    },
                    "aoColumnDefs": [
                        {
                            'bSortable': false,
                            'aTargets': [0]
                        } //disables sorting for column one
            ],
                    'iDisplayLength': 12,
                    "sPaginationType": "full_numbers",
                    "dom": 'T<"clear">lfrtip',
                    /* "tableTools": {
                        "sSwfPath": "<?php echo base_url('assets2/js/Datatables/tools/swf/copy_csv_xls_pdf.swf'); ?>"
                    } */
                });
                $("tfoot input").keyup(function () {
                    /* Filter on the column based on the index of this element's parent <th> */
                    oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
                });
                $("tfoot input").each(function (i) {
                    asInitVals[i] = this.value;
                });
                $("tfoot input").focus(function () {
                    if (this.className == "search_init") {
                        this.className = "";
                        this.value = "";
                    }
                });
                $("tfoot input").blur(function (i) {
                    if (this.value == "") {
                        this.className = "search_init";
                        this.value = asInitVals[$("tfoot input").index(this)];
                    }
                });
            });
        </script>