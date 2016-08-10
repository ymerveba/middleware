<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">

body{
background-image: url(http://www.catheylegal.com/publishImages/Choose-a-service-to-order~~element95.png);
background-size: cover;
}
</style>
</head>
<body><jsp:include page="header.jsp"></jsp:include><br><br><br>
<div align="center">
	<h2>List of All Products</h2>

	<%-- <c:if test="${not empty ProductInfo}"> --%>
	<form:form action="Checkout" method="get" commandName="cart">
		<table width="250px" cellpadding="10px"><tr>
		<th>
		ITEM
		</th><th>
		PRICE
		</th></tr>
			<c:forEach var="item" items="${items}">
				<tr>

					<%-- <td><form:checkboxes  path="cartlist" 
								items="${items}" itemLabel="NamePlusPrice"  
								itemValue="productID" element="div" > </td>
								 --%>
					<td><form:checkbox path="cartlist"
							label="${item.productName}" value="${item.productID}"/></td>
							<td>${item.price}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="ADD to CART">
	</form:form>
	<%-- </c:if> --%>

	<%-- Rmbr: ${cart} --%>
</div>
</body>
</html>