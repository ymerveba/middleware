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
<div >
	<jsp:include page="header2.jsp"></jsp:include>
</div>

<!-- <div align="right">
	<a href="logout" >Logout</a>
</div> -->
	<c:if test="${not empty incompleted}">
	<h3 align="center">Requests Receieved </h3>
	
		<table align="center" border="1"width="800px">
			<tr>
				<th>Service Name</th>
				<th>Customer Name</th>
				<th>EmailID</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${incompleted}" var="item">
				<form:form action="changeStatus" commandName="userServices">
			<tr><td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				
				<td><form:select path="status" type="text" onchange="this.form.submit();">
				<form:option value="0">NOT COMPLETED</form:option>
				<form:option value="1" >COMPLETED</form:option>
				</form:select></td>
				</tr>
			<form:input type="hidden" path="id" value="${item.id}"></form:input>
					<form:input type="hidden" path="service_id"
						value="${item.service_id}"></form:input>
					<form:input type="hidden" path="user_id"
						value="${item.user_id}"></form:input>
					<form:input type="hidden" path="spEmail" value="${item.spEmail}"></form:input>
					
				</form:form>
			</c:forEach>
		</table></c:if><c:if test="${not empty completed }">
		<hr>
		<h3 align="center">COMPLETED SERVICES</h3>
		<table align="center"  border="1" width="800px">
			<tr>
				<th>Service Name</th>
				<th>Customer Name</th>
				<th>EmailID</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${completed}" var="item"><tr>
			
				<td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				<td>Completed</td>
	</tr>
	</c:forEach></table></c:if><c:if test="${not empty rated }">
		<h3 align="center">COMPLETED AND RATED</h3>
		<table align="center"  border="1" width="800px">
			<tr>
				<th>Service Name</th>
				<th>Customer Name</th>
				<th>EmailID</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${rated}" var="item"><tr>
	<td>${item.serviceName}</td>
				<td>${item.spName}</td>
				<td>${item.spEmail}</td>
				<td>Completed and Rated</td></tr>
	</c:forEach></table>
	</c:if>
	<c:if test="${results!=''}">
	No Services Found!!!
	</c:if>
</body>
</html>