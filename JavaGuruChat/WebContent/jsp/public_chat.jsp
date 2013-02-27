<jsp:include page="/jsp/header.jsp" />
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
</html>