function listContactsController($scope){
	
	$scope.contacts = [];
	
	$scope.init = function() {
		
		$scope.param_groupid = 1;
		$scope.param_curr_page = 0;
		               
		$scope.paginate_ajax();
		
	}
	
	$scope.paginate_ajax = function(){
		var formData = new Object();
		formData.param_groupid = $scope.param_groupid;
		formData.param_page_no = $scope.param_curr_page;
		
		$.ajax({
            url: "listcontacts.action",
            type: "POST",
            data : formData,
            error: function(_, textStatus, errorThrown) {
                alert("Error");
            },
            success: function(response, textStatus) {
            	$scope.contacts = JSON.parse(response.jsonString);
            	$scope.$apply();
            }
		 });
	}
	
	
	$scope.showPrev = function() {
		$scope.param_curr_page -= 1;
		$scope.paginate_ajax(false);
	};
	
	$scope.showNext = function() {
		$scope.param_curr_page += 1;
		$scope.paginate_ajax(true);
	};
}