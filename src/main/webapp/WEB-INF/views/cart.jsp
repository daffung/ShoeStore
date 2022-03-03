<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Giỏ hàng</title>

<body>
  <!-- Cart Start -->

    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach var="item" items="${cart}">
                    
                        <tr id="${item.key }">                        	
                            <td class="align-middle"><img src="${item.value.product.image }" alt="ErrorImg" style="width: 50px;"> ${item.value.product.name }</td>
                            <td class="align-middle product-${item.key}-price">$ ${item.value.product.price }</td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 120px;">
                                    <div class="input-group-btn">
                                        <button name="${item.key }" class="btn btn-sm btn-primary btn-minus btn-pid" >
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="number" min="1" max="100" name="${item.key }" class="quantity-input-${item.key} quantity-input  form-control form-control-sm bg-secondary text-center" value="${item.value.quantity }"/>
                                    <div class="input-group-btn">
                                        <button name="${item.key }" class="btn btn-sm btn-primary btn-plus btn-pid">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle product-${item.key}-total-price product-total-price">$ ${item.value.getTotalPrice() }</td>
                            <td class="align-middle"><button name="${item.key }" class="btn btn-sm btn-primary btn-remove-cart"><i class="fa fa-times"></i></button></td>
                        </tr>
                      </c:forEach>  
                    </tbody>
                </table>
                
            </div>
            <div class="col-lg-4">
                
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Subtotal</h6>
                            <h6 class="font-weight-medium cart-subtotal-price">$ 150</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium ship-price">$ 10</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold cart-total-price">$ 160</h5>
                        </div>
                        <a href="<c:url value="/checkout"/>" class="btn btn-block btn-primary my-3 py-3 check-out">Proceed To Checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->
    <input type="hidden" class="cart-size" value="${cart.size() }"/>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

$(document).ready(function(){
	
	//process quantity and price
	function calcSum(){
		var sum=0;
		$(".product-total-price").each(function(){
			sum += Number($(this).text().split(" ")[1]);
			//console.log($(this).text());
		});
		return sum;
	}
	function finalPrice(){
		return Number($(".cart-subtotal-price").text().split(" ")[1])+Number($(".ship-price").text().split(" ")[1]);
	}
	function setfinalPrice(){
		$(".cart-subtotal-price").text("$ "+calcSum());
		$(".cart-total-price").text("$ "+finalPrice());
	}
	$(".cart-subtotal-price").text("$ "+calcSum());
	$(".cart-total-price").text("$ "+finalPrice());
	
	$(".quantity-input").on("change",function(){
		if(this.value >= 100) this.value = 100;
		if(this.value <= 1) this.value = 1;
		$(".product-"+this.name+"-total-price").text("$ "+($(".product-"+this.name+"-price").text().split(" ")[1]*$(".quantity-input-"+this.name).val()).toFixed(1));
		setfinalPrice();
		
	});
	$(".btn-pid").each(function(){
		$(this).on("click",function(){
			if($(".quantity-input-"+this.name).val() <=1){
				$(".quantity-input-"+this.name).val(1)
			}
			if($(".quantity-input-"+this.name).val() >=100){
				$(".quantity-input-"+this.name).val(100)
			}
			$(".product-"+this.name+"-total-price").text("$ "+($(".product-"+this.name+"-price").text().split(" ")[1]*$(".quantity-input-"+this.name).val()).toFixed(1));
			setfinalPrice()
		})		
	})
	$(".btn-remove-cart").each(function(){
		$(this).on("click",function(){
			//console.log($(".btn-remove-cart").length)
			$("tr[id="+this.name+"]").remove();
			$(".cart-quantity").text($(".btn-remove-cart").length)
			setfinalPrice()
		})
	})
	
	//save to session
	function createMap(){
		var map={}
		$(".quantity-input").each(function(){
			map[this.name]=parseInt(this.value);
		})
		return map;
	}
	//createMap();
	$(window).on("beforeunload",function(){
		var map = createMap();
		console.log(map);
		$.ajax({
			url: "/DemoShopping/editAndSaveCart",
				type:"POST",
				dataType:"text",
				data:map
			}).done(function(string){
				console.log("save cart to session successfully");
				$(".cart-quantity").text(string.split(" ").pop())
			}).fail(function(){
				console.log("Fail to save cart to session");
			});
		location.href = location.href
	});
	
	
});
</script>
</body>
