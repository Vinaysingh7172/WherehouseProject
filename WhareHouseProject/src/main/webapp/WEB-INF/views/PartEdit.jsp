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
<h3>WELCOME TO PART EDIT PAGE</h3>
<form:form action="update"  method="POST"
       modelAttribute="part">
       <pre>
       <form:input path="partId" readOnly="true"/>
       Part Code:
<form:input path="partCode" />
Dimensions:
Width<form:input path="partWid" />
Length<form:input path="partLen" />
Height<form:input path="partHgt" />

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
<input type="submit" value="UPDATE" />
       </pre>
       </form:form>
</body>
</html>

