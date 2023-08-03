const app = angular.module("bill_products", []);

app.controller("ctrl", function($scope, $http,$timeout) {
	//thời gian tạo hiện tại
 $scope.currentTime = new Date();
 // thời gian 15s
  $scope.countdown = 11;
  //mãng chứa thông tin mã đơn hàng 43
  $scope.bill_product = {}
  $scope.bill_product = {}
	$scope.printInfo=[]
	//hàm chuyển về trang.
  redirect_shop = function(){
		window.location.replace("/user/shop")
	}
  //mãng chứa thông tin sản phẩm chi tiết.
	$scope.printInfo=[]
     var updateCountdown = function () {
                if ($scope.countdown > 0) {
                    $scope.countdown--;
                    $timeout(updateCountdown, 1000); // Gọi lại hàm sau mỗi 1 giây
                }
                if($scope.countdown <= 0){
					setTimeout(redirect_shop, 1000);    
				}
                	    
            };
	
	//phần sử lí thông tin in ra của bills
	$scope.bills = {
		load_bills_Products() {
			var url = `/rest/bills`;
			$http.get(url).then(resp => {
				$scope.bill_product = resp.data;				
				console.log(resp.data);
			}).catch(error => {
				console.log("Error", error)
			});
		}
		,
		inforbill() {
			var url = `/rest/bills/info`;
			$http.get(url).then(resp => {
				$scope.printInfo = resp.data;
				
				console.log($scope.printInfo);
			}).catch(error => {
				console.log("Error", error)
			});
		}

	}
	
	$scope.bills.load_bills_Products();
	/*$scope.bills.inforbill();*/
	updateCountdown ();
});