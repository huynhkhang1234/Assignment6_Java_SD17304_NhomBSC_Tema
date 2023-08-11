var app = angular.module('myApp', []);

var data = -1;


//controller #NewsController
app.controller('NewsController', function($rootScope, $scope, $http, $sce) {
	$scope.view = function() {
		var url = "http://localhost:8080/api/user/news";
		$http.get(url)
			.then(function(response) {
				$scope.listNews = response.data;

				$scope.getHourDiff = function(date) {
					//lấy giờ

					$scope.today = new Date(); // Ngày hiện tại
					$scope.myDate = new Date($sce.trustAsHtml(date.create_date)); // Ngày từ dữ liệu

					var diffInMilliseconds = Math.abs($scope.myDate - $scope.today); // Độ chênh lệch giữa hai ngày tính bằng mili giây
					var diffInHours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)); // Chuyển đổi thành số giờ

					return diffInHours;
				};



				$scope.news = $scope.listNews[2];
			})
			.catch(function(e) {
				console.log(e);
			});
	};

	$scope.view();
});

/// controller newsDetail

app.controller("NewsDetailController", function($scope, $http, $location, $sce) {
	$scope.newInfo = {}
	// sự dung location để lấy thông tin về URL
	var url = $location.absUrl();

	//Tìm kiếm dấu "/""
	var lastIndex = url.lastIndexOf('/');
	console.log(lastIndex);

	//gán gtri id vào scope để sử dụng trong template
	var id = url.substring(lastIndex + 1);
	//gọi API lấy thông tin news detail dựa trên id


	$http.get('/api/news/details/' + id)
		.then(function(respone) {
			$scope.newInfo = respone.data;
			$scope.nd = $sce.trustAsHtml($scope.newInfo.contents);
			console.log($scope.newInfo);

			//lấy giờ

			$scope.today = new Date(); // Ngày hiện tại
			$scope.myDate = new Date($sce.trustAsHtml($scope.newInfo.create_date)); // Ngày từ dữ liệu

			$scope.getHourDiff = function(date) {

				var diffInMilliseconds = Math.abs($scope.myDate - $scope.today); // Độ chênh lệch giữa hai ngày tính bằng mili giây
				var diffInHours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)); // Chuyển đổi thành số giờ

				return diffInHours;
			};


			/*$scope.myDate = new Date($sce.trustAsHtml($scope.newInfo.create_date));*/
		})
		.catch(function(error) {
			console.error('Error fetchinh product:', error);
		});
	//
	$http.get('/api/news/details/all')
		.then(function(respone) {
			$scope.list = respone.data;

			//lấy giờ
			$scope.getHourDiff = function(date) {
				$scope.today = new Date(); // Ngày hiện tại
				$scope.myDate = new Date($sce.trustAsHtml(date.create_date)); // Ngày từ dữ liệu

				var diffInMilliseconds = Math.abs($scope.myDate - $scope.today); // Độ chênh lệch giữa hai ngày tính bằng mili giây
				var diffInHours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)); // Chuyển đổi thành số giờ

				return diffInHours;
			};

		/*	// lấy ngày
			$scope.getDayDiff = function(date) {

				var currentDate = $scope.getCurrentDate();
				var diffInMilliseconds = Math.abs($scope.dataDate - currentDate); // Độ chênh lệch giữa hai ngày tính bằng mili giây
				var diffInDays = Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24)); // Chuyển đổi thành số ngày

				return diffInDays;
			};*/
			/*$scope.myDate = new Date($sce.trustAsHtml($scope.newInfo.create_date));*/
		})
		.catch(function(error) {
			console.error('Error fetchinh product:', error);
		});



});

//



// controller #HOMEPAGE
app.controller('homepageController', function($scope, $http) {

});


// controller #PROFILE
app.controller('profileController', function($scope, $http) {
	$scope.url = "account";
	$scope.confirmPass = "";
	$scope.showPassword = false;

	let listOD = new Array();

	$scope.getUser = function() {

		var AccountURL = 'http://localhost:8080/api/account';

		$http.get(AccountURL)
			.then(function(response) {
				$scope.userCurrent = response.data;
				$scope.getAllFavorites($scope.userCurrent);
				$scope.getAllOrders($scope.userCurrent);
				$scope.getAllOrderDetails($scope.userCurrent);
				$scope.confirmPass = $scope.userCurrent.pass_words;
			})
			.catch(function(e) {
				console.error("Có lỗi rồi: ", e);
			})

	}

	$scope.getAllFavorites = function(userCurrent) {
		var FavoriteURL = 'http://localhost:8080/api/favorite/' + userCurrent.id;

		$http.get(FavoriteURL)
			.then(function(response) {
				$scope.listFav = response.data;
			})
			.catch(function(e) {
				console.error("Có lỗi rồi: ", e);
			})
	}

	$scope.getAllOrders = function(userCurrent) {
		var OrderURL = 'http://localhost:8080/api/order/' + userCurrent.id;

		$http.get(OrderURL)
			.then(function(response) {
				$scope.listOrd = response.data;
			})
			.catch(function(e) {
				console.error("Có lỗi rồi: ", e);
			})
	}

	$scope.getAllOrderDetails = function(userCurrent) {
		var OrderDetailURL = 'http://localhost:8080/api/profile/order_detail/' + userCurrent.id;
		$http.get(OrderDetailURL)
			.then(function(response) {
				$scope.listOD = response.data;
			})
			.catch(function(e) {
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
