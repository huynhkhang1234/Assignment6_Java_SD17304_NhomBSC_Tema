
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.userLogin.user_names}</h1>

	<h1>Trang chủ</h1>

	<c:forEach var="item" items="${listProduct}">
		<tr>
			<form action="/addCart" method="post">
				<input id="id" name="id" value="${item.id}" />
				
				<input name="price"
					value="${item.price}"/> 
										
				 <input id="name" name="name" value="${item.titles} " />
				<button onclick="addToCart()"  class="btn btn-info w-100 text-white">
					<i class="fa-solid fa-cart-shopping"></i> <span>ADD TO CART</span>
				</button>
				

			
					<button type="button" class="page-link" onClick="onDown()">
						<i class="fa-solid fa-minus"> giảm </i>
					</button>													
						<input id="quantity" name="quantity" value="1"
							class="form-control" />
													
					<button type="button" class="page-link" onClick="onUp()">
						<i class="fa-solid fa-plus"> tăng lên</i>
					</button>
					<br>
			 </form>
			 		

		</tr>
		

	</c:forEach>
	<!-- <form action="/addCart" method="post"> 
	<button>Chuyển trang</button>
	 </form> --> 



</body>
<script src="https:code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	var quantity = 1;

	function onDown() {
		if (quantity >= 2) {
			quantity -= 1;
		}
		document.getElementById("quantity").value = quantity;
	};

	function onUp() {
		quantity += 1;
		document.getElementById("quantity").value = quantity;
	};
	
	function addToCart() {		 
		alert("Thêm vào giỏ hàng thành công");
		/* 
	        var id = $("#id").val();	     
	        var name = $("#name").val();
	       var quantity = $("#quantity").val();
	       var price = $("#price").val();
	       alert("name" + name);	     
	       $.ajax({
	           type: "POST",
	           url: "/addCart",
	           data: {
	               id: id,
	               name: name,
	               quantity: quantity,
	               price: price
	           },
	           success: function(data) { */	        	   
	             //  alert("Thêm vào giỏ hàng thành công");
	          /*  },
	           error: function(data) {
	               alert("Có lỗi xảy ra");
	           }
	       }); */
	   }  
	    /* luu data */
	 /*   function saveCart() {
	       $.ajax({
	           type: "POST",
	           url: "/saveCart",
	           success: function(data) {
	               alert("Lưu giỏ hàng thành công");
	           },
	           error: function(data) {
	               alert("Có lỗi xảy ra");
	           }
	       });
	   } */

</script>
</html>
