<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン画面</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- オリジナルCSS読み込み -->
<link href="css/original/common.css" rel="stylesheet">
<!-- Jqeryの読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<!-- BootstrapのJS読み込み -->
	<script src="js/bootstrap.min.js">
</script>
<!-- レイアウトカスタマイズ用個別CSS -->

</head>
<body>

	<!-- header -->
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">ユーザ管理システム</a>
				</div>
			</div>
		</nav>
	</header>
	<!-- /header -->

	<div class="container">

		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>


		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form class="form-horizontal">

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
						<div class="col-auto">
							<input type="text" class="form-control" id="inputloginid"
								placeholder="loginid">
						</div>
					</div>


					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
						<div class="col-auto">
							<input type="password" class="form-control" id="inputPassword"
								placeholder="Password">
						</div>
					</div>

					<div align="center">
						<div class="col-xs-offset-2 col-xs-10">
							<a href="userlist.html">
								<button class="btn btn-lg btn-primary btn-block btn-signin"
									type="submit">Enter</button>
							</a>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>