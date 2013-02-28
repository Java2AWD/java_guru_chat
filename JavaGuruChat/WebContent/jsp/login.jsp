<jsp:include page="/jsp/header.jsp" />
</head>
<%@ page import="com.seventysevenagency.chat.models.LoginModel" %>
<body>
	<h1>Login</h1>
	<form name="login" method="post">
		<label for="username">Username:</label> <input type="text"
			name="username" id="username" /> <label for="password">Password:</label>
		<input type="password" name="password" id="password" /> <input
			type="submit" name="submit" value="Login" />
	</form>
	<% LoginModel model = (LoginModel) request.getAttribute("model"); %>
	<%= model.getLogin() %>
	
	<%
		String csuccess = (String) request.getAttribute("registered");
		if (csuccess != null) {
	%>
	<div class="success">
		<%=csuccess%>
	</div>
	<%
		}
	%>
	<%
		String cerror = (String) request.getAttribute("error");
		if (cerror != null) {
	%>
	<div class="error">
		<%=cerror%>
	</div>
	<%
		}
	%>
	<a href="register">Register</a>
</body>
</html>