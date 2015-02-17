<!DOCTYPE html>
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="images/favicon.png">

<title>Contacts Management</title>

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

				<!-- page start-->

				<div class="row">
					<div class="col-sm-3">
						<section class="panel">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li class="active"><a href="mail.html"> <i
											class="fa fa-inbox"></i> Contacts <span
											class="label label-danger pull-right inbox-notification">9</span></a></li>
									<li><a href="#"> <i class="fa fa-envelope-o"></i> Send
											Groups
									</a></li>
									<li><a href="#"> <i class="fa fa-certificate"></i>
											Import Contacts
									</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading">
								Editable Table <span class="tools pull-right"> <a
									href="javascript:;" class="fa fa-chevron-down"></a> <a
									href="javascript:;" class="fa fa-cog"></a> <a
									href="javascript:;" class="fa fa-times"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table editable-table ">
									<div class="clearfix">
										<div class="btn-group">
											<a class="btn btn-success" data-toggle="modal"
												href="#myModal"> Dialog </a>
											<!-- Modal -->
											<div class="modal fade" id="myModal" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title">Group Info</h4>
														</div>
														<div class="modal-body">

															<form role="form" class="form-horizontal " action="group">
																<div class="form-group has-success">
																	<label class="col-lg-3 control-label">Group Name</label>
																	<div class="col-lg-6">
																		<input type="text" placeholder="" id="frm_group_name" name="frm_group_name"
																			class="form-control">
																		<p class="help-block">Successfully done</p>
																	</div>
																</div>
																<div class="form-group has-error">
																	<label class="col-lg-3 control-label">Group Desc</label>
																	<div class="col-lg-6">
																		<input type="text" placeholder="" id="frm_group_desc" name="frm_group_desc"
																			class="form-control">
																		<p class="help-block">You gave a wrong info</p>
																	</div>
																</div>

																<div class="form-group">
																	<div class="col-lg-offset-3 col-lg-6">
																		<button class="btn btn-primary" type="submit">Submit</button>
																	</div>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="btn-group pull-right">
											<button class="btn btn-default dropdown-toggle"
												data-toggle="dropdown">
												Tools <i class="fa fa-angle-down"></i>
											</button>
											<ul class="dropdown-menu pull-right">
												<li><a href="#">Print</a></li>
												<li><a href="#">Save as PDF</a></li>
												<li><a href="#">Export to Excel</a></li>
											</ul>
										</div>
									</div>
									<div class="space15"></div>
									<table class="table table-striped table-hover table-bordered"
										id="editable-sample">
										<thead>
											<tr>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Points</th>
												<th>Status</th>
												<th>Edit</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<tr class="">
												<td>Jonathan</td>
												<td>Smith</td>
												<td>3455</td>
												<td class="center">Lorem ipsume</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Mojela</td>
												<td>Firebox</td>
												<td>567</td>
												<td class="center">new user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Akuman</td>
												<td>Dareon</td>
												<td>987</td>
												<td class="center">ipsume dolor</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Theme</td>
												<td>Bucket</td>
												<td>342</td>
												<td class="center">Good Org</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhone</td>
												<td>Doe</td>
												<td>345</td>
												<td class="center">super user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Margarita</td>
												<td>Diar</td>
												<td>456</td>
												<td class="center">goolsd</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhon Doe</td>
												<td>Jhon Doe</td>
												<td>1234</td>
												<td class="center">user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Helena</td>
												<td>Fox</td>
												<td>456</td>
												<td class="center">Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Aishmen</td>
												<td>Samuel</td>
												<td>435</td>
												<td class="center">super Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>dream</td>
												<td>Land</td>
												<td>562</td>
												<td class="center">normal user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>babson</td>
												<td>milan</td>
												<td>567</td>
												<td class="center">nothing</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Waren</td>
												<td>gufet</td>
												<td>622</td>
												<td class="center">author</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhone</td>
												<td>Doe</td>
												<td>345</td>
												<td class="center">super user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Margarita</td>
												<td>Diar</td>
												<td>456</td>
												<td class="center">goolsd</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhon Doe</td>
												<td>Jhon Doe</td>
												<td>1234</td>
												<td class="center">user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Helena</td>
												<td>Fox</td>
												<td>456</td>
												<td class="center">Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Aishmen</td>
												<td>Samuel</td>
												<td>435</td>
												<td class="center">super Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>dream</td>
												<td>Land</td>
												<td>562</td>
												<td class="center">normal user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>babson</td>
												<td>milan</td>
												<td>567</td>
												<td class="center">nothing</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Waren</td>
												<td>gufet</td>
												<td>622</td>
												<td class="center">author</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhone</td>
												<td>Doe</td>
												<td>345</td>
												<td class="center">super user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Margarita</td>
												<td>Diar</td>
												<td>456</td>
												<td class="center">goolsd</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Jhon Doe</td>
												<td>Jhon Doe</td>
												<td>1234</td>
												<td class="center">user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Helena</td>
												<td>Fox</td>
												<td>456</td>
												<td class="center">Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Aishmen</td>
												<td>Samuel</td>
												<td>435</td>
												<td class="center">super Admin</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>dream</td>
												<td>Land</td>
												<td>562</td>
												<td class="center">normal user</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>babson</td>
												<td>milan</td>
												<td>567</td>
												<td class="center">nothing</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
											<tr class="">
												<td>Waren</td>
												<td>gufet</td>
												<td>622</td>
												<td class="center">author</td>
												<td><a class="edit" href="javascript:;">Edit</a></td>
												<td><a class="delete" href="javascript:;">Delete</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</section>
					</div>
					<!-- page end-->
				</div>
			</section>
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

	<script type="text/javascript" src="js/assets/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/assets/DT_bootstrap.js"></script>

	<script src="js/assets/table-editable.js"></script>

	<script type="text/javascript">
			$(function(){
				EditableTable.init();		
			});
	</script>

</body>
</html>
