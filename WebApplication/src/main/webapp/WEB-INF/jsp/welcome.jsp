
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="Checkout" method="get" commandName="cart">
			<table>
				<%-- <c:forEach var="items" items="${ProductInfo.cartlist}"> --%>
					<tr>

						<td><form:checkboxes  path="cartlist" 
								items="${items}" element="div" /> </td>
								<%-- <td>${items.productName}</td> --%>
					</tr>
				<%-- </c:forEach> --%>
			</table>
			<input type="submit" value="Buy!">
		</form:form>
</body>
</html>