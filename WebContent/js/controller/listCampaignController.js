function listCampaignController($scope){
	
	$scope.campaigns = [];
	
	$scope.init = function() {

		$scope.param_curr_page = 0;
		               
		$scope.paginate_ajax();
		
	}
	
	$scope.paginate_ajax = function(){
		var formData = new Object();
		formData.param_page_no = $scope.param_curr_page;
		
		$.ajax({
            url: "listcampaigns.action",
            type: "POST",
            data : formData,
            error: function(_, textStatus, errorThrown) {
                alert("Error");
            },
            success: function(response, textStatus) {
            	if(response.campaignResponse.statusCode == 200){
            		$scope.campaigns = response.campaignResponse.campaigns;
                	$scope.$apply();
            	}else{
            		alert("Ooops !! Something failed.Try again later.");
            	}
            	
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