<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<html>
<head>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />

<script type="text/javascript" src="${contextPath}/resources/js/jquery214.min.js"></script>

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
		<h1>Patient List</h1>

		<table class="table table-bordered">
  <thead>
    <tr>
			<th>Sl No.</th>
			<th>Name</th>
			<th>Gender</th>
			<th>DOB</th>
			<th>Phone</th>
			<th>District</th>
		    <th>Action</th>
</tr>
</thead>
  <tbody>
			<c:forEach var="patient" items="${patientList}" varStatus="myIndex">
				<tr>

					<td>${myIndex.index+1}</td>
					<td>${patient.patient_name}</td>
					<td>${patient.gender_id==1?'Male' : 'Female'}</td>
					<fmt:parseDate pattern="yyyy-MM-dd" value="${patient.dob}" var="parsedDate" />
					<td><fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy" /></td>
					<td>${patient.phone}</td>
					 <td>${patient.district.district_name}</td> 
					<td><a href="editPatient?id=${patient.patient_id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
									onclick="deletePatient(${patient.patient_id});" href="#">Delete</a></td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h4>
			New Patient Register<a href="createPatient">  Here</a>
		</h4>
	</div>
	</div>
</div>
</main>
	<script>
function deletePatient(patientId) {
  if (confirm("Do You Want to Delete?")) {
	  location.href = "deletePatient?id="+patientId; 
  } 

}
</script>
</body>
</html>