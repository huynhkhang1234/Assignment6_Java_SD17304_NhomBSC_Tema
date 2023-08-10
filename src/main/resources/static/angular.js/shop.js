const app = angular.module("shop-cart", []);

app.controller("ctrl", function($scope, $http, $location, $timeout) {

	$scope.product = $location.search().product;
	console.log('dữ liệu truyền qua: ' + $location.search().product);
	//mãng chứa sản phẩm
	$scope.products = []
	//mãng like
	$scope.listLike = []
	// xem nhanh sản phẩm
	$scope.product_Detail = []
	// số phần tử có trong trang
	$scope.itemsPerPage = 8;
	// trang hiên tại
	$scope.currentPage = 1;
	//kiểm tra lần đầu.
	$scope.isFirstTime = true;
	// hàm sử lí hóa đơn...
	//phần này là điều hướng trang

	redirect_shop = function() {
		window.location.replace("/user/shop")
	}
	redirect_bills = function() {
		window.location.replace("/user/bill")
	}
	$scope.bill = {
		YesBill() {
			$scope.cart.clear();
			//Chèn thông báo vô.
			setTimeout(redirect_bills, 200);
		},
		NotBill() {
			/*alert('chuyen trang.')*/
			$scope.cart.clear();
			//Chèn thông báo vô.
			setTimeout(redirect_shop, 4500);
		},
	}
	//xem sản phẩm chi tiết.
	$scope.viewProductDetail = function(id) {
		$http.get(`/rest/product/${id}`).then(resp => {

			$location.path('/user/product').search({ id: id, product: resp.data });

		}).catch(error => {
			console.log("Error", error)
		})
	}
	//xem nhanh sản phẩn
	$scope.viewProduct = function(id) {
		$http.get(`/rest/product/${id}`).then(resp => {

			$scope.product_Detail = resp.data;
			console.log($scope.product_Detail);

		}).catch(error => {
			console.log("Error", error)
		})
	}
	$scope.load_all_Products = function() {
		var url = `/rest/product/all`;
		$http.get(url).then(resp => {
			$scope.products = resp.data;
			//  console.log("Success", resp)
			//console.log( $scope.products);
		}).catch(error => {
			console.log("Error", error)
		});
	}
	$scope.load_all_listLike = function() {
		var url = `/rest/like/all`;
		$http.get(url).then(resp => {
			$scope.listLike = resp.data;
			// console.log("Success", resp)
			// console.log( $scope.listLike);
		}).catch(error => {
			console.log("Error", error)
		});
	}
	// tìm kiếm từ khóa để lưu.
	$scope.searchKeyword = '';
	// hàm tìm kiếm khi gõ sự kiện.
	$scope.search = function() {
		$scope.products = $scope.products.filter(function(product) {
			return product.name.toLowerCase().includes($scope.searchKeyword.toLowerCase());
		});
	};

	// dành riêng cho thêm sửa xóa giỏ hàng
	$scope.cart = {

		items: [],
		// hiện thị thông tin xem nhanh sản phẩm.
		deltail_Product: []
		,
		// danh cho phần trang sản phẩm	
		//lấy số lượng tổng sản phẩm chia ra để lấy phân trang.		
		getPages() {
			var pageCount = Math.ceil($scope.products.length / $scope.itemsPerPage);
			var pages = [];
			for (var i = 1; i <= pageCount; i++) {
				pages.push(i);
			}
			//console.log($scope.products.length);
			return pages;
		}
		// lấy số trang hiện tại để hiện phần tử
		,
		setCurrentPage(page) {
			$scope.currentPage = page;
		},
		//chuển qua phần thêm sản phẩm vào giỏ hàng.


		//hàm lưu dữ liệu
		saveToLocal() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		}
		, readToLocal() {
			var json = localStorage.getItem("cart");

			this.items = json ? JSON.parse(json) : [];
		},
		clear() {
			this.items = [];
			this.saveToLocal();
		},
		//tổng số lượng sản phẩm trong giỏ hàng
		get count() {
			return this.items
				.map(item => item.qty)

				.reduce((sum, qty) => sum += qty, 0);
		}
		, add(id) {
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

		//tính tổng tiền
		get amount() {
			return this.items
				.map(item => item.qty * item.salePirce)
				.reduce((sum, qty) => sum += qty, 0);
		},
		//hàm xóa
		delete(id) {
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index, 1);
			this.saveToLocal();
		}
		,
		cong(id) {
			this.add(id);
		},
		tru(id) {
			var item = this.items.find(item => item.id == id);
			if (item) {
				if (item.qty > 1) {
					item.qty--;
					this.saveToLocal();
				}

			}
		}
	}
	// gọi hàm 
	$scope.cart.readToLocal();
	//đơn hàng khi đặt các cột thông tin
	$scope.order = {
		/*users_id:1,*/
		create_date: new Date(),
		notes: $scope.cart.items.address,
		status: "Đang vẩn chuyển",
		sum_money: $scope.cart.amount,
		update_date: null
		, money_received: $scope.cart.amount
		, is_active: 1,
		// đơn hàng chi tiết insert vào data					
		get order_details() {
			return $scope.cart.items.map(item => {
				return {
					products: { id: item.id },
					price: item.salePirce,
					quanlity: item.qty,
					sum_money: item.qty * item.salePirce,
					create_date: new Date(),
					is_active: 1
				}
			});
		}
		////gọi đến api thêm vào database nguyên đơn hàng thành hay bại.
		, check() {
			if ($scope.cart.items != '') {
				var order = angular.copy(this);
				$http.post("/rest/orders", order).then(resp => {
					//alert("thành công");
					var notification = document.getElementById("idtt");
					notification.className = "notification_s";

					notification.textContent = 'Đặt hàng thành công';
					document.body.appendChild(notification);
					setTimeout(function() {
						notification.style.animation = "fadeOut 2s ease-in-out forwards";
					}, 2000);
					$scope.bill.NotBill();
				}).catch(error => {
					alert('lỗi đặt hàng');
					console.log(order)
					console.log(error);
				});
			} else {
				
					var notification = document.getElementById("idtt");
					notification.className = "notification";

					notification.textContent = 'Vui lòng chọn sản phẩm !';
					document.body.appendChild(notification);
					setTimeout(function() {
						notification.style.animation = "fadeOut 2s ease-in-out forwards";
					}, 2000);
				
				
			}

		}

	}

	/*---------------------------------------*/
	// gọi hàm load sản phẩm
	$scope.load_all_Products();
	// gọi hàm load like
	$scope.load_all_listLike();

})