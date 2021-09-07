<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>List Books</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<style>
	.nav-link .fa-shopping-cart{
		font-size: 20px;
	}
	.nav-link .fa-shopping-cart:after{
		content: attr(value);
		font-size: 15px;
		padding: 3px;
		position: relative;
		left: -3px;
		top: -15px;
	}
</style>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="/pttk-ex3/" class="navbar-brand mr-0 mr-md-5">Excercise 3</a>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item active d-block">
					<a href="/pttk-ex3/cart" class="nav-link">
						<i class="fa fa-shopping-cart" value="${soluongmua }"></i>
					</a>
				</li>
				<c:choose>
					<c:when test="${empty email }">
						<li class="nav-item active dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          				User
		        			</a>
					        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					          <a class="dropdown-item" href="/pttk-ex3/login">Login</a>
					          <a class="dropdown-item" href="/pttk-ex3/register">Register</a>
					        </div>
						</li>
					</c:when>
					<c:when test="${not empty email }">
						<li class="nav-item active dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          				${email }
		        			</a>
					        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					          <a class="dropdown-item" href="/pttk-ex3/logout">Logout</a>
					        </div>
						</li>
					</c:when>
				</c:choose>
				</ul>				
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Book Items</h3>
			<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Author</th>
						<th>Price</th>
						<th style="text-align: center;">Quantity</th>
						<th style="text-align: center;">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bookItem" items="${listBookItem}">
						<tr>
							<td>${bookItem.id}</td>
							<td>${bookItem.book.name }</td>
							<td>${bookItem.book.author }</td>
							<td>${bookItem.price }</td>
							<td style="text-align: center;">${bookItem.quantity }</td>
							<td style="text-align: center;">
								<a href="addToCart?id=${bookItem.id }"><i class="fa fa-shopping-cart"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
