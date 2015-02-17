<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Mail Login">
<meta name="author" content="Bliss">
<link rel="shortcut icon" href="images/favicon.png">

<title>Sign up</title>

<!--Core CSS -->
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap/bootstrap-reset.css" rel="stylesheet">
<link href="css/assets/font-awesome.css" rel="stylesheet" />

<link href="css/assets/jquery.steps.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

</head>
<body class="login-body">

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">Sign Up</h2>
			<div class="login-wrap">

				<p>Enter your account details below</p>
				<input type="text" class="form-control" placeholder="User Name"
					autofocus> <input type="password" class="form-control"
					placeholder="Password"> <input type="password"
					class="form-control" placeholder="Re-type Password"> <label
					class="checkbox"> <input type="checkbox"
					value="agree this condition"> I agree to the Terms of
					Service and Privacy Policy
				</label>
				<button class="btn btn-lg btn-login btn-block" type="submit">Submit</button>

				<div class="registration">
					Already Registered. <a class="" href="index.jsp"> Login </a>
				</div>
			</div>
		</form>
	</div>


	<!-- Placed js at the end of the document so the pages load faster -->

	<!--Core js-->
	<script src="js/lib/jquery.js"></script>
	<script src="bs3/js/bootstrap.min.js"></script>

</body>
</html>