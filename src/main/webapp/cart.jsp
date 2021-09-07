<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
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
				<a href="/pttk-ex3/" class="navbar-brand ml-5 mr-md-5">Excercise 3</a>
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
		<form class="container" action="" method="post">
			<h3 class="text-center">Order</h3>
			<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Author</th>
						<th>Price</th>
						<th>Buy</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${giohang }">
						<tr>
							<td>${item.bookItem.id}</td>
							<td>${item.bookItem.book.name }</td>
							<td>${item.bookItem.book.author }</td>
							<td>${item.bookItem.price }</td>
							<td style="text-align: center;">
								<input class="form-control" type="number" value="${item.quantity }" min="1" max="${item.bookItem.quantity }" disabled>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="d-flex mt-4 mb-4">
				<h6 style="width: 38%">Chọn đơn vị vận chuyển</h6>
				<select name="shipment" class="form-control" style="width: 400px;">
					<c:forEach var="shipment" items="${listShipment }">
						<option value="${shipment.id }">${shipment.name } - ${shipment.price }đ</option>
					</c:forEach>
				</select>
			</div>
			<div class="d-flex mt-4 mb-4">
				<h6 style="width: 38%">Chọn hình thức thanh toán</h6>
				<select name="paymentType" class="form-control" style="width: 400px;">
					<option value="Cash">Cash</option>
					<option value="Checks">Checks</option>
					<option value="Credit cards">Credit cards</option>
				</select>
			</div>
			<button type="submit" class="btn btn-success" style="font-weight: bold;">XÁC NHẬN</button>	
		</form>
	</div>
</body>
</html>
