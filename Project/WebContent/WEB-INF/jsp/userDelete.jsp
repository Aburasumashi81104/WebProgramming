<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>User Delete</title>
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
					<li class="nav-item active"><a class="nav-link" href="#">DELETE
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

	<h1>ユーザ削除確認</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form class="form-horizontal" action="UserDeleteServlet"
					method="post">
					<input type="hidden" name="id" value="${user.id}">
					<p>ID：${user.loginId}</p>
					<p>${user.name}</p>
					<p>を本当に削除してよろしいでしょうか？</p>

					<div class="form-group row">
						<div class="col-xs-offset-2 col-xs-10">
							<button onclick="history.back()" class="btn btn-default">キャンセル</button>
						</div>
						<div class="col-auto">
							<div class="col-xs-offset-2 col-xs-10">
								<button type="submit" class="btn btn-default">OK</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>




</body>
