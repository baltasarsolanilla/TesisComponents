angular.module('objetivosList', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('objetivosList').controller('ObjetivosListCtrl', function ($scope) {
  $scope.oneAtATime = false;

  $scope.groups = [
    {
      perspectiva: 'Finanzas',
      objetivos: [{nombre: 'obj1'}, {nombre: 'obj2'}, {nombre: 'obj3'}],
    },
    {
      perspectiva: 'Clientes',
      objetivos: [{nombre: 'obj4'}, {nombre: 'obj5'}, {nombre: 'obj6'}],
    }
  ];

  $scope.addObjetivo = function() {
    $scope.groups[$scope.groups.length -1].objetivos.push($scope.nuevoObjetivo);
    $scope.nuevoObjetivo = {};
  };

  $scope.addPerspectiva = function(){
    $scope.nuevaPerspectiva.objetivos = [];
    $scope.groups.push($scope.nuevaPerspectiva);
    $scope.nuevaPerspectiva = {};
  }
  /*
    VER SI QUEDA EL SCOPE STATUS!
  */
  $scope.status = {
    isCustomHeaderOpen: false,
    isFirstOpen: true,
    isFirstDisabled: false
  };
});