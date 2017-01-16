require.config({
	paths: {
		'eo_proxyService': 'api/pub/eo/js/require/angular/proxyService'
	}
});
//
define(function (require) {
	var app = require('app.js');

	app.config(['$translateProvider', '$translatePartialLoaderProvider',
		/** @memberOf app */
		function $translateProvider($translateProvider, $translatePartialLoaderProvider) {
			$translatePartialLoaderProvider.addPart('eo')
		}]);

	app.config(['$stateProvider', '$urlRouterProvider',
		/** @memberOf app */
		function $stateProvider($stateProvider, $urlRouterProvider) {

//			$stateProvider
//				// 例子
//				.state('session.es_space', {
//					url: '/es_space',
//					templateUrl: 'es/session/space.html',
//					controllerUrl: 'es/session/spaceController.js',
//					controller: 'es_spaceController',
//					dependencies: ['es_proxyService'],
//					access: { permission: 'Editsphere/es_space'}
//				});
		}]);
});
