<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="student"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin profile</title>
<%@ include file="components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="components/adminNavbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Admin Profile</p>

						<student:form action="save_profile" modelAttribute="adminObj">
							<div class="mb-3">
								<label class="form-label">Name</label>
								<student:input path="name" class="form-control" />
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label>
								<student:input path="email" class="form-control" />
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<student:input path="password" class="form-control" />
							</div>
							<student:input path="id" type="hidden" />
							<student:button class="btn bg-success text-white col-md-12">Update</student:button>


						</student:form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>