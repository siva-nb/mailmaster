function createContentController($scope)
{
	$scope.submission = function(){
		
		var content = CKEDITOR.instances['editor1'].getData();
		
		$scope.createCampaign($scope.model_campaignname, content);
	} 
	
	$scope.createCampaign = function(campaignName, content){
		var formData = new Object();
		formData.param_campaignName = campaignName;
		formData.param_campaignContent = content;
		formData.param_campaignGroupId = 1;
		
		$.ajax({
            url: "createnewcampaign.action",
            type: "POST",
            data : formData,
            error: function(_, textStatus, errorThrown) {
                alert("Error");
            },
            success: function(response, textStatus) {
            	if(response.jsonResponse.status){
            		$location.path("/home.action");
            	}else{
            		alert("Oops !! something wrong. Try again later");
            	}
            	
            }
		 });
	}
}