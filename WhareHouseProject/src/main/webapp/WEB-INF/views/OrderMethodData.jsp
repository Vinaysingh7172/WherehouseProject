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
<h3>WELCOME TO ORDER METHOD DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>ID</th>
 <th>ORDER MODE</th>
 <th>ORDER CODE</th>
 <th>ORDER METHOD</th>
 <th>ORDER ACCEPT</th>
 <th>DESCRIPTION</th>
 </tr>
 <!-- for(ShipmentType ob:list){} -->
 <c:forEach items="${list}" var="ob">
 <tr>
 <td>${ob.orderId}</td>
 <td>${ob.orderMode}</td>
 <td>${ob.orderCode}</td>
 <td>${ob.orderType}</td>
 <td>${ob.orderAcpt}</td>
 <td>${ob.description}</td>
 <td>
 </td>
 <td>
 <a href="delete?omid=${ob.orderId}">DELETE</a>
 </td>
 <td>
 <a href="edit?omid=${ob.orderId}">EDIT</a>
 </td>
 <td>
 <a href="view?omid=${ob.orderId}">VIEW</a>
 </td>
 </c:forEach>
</table>
</c:when>
<c:otherwise>
<h4>NO DATA FOUND !!</h4>
</c:otherwise>
</c:choose>
</body>
</html>




