<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Input Screen</title>
	</head>
	<body bgcolor="#aaafff" text="black"> 
		<form action="MyServlet" method="post">
		<table border="3" cellspacing="4" cellpadding="3">
		<tr><td>Enter the number of supply entities: <input type="text" name="m" maxlength="4" size="4" /></td></tr>
		<tr><td>Enter the number of demand entities: <input type="text" name="n"maxlength="4" size="4" /></td></tr>
		</table>
		<h3>Enter the cost matrix:</h3>
		<% int m=Integer.parseInt(request.getParameter("m")); 
		int n=Integer.parseInt(request.getParameter("n"));
		int a=0,b=0,c=0;
		%>
		<table border="3" cellspacing="0" cellpadding="3">
		<% for(int i = 0; i < m; i+=1) { %>
			<tr>
				<% for(int j = 0;j < n; j++) { %>
					<td colspan="1"><input type="text" name="a<%=a%>" maxlength="4" size="4" /></td>
					<% a++; %>
				<% } %>
			</tr>
		<% } %>
		</table>
		</br>
		<h4>Enter the supply:</h4>
		<table border="3" cellspacing="3" cellpadding="3">
			<% for(int i=0;i<m;i++){ %>
				<tr><td colspan="1"><input type="text" name="b<%=b%>" maxlength="4" size="4" /></td></tr> 
			<% b++; %>
			<% } %>
		</table>
		<h4>Enter the demand:</h4>
		<table border="3" cellspacing="3" cellpadding="3">
			<% for(int i=0;i<n;i++){ %>
				<tr><td colspan="1"><input type="text" name="c<%=c%>" maxlength="4" size="4"/></td></tr> 
			<% c++; %>
			<% } %>
		</table>
		</br>
		<input type="submit" value="Send"  />
		</form>
	</body>
</html>