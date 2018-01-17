<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
  	<meta charset="UTF-8">
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" name="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.address" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Address</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.username"></span></td>
                              <td><span ng-bind="u.address"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      <div ng-controller="ObjetivosListCtrl">
  <script type="text/ng-template" id="group-template.html">
    <div class="panel-heading">
      <h4 class="panel-title" style="color:#fa39c3">
        <a href tabindex="0" class="accordion-toggle" ng-click="toggleOpen()" uib-accordion-transclude="heading">
          <span uib-accordion-header ng-class="{'text-muted': isDisabled}">
            {{heading}}
          </span>
        </a>
      </h4>
    </div>
    <div class="panel-collapse collapse" uib-collapse="!isOpen">
      <div class="panel-body" style="text-align: right" ng-transclude></div>
    </div>
  </script>

  <input type="text" ng-model="perspectiva.name" onclick="activar('botonAddPers')" placeholder="nombre Perspectiva..."> 

  <script type="text/javascript">
    function activar(nombreBoton){
      var boton = document.getElementById(nombreBoton);
      boton.disabled = false;
      boton.enable = true;
      boton.style="color:white;"
    }
  </script>
  <script type="text/javascript">
    function desactivar(nombreBoton){
      var boton = document.getElementById(nombreBoton);
      boton.disabled = true;
      boton.enable = false;
      style="color:black;"
    }
  </script>
  <button type="button" id="botonAddPers" class="btn btn-primary" disabled="true" onclick="desactivar('botonAddPers')" ng-click="createPerspectiva()" style="color:black;">Agregar Perspectiva</button><br/>
  <input type="text" ng-model="objetivo.name" onclick="activar('botonAddObj')" placeholder="nombre Objetivo..."> 
  <button type="button" id="botonAddObj" class="btn btn-primary" disabled="true" onclick="desactivar('botonAddObj')" ng-click="createObjetivo()" style="color:black;">Agregar Objetivo</button>
	{{perspectiva}}
 	{{objetivo}}
  <div class="checkbox">
    <label>
      <input type="checkbox" ng-model="oneAtATime">
      Open only one at a time
    </label>
  </div>

  <uib-accordion close-others="oneAtATime">
    
    <div uib-accordion-group class="panel-default accordionSize" ng-repeat="group in groups" is-open="group.open">
        <uib-accordion-heading>
           {{group.name}} <i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': group.open, 'glyphicon-chevron-right': !status.open}"></i>
        </uib-accordion-heading>
        <ul class="list-group">
          <li class="list-group-item" ng-repeat="objetivo in group.objetivos | orderBy:'nombre'">
            {{objetivo.name}}
          </li>
        </ul>  
    </div>
    {{objetivosRecuperados}}
    <br/>
    {{segundo}}

  </uib-accordion>
</div>

      <script src="<c:url value='js/app.js' />"></script>
      <script src="<c:url value='js/service/user_service.js' />"></script>
      <script src="<c:url value='js/controller/user_controller.js' />"></script>
      <script src="<c:url value='js/service/list-objetivos_service.js' />"></script>
      <script src="<c:url value='js/controller/list-objetivos_controller.js' />"></script>
  </body>
</html>