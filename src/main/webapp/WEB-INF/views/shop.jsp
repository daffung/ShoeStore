<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Cửa hàng</title>

<body>
<!-- Shop Start -->
<h1>${paginationDTO}</h1>
<h2 id="checked"></h2>
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-12">
                <!-- Price Start -->
                <div class="border-bottom mb-4 pb-4">
                    <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-price" class="custom-control-input" id="price-all">
                            <label class="custom-control-label" for="price-all">All Price</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-price" class="custom-control-input" id="price-1">
                            <label class="custom-control-label" for="price-1">$0 - $100</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-price" class="custom-control-input" id="price-2">
                            <label class="custom-control-label" for="price-2">$100 - $140</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-price" class="custom-control-input" id="price-3">
                            <label class="custom-control-label" for="price-3">$140 - $170</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        
                    </form>
                </div>
                <!-- Price End -->
                
                

                <!-- Size Start -->
                <div class="mb-5">
                    <h5 class="font-weight-semi-bold mb-4">Filter by size</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-size" class="custom-control-input" id="size-all">
                            <label class="custom-control-label" for="size-all">All Size</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-size" class="custom-control-input" id="size-1">
                            <label class="custom-control-label" for="size-1">XS</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-size" class="custom-control-input" id="size-2">
                            <label class="custom-control-label" for="size-2">S</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-size" class="custom-control-input" id="size-3">
                            <label class="custom-control-label" for="size-3">M</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" name="by-size" class="custom-control-input" id="size-4">
                            <label class="custom-control-label" for="size-4">L</label>
                            <span class="badge border font-weight-normal">0</span>
                        </div>
                    </form>
                </div>
                <!-- Size End -->
            </div>
            <!-- Shop Sidebar End -->

			
            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-12 ">
                <div class="row pb-3 shop-products">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <form action="">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search by name">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </span>
                                    </div>
                                </div>
                            </form>
                            <div class="dropdown ml-4">
                                <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                            Sort by
                                        </button>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                    <a class="dropdown-item" href="#">Latest</a>
                                    <a class="dropdown-item" href="#">Popularity</a>
                                    <a class="dropdown-item" href="#">Best Rating</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <c:forEach var="product" items="${productsByCategory}">
                    <div class="col-lg-4 col-md-6 col-sm-12 pb-1 product">
                        <div class="card product-item border-0 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                <img class="img-fluid w-100" src="${ product.image}" alt="${ product.image}">
                            </div>
                            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                <h6 class="text-truncate mb-3">${ product.name}</h6>
                                <div class="d-flex justify-content-center">
                                    <h6>$ ${ product.price }</h6><h6 class="text-muted ml-2"><del>$ ${ product.price+5}</del></h6>
                                </div>
                            </div>
                            <div class="card-footer d-flex justify-content-between bg-light border">
                                <a href="<c:url value="/detail/${product.pID}"/>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                <button class="btn btn-sm text-dark p-0 add-to-cart" id="${product.pID }"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</button>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    <div class="col-12 pb-1">
                        <nav aria-label="Page navigation">
                          <ul class="pagination justify-content-center mb-3">
                            <li class="page-item">
                              <a class="page-link" href="<c:url value="/categories/${cID}/filter/?byPrice=${byPrice }&bySize=${bySize }&page=${paginationDTO.currentPage-1 < 1? 1:paginationDTO.currentPage-1}"/>" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                              </a>
                            </li>
                            <c:forEach varStatus="loop" begin="${paginationDTO.startPage }" end="${paginationDTO.endPage }">
                            <c:if test="${loop.index  == paginationDTO.currentPage }">
                            	<li class="page-item active"><a class="page-link" href="<c:url value="/categories/${cID}/filter/?byPrice=${byPrice }&bySize=${bySize }&page=${loop.index  }"/>">${loop.index  }</a></li>
                            </c:if>
                            <c:if test="${loop.index != paginationDTO.currentPage }">
                            	<li class="page-item "><a class="page-link" href="<c:url value="/categories/${cID}/filter/?byPrice=${byPrice }&bySize=${bySize }&page=${loop.index  }"/>">${loop.index }</a></li>
                            </c:if>
                            
                            </c:forEach>
                            
                            <li class="page-item">
                              <a class="page-link" href="<c:url value="/categories/${cID}/filter/?byPrice=${byPrice }&bySize=${bySize }&page=${paginationDTO.currentPage+1 > paginationDTO.totalPage? (paginationDTO.totalPage):paginationDTO.currentPage+1}"/>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                              </a>
                            </li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script>
   function GetURLParameter(sParam) {
	    var sPageURL = window.location.search.substring(1);
	    var sURLVariables = sPageURL.split('&');
	    for (var i = 0; i < sURLVariables.length; i++){
	        var sParameterName = sURLVariables[i].split('=');
	        if (sParameterName[0] == sParam)
	        {
	            return sParameterName[1];
	        }
	    }
	}
   $(document).ready(function(){
	   var priceChecked = GetURLParameter('byPrice');
	   var sizeChecked = GetURLParameter('bySize');
	   
	   var byPrice= priceChecked !== undefined? priceChecked:"price-all";
	   var bySize= sizeChecked !==undefined? sizeChecked:"size-all";
	   $('input[id='+byPrice+']').prop('checked', true);
	   $('input[id='+bySize+']').prop('checked', true);
	  	$('input[name="by-price"]').on('change', function() {
	  		$('input[name="by-price"]').not(this).prop('checked', false);
	  		byPrice = $('input[name="by-price"]:checked').attr("id");
	  		window.location.href  = "/DemoShopping/categories/"+${cID}+"/filter/?byPrice="+byPrice+"&bySize="+bySize;
	   			
	  	});
	  	$('input[name="by-size"]').on('change', function() {
	  		$('input[name="by-size"]').not(this).prop('checked', false);
	  		bySize = $('input[name="by-size"]:checked').attr("id");
	  		window.location.href = "/DemoShopping/categories/"+${cID}+"/filter/?byPrice="+byPrice+"&bySize="+bySize;
	  	});
	  	
	});

   
   
   </script>
   <script src="<c:url value="/assets/lib/addToCart.js"/>"></script>
</body>
