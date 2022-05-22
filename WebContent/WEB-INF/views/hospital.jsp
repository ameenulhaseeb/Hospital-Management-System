<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />

<script type="text/javascript"
	src="${contextPath}/resources/js/jquery214.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hospital Management Screen</title>
</head>
<body>
	<main class="out-main">
	<div class="layout">
		<c:if test="${not empty message}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Success!</strong> ${message}
			</div>

		</c:if>
		<div class='row' style="margin: 10 !important;">
			<div class="text-right">
				<a href="index" class="btn btn-success" role="button">Home</a>
			</div>
			<div class='col-xs-12'>
				<h1>Hospital List</h1>

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Sl No.</th>
							<th>Name</th>
							<th>District</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="hosp" items="${listHospital}" varStatus="myIndex">
							<tr>

								<td>${myIndex.index+1}</td>
								<td>${hosp.hospital_name}</td>
								<td>${hosp.district.district_name}</td>
								<td><a href="editHospital?id=${hosp.hospital_id}">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									onclick="deleteHospital(${hosp.hospital_id});" href="#">Delete</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h4>
					New Hospital Register<a href="createHospital"> Here</a>
				</h4>
			</div>
		</div>
	</div>
	</main>
	<script>
function deleteHospital(hospId) {
  if (confirm("Do You Want to Delete?")) {
	  location.href = "deleteHospital?id="+hospId; 
  } 

}
</script>
</body>
</html>