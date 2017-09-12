<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
table#nat {
	width: 50%;
	background-color: #c48ec5;
}
</style>
</head>
<body>

	<%
		String name = request.getParameter("uname");
	
	%>
	<div align="center" style="margin-top: 50px;">

		<h1>
			Welcome
			<%=name%>
			to TTND Campus Connect
		</h1>

	</div>
<form  method="GET" action="MyProfileController">
<input type="submit" value="My Profile"></input>
</form>
</body>
</html>