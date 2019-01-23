<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
</head>
<body>
<div ng-app="calendarApp" ng-controller="calendarCtrl">
<table>
<tr ng-repeat="e in events"><td>{{e.start}}</td><td>{{e.end}}</td></tr>

</table>
<input type="button" id="createEvent" value="Create Event" ng-click="renderDiv()"/>
<div id="eventDetails"  ng-show="showhideDetails">
<p>{{message}}</p>
<table>
<tr><td><label>Start Time</label></td><td><input type="text" id="startTime" ng-model="startTime" value=""></td></tr>
<tr><td><label>End Time</label></td><td><input type="text" id="endTime" ng-model="endTime" value=""></td></tr>
<tr><td><input type="button" id="addEvent" value="Add Event" ng-click="addEvent()"/></td><td><input type="button" id="closeEventDiv" value="Close" ng-click="close()"/> </td></tr>
</table>

</div>


</div>
<script type="text/javascript">
/* function renderDiv()
{
	document.getElementById("createEvent").style.visibility="visible";	
} */
var calendarApp = angular.module("calendarApp",[]);
calendarApp.controller("calendarCtrl",function($scope, $http){
	$scope.showhideDetails=false;
	var getPromise = $http.get("http://localhost:7070/calendarDemo/get");
	getPromise.then(function(response){
		$scope.events=response.data;
	});
	//$scope.events = [{start:50,end:100},{start:200,end:250}];
	$scope.renderDiv = function(){
		$scope.showhideDetails=true;
	}
	$scope.close = function(){
		$scope.showhideDetails = false;
	}
	$scope.addEvent = function(){
		var promise = $http.get("http://localhost:7070/calendarDemo/add/"+$scope.startTime+"/"+$scope.endTime);
		promise.then(function(response){
			$scope.message=response.data;
		});
		var getPromiseAfterAdd = $http.get("http://localhost:7070/calendarDemo/get");
		getPromiseAfterAdd.then(function(response){
			$scope.events=response.data;
		});
		close();
	}
	
});

</script>
</body>
</html>