<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JG Chat</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<h1>Chatroom</h1>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span6">
				<div class="span4">
					<textarea rows="10" cols="20"></textarea>
				</div>
				<div class="span2 userlist">
					<ul>
						<li>Test user</li>
						<li>Test user</li>
						<li>Test user</li>
						<li>Test user</li>
					</ul>
				</div>
			</div>				
		</div>
		<div class="row-fluid">
			<div class="span6">
				<form method="POST" action="">
					<div class="span4">
						<input type="text" name="message" required/>
					</div>
					<div class="span2">
    					<button type="submit" class="btn">Submit</button>
					</div>
				</form>
			</div>		
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>