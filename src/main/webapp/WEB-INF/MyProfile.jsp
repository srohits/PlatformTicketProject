<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

String FirstName = request.getParameter("uname");
String LastName = request.getParameter("lastname");
String Email = request.getParameter("email");
String LastLogin = request.getParameter("lastlogin");


%>


<h1>
			
			NAME        : <%=FirstName%> <%=LastName%><br>
			EMAIL ID    : <%=Email%><br>
			LAST LOGIN  : <%=LastLogin%><br>
			
			
		</h1>
		<%
	
		
		%>
</body>

</html>