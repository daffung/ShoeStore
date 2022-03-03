<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Chi tiết</title>

<body>
<!-- Shop Detail Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner border">
                    
                        <div class="carousel-item active">
                            <img class="w-100 h-100" src="${product.image }" alt="${product.image }">
                        </div>
                        <div class="carousel-item ">
                            <img class="w-100 h-100" src="${product.image }" alt="${product.image }">
                        </div>
                        <div class="carousel-item">
                            <img class="w-100 h-100" src="${product.image }" alt="${product.image }">
                        </div>                      
                    </div>
                    <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
                        <i class="fa fa-2x fa-angle-left text-dark"></i>
                    </a>
                    <a class="carousel-control-next" href="#product-carousel" data-slide="next">
                        <i class="fa fa-2x fa-angle-right text-dark"></i>
                    </a>
                </div>
            </div>

            <div class="col-lg-7 pb-5">
                <h3 class="font-weight-semi-bold">${product.name }</h3>
                <div class="d-flex mb-3">
                    <div class="text-primary mr-2">
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star-half-alt"></small>
                        <small class="far fa-star"></small>
                    </div>
                    <small class="pt-1">(50 Reviews)</small>
                </div>
                <h3 class="text-muted font-weight-semi-bold mb-4"><del>$ ${product.price+5  }</del></h3>
                <h3 class="font-weight-semi-bold mb-4">$ ${product.price}</h3>
                
                <p class="mb-4">${product.title }</p>
                <div class="d-flex mb-3">
                    <p class="text-dark font-weight-medium mb-0 mr-3">Sizes:</p>
                    <form>
                    
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" class="custom-control-input" id="size-1" name="size">
                            <label class="custom-control-label" for="size-1">XS</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" class="custom-control-input" id="size-2" name="size">
                            <label class="custom-control-label" for="size-2">S</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" class="custom-control-input" id="size-3" name="size">
                            <label class="custom-control-label" for="size-3">M</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" class="custom-control-input" id="size-4" name="size">
                            <label class="custom-control-label" for="size-4">L</label>
                        </div>
                        
                    </form>
                </div>
                
                <div class="d-flex align-items-center mb-4 pt-2">
                    <div class="input-group quantity mr-3" style="width: 130px;">
                        <div class="input-group-btn">
                            <button class="btn btn-primary btn-minus btn-pid" >
                            <i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <input type="text" class="quantity-input form-control bg-secondary text-center" value="1">
                        <div class="input-group-btn">
                            <button  class="btn btn-primary btn-plus btn-pid">
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <button class="btn btn-primary px-3 detail-add-to-cart" id="${product.pID }"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
                </div>
                <div class="d-flex pt-2">
                    <p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
                    <div class="d-inline-flex">
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-pinterest"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="nav nav-tabs justify-content-center border-secondary mb-4">
                    <a class="nav-item nav-link active" data-toggle="tab" href="#tab-pane-1">Mô tả</a>

                </div>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="tab-pane-1">
                        <h4 class="mb-3">Mô tả sản phẩm</h4>
                        <p>${product.description }</p>
                        </div>
                   
                    
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->


    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Sản phẩm mới</span></h2>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel related-carousel">
                
                <c:forEach var="new_product" items="${new_products}">
                    <div class="card product-item border-0">
                        <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                            <img class="img-fluid w-100" src="${new_product.image}" alt="${new_product.image}">
                        </div>
                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                            <h6 class="text-truncate mb-3">${new_product.name}</h6>
                            <div class="d-flex justify-content-center">
                                <h6>$ ${new_product.price}</h6><h6 class="text-muted ml-2"><del>$ ${new_product.price+5}</del></h6>
                            </div>
                        </div>
                        <div class="card-footer d-flex justify-content-between bg-light border">
                            <a href="<c:url value="/detail/${new_product.pID }"/>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                            <button class="btn btn-sm text-dark p-0 add-to-cart" id="${new_product.pID }"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <!-- Products End -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="<c:url value="/assets/lib/addToCart.js"/>"></script>
<script>
$(document).ready(function(){
	$(".quantity-input").on("change",function(){
		if(this.value >= 100) this.value = 100;
		if(this.value <= 1) this.value = 1;
		
	});
	$(".btn-pid").each(function(){
		$(this).on("click",function(){
			if($(".quantity-input").val() <=1){
				$(".quantity-input").val(1)
			}
			if($(".quantity-input").val() >=100){
				$(".quantity-input").val(100)
			}
		})		
	})
	$('.detail-add-to-cart').on('click', function() {
        var pID = this.id;
        var quantity = $(".quantity-input").val()
        console.log(pID);
        $.ajax({
            url: "/DemoShopping/addToCart",
            type:"POST",
            dataType:"text",
            data:{
                pID:pID,
                quantity:quantity
            }
        }).done(function(string){
            
            console.log("success post");
            //console.log(string.split(" ").pop())
            $(".cart-quantity").text(string.split(" ").pop())
            //console.log($(".cart-quantity").text())
        }).fail(function(){
            console.log("Fail");
        })
        
    });
	
	
})


</script>
</body>
