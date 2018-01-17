'use strict';

App.controller('ObjetivosListCtrl', ['$scope', 'listObjetivosService', function($scope, listObjetivosService) {
  $scope.oneAtATime = false;
  $scope.perspectiva = {name:''};
  var pers_name = {name: 'Finanzas'};
  $scope.objetivo = {name:'', perspectiva: pers_name};
//var lastPerspectiva = $scope.groups[$scope.groups.length -1].perspectiva;
  
  
  
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
  
  //Arreglar orden ejecucion -> hacer sincrónico
  $scope.fetchAllListObjetivos = function(){
	  listObjetivosService.fetchAllPerspectivas()
          .then(
					    function(d) {
						        $scope.groups = d;//mejorarlo
					       },
    					function(errResponse){
    						console.error('Error while fetching perspectivas');
    					}
			   );
	  listObjetivosService.fetchAllObjetivos()
	  	 .then(
	  			 function(d){
	  				 $scope.groups[$scope.groups.length -1].objetivos = d;
	  				 $scope.objetivosRecuperados = d;
	  			 },
	  			 function(errResponse){
	  				console.error('Error while fetching objetivos');
	  			 });
	  	 
  };
  
  $scope.fetchAllListObjetivos(); //Debe cargar $scope.groups con toda la data (perspectiva + objetivos)
  
  
  $scope.addObjetivo = function() {
    $scope.groups[$scope.groups.length -1].objetivos.push($scope.nuevoObjetivo);
    $scope.nuevoObjetivo = {};
  };
  
  $scope.createObjetivo = function(){
	  listObjetivosService.createObjetivo($scope.objetivo)
              .then(
            		  function(okResponse) {
            			  $scope.fetchAllListObjetivos();
            			  $scope.objetivo.name = '';
            		  }, 
		              function(errResponse){
			               console.error('Error while creating Objetivo.');
		              }	
          );
  };
  
  
  $scope.addPerspectiva = function(){
    $scope.nuevaPerspectiva.objetivos = [];
    $scope.groups.push($scope.nuevaPerspectiva);
    $scope.nuevaPerspectiva = {};
  }
  
  $scope.createPerspectiva = function(){
	  listObjetivosService.createPerspectiva($scope.perspectiva)
              .then(
            		  function(okResponse) {
            			  $scope.fetchAllListObjetivos();
            			  $scope.perspectiva.name = '';
            		  }, 
		              function(errResponse){
			               console.error('Error while creating Perspectiva.');
		              }	
          );
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