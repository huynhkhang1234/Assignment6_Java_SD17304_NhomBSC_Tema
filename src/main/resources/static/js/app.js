 var app = angular.module('myApp', []);

  
  app.controller('NewsController', function($scope, $http){
		
		 $scope.view = function(){
			var url = "http://localhost:8080/api/user/news";	 
		 
			 $http.get(url)
			 .then(function(response) {
				    $scope.listNews = response.data;
				    $scope.news =$scope.listNews[2];
				    console.log(response);
				  })
			.catch(function (e) {
				 console.log(e);
			})
		 }
		 
		 $scope.view();
		 
	 })
	 
	/* app.controller('NewsDetailController', function($scope, $http){
		
		 $scope.view = function(){
			var url = "http://localhost:8080/api/user/news/detail";	 
		 
			 $http.get(url)
			 .then(function(response) {
			 $scope.listNewsDetail = response.data;
				    $scope.news =$scope.listNewsDetail[id];
				  })
			.catch(function (e) {
				 console.log(e);
			})
			 
		 }
		 
		 $scope.view();
		 
	 })*/