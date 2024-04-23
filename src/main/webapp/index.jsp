<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>HostMdy Exam Result</title>
<!-- CDN-->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/school.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/custom.css" rel="stylesheet" />
</head>
<body>
	<div class="container"></div>
	<!-- Responsive navbar-->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#"><img id="logo"
				src="assets/fblogo.jpg" alt="logo" /> HMI</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
						<c:if test="${fn:contains(user.role,'admin') }">
					<li class="nav-item"><a class="nav-link" href="registerform.html">Register</a></li>
					</c:if>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false"> <c:out value="${user.username}"> </c:out></a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="result?mode=LOGOUT">Logout</a></li>
							
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page content-->
	<div class="container mt-5">
		<table id="result" class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Major</th>
					<th>Year</th>
					<th>SeatNo</th>
					<th>Name</th>
					<th>Grade</th>
					<th>Qualify</th>
					
					<c:if test="${fn:contains(user.role,'admin') }">
					
					<th>Action</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${resultList }">
					<c:url var="updatelink" value="result"> 
					<c:param name="mode" value="LOAD"></c:param>
					<c:param name="id" value="${result.id }"></c:param>
					</c:url>
					
					<c:url var="deletelink" value="result"> 
					<c:param name="mode" value="DELETE"></c:param>
					<c:param name="id" value="${result.id }"></c:param>
					</c:url>
					<tr>
						<td> <c:out value="${result.id }"></c:out>  </td>
						<td> <c:out value="${result.major }"></c:out> </td>
						<td> <c:out value="${result.year }"></c:out> </td>
						<td> <c:out value="${result.seatNo }"></c:out> </td>
						<td> <c:out value="${result.name }"></c:out> </td>
						<td> <c:out value="${result.grade }"></c:out> </td>
						<td> 
							<c:choose>
							<c:when test="${result.qualify }">
								<c:out value="Qualified"> </c:out>
							
							</c:when>
							<c:otherwise>
								<c:out value="-"></c:out>
							
							
							</c:otherwise>
							</c:choose>
							
						 </td>
						 <c:if test="${fn:contains(user.role,'admin') }">
						 
						
						<td> 
						<a class="btn btn-primary" href="${updatelink }"> Edit </a> 
						<a class="btn btn-danger" id="delete" href="${deletelink }" onclick="return confirm('Are you sure to delete this result');
"> Delete </a>
						
						</td>
						</c:if>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>
				<tr>

					<th>ID</th>
					<th>Major</th>
					<th>Year</th>
					<th>SeatNo</th>
					<th>Name</th>
					<th>Grade</th>
					<th>Qualify</th>
					<th>Action</th>
				</tr>
			</tfoot>
		</table>

	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<script>
            $(document).ready(function () {
                 $('#result').DataTable();
                 
          
            });
            
           
        </script>
</body>
</html>
