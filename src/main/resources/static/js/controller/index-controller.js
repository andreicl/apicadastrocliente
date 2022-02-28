appCliente.controller("mainController", function($scope, $route, $routeParams, $location) {
	$scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
    
    /*
    	-- Adicionar ao front --
		Path: {{$location.path()}}
		Template URL: {{$route.current.templateUrl}}
		Parametros: {{$routeParams}}
	*/
});