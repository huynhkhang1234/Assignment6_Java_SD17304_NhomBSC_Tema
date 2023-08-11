const app = angular.module("detail_products", []);

app.controller("ctrl", function($scope, $http, $location, $timeout) {
	$scope.productInfo = {}
	$scope.isFirstTime = true;
	// Sử dụng $location để lấy thông tin về URL
	var url = $location.absUrl();

	// Tìm index của dấu "/"
	var lastIndex = url.lastIndexOf('=');

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
			if ($scope.isFirstTime) {
				var item = this.items.find(item => item.id == id);
				if (item) {
					item.qty++;
					this.saveToLocal();
					this.showNotification();
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
						this.showNotification();
					})

				}
				$scope.isFirstTime = false;
				 $timeout(function() {
      			$scope.isFirstTime = true;
      			}, 1000);				
				
			}
		},
		showNotification() {			
			var notification = document.getElementById("idtt");
			notification.className = "notification";
			
			notification.textContent = 'Thêm thành công sản phẩm';
			document.body.appendChild(notification);

			setTimeout(function() {
				notification.style.animation = "fadeOut 2s ease-in-out forwards";				
			}, 2000);
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