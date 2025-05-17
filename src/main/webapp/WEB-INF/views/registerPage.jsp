<%@ page import="com.example.entity.Student"%>
<html>
<head>
<title>Register Student</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/registerPage.css" />
<body>
	<div id="container">
		<h1>Fill Student's Details</h1>
		<div id="sub-container">
			<div id="cards">
				<form action="register" method="post" enctype="multipart/form-data">
					<div class="filed">
						<label for="name">Name: </label><input type="text" name="name"
							autofocus />
					</div>
					<div class="filed">
						<label for="reg">Registration no: </label><input type="text"
							name="reg" />
					</div>
					<div class="filed">
						<label for="email">Email: </label><input type="email" name="email" />
					</div>
					<div class="filed">
						<label for="phone">Phone: </label><input type="tel" name="phone" />
					</div>
					<div class="filed">
						<label for="password">Password: </label><input type="password"
							name="password" />
					</div>
					<div class="filed">
						<label for="image">Profile pic: </label><input type="file"
							name="image" />
					</div>
					<button>Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
