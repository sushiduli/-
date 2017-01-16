pmApp.controller('StaticsController',function($scope, $rootScope, Proxy){
	
	$scope.resetMenu('manage', 'statics');
	
	Proxy.User.getOnline({},function(response){
		$scope.sessionCount = response.result;
	},function(error){
		$scope.sessionCount = '查询失败.....';
	});
	
});