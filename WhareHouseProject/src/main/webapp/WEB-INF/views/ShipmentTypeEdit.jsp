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
			<div class="card-header bg-primary text-center text-white text-uppercase">
				<h3>WELCOME TO SHIPMENT TYPE EDIT PAGE</h3>
					</div>
				<div class="card-body">
					<form:form action="update" method="POST"
						modelAttribute="shipmentType">
						<div class="row">
							<div class="col-4">
								<label for="shipId">ShipmentId:</label>
							</div>
							<div class="col-4">
								<form:input path="shipId" readOnly="true" />
							</div>
							<div class="col-4">
								<!-- 	Error Message -->
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for=shipMode>Shipment Mode:</label>
							</div>
							<div class="col-4">
								<form:select path="shipMode">
									<form:option value="">--SELECT--</form:option>
									<form:option value="Air">Air</form:option>
									<form:option value="Truck">Truck</form:option>
									<form:option value="Ship">Ship</form:option>
									<form:option value="Train">Train</form:option>
								</form:select>
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="shipCode">Shipment Code:</label>
							</div>
							<div class="col-4">
								<form:input path="shipCode" />
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="enbShip">Enable Shipment:</label>
							</div>
							<div class="col-4">

								<form:select path="enbShip">
									<form:option value="">--SELECT--</form:option>
									<form:option value="YES">YES</form:option>
									<form:option value="No">NO</form:option>
								</form:select>
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="shipGrad"> Shipment Grade:</label>
							</div>
							<div class="col-4">
								<form:radiobutton path="shipGrad" value="A" />
								A
								<form:radiobutton path="shipGrad" value="B" />
								B
								<form:radiobutton path="shipGrad" value="C" />
								C
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>

						<div class="row">
							<div class="col-4">
								<label for="shipDesc"> Description: </label>
							</div>
							<div class="col-4">
								<form:textarea path="shipDesc" />
							</div>
							<div class="col-4">
								<!-- Error Message -->
							</div>
						</div>
						<div class="row">
							<div class="col-4"></div>
							<div class="col-4">
								<input type="submit" value="UPDATE" class="btn btn-success" />


							</div>
						</div>
					</form:form>
					<div class="card-footer bg-info text-white text-center"></div>
				</div>

		

		</div>
		<!-- card end  -->
	</div>
	<!-- container end  -->
</body>
</html>


