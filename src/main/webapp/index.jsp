<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>



<div ng-app="myApp" ng-controller="myCtrl">


<select ng-model="selectedName" ng-options="x for x in names">
</select>
<input type="text" name="inputCountry" ng-model="inputCountry" ng-hide="selectedName == 'Report'" />
<input type="submit"  />
</div>

<div ng-controller="Hello">
<table>
<tr ng-repeat="d for d in myWelcome">
 <td>{{d.country}}</td>
 <td>{{d.airport}}</td>
 <td>{{d.runway}}</td>
</tr>
</table>
</div>


<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http) {
    $scope.names = ["Query", "Report"];
    $scope.selectedName = $scope.names[0];
    $http.get("http://localhost:8080/runwaysOfCountry?countryCode=US")
    .then(function(response) {
        $scope.myWelcome = response.data;
    });
});


</script>



</body>
</html>
