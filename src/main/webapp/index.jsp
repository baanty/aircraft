<!DOCTYPE html>
<html>
<script
 src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.list-group-item:hover {
 color: #337ab7;
 text-shadow: 0 0 1em #337ab7;
 cursor: pointer;
}
</style>
<body>



 <div ng-app="myApp" ng-controller="myCtrl" class="container col-md-6">


  <select ng-model="selectedName" ng-options="x for x in names">
  </select> 
  
  <input type="text" name="inputCountry" ng-model="inputCountry"
   ng-hide="selectedName == 'Report'" ng-keyup="complete(inputCountry)" />
  <ul class="list-group">
   <li class="list-group-item" ng-repeat="countrydata in filterCountry"
    ng-click="fillTextbox(countrydata)">{{countrydata}}</li>
  </ul>
  <input type="submit" />
  <table ng-hide="selectedName != 'Report'">
   <tr ng-repeat="d in chosenCountryData" >
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
        
    $http.get("http://localhost:8080/getAllCountries")
    .then(function(response) {
        $scope.allCountries = response.data;
    });
    
    $scope.complete = function(inputCountry){
        var output=[];
        angular.forEach($scope.allCountries, function(country){
            if(country.toLowerCase().indexOf(inputCountry.toLowerCase())>=0){
                output.push(country);
            }
        });
        $scope.filterCountry=output;
    }
    
    $scope.fillTextbox = function(chosen){
        $scope.inputCountry = chosen;
        $scope.filterCountry = null;
        $http.get("http://localhost:8080/runwaysOfCountry?countryCode=" + $scope.inputCountry)
        .then(function(response) {
            $scope.chosenCountryData = response.data;
        });
    }
});


</script>



</body>
</html>
