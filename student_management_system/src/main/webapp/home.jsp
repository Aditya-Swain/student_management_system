<%@page import="com.org.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home </title>
<%@ include file="components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

<%@ include file="components/adminNavbar.jsp" %>

   <p class="text-center text-primary fs-3">Welcome To Home Page</p>
   <a href="add_student" class="btn btn-sm btn-primary btn-white">Add Student</a>

	<div class="container p-3">
					<div class="row">
						<div class="col-md-12">
							<div class="card paint-card">
								<div class="card-body">
									<p class="fs-4 text-center">Student Details</p>
	
	
											<table class="table">
											<tr>
												<th>Name</th>
												<th>Age</th>
												<th>Mobile</th>
												<th>Email</th>
												<th>Action</th>

										</tr>
											
										<c:forEach var="s" items="${students}">
		
											<tr>
													<td>${s.getName()}</td>			
													<td>${s.getAge()}</td>			
													<td>${s.getMobile()}</td>			
													<td>${s.getEmail()}</td>	
												<td> <a href="update_student?id=${s.getId()}" class="btn btn-sm btn-primary">update</a> 
												  <a href="delete_student?id=${s.getId()}"  class="btn btn-sm btn-danger">delete</a>
												</td>	
									</tr>
		
										</c:forEach>
		
										</table>
		
												</div>
											</div>
										</div>
									</div>
								</div>
</body>
</html>