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
<h3>WELCOME TO PART DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>ID</th>
 <th>CODE</th>
 <th>LENGTH</th>
 <th>WIDTH</th>
 <th>HEIGHT</th>
 <th>UOM MODEL</th>
 <th>ORDER SALE</th>
 <th>ORDER PURCHASE</th>
 <th>COST</th>
 <th>CURRENCY</th>
 <th>NOTE</th>
 </tr>
 <!-- for(Part ob:list){} -->
 <c:forEach items="${list}" var="ob">
 <tr>
 <td>${ob.partId}</td>
 <td>${ob.partCode}</td>
 <td>${ob.partLen}</td>
 <td>${ob.partWid}</td>
 <td>${ob.partHgt}</td>
 <td>${ob.uomOb.uomModel}</td>
 <td><c:out value="${ob.omSaleOb.orderCode}" /></td>
 <td><c:out value="${ob.omPurchaseOb.orderCode}" /></td>
 <td>${ob.baseCost}</td>
 <td>${ob.baseCurrency}</td>
 <td>${ob.note}</td>
 <td>
 </td>
 <td>
 <a href="delete?partId=${ob.partId}">DELETE</a>
 </td>
 <td>
 <a href="edit?partId=${ob.partId}">EDIT</a>
 </td>
 <td>
 <a href="view?partId=${ob.partId}">VIEW</a>
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

