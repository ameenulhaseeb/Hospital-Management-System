<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="${contextPath}/resources/js/jquery214.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department</title>

</head>
<body>
	<div class="text-right" style="margin: 10px;">
		<a href="index" class="btn btn-success">Home</a>
	</div>
	<c:if test="${not empty message}">
		<div class="alert alert-success alert-dismissible">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong> ${message}
		</div>

	</c:if>
	<div class="container">

		<div class="col-12 col-lg-6 col-xl-7"
			style="background-color: lightgrey;">


			<h3 class="mb-0">Add Department</h3>

			<form:form action="saveDepartment" method="post"
				modelAttribute="departmentVo">


				<div class="form-group">
					<label for="inputPassword3">District</label> <select
						class="form-control" onchange="changeDistrict(this.value)">
						<option value="0">--Select--</option>
						<c:forEach items="${departmentVo.districtList}" var="districtList">
							<option value="${districtList.district_id}">${districtList.district_name}</option>
						</c:forEach>

					</select>
				</div>
				<div class="form-group">
					<label for="inputPassword3">Hospital</label>
					<form:select class="form-control" id="hospital"
						path="hospitalVo.hospital_id" multiple="false">
						<option value="0">--Select District First--</option>
						<%-- 	<form:options items="${hospitalVisitVo.hospitalList}"
									itemValue="hospital_id" itemLabel="hospital_name" /> --%>
					</form:select>
				</div>
				<div class="form-group">
					<label for="inputName">Department Name</label>
					<form:input path="department_name" class="form-control"
						placeholder="Department Name" type="text" />
				</div>

				<div class="form-group">
					<form:button class="btn btn-primary btn-lg float-right"
						type="submit">Save</form:button>
				</div>
			</form:form>

		</div>
	</div>
	<script>

	function changeDistrict(districtId){
   		
   		$('#hospital')
   	    .empty()
   	    .append('<option selected="selected" value="">--Select--</option>'); 

   		if(districtId !="" && districtId !=null){
	   		var params = {
	   				districtId : districtId
				};
			$.ajax({
						url : "getHospitalByDistrict",
						data : params,
						type : "POST",
						
						success : function(res) {
							console.log(res)
							$.each(res, function(i, obj) {	
							
								$("#hospital").append('<option value='+obj.hospital_id+'>'+obj.hospital_name+'</option>');
							/*$('#hospital').append($('<option>',
									 {
									    value: obj[0],
									    text : obj[1]
									}));*/
							
							});
							
						/* 	res.forEach(workplace => {
							    $('#hospital.hospital_id').append($('<option>', {
							       value: workplace,
							       text: workplace
							    }));
							}) */
						},
						error : function(xhr, textStatus, errorThrown) {
							
						alert("Error")

						}

					});
			
	   		}
   		
   	}
</script>
</body>
</html>