var pmApp = angular.module("pmApp",[
	"ngRoute",
	"ngResource",
	"ui.bootstrap",
	"pmProxys"
]);

pmApp.config([
    '$routeProvider', function ($routeProvider){
    	$routeProvider.
    		when('/login',{
    			templateUrl: 'page/login.html',
    			controller: 'LoginController',
    			access: { isFree: true }
    		}).
    		when('/manage/statics',{
    			templateUrl: 'page/statics.html',
    			controller: 'StaticsController',
    			access :{isFree : true }
    		}).
    		when('/manage/menu',{
    			templateUrl: 'page/user.html',
    			controller: 'UserController',
    			access :{isFree : true }
    		}).
    		otherwise({
    			redirectTo: '/login'
    		});
    }
])
.factory('authInterceptor',
	/** @memberOf editorApp */
	function authInterceptor($q, $rootScope, $window, $location) {
	    return {
	        request: function (config) {
	        	config.headers = config.headers || {};
	            if (!!$rootScope.session) {
	              config.headers.Authorization = $rootScope.session.id;
	            }
	            return config;
	        },
	        requestError: function (rejection) {
	            return $q.reject(rejection);
	        },
	        response: function (response) {
	            return response;
	        },
	        responseError: function (rejection) {
				switch (rejection.status) {
					case 0:
					case 401:
					case 403:
						if ($rootScope.session) {
							$rootScope.session.isLogged = false;
						}
						$rootScope.isLogoning = true;
						$location.path('/login');
						break;
				}
	            return $q.reject(rejection);
	        }
	    };
})
.config(
	function interceptors($routeProvider, $httpProvider) {
	    $httpProvider.interceptors.push('authInterceptor');
}).run(function( $rootScope,$location,Proxy){
	if(!$rootScope.isLogoning){
		Proxy.User.getCurrentSession({},function(resp){
			$rootScope.session = resp;
			$rootScope.isLogoning = false;
		},function(error){
			$location.path('/login')
		});
	}
	
	
});

pmApp.controller('MainController',function($scope,$rootScope){
	$scope.resetMenu = function (page, subpage) {
		$scope.page = page;
		$scope.subpage = subpage;
	};
})