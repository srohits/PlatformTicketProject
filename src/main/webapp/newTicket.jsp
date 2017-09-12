<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table#nat {
	width: 50%;
	background-color: #c48ec5;
}
</style>

</head>
<body>
	<%
		String name = (String)session.getAttribute("username");
	%>
	<div align="center" style="margin-top: 50px;">

		<h1 >
			Welcome
			<%=name%>
			to online ticket
		</h1>
		
		<form method="post" action="TicketControl">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td>
                        <select name="state">
                         <option value="U.P." name="state">Uttar Pradesh</option>
                        </select>
                    </tr>
                    <tr>
                     <td>District</td>
                     <td>
                     <select name="district">
                      <option value="ghaziabad" name="ghaziabad">GHAZIABAD</option>
                      <option value="merrut" name="merrut">MERRUT</option>
                      <option value="hapur" value="hapur">HAPUR</option>
                     </select>

                     </td>
                    </tr>
                    <tr>
                       <td>Number of tickets</td>
                       <td><input type="number" name="tn" min="1" max="50"/>
                    </tr>
                    <tr>
                       <td><input type="submit" value="Print"/></td>
                    </tr>
              
                </tbody>
            </table>
            </center>
        </form>

	</div>


</body>
</html>