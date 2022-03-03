<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<title>Checkout</title>

<body>


<div class="container-fluid pt-5">
<form:form action="place_order" method="post" modelAttribute="order">  
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4 ">Billing Address</h4>
                    
                    <div class="row ">
                    
                        <div class="col-lg-6 form-group">
                            <label>Họ và tên</label>
                            <form:input required="required"  value="${login_account.fullname }" class="form-control" type="text" placeholder="John" path="fullname" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <form:input required="required" value="${login_account.email }" class="form-control" type="email" path="email" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Điện thoại</label>
                            <form:input required="required" value="${login_account.phone }" class="form-control"  placeholder="+123 456 789" path="phone" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ</label>
                            <form:input class="form-control"  value="${login_account.address}" placeholder="123 Street" path="address" />  
                           
                        </div>
                        
                        <div class="col-md-6 form-group">
                            <label>Thành phố</label>
                         	<input type="hidden" value="${login_account.city }" class="city-select"/>
                            <form:select class="custom-select" path="city">  
                            
                            
                               <form:option class="city-option" value="Hà Nội" label="Hà Nội"/>  
                               
                            
                            
                            
                               <form:option class="city-option" value="Hải Phòng" label="Hải Phòng"/>  
                               
                            
                            
                            
                               <form:option class="city-option" value="Tp Hồ Chí Minh" label="Tp Hồ Chí Minh"/>  
                               
                            
                            
                               
                               
                            </form:select>
                        </div>
                        
            			
                    </div>
                   
                </div>
                
            </div>
            
            <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Order Total</h4>
                    </div>
                    <div class="card-body">
                        <h5 class="font-weight-medium mb-3">Products</h5>
                        <c:forEach var="item" items="${cart}">
                        <div class="d-flex justify-content-between">
                            <p>${item.value.product.name }</p>
                            <p class="product-total-price">$ ${item.value.getTotalPrice() }</p>
                        </div>
                        </c:forEach>
                        <hr class="mt-0">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Subtotal</h6>
                            <h6 class="font-weight-medium cart-subtotal-price">$150</h6>
                            <form:input type="hidden" class="cart-subtotal-price-input" path="sub_total"/>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium ship-price">$ 10</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold cart-total-price">$160</h5>
                            <form:input type="hidden" class="cart-total-price-input" path="total"/>
                        </div>
                    </div>
                </div>
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Payment</h4>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <form:radiobutton required="required" path="payment_method" value="1" class="custom-control-input" name="payment" id="paypal"/>
                                <label class="custom-control-label" for="paypal">Paypal</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <form:radiobutton required="required" path="payment_method" value="2" class="custom-control-input" name="payment" id="directcheck"/>
                                <label class="custom-control-label" for="directcheck">Direct Check</label>
                            </div>
                        </div>
                        <div class="">
                            <div class="custom-control custom-radio">
                                <form:radiobutton required="required" path="payment_method" value="3" class="custom-control-input" name="payment" id="banktransfer"/>
                                <label class="custom-control-label" for="banktransfer">Bank Transfer</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <button type="submit" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place Order</button>
                    </div>
                </div>
            </div>
        </div>
        </form:form>
    </div>
    <!-- Checkout End -->
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
		$(".cart-subtotal-price").text("$ "+calcSum());
		$(".cart-subtotal-price-input").val(calcSum());
		
		$(".cart-total-price").text("$ "+(finalPrice() > 10? finalPrice(): 0));
		$(".cart-total-price-input").val(finalPrice() > 10? finalPrice(): 0);
		
		
		$(".city-option").each(function(){
			if($(this).val() == $(".city-select").val())
				{
					console.log($(this).val());
					$(this).attr("selected","true")
				}
			
		})

})
	
</script>


	
</body>
