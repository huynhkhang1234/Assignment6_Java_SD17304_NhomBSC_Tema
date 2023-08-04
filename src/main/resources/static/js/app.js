var app = angular.module('myApp', []);

// controller #HOMEPAGE
app.controller('homepageController', function ($scope, $http) {

});

// controller #PROFILE
app.controller('profileController', function ($scope, $http) {
    $scope.url = "account";
    $scope.confirmPass = "";
    $scope.getUser = function () {

        var AccountURL = 'http://localhost:8080/api/account';

        $http.get(AccountURL)
            .then(function (response) {      
                $scope.userCurrent = response.data;
                $scope.confirmPass = $scope.userCurrent.pass_words;
            })
            .catch(function (e) {
                console.error("Có lỗi rồi: ", e);
            })
        
    }

    $scope.getUser();
    console.log($scope.url);
});
