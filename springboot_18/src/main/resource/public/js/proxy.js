var pmProxys = angular.module("pmProxys", ['ngResource']);

pmProxys.factory("Proxy",function ($resource){
	function Proxy(){};
	
	return{
		User : $resource('/pm/security/:action/:target/:scope', { "_": Date.now() },{
			'logon': { method: 'POST', params: { action: 'logon' } },
			'logoff':{ method: 'POST', params: { action: 'logoff' } },
			'getOnline': {method: 'GET',params: {action: 'getOnline'}},
			'getCurrentSession': {method:'GET',params :{action:'getCurrentSession'}}
		})
	}
})
.factory('Message', ['$rootScope', '$timeout', function ($rootScope, $timeout) {
	/** @memberOf nSiteConsoleServices */
	function Message(){}

	$rootScope.messages = [];

	return {
		defaults: {
			level: 'warning',
			closable: false,
			lifecycle: 2000,
			close: function () {
				$rootScope.messages.splice($rootScope.messages.indexOf(this), 1);
			}
		},
		danger: function (text, closable) {
			this.show({ text: text, level: 'danger', closable: closable || false });
		},
		warn: function (text, closable) {
			this.show({ text: text, level: 'warning', closable: closable || false });
		},
		info: function (text, closable) {
			this.show({ text: text, level: 'info', closable: closable || false });
		},
		success: function (text, closable) {
			this.show({ text: text, level: 'success', closable: closable || false });
		},
		show: function (msg) {
			msg = $.extend(true, {}, this.defaults, msg);
			$rootScope.messages.push(msg);
			if (!msg.closable) {
				$timeout(function () {
					msg.close();
				}, msg.lifecycle);
			}
		}
	};
}])
.factory('AuthService', function ($resource, $q, $rootScope, $location, Proxy) {
	function AuthService(){}
	return  {
		model: {
			
		},
		clear: function() {
			
		},
		setCurrentSession: function(session) {
			
		},
		getCurrentSession: function(){
			
		},
		getCurrentSession: function(keys) {
			
		}
		}
})