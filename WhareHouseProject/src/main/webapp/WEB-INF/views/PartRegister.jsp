<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO PART REGISTER PAGE</h3>
	<form:form action="save" method="POST" modelAttribute="part">
		<pre>
Part Code:
<form:input path="partCode" />
Dimensions:
Width<form:input path="partWid" />
Length<form:input path="partLen" />
Height<form:input path="partHgt" />

<form:label path="uomOb">Uom</form:label>
<form:select path="uomOb.uomid" class="form-control">
<form:option value="">-SELECT-</form:option>
<form:options items="${uomMap}"/>
</form:select>

Order Sale:
<form:select path="omSaleOb.orderId" class="form-control">

<form:option value="">-SELECT-</form:option>

<form:options items="${omSaleMap}" />

</form:select>

Order Purchase:
<form:select path="omPurchaseOb.orderId" class="form-control">

<form:option value="">-SELECT-</form:option>

<form:options items="${omPurchaseMap}" />

</form:select>

Base Cost:
<form:input path="baseCost" />
Base Currency:
<form:select path="baseCurrency">
<form:option value="">--SELECT--</form:option>
<form:option value="INR">INR</form:option>
<form:option value="USD">USD</form:option>
<form:option value="AUS">AUS</form:option>
<form:option value="ERU">ERU</form:option>
</form:select>`
Description:
<form:input path="note" />
<input type="submit" value="Create" />


	</pre>
	</form:form>
	${message}
</body>
</html>


