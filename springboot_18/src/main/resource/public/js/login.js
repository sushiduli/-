pmApp.controller('LoginController',function($rootScope,$scope,$location, $timeout,Proxy){
	
	$scope.principal = "xiaoyi";
	$scope.password = "123456";
	$scope.submitted = false;
	$scope.showMessage = false;
	$scope.submit = function () {
		Proxy.User.logon({
			username: $scope.principal,
			password: $scope.password
		}, function success(resp) {
				$scope.showMessage = true;
				$rootScope.isLogoning = false;
				$timeout(function(){
					$location.path('/manage/statics');
				}, 200);
			}, function error(resp) {
				$scope.errorMessage = resp.data && resp.data.message ? resp.data.message : resp.statusText;
				$scope.showMessage = true;
			});
	};
});