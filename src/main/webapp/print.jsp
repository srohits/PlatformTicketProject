<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your ticket</title>

<style>
header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}
.container
{
background:lightgrey;
color:#000000;
padding: 25px;
margin: 25px;

}
</style>
</head>
<body>
  <header>
  <h1>PLATFORM TICKET</h1>
 </header>
<%
String username = request.getParameter("uname");
String state = request.getParameter("state");
String district = request.getParameter("district");
//String totaltic = request.getParameter("tn");
String cost = request.getParameter("ti");
%>
<div class=container>
<ul>
<li>
 <p>
  <b>Passenger Name:</b>
   <%=username %>
 </p>  
</li>
<li>
 <p>
  <b>State:</b>
   <%=state %>
 </p>  
</li>
<li>
 <p>
  <b>District:</b>
   <%=district %>
 </p>  
</li>

<li>
 <p>
  <b>Total Cost:</b>
	<%=cost %>
 </p>  
</li>
<li>
<a href="Welcome.jsp">Exit</a> 
</li>
</div>
</body>
</html>