var appCliente = angular.module("appCliente", ['ngMask', 'ngRoute']);

appCliente.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/clientes", {
		templateUrl : 'view/cliente.html', 
		controller : 'clienteController'
	}).otherwise({
		redirectTo : '/'
	});
	
	$locationProvider.html5Mode(true);
});