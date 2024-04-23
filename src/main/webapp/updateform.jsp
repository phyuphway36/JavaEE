<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>HostMdy Register Form</title>
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
	<div class="container">
    <form action="result" method="post" class="form-horizontal" role="form">
        <h2 class="text-center">Registration</h2>
        <h3>ID: ${result.id } </h3>
        <input type="hidden" name="mode" value="UPDATE"/>
        <input type="hidden" name="id" value="${result.id}"/>
        <div class="mb-3">
            <label for="major" class="form-label">Major</label>
            
                <input type="text" value ="${result.major}" id="major" name ="major" placeholder="Major" class="form-control" autofocus>
           
        </div>
        
        <div class="mb-3">
                <label for="seatnumber" class="form-label">SeatNo</label>
         
                <input type="number" value ="${result.seatNo}" id="seatnumber" name="seatnumber" placeholder="Seat No" class="form-control">
            
        </div>
         <div class="mb-3">
            <label for="name" class="form-label">Name</label>
           
                <input type="text" value ="${result.name}" id="name" name ="name" placeholder="FullName" class="form-control" autofocus>
            
        </div>
        
        <div class="mb-3">
                <label for="year" class="form-label">Year</label>
            
                <input type="number" value ="${result.year}" id="year" name="year" placeholder=" Year" class="form-control">
           
        </div>
        
        <div class="mb-3">
                <label for="grade" class="form-label">Grade</label>
            
                <input type="text"value ="${result.grade}" id="grade" name="grade" placeholder=" Grade" class="form-control">
          
        </div>
        <div class="mb-3">
            <label class="form-label">Qualify</label>
            <div class="col-sm-6">
                <div class="row">
                <c:choose>
                <c:when test="${result.qualify }">
                
                 <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="qualify" name="qualify" value="true" checked="checked" >Yes
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="qualify" name="qualify" value="false">No
                        </label>
                    </div>
                </c:when>
                <c:otherwise>
                 <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="qualify" name="qualify" value="true">Yes
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="qualify" name="qualify" value="false" checked="checked" >No
                        </label>
                    </div>
                
                </c:otherwise>
                
                </c:choose>
                   
                </div>
            </div>
        </div> <!-- /.form-group -->
        <div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*Required fields</span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Submit</button>
         <button type="reset" class="btn btn-danger btn-block">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->

<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

</body>
</html>