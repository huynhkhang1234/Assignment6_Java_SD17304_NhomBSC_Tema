const app = angular.module("detail_products", []);

app.controller("ctrl", function($scope, $http, $location) {
	$scope.productInfo = {}
	// Sử dụng $location để lấy thông tin về URL
	var url = $location.absUrl();
// url = http://localhost:8080/user/product?id=2
	// Tìm index của dấu "/"
	var lastIndex = url.lastIndexOf('=');
// sôsm  n
	// Lấy phần từ sau dấu "/"
	var id = url.substring(lastIndex + 1);

	// Gán giá trị ID vào scope để sử dụng trong template

	// Gọi API để lấy thông tin sản phẩm dựa trên ID
	$http.get('/rest/product/' + id)
		.then(function(response) {
			$scope.productInfo = response.data;
			console.log($scope.productInfo);
		})
		.catch(function(error) {
			console.error('Error fetching product:', error);
		});
	$scope.load_img = function(){
		$http.get('/rest/galleries/products/' + id)
		.then(function(response) {
			//$scope.productInfo = response.data;
			console.log('danh sách imges'+$scope.response.data);
		})
		.catch(function(error) {
			console.error('Error fetching product:', error);
		});
	}
	$scope.cart = {

		items: [],
		// hiện thị thông tin xem nhanh sản phẩm.
		add(id) {	
			alert('Thêm sản phẩm thành công !')		
			var item = this.items.find(item => item.id == id);
			if (item) {
				item.qty++;
				this.saveToLocal();
			} else {
				$http.get(`/rest/product/${id}`).then(resp => {
					resp.data.qty = 1;
					if (resp.data.discounts != null || resp.data.discounts > 0) {
						resp.data.salePirce = resp.data.price - (resp.data.price * (resp.data.discounts.price_discounts / 100));
					} else {
						resp.data.salePirce = resp.data.price;
					}

					this.items.push(resp.data);
					this.saveToLocal();

				})

			}
		},

		//hàm lưu dữ liệu
		saveToLocal() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		}, readToLocal() {
			var json = localStorage.getItem("cart");

			this.items = json ? JSON.parse(json) : [];
		},
		userCart(id){
			alert('sf')
			//window.location.replace("/user/cart");
			
			$scope.cart.add(id);
			
		}
		}
			// gọi hàm 
	$scope.cart.readToLocal();
	$scope.load_img();

	});