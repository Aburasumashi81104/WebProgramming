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
<title>User List</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
</head>
<body>

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
					<li class="nav-item active"><a class="nav-link" href="#">USERLIST
							<span class="sr-only">(現位置)</span>
					</a></li>


				</ul>
				<span class="navbar-text"></span>
				<b style="color:#FFFF00">
				<span>${userInfo.name} さん　　　</span></b>
				<a href="LogoutServlet"class="navbar-link logout-link">ログアウト</a>
			</div>
		</nav>
	</header>


	<form style="margin: 60px">
		<h1>ユーザ 一覧</h1>
	</form>

	<div class="container">

		<p>
			<a href="UserRegisterServlet"class="navbar-link logout-link">新規登録</a>
		</p>
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form class="form-horizontal" action="UserListServlet" method="post">

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
						<div class="col-auto">
							<input type="text" class="form-control" id="login_id" value="${loginId}"
							name="loginId"
								placeholder="loginid">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">ユーザ名</label>
						<div class="col-auto">
							<input type="text" class="form-control" id="name" value="${name}"
							name="name"
								placeholder="username">
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
						<div class="col-auto">
							<input type="date" class="form-control" id="birthA" value="${birthdateA}"
							name="birthDateA" placeholder="年/月/日">

							<p>～</p>

							<input type="date" class="form-control" id="birthB" value="${birthdateB}"
							name="birthDateB" placeholder="年/月/日">

						</div>
					</div>

					<div align="center">
						<div class="col-xs-offset-8 col-auto">
							<button type="submit" class="btn btn-default">検索</button>
						</div>
					</div>

				</form>


				<div class="table-responsive">
					<table class="table table-boardered">
						<thead class="thead-light">
							<tr>
								<th>ログインID</th>
								<th>ユーザ名</th>
								<th>生年月日</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${userList}">
								<tr>
									<td>${user.loginId}</td>
									<td>${user.name}</td>
									<td>${user.birthDateFmt}</td>
									<!-- TODO 未実装；ログインボタンの表示制御を行う -->
									<td><a class="btn btn-primary"href="UserDetailServlet?id=${user.id}">詳細</a>
										<c:if test="${userInfo.name=='管理者'}">
										<a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
										</c:if>
										<c:if test="${userInfo.name==user.name}">
										<a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
										</c:if>
										<c:if test="${userInfo.name=='管理者'}">
										<a class="btn btn-danger"href="UserDeleteServlet?id=${user.id}">削除</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>

</body>
</html>