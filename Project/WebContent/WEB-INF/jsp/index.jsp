<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<style>

h1 {
  text-align: center;
}

</style>
<meta charset="UTF-8">
<title>Login Form </title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<form style="margin:90px" >
	<h1>ログイン画面</h1>
</form>

	<div class="container">

	<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form class="form-horizontal" action="LoginServlet" method="post">
					<span id="reauth-email" class="reauth-email"></span>
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
								<button class="btn btn-default" type="submit">Enter</button>
							</a>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>


</body>
</html>