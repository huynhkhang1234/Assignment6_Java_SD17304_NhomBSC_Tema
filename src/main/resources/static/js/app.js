var app = angular.module('myApp', []);

// controller #HOMEPAGE
app.controller('homepageController', function ($scope, $http) {

});

// controller #PROFILE
app.controller('profileController', function ($scope, $http) {
    $scope.url = "account";
    $scope.confirmPass = "";
    $scope.showPassword = false;

    let listOD = new Array();

    $scope.getUser = function () {

        var AccountURL = 'http://localhost:8080/api/account';

        $http.get(AccountURL)
            .then(function (response) {      
                $scope.userCurrent = response.data;
                $scope.getAllFavorites($scope.userCurrent);
                $scope.getAllOrders($scope.userCurrent);
                $scope.getAllOrderDetails($scope.userCurrent);
                $scope.confirmPass = $scope.userCurrent.pass_words;
            })
            .catch(function (e) {
                console.error("Có lỗi rồi: ", e);
            })
        
    }

    $scope.getAllFavorites = function (userCurrent) {
        var FavoriteURL = 'http://localhost:8080/api/favorite/' + userCurrent.id;

        $http.get(FavoriteURL)
            .then(function (response) {
                $scope.listFav = response.data;
            })
            .catch(function (e) {
                console.error("Có lỗi rồi: ", e);
            })
    }

    $scope.getAllOrders = function (userCurrent) {
        var OrderURL = 'http://localhost:8080/api/order/' + userCurrent.id;

        $http.get(OrderURL)
            .then(function (response) {
                $scope.listOrd = response.data;
            })
            .catch(function (e) {
                console.error("Có lỗi rồi: ", e);
            })
    }

    $scope.getAllOrderDetails = function (userCurrent) {
        var OrderDetailURL = 'http://localhost:8080/api/profile/order_detail/' + userCurrent.id;
        $http.get(OrderDetailURL)
            .then(function (response) {
               $scope.listOD = response.data;
            })
            .catch(function (e) {
                console.error("Có lỗi rồi: ", e);
            })
    }

    $scope.togglePassword = function() {
        $scope.showPassword = !$scope.showPassword;
    };

    $scope.getUser();
    // $scope.listOD = listOD.forEach;
    console.log(listOD.join);
});
