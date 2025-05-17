<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="/css/loginPage.css" />
</head>
<body>

	<div id="container">
		<h1>Login Details</h1>
		<%
		String msg = (String) request.getAttribute("message");
		if (msg != null) {
		%>
		<p style="color: red;"><%=msg%></p>
		<%
		}
		%>

		<div id="login">
			<form action="login" method="post">
				<div class="filed">
					<label for="reg">Registration no: </label><input type="text"
						name="reg" />
				</div>
				<div class="filed">
					<label for="password">Password: </label><input type="password"
						name="password" />
				</div>
				<button>Login</button>
			</form>
		</div>
	</div>
	<a href="/"><button
			style="margin-left: 47.5%; background-color: yellow; color: red; margin-top: 20px;">Home</button></a>
</body>
</html>