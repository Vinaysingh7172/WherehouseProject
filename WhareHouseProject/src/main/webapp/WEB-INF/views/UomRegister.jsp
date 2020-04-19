<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-center text-white text-uppercase">

<h3>WELCOME TO UOM REGISTER PAGE</h3>
</div>
<div class="card-body">
	<form:form action="save" method="POST" modelAttribute="uom">
<div class="row">
<div class="col-4">
<label for="uomType">UomType:</label>
</div>
<div class="col-4">
<form:select path="uomType" class="form-control">
<form:option value="">--SELECT--</form:option>
<form:option value="PACKING">PACKING</form:option>
<form:option value="NO PACKING">NO PACKING</form:option>
<form:option value="-NA-">-NA-</form:option>
</form:select>
</div>
<div class="col-4" id="uomTypeError">

</div>
</div>

<div class="row">
<div class="col-4">
<label for="uomModel ">UomModel:</label>
</div>
<div class="col-4">
<form:input path="uomModel" />
</div>
<div class="col-2" id="uomModelError">
</div>
<div class="col-2">
<form:errors path="uomModel" cssClass="text-danger"/>
</div>
</div>

<div class="row">
<div class="col-4">
<label for=" note">Description:</label>
</div>
<div class="col-4">
<form:textarea path="note" />
</div>
<div class="col-4" id="noteError">
</div>
</div>
<div class="row">
<div class="col-4"></div>
<div class="col-4">
<input type="submit" value="Create Uom" id="register" class="btn btn-success"/>
</div>
</div>
	</form:form>
</div>
<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
			</c:if>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	 //1. Hide Error section
	 $("#uomTypeError").hide();
	$("#uomModelError").hide();
    $("#noteError").hide();


	//2. Define flag for error section
   	 var uomTypeError= false;
	 var uomModelError=false;
	 var noteError=false;
	//3. Link with action/event
	 $("#uomType").change(function(){
        validate_uomType();
    });
	
	    $("#uomModel").keyup(function(){
	        validate_uomModel();
	    });
	    $("#note").keyup(function(){
	        validate_note();
	    });
		    
		    
	    
	    //4. define one validation function

	 function validate_uomTypeError(){
		    var val = $("#uomType").val();
			if(val==''){
			  $("#uomTypeError").show();
			  $("#uomTypeError").html("Choose <b>UOM TYPE Type </b>");
		  	  $("#uomTypeError").css("color","red");
		  	uomTypeError = false;
			}else{
		      $("#uomTypeError").hide();
		      uomTypeError = true;

			 
			}
			return uomTypeError;
		  }
	

	 //4. drfine one validation function
		 function validate_uomModelError(){
		    var val=$("#uomModel").val();
		
		    if(val==''){
			  $("#uomModelError").show();
			  $("#uomModelError").html("Enter <b>User Code</b>");
		   	  $("#uomModelError").css("color","red");
		   	uomModelError = false;
			}else if(!exp.test(val)) {
			  $("#uomModelError").show();
			  $("#uomModelError").html("Enter <b>Upper Case (2-8)</b> letters only");
		   	  $("#uomModelError").css("color","red");
		   	uomModelError = false;
			}else{
			  $("#uomModelError").hide();
			  uomModelError = true;
			}
		    return uomModelError;
		  }

		  function validate_noteError(){
			  var val=$("#note").val();
			
			  if(val==''){
				  $("#noteError").show();
				  $("#noteError").html("Enter <b>  Discription</b>");
				  $("#noteError").css("color","red");
				  noteError=false;
			  }else if(!exp.test(val)){
				  $("#noteError").show();
				  $("#noteError").html("Enter <b> [A-Z][a-z](0-9)</b> minimum 10 and maximum 1000 latters");
				  $("#noteError").css("color","red");
				  noteError=false;
			  }else{
				  $("#noteError").hide();
				  noteError = true;
				  }
			  return noteError;

				  }

				 
	  // **************on click submit button****************
	  $("#register").click(function(){
		  //a. reset flags to false
		  uomTypeError = false;
		  uomModelError = false;
		  noteError=false;
		//b. call all validate function
		  validate_noteError();
		  validate_uomModelError();
		  validate_uomTypeError();
		

		  //c. check if all are true then submit else dont
			if(uomModelError &&noteError &&uomTypeError  )
					  return true;
			        else 
					  return false;
	  });
});
</script>
	
</body>
</html>

