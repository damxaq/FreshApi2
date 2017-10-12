var ourApp = angular.module('loginApp', []);

ourApp.service('NetworkService', function ($http) {

    this.submitUserDetailsToServer = function (name, password) {
        $http.post('localhost:9000/Application/index', {
            "Name": name,
            "Password": password
        });
    };
});

ourApp.controller('LoginController', function ($scope) {

    $scope.submitUserDetails = function () {
        if ($scope.validateName()) {
        	
        	console.log($scope.password);
        	
            return;
        }

    };

    $scope.validateName = function () {
        if (!$scope.name || $scope.name.length < 3) {
            $scope.hasNameError = true;
            return false;
        }
        $scope.hasNameError = false;
        return true;
    }

});