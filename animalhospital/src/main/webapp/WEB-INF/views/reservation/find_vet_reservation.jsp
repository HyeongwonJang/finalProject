<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

        <link href="${initparam.root}resources/css/calendar/fullcalendar.css" rel="stylesheet">
        <link href="${initparam.root}resources/css/calendar/fullcalendar.print.css" rel="stylesheet" media="print">

    <body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- page content -->
			<div class="row">
				<div class="col-md-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>스케줄조회</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<div id='calendar'></div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Start Calender modal -->
			<!-- <div id="CalenderModalNew" class="modal fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">New Calender Entry</h4>
						</div>
						<div class="modal-body">
							<div id="testmodal" style="padding: 5px 20px;">
								<form id="antoform" class="form-horizontal calender" role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label">Title</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="title"
												name="title">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Description</label>
										<div class="col-sm-9">
											<textarea class="form-control" style="height: 55px;"
												id="descr" name="descr"></textarea>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default antoclose"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary antosubmit">Save
								changes</button>
						</div>
					</div>
				</div>
			</div> -->
			<div id="CalenderModalEdit" class="modal fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel2">일일조회</h4>
						</div>
						<div class="modal-body">

							<div id="testmodal2" style="padding: 5px 20px;">
								<form id="antoform2" class="form-horizontal calender"
									role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label">Title</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="title2"
												name="title2">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Description</label>
										<div class="col-sm-9">
											<textarea class="form-control" style="height: 55px;"
												id="descr2" name="descr"></textarea>
										</div>
									</div>

								</form>
							</div>
						</div>
						<!-- <div class="modal-footer">
                                <button type="button" class="btn btn-default antoclose2" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary antosubmit2">Save changes</button>
                            </div> -->
					</div>
				</div>
			</div>

			<!-- <div id="fc_create" data-toggle="modal"
				data-target="#CalenderModalNew"></div> -->
			<div id="fc_edit" data-toggle="modal"
				data-target="#CalenderModalEdit"></div>

			<!-- End Calender modal -->
			<!-- /page content -->
		</div>

	</div>

	<div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
        </div>

        <script src="${initparam.root}resources/js/moment.min.js"></script>
        <script src="${initparam.root}resources/js/calendar/fullcalendar.min.js"></script>

        <script>
            $(document).ready(function () {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();
                var started;
                var categoryClass;
                alert(3);
                var calendar = $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: ''
                    },
                    selectable: true,
                    selectHelper: true,
/*                     select: function (start, end, allDay) {
                        $('#fc_create').click();
                        started = start;
                        ended = end

                        $(".antosubmit").on("click", function () {
                            var title = $("#title").val();
                            if (end) {
                                ended = end
                            }
                            categoryClass = $("#event_type").val();

                            if (title) {
                                calendar.fullCalendar('renderEvent', {
                                        title: title,
                                        start: started,
                                        end: end,
                                        allDay: allDay
                                    },
                                    true // make the event "stick"
                                );
                            }
                            $('#title').val('');
                            calendar.fullCalendar('unselect');

                            $('.antoclose').click();

                            return false;
                        });
                    }, */
                    eventClick: function (calEvent, jsEvent, view) {
                        //alert(calEvent.title, jsEvent, view);

                        $('#fc_edit').click();
                        $('#title2').val(calEvent.title);
                        categoryClass = $("#event_type").val();

                        $(".antosubmit2").on("click", function () {
                            calEvent.title = $("#title2").val();

                            calendar.fullCalendar('updateEvent', calEvent);
                            $('.antoclose2').click();
                        });
                        calendar.fullCalendar('unselect');
                    },
                    editable: false,
                    events: [
                        {
                            title: 'All Day Event',
                            start: new Date(y, m, 1)
                    },
                        {
                            title: 'Long Event',
                            start: new Date(y, m, d - 5),
                            end: new Date(y, m, d - 2)
                    },
                        {
                            title: 'Meeting',
                            start: new Date(y, m, d, 10, 30),
                            allDay: false
                    },
                        {
                            title: 'Lunch',
                            start: new Date(y, m, d + 14, 12, 0),
                            end: new Date(y, m, d, 14, 0),
                            allDay: false
                    },
                        {
                            title: 'Birthday Party',
                            start: new Date(y, m, d + 1, 19, 0),
                            end: new Date(y, m, d + 1, 22, 30),
                            allDay: false
                    }, {
                        title: 'Birthday Party',
                        start: new Date(y, m, d + 1, 19, 0),
                        end: new Date(y, m, d + 1, 22, 30),
                        allDay: false
                },
                        {
                            title: 'Click for Google',
                            start: new Date(y, m, 28),
                            end: new Date(y, m, 29),
                            url: 'http://google.com/'
                    }
                ]
                });
            });
        </script>
    </body>

</html>