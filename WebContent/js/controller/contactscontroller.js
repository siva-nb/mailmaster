function ContactController($scope){
	
	$scope.groups = [
	                 	{ "groupid": 1, "groupname": "DEFAULT" }, 
	                 	{ "groupid": -1, "groupname": "ALL" }
	                ];
	
	$scope.add = function() {
		alert($scope.contact_fname);
      	alert($scope.contact_email);
      	alert($scope.contact_selectedGroups);
      	
      	var postParam = new Object();
      	postParam.action = 1;
      	postParam.frm_contact_grpid = $scope.contact_selectedGroups[0].groupid;
      	postParam.frm_first_name = $scope.contact_fname;
      	postParam.frm_contact_email = $scope.contact_email;
      	
      	$.ajax({
      	  type: "POST",
      	  url: "contact",
      	  data: postParam,
      	  success: function(data, status){
      		  alert("Success");
      	  },
      	  error: function(request, status, error){
      		alert("Error");
      	  }
      	});
    }; 
}