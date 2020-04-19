<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO UOM EDIT PAGE</h3>
<form:form action="update"  method="POST"
       modelAttribute="uom">
 <pre>
 <form:input path="uomid" readOnly="true"/>
 UomType:
<form:select path="uomType">
<form:option value="">--SELECT--</form:option>
<form:option value="PACKING">PACKING</form:option>
<form:option value="NO PACKING">NO PACKING</form:option>
<form:option value="-NA-">-NA-</form:option>
</form:select>`
UomModel
<form:input path="uomModel" />
Description:
<form:textarea path="note" />
<input type="submit" value="Update Uom" />
 </pre>      
 </form:form>
</body>
</html>


