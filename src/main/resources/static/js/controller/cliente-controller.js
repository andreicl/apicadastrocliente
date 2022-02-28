appCliente.controller("clienteController", function($scope, $http) {
	$scope.clientes = [];
	$scope.cliente  = {};
	$scope.mensagem = "";
	
	carregarClientes = function (){
		$http({method:'GET', url:'http://localhost:8080/api/clientes'})
		.then(function (response){
			$scope.clientes=response.data;
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.adicionarCliente = function() {
		var idCliente = $scope.cliente.id;
		var metodo    = "POST";
		
		if (idCliente != '' && idCliente != undefined) {
			metodo = "PUT"
		}
		
		$http({method:metodo, url:'http://localhost:8080/api/clientes', data:$scope.cliente})
		.then(function (response){
			if (idCliente != '' && idCliente != undefined) {
				carregarClientes();
			} else {
				$scope.clientes.push(response.data);
			}
			$scope.cliente={};
		}, function (response){
			$scope.mensagem = response.data;
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.excluirCliente = function(cliente) {
		$http({method:'DELETE', url:'http://localhost:8080/api/clientes/'+cliente.id})
		.then(function (response){
			$scope.clientes.splice($scope.clientes.indexOf(cliente), 1);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.editarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
	}
	
	carregarClientes();
});