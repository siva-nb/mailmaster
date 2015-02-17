function loginController($scope, $http) {
	$scope.login = function() {
		
		var postparam = $.param({frm_username: $scope.frm_username, frm_password: $scope.frm_password });
		/*postparam.frm_username = $scope.frm_username;
		postparam.frm_password = $scope.frm_password;*/
		
		$http({method: 'POST', url: 'login.action', data : postparam, headers: {'Content-Type': 'application/x-www-form-urlencoded'}}).
		success(function(data, status, headers, config) {	
				alert("Success");	
		    }).
		    error(function(data, status, headers, config) {
		    	alert("Error");
		    });
	}
}
