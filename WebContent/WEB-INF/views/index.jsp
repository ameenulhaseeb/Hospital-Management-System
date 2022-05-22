<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<div class='row'>
			<div class='col-xs-12'>
		<h1>Home</h1>

 <a href="hospital" class="btn btn-info" role="button">Hospital</a>
  <a href="listPatient" class="btn btn-primary" role="button">Patient</a>
<a href="hsopitalVisit" class="btn btn-success" role="button">Hospital Visit</a> <a href="createDepartment" class="btn btn-success" role="button">Department</a>

			</div>
	</div>
</div>
</main>

</body>
</html>