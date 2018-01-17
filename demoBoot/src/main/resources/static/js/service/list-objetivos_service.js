'use strict';

App.factory('listObjetivosService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllObjetivos: function() {
					return $http.get('http://localhost:8080/Objetivo/')
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching objetivos');
									return $q.reject(errResponse);
								}
						);
			},
		    
		    createObjetivo: function(objetivo){
					return $http.post('http://localhost:8080/Objetivo/', objetivo)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while creating objetivo');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    fetchAllPerspectivas: function() {
				return $http.get('http://localhost:8080/Perspectiva/')
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching perspectivas');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    createPerspectiva: function(perspectiva){
				return $http.post('http://localhost:8080/Perspectiva/', perspectiva)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while creating perspectiva');
									return $q.reject(errResponse);
								}
						);
	    },
	    
		
	};

}]);