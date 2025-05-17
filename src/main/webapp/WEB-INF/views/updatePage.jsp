<%@page import="java.util.List"%>
<%@ page import="com.example.entity.Student"%>
<html>
<head>
<title>Update Student Data</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/registerPage.css" />
<body>
	<%
	String reg = (String) session.getAttribute("reg");
	Student stu = (Student) request.getAttribute("stu");
	%>
	<div id="container">
		<h1>Fill Student's Details</h1>
		<div id="sub-container">
			<div id="cards">
				<form action="update" method="post" enctype="multipart/form-data">
					<input type="hidden" name="reg" value="<%=reg%>" />
					<div class="filed">
						<label for="name">Change Name: </label><input type="text"
							name="name" value="<%=stu.getName()%>" autofocus />
					</div>
					<div class="filed">
						<%
						String emailMsg = (String) session.getAttribute("emailMsg");
						if (emailMsg != null) {
						%>
						<p style="color: red;"><%=emailMsg%></p>
						<%
						}
						%>
						<label for="email">Change Email: </label><input type="email"
							name="email" value="<%=stu.getEmail()%>" />
					</div>
					<div class="filed">
						<%
						String phoneMsg = (String) session.getAttribute("phoneMsg");
						if (phoneMsg != null) {
						%>
						<p style="color: red;"><%=phoneMsg%></p>
						<%
						}
						%>
						<label for="phone">Change Phone: </label><input type="tel"
							name="phone" value="<%=stu.getPhone()%>" />
					</div>
					<div class="filed">
						<label for="password">Change Password: </label><input
							type="password" name="password" />
					</div>
					<div class="filed">
						<label for="image">Change Photo: </label><input type="file"
							name="image" />
					</div>
					<button>Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
