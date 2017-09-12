<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ttnd.workshop.entities.User" %>
    <%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.Profile{
background-color:#D3D3D3;
text-align:center;
font-family:times;

}
header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

</style>
<body>


<%
User user = (User) session.getAttribute("userdata");
String FirstName = user.getFirstName();
String LastName = user.getLastName();
String Email = user.getEmail();
Date LastLogin = (Date)user.getLastLogin();
%>
 <header>
  <h1>PROFILE</h1>
 </header>
<div class="Profile">
<h3>
			
			NAME        : <%=FirstName%> <%=LastName%><br>
			EMAIL ID    : <%=Email%><br>
			LAST LOGIN  : <%=LastLogin%><br>
			
			
		</h3>
		</div>
		<%
	
		
		%>
<form method="post" action="LogoutController">
<input type="submit" value="Change Password"></input>
</form>
</body>
</html>