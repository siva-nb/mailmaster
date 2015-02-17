function ActionController($scope){
	
	$scope.contactslist = [];
	
	$scope.init = function () {
		var postParam = new Object();
      	postParam.action = 4;
      	postParam.frm_contact_grpid = 1;
      	
      	$.ajax({
      	  type: "GET",
      	  url: "contact",
      	  data: postParam,
      	  success: function(data, status){
      		  alert("Success");
      		  
      		  $scope.contactslist = data.jsonList;
      		 console.log($scope.contactslist);
      		 $scope.contactslist = JSON.parse($scope.contactslist);
      		 console.log($scope.contactslist);
      	  },
      	  error: function(request, status, error){
      		alert("Error");
      	  }
      	});
	};
	
}