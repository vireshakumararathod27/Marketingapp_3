<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create lead</title>
</head>
<body>
<h2>Create New  Lead</h2>
	<form action = "saveLead" method="post">
		<pre>
			First name <input type = "text" name = "firstName"/>
			Last name <input type = "text" name = "lastName"/>
			Email <input type = "text" name = "email"/>
			Mobile <input type = "text" name = "mobile"/>
				<input type="submit" value = "save"/>
			
		</pre>		

	</form>
	${msg}

</body>
</html>