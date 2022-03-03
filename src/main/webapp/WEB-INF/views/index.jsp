
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Trang chủ</title>
<body>
<!-- Slide Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <div class="col-lg-11">
				<div id="header-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active" style="height: 500px;">
							<img class="img-fluid"
								src="<c:url value="assets/img/carousel-1.jpg"/>" alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
										Off Your First Order</h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable
										Dress</h3>
									<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
								</div>
							</div>
						</div>
						<div class="carousel-item" style="height: 500px;">
							<img class="img-fluid"
								src="<c:url value="assets/img/carousel-2.jpg"/>" alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
										Off Your First Order</h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable
										Price</h3>
									<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
								</div>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#header-carousel"
						data-slide="prev">
						<div class="btn btn-dark" style="width: 45px; height: 45px;">
							<span class="carousel-control-prev-icon mb-n2"></span>
						</div>
					</a> <a class="carousel-control-next" href="#header-carousel"
						data-slide="next">
						<div class="btn btn-dark" style="width: 45px; height: 45px;">
							<span class="carousel-control-next-icon mb-n2"></span>
						</div>
					</a>
				</div>
			</div>
        </div>
    </div>
    <!-- Slide End -->


	


	<!-- Featured Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
					<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured End -->


<!-- New Products Start -->
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Just Arrived</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
		<c:forEach var="new_product" items="${new_products}">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="card product-item border-0 mb-4">
					<div
						class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
						<img class="img-fluid w-100" src="${new_product.image}" alt="${new_product.image}">
					</div>
					<div
						class="card-body border-left border-right text-center p-0 pt-4 pb-3">
						<h6 class="text-truncate mb-3 product-name">${new_product.name}</h6>
						<div class="d-flex justify-content-center">
							<h6>$ ${new_product.price }</h6>
							<h6 class="text-muted ml-2">
								<del>$ ${new_product.price+5}</del>
							</h6>
						</div>
					</div>
					<div
						class="card-footer d-flex justify-content-between bg-light border">
						<a href="<c:url value="/detail/${new_product.pID }"/>" class="btn btn-sm text-dark p-0"><i
							class="fas fa-eye text-primary mr-1"></i>View Detail</a> <button
							class="btn btn-sm text-dark p-0 add-to-cart" id="${new_product.pID }"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
					</div>
				</div>
			</div>
		</c:forEach>
			</div>
		</div>
	<!-- New Products End -->

	




	<!-- Products Start -->
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Trandy Products</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
		
		<c:forEach var="trandy_product" items="${products}">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="card product-item border-0 mb-4">
					<div
						class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
						<img class="img-fluid w-100" src="${trandy_product.image }" alt="${trandy_product.image }">
					</div>
					<div
						class="card-body border-left border-right text-center p-0 pt-4 pb-3">
						<h6 class="text-truncate mb-3">${trandy_product.name}</h6>
						<div class="d-flex justify-content-center">
							<h6>$ ${trandy_product.price }</h6>
							<h6 class="text-muted ml-2">
								<del>$ ${trandy_product.price+5}</del>
							</h6>
						</div>
					</div>
					<div
						class="card-footer d-flex justify-content-between bg-light border">
						<a href="<c:url value="/detail/${trandy_product.pID }"/>" class="btn btn-sm text-dark p-0"><i
							class="fas fa-eye text-primary mr-1"></i>View Detail</a> <button 
							class="btn btn-sm text-dark p-0 add-to-cart" id="${trandy_product.pID }"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
	<!-- Products End -->

<!-- Categories Start -->
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Categories</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
		
		<c:forEach var="category" items="${categories}">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			
				<div class="cat-item d-flex flex-column border mb-4"
					style="padding: 30px; height:300px;width:300px;">
					<p class="text-right">${category.amount } Products</p>
					<a href="<c:url value="/categories/${category.cID }"/>" class="cat-img position-relative overflow-hidden mb-3">
						<img class="img-fluid" src="<c:url value="assets/img/category-shoe-${category.cID}.jpg"/>" alt="">
					</a>
					<h5 class="font-weight-semi-bold m-0">${category.cname} </h5>
				</div>
			</div>
			</c:forEach>
			
		</div>
	</div>
	
	<!-- Categories End -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="<c:url value="/assets/lib/addToCart.js"/>"></script>
	
</body>
