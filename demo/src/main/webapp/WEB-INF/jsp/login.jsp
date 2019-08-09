<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>HTML5响应式第三方登录页面模板</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />

		<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
		<link rel="stylesheet" type="text/css" href="css/util.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>

	<body>

		<div class="limiter">
			<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
				<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
					<form id="signIn"  class="login100-form validate-form">
						<span class="login100-form-title p-b-30">登录</span>
						<span class="login100-form-title login100-form-subtitle"></span>
						<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
							<span class="label-input100">用户名</span>
							<input class="input100" type="text" name="username" placeholder="请输入用户名" autocomplete="off">
							<span class="focus-input100" data-symbol="&#xf206;"></span>
						</div>

						<div class="wrap-input100 validate-input" data-validate="请输入密码">
							<span class="label-input100">密码</span>
							<input class="input100" type="password" name="pass" placeholder="请输入密码">
							<span class="focus-input100" data-symbol="&#xf190;"></span>
						</div>

						<div class="text-right p-t-8 p-b-31">
							<a href="javascript:">忘记密码？</a>
						</div>

						<div class="container-login100-form-btn">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn" onclick="user.login();">登 录</button>
							</div>
						</div>
						
						<div class="container-login100-form-btn">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn" onclick="util.showSignUp()">立即注册</button>
							</div>
						</div>
						
					</form>
					<form id="signUp" class="login100-form validate-form">
						<span class="login100-form-title">注册</span>
						<span class="login100-form-title login100-form-subtitle  p-t-25 p-b-10"></span>
						<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
							<span class="label-input100">用户名</span>
							<input class="input100" type="text" name="username" placeholder="请输入用户名" autocomplete="off">
							<span class="focus-input100" data-symbol="&#xf206;"></span>
						</div>

						<div class="wrap-input100 validate-input" data-validate="请输入密码">
							<span class="label-input100">密码</span>
							<input class="input100" type="password" name="pass" placeholder="请输入密码">
							<span class="focus-input100" data-symbol="&#xf190;"></span>
						</div>

						<div class="wrap-input100 validate-input" data-validate="请再一次输入密码">
							<span class="label-input100">确认密码</span>
							<input class="input100" type="password" name="checkPass" placeholder="请输入密码">
							<span class="focus-input100" data-symbol="&#xf190"></span>
						</div>

						<div class="wrap-input100 validate-input m-b-23" data-validate="请输入手机号">
							<span class="label-input100">手机号</span>
							<input class="input100" type="text" name="phone" placeholder="请输入手机号" autocomplete="on">
							<span class="focus-input100" data-symbol="&#xf2b5;"></span>
						</div>

						<div class="wrap-input100 validate-input m-b-23" data-validate="请输入邮箱">
							<span class="label-input100">邮箱</span>
							<input class="input100" type="text" name="email" placeholder="请输入用户名" autocomplete="off">
							<span class="focus-input100" data-symbol="&#xf15a;"></span>
						</div>



						<div  class="container-login100-form-btn p-t-20">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn" onclick="user.signUp()">注册</button>
							</div>
						</div>

						<div  class="container-login100-form-btn">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn" onclick="util.showSignIn()">返回登陆</button>
							</div>
						</div>

					</form>
				</div>

			</div>
		</div>

		<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/velocity/1.5.0/velocity.min.js"></script>
		<script src="js/login.js"></script>
	</body>

</html>
