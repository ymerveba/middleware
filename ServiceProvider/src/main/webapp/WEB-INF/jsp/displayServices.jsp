<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Services</title>
<style type="text/css">
body{
background-image: url(http://www.catheylegal.com/publishImages/Choose-a-service-to-order~~element95.png);
background-size: cover;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${not empty incompleted}">
	<h3 align="center">IN COMPLETE SERVICES</h3>
		<table align="center"  border="1" width="800px">
			<tr>
				<th>Service Name</th>
				<th>Service Provider</th>
				<th>EmailID</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${incompleted}" var="item"><tr>
			
				<td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				<td>In Progress</td>
	</tr>
	</c:forEach></table></c:if><c:if test="${not empty completed}"><h3 align="center">COMPLETED </h3>
	<h4 align="center">Rate your service Provider</h4>
		<table align="center" border="1"width="800px">
			<tr>
				<th>Service Name</th>
				<th>Service Provider</th>
				<th>EmailID</th>
				<th>Rate</th>
			</tr>
			<c:forEach items="${completed}" var="item">
				<form:form action="rateSP" commandName="userServices">
			<tr><td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				
				<td><form:input path="rating" type="text"></form:input><input type="submit" value="Rate" onclick="this.form.submit();"></td>
				</tr>
			<form:input type="hidden" path="id" value="${item.id}"></form:input>
					<form:input type="hidden" path="service_id"
						value="${item.service_id}"></form:input>
					<form:input type="hidden" path="serviceProvider_id"
						value="${item.serviceProvider_id}"></form:input>
					<form:input type="hidden" path="spEmail" value="${item.spEmail}"></form:input>
					
				</form:form>
			</c:forEach>
		</table></c:if><c:if test="${not empty rated}">
		<h3 align="center">COMPLETED AND RATED</h3>
		<table align="center"  border="1" width="800px">
			<tr>
				<th>Service Name</th>
				<th>Service Provider</th>
				<th>EmailID</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${rated}" var="item"><tr>
	<td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				<td>Completed</td></tr>
	</c:forEach></table>
	</c:if>
	<c:if test="${results!=''}">
	No Services Found!!!
	</c:if>
</body>
</html>