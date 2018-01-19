<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
  	<meta charset="UTF-8">
    <title>Tesis first component</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
  </head>
  <body ng-app="myApp">
  	<div ng-controller="ObjetivosListCtrl">
	 	<!-- VER SI ELIMINAR SCRIPT -->
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

  <input type="text" ng-model="perspectiva.name" placeholder="nombre Perspectiva..."> 
  <button type="button" class="btn btn-primary" ng-click="createPerspectiva()">Agregar Perspectiva</button>
  <button type="button" class="btn btn-danger" ng-click="deletePerspectiva()">Eliminar Perspectiva</button><br/>
  
  <input type="text" ng-model="objetivo.name" placeholder="nombre Objetivo...">
  <input type="text" ng-model="objetivo.perspectiva.id" placeholder="id Perspectiva">  
  <button type="button" class="btn btn-primary" ng-click="createObjetivo()">Agregar Objetivo</button>
  <button type="button" class="btn btn-danger" ng-click="deleteObjetivo()">Eliminar Objetivo</button><br/>
  
  
  <div class="checkbox">
    <label>
      <input type="checkbox" ng-model="oneAtATime">
      Open only one at a time
    </label>
  </div>

 
  <uib-accordion close-others="oneAtATime">
    <div uib-accordion-group class="panel-default accordionSize" ng-repeat="group in groups" is-open="group.open">
        <uib-accordion-heading>
           {{group.name}} <i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': group.open, 'glyphicon-chevron-right': !group.open}"></i>
        </uib-accordion-heading>
        <ul class="list-group">
          <li class="list-group-item" ng-repeat="objetivo in group.objetivos">
            {{objetivo.name}}
          </li>
        </ul>  
    </div>
  </uib-accordion>
  
  
  <h4>Lista de Perspectivas</h4>
  {{perspectivasList}}
  <h4>Lista de Objetivos</h4>
  {{objetivosList}}
  <h4>Lista Groups</h4>
  {{groups}}
  
</div>
		
      <script src="<c:url value='js/app.js' />"></script>
      <script src="<c:url value='js/service/list-objetivos_service.js' />"></script>
      <script src="<c:url value='js/controller/list-objetivos_controller.js' />"></script>
  </body>
</html>