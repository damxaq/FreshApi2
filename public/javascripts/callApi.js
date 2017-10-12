var ourApp = angular.module('ping', []);

ourApp.service('FreshmailService', function ($http) {

    this.getApiSign = function () {
    	$http({
    		method:'GET',
    		url: 'https://api.freshmail.com/rest/ping',
        	headers: {
                'Content-Type': 'application/json',
                'X-Rest-ApiKey': '1912cf4c2a8b21303a3b32f65d3b3496',
                'X-Rest-ApiSign': '6dca264c0b5195af3179fcde4a67ae0cc66cabb0'
            }
        }).then(function(response){
            console.log('Success! Response is ', response);        	
        }, function(error){
            console.log('Error is ', error);
        });
    }
});

ourApp.controller('RequestController', function ($scope, FreshmailService) {

    $scope.loginAndFetchData = function () {
        FreshmailService.getApiSign();
    }
});
