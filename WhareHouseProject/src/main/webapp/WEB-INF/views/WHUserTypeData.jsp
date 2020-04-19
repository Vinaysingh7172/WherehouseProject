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
<h3>WELCOME TO WHUser TYPE DATA PAGE</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
 <th>ID</th>
 <th>USER TYPE</th>
 <th>USER CODE</th>
 <th>USER MAIL</th>
 <th>USER CONTACT</th>
 <th>USER ID TYPE</th>
 <th>*IF OTHER</th>
  <th>ID NUMBER</th>
 </tr>
 <!-- for(WHUserType ob:list){} -->
 <c:forEach items="${list}" var="ob">
 <tr>
 <td>${ob.whuId}</td>
 <td>${ob.userType}</td>
 <td>${ob.userCode}</td>
 <td>${ob.userMail}</td>
 <td>${ob.userContact}</td>
 <td>${ob.userIdType}</td>
 <td>${ob.ifOther}</td>
 <td>${ob.idNumber}</td>
 <td>
 </td>
 
 <td>
  <a href="delete?wid=${ob.whuId}">DELETE</a>
 </td>
 <td>
  <a href="edit?wid=${ob.whuId}">EDIT</a>
 </td>
 <td>
  <a href="view?wid=${ob.whuId}">VIEW</a>
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


