<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>LIST</h1>

	<table>

		
			<tr>
				<th>ID <br /></th>
				<th>DESCRIPTION <br /></th>
				<th>COMPANY <br /></th>
				<th>DATE <br /></th>
				<th>PRICE <br /></th>
			</tr>
				<c:forEach var="row" items="${receipts}">	
			<tr>
			<th>${row.id} </th>
			<th>${row.description} </th>
			<th>${row.company} </th>
			<th>${row.date} </th>
			<th>${row.price} </th>
			</tr>
			
		</c:forEach>

	</table>

</body>
</html>