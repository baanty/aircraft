<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>

<div ng-app="myApp" ng-controller="myCtrl">

<select ng-model="selectedName" ng-options="x for x in names">
</select>
<input type="text" name="inputCountry" ng-model="inputCountry" ng-hide="selectedName == 'Report'" />
<input type="submit"  ng-hide="selectedName == 'Query'" />
</div>

<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.names = ["Query", "Report"];
    $scope.selectedName = $scope.names[0];
});
</script>



</body>
</html>
