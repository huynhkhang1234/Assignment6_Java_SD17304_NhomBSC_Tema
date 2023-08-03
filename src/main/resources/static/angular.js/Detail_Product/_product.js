const app = angular.module("detail_products", []);

app.controller("ctrl", function($scope, $http, $location) {
	alert('df')
	   $scope.product = $location.search().product;
	   console.log('dữ liệu truyền qua: ' + $location.search().product);
	
		$scope.cart = {
		items: [],		
		add(id) {
			var item = this.items.find(item => item.id == id);
			if (item) {
				item.qty++;
				this.saveToLocal();
			} else {
				$http.get(`/rest/product/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocal();

				})

			}
		},
		 readToLocal() {
			var json = localStorage.getItem("cart");

			this.items = json ? JSON.parse(json) : [];
		},
		//tổng số lượng sản phẩm trong giỏ hàng
		get count() {
			return this.items
				.map(item => item.qty)

				.reduce((sum, qty) => sum += qty, 0);
		}		
	}
	// gọi hàm 
	$scope.cart.readToLocal();
});