<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO PURCHASE ORDER DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>PURCHASE ID</th>
 <th>ORDER CODE</th>
 <td>ENABLE SHIPMENT</td>
 <td>VENDOR</td>
 <th>REFERENCE NUMBER</th>
 <th>QUALITY CHECK</th>
 <th>DEFAULT STATUS</th>
 <th>DESCRIPTION</th>
 </tr>
 <!-- for(ShipmentType ob:list){} -->
 <c:forEach items="${list}" var="ob">
 <tr>
 <td>${ob.porderId}</td>
 <td>${ob.porderCode}</td>
  <td>${ob.shipOb.enbShip}</td>
  <td><c:out value="${ob.whVendorOb.whuId}" /></td>
 
 <td>${ob.refNum}</td>
 <td>${ob.qltyCheck}</td>
 <td>${ob.defStatus}</td>
 <td>${ob.description}</td>
 
 </c:forEach>
</table>
</c:when>
<c:otherwise>
<h4>NO DATA FOUND !!</h4>
</c:otherwise>
</c:choose>
</body>
</html>



