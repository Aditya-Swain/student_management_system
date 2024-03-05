<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
<%@ include file="components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Admin Login </p>
							
					<p class="fs-5 text-center text-danger">${fail}</p>
					<% request.removeAttribute("fail"); %>
						<form action="login" method="post">
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>

						<p class ="fs-4">
							<a href="#" class="text-decoration-none text-success">Forgot Password ?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>