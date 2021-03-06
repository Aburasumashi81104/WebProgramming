<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<style>
h1 {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>User Detail</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
</head>
<body topmargin="100">


<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
			<a class="navbar-brand" href="#">ユーザ管理システム</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#Navbar" aria-controls="Navbar" aria-expanded="false"
				aria-label="ナビゲーションの切替">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="Navbar">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">DETAIL
							<span class="sr-only">(現位置)</span>
					</a></li>


				</ul>
				<span class="navbar-text">
				<span>${userInfo.name} さん　　　</span>
				<a href="LogoutServlet"class="navbar-link logout-link">ログアウト</a>
				</span>
			</div>
		</nav>
	</header>



	<h1>ユーザ情報詳細</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<form class="form-horizontal">

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
						<div class="col-auto">
							<p>${user.loginId}</p>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">ユーザ名</label>
						<div class="col-auto">
							<p>${user.name}</p>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
						<div class="col-auto">
							<p>${user.birthDate}</p>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">登録日時</label>
						<div class="col-auto">
							<p>${user.createDate}</p>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">更新日時</label>
						<div class="col-auto">
							<p>${user.updateDate}</p>
						</div>
					</div>

				</form>
				<p>
					<a href="UserListServlet"class="navbar-link logout-link">戻る</a>
				</p>
			</div>
		</div>
	</div>



</body>
