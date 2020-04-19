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
<h3>WELCOME TO WHUser TYPE EDIT PAGE</h3>
<form:form action="update"  method="POST"
       modelAttribute="wHUserType">
       <pre>
       <form:input path="whuId" readOnly="true"/>
       User Type:
<form:radiobutton path="userType" value="Vendor"/>Vendor
<form:radiobutton path="userType" value="Customer"/>Customer
User Code:
<form:input path="userCode"/>
User Email:
<form:input path="userMail"/>
User Contact:
<form:input path="userContact"/>
UserId Type:
<form:select path="userIdType">
<form:option value="">--SELECT--</form:option>
<form:option value="PANCARD">PANCARD</form:option>
<form:option value="ADHAR">ADHAR</form:option>
<form:option value="VOTERID">VOTERID</form:option>
<form:option value="OTHER">OTHER</form:option>
</form:select>
*If Other:
<form:input path="ifOther"/>
ID Number:
<form:input path="idNumber"/>
<input type="submit" value="UPDATE" />
       </pre>
       </form:form>
</body>
</html>

