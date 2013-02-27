<jsp:include page="/jsp/header.jsp" />
</head>
<body>	 
	<h1>Register</h1>
	<form name="register" method="post">
		<div>
			<label for="username">Username:</label> <input type="text"
				name="username" id="username" value="<%= (request.getAttribute("username") == null) ? "" : request.getAttribute("username")%>" />
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" />
		</div>
		<div>
			<label for="repassword">Repeat password:</label> <input
				type="password" name="repassword" id="repassword" />
		</div>
		<div>
			<label for="name">Name:</label> <input
				type="text" name="name" id="name" value="<%= (request.getAttribute("name") == null) ? "" : request.getAttribute("name")%>"/>
		</div>
		<div>
			<label for="surname">Surname:</label> <input
				type="text" name="surname" id="surname" value="<%= (request.getAttribute("surname") == null) ? "" : request.getAttribute("surname")%>"/>
		</div>
		<div>
			<label for="email">Email:</label> <input
				type="text" name="email" id="email" value="<%= (request.getAttribute("email") == null) ? "" : request.getAttribute("email")%>"/>
		</div>
		<%
			String cerror = (String) request.getAttribute("error");
			if (cerror != null) {
		%>
		<div class="error">
			<%=cerror%>
		</div>
		<% } %>
		
		<input type="submit" name="submit" value="Register" />
	</form>
	<a href="login">Login</a>
</body>
</html>