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
			<%if(request.getAttribute("status") != null && request.getAttribute("status").toString().equalsIgnoreCase("Đăng nhập thất bại")){ %>
			<div class="alert alert-danger">
				<strong>${status }</strong> 
			</div>
			<%} %>
			
			<form action="/pttk-ex3/login" method="POST">

				<div class="form-group">
					<label>Username</label> 
					<input type="text" name="username" class="form-control" >
				</div>

				<div class="form-group">
					<label>Password</label> 
					<input type="password" name="password" class="form-control">
				</div>
				
				<div>
					<button type="submit" class="btn btn-success">Đăng nhập</button>
					<a href="/pttk-ex3/register" class="btn btn-primary">Đăng ký</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
