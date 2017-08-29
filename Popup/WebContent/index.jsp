<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
<div class="row">
<!-- popup box modal starts here -->
<div class="modal fade form-popup" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content">
<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<h3 class="modal-title">ENQUIRY FORM</h3>
</div>
<div class="modal-body">
<!-- form code starts here -->
<form class="form-horizontal tpad" role="form">
<div class="form-group">
<label for="email" class="col-lg-3 control-label">EMAIL</label>
<div class="col-lg-9">
<input type="email" class="form-control" id="email" placeholder="EMAIL">
</div>
</div>
<div class="form-group tpad">
<label for="message" class="col-lg-3 control-label">Message</label>
<div class="col-lg-9">
<textarea class="form-control" rows="6" id="message" placeholder="MESSAGE..."></textarea>
</div>
</div>
<div class="form-group tpad">
<div class="col-lg-offset-3 col-lg-9">
<a data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Send</a>
</div>
</div>
</form>
<!-- form code ends here -->
</div>
<div class="modal-footer">
<a href="http://www.google.com">FOOTER</a>
</div>
</div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal-->
<!-- popup box modal ends -->
</div>
</div>
</body>
</html>