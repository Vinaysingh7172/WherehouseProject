
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>WELCOME TO ORDER METHOD REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="orderMethod">
					<div class="row">
						<div class="col-4"></div>
						<label for="orderMode">Order Mode:</label>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="Sale" />
							Sale
							<form:radiobutton path="orderMode" value="Purchase" />
							Purchase
						</div>
						<div class="col-4">
							<!-- Error Message -->

						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for="orderCode">Order Code:</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" />
						</div>
						<div class="col-4">

							<!-- Error Message -->
						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for="orderType ">Order Type:</label>
						</div>
						<div class="col-4">
							<form:select path="orderType">
								<form:option value="">--SELECT--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
							`
						</div>
						<div class="col-4">

							<!-- Error Massage -->
						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for=" orderAcpt">Order Accept:</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAcpt" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="orderAcpt" value="Accept Return" />
							Accept Return
						</div>
						<div class="col-4">

							<!-- Error Message -->
						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for=" description">Description:</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" />
						</div>
						<div class="col-4">
							<!-- Error Message -->

						</div>

					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" />
						</div>
					</div>



				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
			<!-- card End -->
		</div>
		<!-- Container End -->
	</div>

</body>
</html>



