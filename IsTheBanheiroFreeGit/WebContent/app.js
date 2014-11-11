(function() {
	var app = angular.module('BanheiroApp', []);

	app.controller('controller', [ '$http', function($http) {
		
		var ctrl = this;
		
		this.masculino = false;
		this.masculinoDesc = "";
		
		this.feminino = false;
		this.femininoDesc = "";
		
		$http({
			method : 'POST',
			url : 'http://localhost:8080/IsTheBanheiroFreeGit/banheiro',
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data) {
			ctrl.masculino = data.masculino;
			ctrl.masculinoDesc = (data.masculino === "true") ? "Aberto" : "Fechado";
			ctrl.feminino = data.feminino;
			ctrl.femininoDesc = (data.feminino === "true") ? "Aberto" : "Fechado";
			ctrl.myTime = data.atualizacao;
		});
		
		this.mudaEstado = function(){
			$http({
				method : 'POST',
				url : 'http://172.27.10.94:8080/IsTheBanheiroFreeGit/mudaEstado',
				headers : {'Content-Type' : 'application/json'},
				data: {"masculino" : ctrl.masculino, "feminino" : ctrl.feminino}
			}).success(function(data) {
				ctrl.masculino = data.masculino;
				ctrl.masculinoDesc = (data.masculino === "true") ? "Aberto" : "Fechado";
				ctrl.feminino = data.feminino;
				ctrl.femininoDesc = (data.feminino === "true") ? "Aberto" : "Fechado";
			});
		};
		
		this.mudarEstadoMasculino = function(){
			ctrl.masculino = (ctrl.masculino === "false") ? true : false;
			
			ctrl.mudaEstado();
		};
		
		this.mudarEstadoFeminino = function(){
			ctrl.feminino = (ctrl.feminino=== "false") ? true : false;;
			
			ctrl.mudaEstado();
		};
	}]);
})();
