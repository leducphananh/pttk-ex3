<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="row">
		<div class="container mt-5">
			<%if(request.getAttribute("status") != null && request.getAttribute("status").toString().equalsIgnoreCase("Tên đăng nhập bị trùng")){ %>
			<div class="alert alert-danger">
				<strong>${status }</strong> 
			</div>
			<%} %>
			<%if(request.getAttribute("status") != null && request.getAttribute("status").toString().equalsIgnoreCase("Đăng kí thất bại")){ %>
			<div class="alert alert-danger">
				<strong>${status }</strong> 
			</div>
			<%} %>
			
			<form action="/pttk-ex3/register" method="POST">

				<div class="form-group">
					<label>Email</label> 
					<input type="text" name="email" class="form-control" required>
				</div>
				
				<div class="form-group">
					<label>Country</label> 
					<input type="text" name="country" class="form-control" required>
				</div>
				
				<div class="form-group">
					<label>Gender</label> 
					<select name="gender" class="form-control">
						<option value="Nam">Nam</option>
						<option value="Nữ">Nữ</option>
						<option value="Khác">Khác</option>
					</select>
				</div>
				
				<div class="form-group">
					<label>Username</label> 
					<input type="text" name="username" class="form-control" required>
				</div>

				<div class="form-group">
					<label>Password</label> 
					<input type="password" name="password" class="form-control" required>
				</div>
				
				<button type="submit" class="btn btn-success">Đăng kí</button>
			</form>
		</div>
	</div>
</body>
</html>
