<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H3>WELCOME TO PART VIEW PAGE</H3>
<table border="1">
<tr>
<th>ID</th>
<td>${ob.partId}</td>
</tr>
<tr>
<th>PART CODE</th>
<td>${ob.partCode}</td>
</tr>
<tr>
<th>LENGTH</th>
<td>${ob.partLen}</td>
</tr>
<tr>
<th>WIDTH</th>
<td>${ob.partWid}</td>
</tr>
<tr>
<th>HEIGHT</th>
<td>${ob.partHgt}</td>
</tr>
<tr>
<th>BASE COST</th>
<td>${ob.baseCost}</td>
</tr>
<tr>
<th>CURRENCY</th>
<td>${ob.baseCurrency}</td>
</tr>
<tr>
<th>DESCRIPTION</th>
<td>${ob.note}</td>
</tr>

</table>
</body>
</html>

