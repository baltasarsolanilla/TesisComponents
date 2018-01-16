'use strict';

App.controller('ObjetivosListCtrl', ['$scope', 'listObjetivosService', function($scope, listObjetivosService) {
  $scope.oneAtATime = false;
  $scope.perspectiva = {name:''};
  //var lastPerspectiva = $scope.groups[$scope.groups.length -1].perspectiva;
  
  $scope.objetivo = {name:'', namePerspectiva: "Finanzas"};
  
  
  
  $scope.groups = [
    {
      name: 'Finanzas',
      objetivos: [{nombre: 'obj1'}, {nombre: 'obj2'}, {nombre: 'obj3'}],
    },
    {
      name: 'Clientes',
      objetivos: [{nombre: 'obj4'}, {nombre: 'obj5'}, {nombre: 'obj6'}],
    }
  ];
  
  
  $scope.fetchAllListObjetivos = function(){
	  listObjetivosService.fetchAllPerspectivas()
          .then(
					       function(d) {
						        $scope.groups = d;//mejorarlo
					       },
    					function(errResponse){
    						console.error('Error while fetching Currencies');
    					}
			       );
  };
  $scope.fetchAllListObjetivos(); //Debe cargar $scope.groups con toda la data (perspectiva + objetivos)
  
  
  $scope.addObjetivo = function() {
    $scope.groups[$scope.groups.length -1].objetivos.push($scope.nuevoObjetivo);
    $scope.nuevoObjetivo = {};
  };
  
  $scope.createObjetivo = function(objetivo){
	  listObjetivosService.createObjetivo(objetivo)
              .then(
              $scope.fetchAllListObjetivos, 
		              function(errResponse){
			               console.error('Error while creating Objetivo.');
		              }	
          );
      $scope.nuevoObjetivo = {};
  };
  

  $scope.addPerspectiva = function(){
    $scope.nuevaPerspectiva.objetivos = [];
    $scope.groups.push($scope.nuevaPerspectiva);
    $scope.nuevaPerspectiva = {};
  }
  
  $scope.createPerspectiva = function(perspectiva){
	  listObjetivosService.createPerspectiva(perspectiva)
              .then(
              $scope.fetchAllListObjetivos, 
		              function(errResponse){
			               console.error('Error while creating Perspectiva.');
		              }	
          );
      $scope.nuevaPerspectiva = {};
  };
  
  /*
    VER SI QUEDA EL SCOPE STATUS!
  */
  $scope.status = {
    isCustomHeaderOpen: false,
    isFirstOpen: true,
    isFirstDisabled: false
  };
}]);