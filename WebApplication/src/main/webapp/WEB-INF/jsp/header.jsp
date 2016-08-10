<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.table td:HOVER{
	background-color: white;
	
}

</style>
</head>
<body>
<table width=1000px bgcolor="grey" align="center" >
<tr>
<td>
<table class ="table" cellpadding="10px" bgcolor="grey" align="center"><tr><td>
<a href="welcomepage"><b>HOME</b></a></td><td>
<c:if test="${ empty User }" >
	<a href="login"> <b>login</b> </a></c:if>
	<c:if test="${not empty User}"><b>${User.userID}</b>
	<a href="logout"><b>Logout</b></a>
	</c:if></td></tr></table>
</td>
</tr>
</table>
</body>
</html>