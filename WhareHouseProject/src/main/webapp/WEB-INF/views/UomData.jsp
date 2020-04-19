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
<h3>WELCOME TO UOM DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>UOM ID</th>
 <th>UOM TYPE</th>
 <th>UOM MODEL</th>
 <th>DESCRIPTION</th>
 </tr>
 <!-- for(Part ob:list){} -->
 <c:forEach items="${list}" var="ob">
 <tr>
 <td>${ob.uomid}</td>
 <td>${ob.uomType}</td>
 <td>${ob.uomModel}</td>
 <td>${ob.note}</td>
 <td>
 </td>
 <td>
 <a href="delete?umid=${ob.uomid}">DELETE</a>
 </td>
 <td>
 <a href="edit?umid=${ob.uomid}">EDIT</a>
 </td>
 <td>
 <a href="view?umid=${ob.uomid}">VIEW</a>
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



