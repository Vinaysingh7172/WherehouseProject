<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp"%>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-center text-white text-uppercase">
<H3>WELCOME TO SHIPMENT TYPE VIEW PAGE</H3>
</div>
</div>

</div>

<a href="excel?id=${ob.shipId}"><img src="../resources/images/excel.png" width="30" height="30"/></a>
<a href="pdf?id=${ob.shipId}"><img src="../resources/images/pdf.png" width="30" height="30"/></a>
<table border="1">
<tr>
<th>ID</th>
<td>${ob.shipId}</td>
</tr>
<tr>
<th>MODE</th>
<td>${ob.shipMode}</td>
</tr>
<tr>
<th>CODE</th>
<td>${ob.shipCode}</td>
</tr>
<tr>
<th>ENABLE</th>
<td>${ob.enbShip}</td>
</tr>
<tr>
<th>GRADE</th>
<td>${ob.shipGrad}</td>
</tr>
<tr>
<th>NOTE</th>
<td>${ob.shipDesc}</td>
</tr>
</table>
</body>
</html>


