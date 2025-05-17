<%@page import="java.util.List"%>
<%@page import="com.example.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged Page</title>
<link rel="stylesheet" type="text/css" href="/css/login_dashboard.css" />
</head>
<body>
	<%
	String reg = (String) session.getAttribute("reg");
	Student stu = (Student) request.getAttribute("student");
	List<Student> list = (List<Student>) request.getAttribute("list");
	%>
	<div id="container">
		<div id="sub-container">
			<img src="fetchImage?reg=<%=reg%>" alt="Profile Picture" />
			<div style="display: flex; flex-direction: row;">
				<a href="/logout"><button
						style="background-color: red; color: white; font-size: 1rem; border-radius: 5px; padding: 3px 8px; margin: 15px 15px 0px 15px;">Logout</button></a>
				<a href="/updatePage"><button
						style="background-color: yellow; color: red; font-size: 1rem; border-radius: 5px; padding: 3px 8px; margin: 15px 15px 0px 15px;">Update</button></a>
			</div>
			<div id="details">
				<table bgcolor="violet">
					<tr>
						<th colspan="2">REGISTRATION NUMBER</th>
					</tr>
					<tr>
						<td colspan="2" align="center"><%=stu.getReg()%></td>
					</tr>
					<tr>
						<th>ID</th>
						<th>NAME</th>
					</tr>
					<tr>
						<td><%=stu.getId()%></td>
						<td><%=stu.getName()%></td>
					</tr>

					<tr>
						<th>EMAIL</th>
						<th>PHONE</th>
					</tr>
					<tr>
						<td><%=stu.getEmail()%></td>
						<td><%=stu.getPhone()%></td>
					</tr>

				</table>
			</div>
		</div>
		<%
		if (list != null && list.size() > 1) {
		%>
		<div id="details" style="border: none;">
			<table align="center" bgcolor="lightyellow">
				<tr>
					<th colspan="6" style="color:red; font-size: 2rem;">All Student List</th>
				</tr>

				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>REGISTRATION No.</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>PROFILE</th>
				</tr>

				<%
				for (Student s : list) {
					if (s.getReg().equals(reg))
						continue;
				%>
				<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getReg()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getPhone()%></td>
					<td><img src="fetchImage?reg=<%=s.getReg()%>"
						alt="Profile Picture"
						style="width: 100px; height: 100px; border: 2px double lightgreen" />
					</td>
				</tr>
				<%
				}
				%>


			</table>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>