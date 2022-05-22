<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient Registration</title>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />

</head>
<body>

	<div class="text-right" style="margin: 10px;">
		<a href="index" class="btn btn-success">Home</a>
	</div>

	<div class="container">

		<div class="col-12 col-lg-8 col-xl-7"
			style="background-color: lightgrey;">
			<form:form class="form-horizontal" modelAttribute="patientVo"
				method="post" enctype="multipart/form-data" action="savePatient"
				id="patientCreation">
				<form:hidden path="patient_id" />
				<h2>Patient Registration</h2>
				<div class="form-group">
					<label for="firstName" class="col-sm-3 control-label"> Name</label>
					<div class="col-sm-9">
						<form:input type="text" path="patient_name" placeholder="Name"
							autocomplete="off" required="" class="form-control"
							maxlength="50" />
						<form:errors path="patient_name" cssClass="error" />
					</div>
				</div>
				<!-- <div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="lastName" placeholder="Last Name" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div> -->

				<div class="form-group">
					<label for="birthDate" class="col-sm-3 control-label">Date
						of Birth</label>
					<div class="col-sm-9">
						<form:input type='date' path="dob" placeholder="DOB"
							autocomplete="off" required="" class="form-control"
							style="margin: 0 0 0;" />
						<form:errors path="dob" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label for="phoneNumber" class="col-sm-3 control-label">Phone
						number </label>
					<div class="col-sm-9">
						<form:input type="text" path="phone" placeholder="Phone number"
							class="form-control" />
						<form:errors path="phone" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">District</label>
					<div class="col-sm-9">
						<form:select class="form-control" path="district.district_id"
							multiple="false">
							<option value="0">--Select--</option>
							<form:options items="${patientVo.districtList}"
								itemValue="district_id" itemLabel="district_name" />
						</form:select>
						<form:errors path="district.district_id" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3">Gender</label>
					<div class="col-sm-6">
						<div class="row">
							<div class="col-sm-4">
								<label class="radio-inline"> <form:radiobutton
										path="gender_id" value="1" />Male
								</label>
							</div>
							<div class="col-sm-4">
								<label class="radio-inline"> <form:radiobutton
										path="gender_id" value="2" />Female
								</label>
							</div>
							<form:errors path="gender_id" cssClass="error" />
						</div>
					</div>
				</div>
				<!-- /.form-group -->


				<div class="form-group">
					<label class="control-label col-sm-3">Photo</label>
					<div class="col-sm-9">
						<input type="file" name="file" class="form-control mb-4 col-4"
							placeholder="Image">
						<c:if test="${not empty patientVo.patient_image}">
							<img src="data:image/*;base64,${patientVo.patient_image}"
								alt="Photo" width="100" height="100" />

						</c:if>
					</div>

				</div>
				<div class="col-md-12 text-center">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</form:form>
			<!-- /form -->
		</div>
	</div>
	<!-- ./container -->

</body>
</html>