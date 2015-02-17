<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Mail Login">
    <meta name="author" content="Bliss">
    <link rel="shortcut icon" href="images/favicon.png">

    <title>Login</title>

    <!--Core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap/bootstrap-reset.css" rel="stylesheet">
    <link href="css/assets/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    </head>

  <body class="login-body" ng-app>

    <div class="container">

      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap" ng-controller="loginController">
            <div class="user-login-info">
                <input type="text" ng-model="frm_username" class="form-control" placeholder="User ID" name="frm_username" id="frm_username" autofocus>
                <input type="password" ng-model="frm_password" class="form-control" placeholder="Password" name="frm_password" id="frm_password">
            </div>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                </span>
            </label>
            <input type="submit" class="btn btn-lg btn-login btn-block" value="Sign in">

            <div class="registration">
                Don't have an account yet?
                <a class="" href="#">
                    Create an account
                </a>
            </div>

        </div>

          <!-- Modal -->
          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">Forgot Password ?</h4>
                      </div>
                      <div class="modal-body">
                          <p>Enter your e-mail address below to reset your password.</p>
                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                      </div>
                      <div class="modal-footer">
                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                          <button class="btn btn-success" type="button">Submit</button>
                      </div>
                  </div>
              </div>
          </div>
          <!-- modal -->

      </form>

    </div>



    <!-- Placed js at the end of the document so the pages load faster -->

    <script src="js/jquery/jquery.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/assets/angular.js"></script>
	<script src="js/controller/logincontroller.js"></script>
  </body>
</html>
