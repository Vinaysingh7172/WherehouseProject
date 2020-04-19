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

				<h3>WELCOME TO PURCHASE ORDER REGISTER PAGE</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST"
					modelAttribute="purchaseOrder">
					<div class="row">
						<div class="col-4">
							<label for="shipOb.shipId">Shipment Code:</label>

						</div>
						<div class="col-4">
							<form:select path="shipOb.shipId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${shipMap}" />
							</form:select>

						</div>
						<div class="col-4"></div>
						<!-- Error Message -->
					</div>

					<div class="row">
						<div class="col-4">
							<label for="whVendorOb.whuId"> Vendor:</label>
						</div>
						<div class="col-4">
							<form:select path="whVendorOb.whuId" class="form-control">

								<form:option value="">-SELECT-</form:option>

								<form:options items="${whVenMap}" />
							</form:select>

						</div>
						<div class="col-4"></div>
						<!-- Error Massage -->
					</div>
					<div class="row">
						<div class="col-4">
							<label for="refNum">Reference Number:</label>
						</div>
						<div class="col-4">
							<form:input path="refNum" />
						</div>
						<div class="col-4">
							<!-- Error Massage -->
						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for="qltyCheck">Quality Check:</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qltyCheck" value="Required" />
							Required
							<form:radiobutton path="qltyCheck" value="Not Required" />
							Not Required
						</div>
						<div class="col-4">
							<!-- Error Massage -->
						</div>

					</div>

					<div class="row">
						<div class="col-4">
							<label for="defStatus"> Default Status:</label>
						</div>
						<div class="col-4">
							<form:input path="defStatus" />
						</div>
						<div class="col-4">
							<!-- Error Massage -->
						</div>

					</div>



					<div class="row">
						<div class="col-4">
							<label for="description"> Description:</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" />
						</div>
						<div class="col-4">
							<!-- Error Massage -->
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

		</div>
	</div>

</body>
</html>


