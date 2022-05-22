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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Hospital</title>
</head>
<body>
	<div class="text-right" style="margin: 10px;">
		<a href="index" class="btn btn-success">Home</a>
	</div>


	<div class="container">

		<div class="col-12 col-lg-6 col-xl-7"
			style="background-color: lightgrey;">
			<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">New/Edit Hospital</h3>
			<form:form action="saveHospital" method="post"
				modelAttribute="hospitalVo">
				<form:hidden path="hospital_id" />
				<div class="form-group">
					<label for="inputName">Hospital Name</label>
					<form:input path="hospital_name" class="form-control"
						placeholder="Hospital Name" type="text" />
				</div>

				<div class="form-group">
					<label for="inputPassword3">District</label>
					<form:select class="form-control" path="district.district_id"
						multiple="false">
						<option value="0">--Select--</option>
						<form:options items="${hospitalVo.districtList}"
							itemValue="district_id" itemLabel="district_name" />
					</form:select>
				</div>

				<div class="form-group">
					<form:button class="btn btn-success btn-lg float-right"
						type="submit">Save</form:button>
				</div>
			</form:form>
		</div>
	</div>


</body>
</html>