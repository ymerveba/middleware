<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
<style type="text/css">
body{
background-image: url(http://www.catheylegal.com/publishImages/Choose-a-service-to-order~~element95.png);
background-size: cover;
}
</style>

</head>
<body>
<div >
	<jsp:include page="header.jsp"></jsp:include>
</div>


	<!-- <a href="displayServices">OptedServices</a> -->
	<div align="center">
		<br>
		<br>
		<br>
		<h3>CHOOSE YOUR SERVICE PROVIDERS</h3>
		<form name="frm" method="get" action="getServiceProvider">
			<select name="serviceID" onchange="this.form.submit();">
				<option value="Select Service">Select Service
					<c:forEach var="item" items="${services}">
						<option value="${item.id}">${item.serviceName}</option>
					</c:forEach>
			</select>



		</form>
	</div>
	
	<div align="center">
		<c:if test="${not empty none}"><br><br>
			<b>No Service Providers Found!!</b>
		</c:if></div>
		<c:if test="${not empty serviceProviders}">
		<br>
			<form action="selectServices">
				<input type="hidden" name="serviceID" value="${serviceID}">
				<table cellpadding="6px" align="center" border="1"><tr>
				<th>Select</th>
					<th>Service Provider</th>
					<th>EmailID</th>
					<th>Rating</th></tr>
					<c:forEach var="item" items="${serviceProviders}">
						<tr><td><input type="radio" name="serviceProviderID"
								value="${item.sp_id}"></td>
							<td>${item.serviceProvider}</td>
							<td>${item.serviceProviderEmail}</td>
							<td>${item.rating}/5 (${item.numberOfRating} users)</td>
							
							
							</tr>
							
					</c:forEach>
					<tr align="right"><td colspan="4"><input type="submit" value="Select"></td></tr>
				</table>
				
			</form>
		</c:if>
	
</body>
</html>