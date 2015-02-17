<!DOCTYPE html>
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="images/favicon.png">

<title>Blank page</title>

<!--Core CSS -->
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap/bootstrap-reset.css" rel="stylesheet">
<link href="css/assets/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

</head>

<body>

	<section id="container">
		<!--header start-->
		<header class="header fixed-top clearfix">
			<!--logo start-->
			<div class="brand">

				<a href="index.html" class="logo"> <img src="images/logo.png"
					alt="">
				</a>
				<div class="sidebar-toggle-box">
					<div class="fa fa-bars"></div>
				</div>
			</div>
			<!--logo end-->

			<div class="top-nav clearfix">
				<!--search & user info start-->
				<ul class="nav pull-right top-menu">
					<li><input type="text" class="form-control search"
						placeholder=" Search"></li>
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <img alt=""
							src="images/avatar1_small.jpg"> <span class="username">John
								Doe</span> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
							<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
							<li><a href="login.html"><i class="fa fa-key"></i> Log
									Out</a></li>
						</ul></li>
					<!-- user login dropdown end -->
				</ul>
				<!--search & user info end-->
			</div>
		</header>
		<!--header end-->
		<aside>
			<div id="sidebar" class="nav-collapse">
				<!-- sidebar menu start-->
				<div class="leftside-navigation">
					<ul class="sidebar-menu" id="nav-accordion">
						<li><a href="#"> <i class="fa fa-dashboard"></i> <span>Campaign</span>
						</a></li>

						<li><a href="index.html"> <i class="fa fa-dashboard"></i>
								<span>Statistics</span>
						</a></li>

						<li><a href="index.html"> <i class="fa fa-dashboard"></i>
								<span>Contacts</span>
						</a></li>
					</ul>
				</div>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<!--mini statistics start-->
				<div class="row">
					<div class="col-md-3">
						<div class="mini-stat clearfix">
							<span class="mini-stat-icon orange"><i class="fa fa-gavel"></i></span>
							<div class="mini-stat-info">
								<span>320</span> New Order Received
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mini-stat clearfix">
							<span class="mini-stat-icon tar"><i class="fa fa-tag"></i></span>
							<div class="mini-stat-info">
								<span>22,450</span> Copy Sold Today
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mini-stat clearfix">
							<span class="mini-stat-icon pink"><i class="fa fa-money"></i></span>
							<div class="mini-stat-info">
								<span>34,320</span> Dollar Profit Today
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mini-stat clearfix">
							<span class="mini-stat-icon green"><i class="fa fa-eye"></i></span>
							<div class="mini-stat-info">
								<span>32720</span> Unique Visitors
							</div>
						</div>
					</div>
				</div>
				<!--mini statistics end-->

				<div class="row">
					<div class="col-md-12">
						<!--notification start-->
						<section class="panel">
							<header class="panel-heading">
								Notification <span class="tools pull-right"> <a
									href="javascript:;" class="fa fa-chevron-down"></a> <a
									href="javascript:;" class="fa fa-cog"></a> <a
									href="javascript:;" class="fa fa-times"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="alert alert-info clearfix">
									<span class="alert-icon"><i class="fa fa-envelope-o"></i></span>
									<div class="notification-info">
										<ul class="clearfix notification-meta">
											<li class="pull-left notification-sender"><span><a
													href="#">Jonathan Smith</a></span> send you a mail</li>
											<li class="pull-right notification-time">1 min ago</li>
										</ul>
										<p>Urgent meeting for next proposal</p>
									</div>
								</div>
								<div class="alert alert-danger">
									<span class="alert-icon"><i class="fa fa-facebook"></i></span>
									<div class="notification-info">
										<ul class="clearfix notification-meta">
											<li class="pull-left notification-sender"><span><a
													href="#">Jonathan Smith</a></span> mentioned you in a post</li>
											<li class="pull-right notification-time">7 Hours Ago</li>
										</ul>
										<p>Very cool photo jack</p>
									</div>
								</div>
								<div class="alert alert-success ">
									<span class="alert-icon"><i class="fa fa-comments-o"></i></span>
									<div class="notification-info">
										<ul class="clearfix notification-meta">
											<li class="pull-left notification-sender">You have 5
												message unread</li>
											<li class="pull-right notification-time">1 min ago</li>
										</ul>
										<p>
											<a href="#">Anjelina Mewlo, Jack Flip</a> and <a href="#">3
												others</a>
										</p>
									</div>
								</div>
								<div class="alert alert-warning ">
									<span class="alert-icon"><i class="fa fa-bell-o"></i></span>
									<div class="notification-info">
										<ul class="clearfix notification-meta">
											<li class="pull-left notification-sender">Domain Renew
												Deadline 7 days ahead</li>
											<li class="pull-right notification-time">5 Days Ago</li>
										</ul>
										<p>Next 5 July Thursday is the last day</p>
									</div>
								</div>
							</div>
						</section>
						<!--notification end-->
					</div>
				</div>
			</section>
		</section>

		<!-- Placed js at the end of the document so the pages load faster -->

		<!--Core js-->
		<script src="js/jquery/jquery.js"></script>
		<script src="js/bootstrap/bootstrap.min.js"></script>
		<script class="include" type="text/javascript"
			src="js/assets/jquery.dcjqaccordion.2.7.js"></script>
		<script src="js/assets/jquery.scrollTo.min.js"></script>
		<script src="js/assets/jquery.slimscroll.min.js"></script>
		<script src="js/assets/jquery.nicescroll.js"></script>


		<!--common script init for all pages-->
		<script src="js/assets/scripts.js"></script>
</body>
</html>
