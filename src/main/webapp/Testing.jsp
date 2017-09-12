<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="Exception.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Example</title>
</head>
<body>
	<!--Scriplet Tag  -->
	<%
		out.println("Welcome to JSP Scriplet");
	%>
	</br>

	<!--Expression Tag  -->
	Current Time using Expression Tag:<%=java.util.Calendar.getInstance().getTime()%>
	</br>

	<!-- Declaration Tag  -->
	<%!int cube(int n) {
		return n * n * n;
	}%>
	<%="Cube of 3 using Declaration Tag: " + cube(3)%>
	</br>

	<!-- Exceptions  -->
	<%
		String num1 = "10";
		String num2 = "10";
		int v1 = Integer.parseInt(num1);
		int v2 = Integer.parseInt(num2);
		int res = v1 / v2;
		out.print("Output is: " + res);
	%>
	</br>
	<!-- Response -->
	<%
		if (false)
			response.sendRedirect("http://www.google.com");
	%>
	</br>
	<!-- Application implicit Object -->
	<%
		String database = application.getInitParameter("database_name");
		out.print("DataBase name is=" + database);
	%>
	
	<!-- Include  -->
	 <%@ include file="reg.jsp" %>
	 
</body>
</html>