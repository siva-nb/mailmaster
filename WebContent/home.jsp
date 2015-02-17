<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en" ng-app>
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
<link href="css/style-responsive.css" rel="stylezsheet" />


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
						class="dropdown-toggle" href="#"> <span class="username"><s:property value="#session.session_user.getFirstName()" /> </span> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<li><a href="logout.action"><i class="fa fa-key"></i> Log Out</a></li>
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
						<li><a href="home.action"> <i class="fa fa-dashboard"></i> <span>Home</span>
						</a></li>

						<li><a href="managecontact.action"> <i class="fa fa-dashboard"></i>
								<span>Contacts</span>
						</a></li>

						<li><a href="createcampaign.action"> <i class="fa fa-dashboard"></i>
								<span>Campaign</span>
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
				<div class="row">
					<div class="col-sm-6">
						<section class="panel">
							<header class="panel-heading"> Download Template </header>
							<div class="panel-body">
								<a href="Template/Template.csv"><img
									src="images/MSexcel.png" alt="Excel Icon" width="100px"
									height="100px"> Download the template</a> <br> <a
									href="#">How to upload contacts</a>
							</div>
						</section>
					</div>
					<!-- Template Column -->

					<div class="row" ng-controller="uploadController">
						<div class="col-sm-6">
							<section class="panel">
								<header class="panel-heading">
									Upload Zone 
								</header>
								<div class="panel-body">
								<form id="uploadForm" name="uploadForm" action="uploadcontacts.action" method="POST">
										<div id="drop">
											<input type="file" name="param_file" id="param_file" />
										</div>
										<br>
										<input type="button" name="frm_submit" id="frm-submit" class="btn btn-success" value="Upload" ng-click="upload()">
										<s:property value="param_result" />
								</form>
								</div>
							</section>
						</div>
					</div>
					<!-- Upload Column -->
				</div>
				<!-- Row  -->


		<div class="row" ng-controller="listCampaignController" ng-init="init()">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        Campaign
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-cog"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                    </header>
                    <div class="panel-body">
                        <table class="table  table-hover general-table">
                            <thead>
                            <tr>
                                <th>Campaign Name</th>
                                <th>Group Name</th>
                                <th>Group Description</th>
                                <th>Status</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr ng-repeat="campaign in campaigns">
                                <td>{{ campaign.campaignName }}</td>
								<td>{{ campaign.groupName }}</td>
								<td>{{ campaign.groupDescription }}</td>
								<td ng-if="campaign.campaignStatus == '1'">
									<a ng-href="campaignasynctask.action?param_campaign_id={{campaign.campaignId}}"  class="btn btn-danger btn-sm">Start</a> 
								</td>
								<td ng-if="campaign.campaignStatus == '2'">
									<button type="button" class="btn btn-danger btn-sm">Complete</button> 
								</td>
                            </tr>
                            
                            </tbody>
                        </table>
                    </div>

					<div class="text-center">
						<ul class="pagination">
							<li><a href="#" ng-click="showPrev()">«</a></li>
							<li><a href="#" ng-click="showNext()">»</a></li>
						</ul>
					</div>
					</section>
            </div>
        </div>
        
			</section>
			<!--  Wrapper -->
		</section>
		<!--  Main Content -->
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
		<script src="js/assets/angular.js"></script>
		<script src="js/controller/uploadcontroller.js"></script>
		<script src="js/assets/angular.js"></script>
	<script src="js/controller/listCampaignController.js"></script>
		<!--common script init for all pages-->
		<script src="js/assets/scripts.js"></script>
</body>
</html>
