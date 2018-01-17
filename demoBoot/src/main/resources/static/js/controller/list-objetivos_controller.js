'use strict';

App.controller('ObjetivosListCtrl', ['$scope', 'listObjetivosService', function($scope, listObjetivosService) {
  $scope.oneAtATime = false;
  $scope.groups = [];
  $scope.objetivo = {name:'', perspectiva: {id:'1'}};
  
  
  /*
   * Carga el elemento accordion con todas las perspectivas y objetivos.
   */
  //Arreglar orden ejecucion -> hacer sincrónico
  $scope.fetchAllListObjetivos = function(){
	  listObjetivosService.fetchAllPerspectivas()
          .then(
					    function(dataPerspectivas) {
						        $scope.groups = dataPerspectivas;
					       },
    					function(errResponse){
    						console.error('Error while fetching Perspectivas');
    					}
			   );
	  listObjetivosService.fetchAllObjetivos()
	  	 .then(
	  			 function(dataObjetivos){
	  				 $scope.groups[$scope.groups.length -1].objetivos = dataObjetivos;
	  			 },
	  			 function(errResponse){
	  				console.error('Error while fetching Objetivos');
	  			 });
	  	 
  };
  
  /*
   * Carga inicial de elemento accordion
   */
  $scope.fetchAllListObjetivos(); 
  
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