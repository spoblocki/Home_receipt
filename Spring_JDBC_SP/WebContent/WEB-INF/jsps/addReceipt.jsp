<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="${pageContext.request.contextPath}/doCreate">

		<table>
			<tr>
				<td>Description:</td>
				<td><input name="description" type="text" /></td>
			</tr>
			<tr>
				<td>Company:</td>
				<td><input name="company" type="text" /></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input name="date" type="text" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input name="price" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create receipt" type="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>