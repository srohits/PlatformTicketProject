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
header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}
.anchorClass{
text-decoration: none;
}
li{
float:center;
}
li a{
display:block;
color: #000000;
text-align:center;
padding:16px;
text-decoration:none;
}
li a:hover{
color:white;
background-color:#111111;
}
body{
background-color:#D3D3D3;
}
</style>
</head>
<body>

	<%
		//String name = request.getParameter("uname");
String name = (String)session.getAttribute("username");
	//String pass = request.getParameter("pass");
	%>
	<div align="center" style="margin-top: 50px;">
 <header>
  <h1>PLATFORM TICKET</h1>
 </header>
		<h1>
			Welcome
			<%=name%>
			to Platform Ticket Booking
		</h1>

	</div>

<ul>
 <li><a href= "MyProfileController" class="anchorClass">My Profile</a></li>
 <li><a href= "TicketControl" class="anchorClass">Book Ticket</a></li>
 <li><a href= "LogoutController" class="anchorClass">Log Out</a></li>


</ul>
</body>
</html>