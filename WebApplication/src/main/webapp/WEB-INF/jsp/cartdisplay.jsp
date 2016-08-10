<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<script type="text/javascript">
	function getDiscount(totalValue) {
		
		 var ajaxRequest; // The variable that makes Ajax possible!

		try {
			// Opera 8.0+, Firefox, Safari
			ajaxRequest = new XMLHttpRequest();
			
		} catch (e) {
			// Internet Explorer Browsers
			/* try {
				ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					// Something went wrong
					alert("Your browser broke!");
					return false;
				} 
			}*/
		}

		// Create a function that will receive data sent from the server
	 	ajaxRequest.onreadystatechange = function() {
			if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
				//alert(totalValue);
				var r = ajaxRequest.responseText;
				var s = r.split(";");
				document.getElementById("discountTotal").innerHTML = s[1];
				document.getElementById("discount").innerHTML = s[0];
				document.getElementById("d").innerHTML = "After Discount";
				document.getElementById("submit").style.display = 'block';
				document.getElementById("discountValue").value=s[1];
				console.log(s);
				console.log("Here");
			}
		}; 
		//alert(ajaxRequest.open("GET", "AvailDiscount?discountTotal=" + totalValue, true));
		ajaxRequest.open("GET", "AvailDiscount?discountTotal=" + totalValue, true);
		ajaxRequest.send(null);
	}
</script>
<style type="text/css">body{
background-image: url(http://www.catheylegal.com/publishImages/Choose-a-service-to-order~~element95.png);
background-size: cover;
}</style>
</head>
<body><jsp:include page="header.jsp"></jsp:include><br><br><br>
	<form:form action="checkOUT" method="get" commandName="cart">
		<table width="700px" border="1" align="center"><tr><th>Product</th><th>Price</th></tr>
			<c:forEach var="item" items="${cartList}">
				<tr>

					<%--	<td> <form:checkboxes  path="cartlist" 
								items="${cart.cartlist}" var="item" itemLabel="productName" element="div" />  </td>--%>
					<td>${item.productName}</td>
					<td>${item.price}</td>
				</tr>

			</c:forEach>
			<tr>
				<td >Total : <input type="hidden" name="total" 
					value="${total}"></input></td><td>${total}</td>
			</tr>
			<tr >
				<td colspan="2" id="d">Registered Servicer Provider?<a
					href="javascript:getDiscount(${total});"> Click Here For
						Discount</a></td>
			</tr>
			<tr>
				<td >Discount Percentage : </td><td id="discount"></td>
			</tr>
			<tr>
				<td > Total Amount: </td><td id="discountTotal" 
					></td>
			</tr>
			
		</table><br>
		<div align="center"><input type="hidden" id="discountValue" name="discountValue" value="0"></input>
<input type="submit" id="submit" name="submit" value="CheckOut" ></div>
	</form:form>
	
</body>
</html>