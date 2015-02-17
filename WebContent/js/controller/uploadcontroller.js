function uploadController($scope, $http) {
	$scope.upload = function() {
		
		var formData = new FormData();
		formData.append("param_file", $("#param_file").get(0).files[0]);
		
		 $.ajax({
             url: "uploadcontacts.action",
             type: "POST",
             contentType: false,
             processData: false,
             data : formData,
             error: function(_, textStatus, errorThrown) {
                 alert("Error");
                 console.log(textStatus, errorThrown);
             },
             success: function(response, textStatus) {
                 alert("Success");
                 console.log(response, textStatus);
             }
		 });
	}
}