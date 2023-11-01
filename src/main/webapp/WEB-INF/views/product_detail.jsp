<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Header -->
<jsp:include page="./header.jsp" flush="true"/>

<body class="animsition">
	<!-- breadcrumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
				Home
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<a href="product.html" class="stext-109 cl8 hov-cl1 trans-04">
				Men
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<span class="stext-109 cl4">
				Lightweight Jacket
			</span>
		</div>
	</div>
		

	<!-- Product Detail -->
	<section class="sec-product-detail bg0 p-t-65 p-b-60">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-lg-7 p-b-30">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="wrap-slick3-dots"></div>
							<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

							<div class="slick3 gallery-lb">
								<div class="item-slick3" data-thumb="${imageResource}/${pictureName}-detail-01.jpg">
									<div class="wrap-pic-w pos-relative">
										<img src="${imageResource}/${pictureName}-detail-01.jpg" alt="IMG-PRODUCT">

										<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="${imageResource}/${pictureName}-detail-01.jpg">
											<i class="fa fa-expand"></i>
										</a>
									</div>
								</div>

								<div class="item-slick3" data-thumb="${imageResource}/${pictureName}-detail-02.jpg">
									<div class="wrap-pic-w pos-relative">
										<img src="${imageResource}/${pictureName}-detail-02.jpg" alt="IMG-PRODUCT">

										<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="${imageResource}/${pictureName}-detail-02.jpg">
											<i class="fa fa-expand"></i>
										</a>
									</div>
								</div>

								<div class="item-slick3" data-thumb="${imageResource}/${pictureName}-detail-03.jpg">
									<div class="wrap-pic-w pos-relative">
										<img src="${imageResource}/${pictureName}-detail-03.jpg" alt="IMG-PRODUCT">

										<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="${imageResource}/${pictureName}-detail-03.jpg">
											<i class="fa fa-expand"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
					
				<div class="col-md-6 col-lg-5 p-b-30">
					<div class="p-r-50 p-t-5 p-lr-0-lg">
						<h4 class="mtext-105 cl2 js-name-detail p-b-14">
							${product.name}
						</h4>

						<span class="mtext-106 cl2">
							<c:if test="${product.discount == 0}">
								<fmt:formatNumber value = "${product.price}" type="number" maxFractionDigits="0"/>đ
							</c:if>
							<c:if test="${product.discount != 0}">
								<span style="color: red"><fmt:formatNumber value = "${product.price - product.discount}" type="number" maxFractionDigits="0"/>đ</span> (<span style="text-decoration: line-through"><fmt:formatNumber value = "${product.price}" type="number" maxFractionDigits="0"/>đ</span>)
							</c:if>
						</span>

						<p class="stext-102 cl3 p-t-23">
							${product.description}
						</p>
						
						<h5 style="font-family: Poppins-Regular; padding-top: 15px; padding-bottom: 10px">
							Số lượng còn lại: ${product.quantity}
						</h5>

							<div class="flex-w flex-r-m p-b-10">
								<div class="size-204 flex-w flex-m respon6-next">
									<div class="wrap-num-product flex-w m-r-20 m-tb-10">
										<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
											<button class="fs-16 zmdi zmdi-minus"></button>
										</div>

										<input id="quantity" class="mtext-104 cl3 txt-center num-product" type="number" name="num-product" value="1">

										<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
											<button class="fs-16 zmdi zmdi-plus"></button>
										</div>
									</div>
									
									<c:url value="/cart/add?productId=${product.productId}&quantity=" var="addToCart"></c:url>
<%-- 									<a href="${addToCart}" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04"> --%>
<!-- 										Thêm vào giỏ hàng -->
<!-- 									</a> -->
									<button onclick="addToCartt(${product.quantity},${product.productId})" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
										Thêm vào giỏ hàng
									</button>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>
	</section>


	<!-- Related Products -->
	<section class="sec-relate-product bg0 p-t-45 p-b-105">
		<div class="container">
			<div class="p-b-45">
				<h3 class="ltext-106 cl5 txt-center">
					Sản phẩm liên quan
				</h3>
			</div>

			<!-- Slide2 -->
			<div class="wrap-slick2">
				<div class="slick2">
					<c:forEach items="${relatedProds}" var="p">
						<div class="item-slick2 p-l-15 p-r-15 p-t-15 p-b-15">
							<!-- Block2 -->
							<div class="block2">
								<div class="block2-pic hov-img0">
									<img src="${p.picture}" alt="IMG-PRODUCT">
	
									<a href="${rootPath}/productDetail?prodId=${p.productId}" 
										class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
										Chi tiết
									</a>
								</div>
	
								<div class="block2-txt flex-w flex-t p-t-14">
									<div class="block2-txt-child1 flex-col-l ">
										<a href="${rootPath}/productDetail?prodId=${p.productId}" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
											${p.name}
										</a>
	
										<span class="stext-105 cl3">
											<c:if test="${p.discount == 0}">
												<fmt:formatNumber value = "${p.price}" type="number" maxFractionDigits="0"/>đ
											</c:if>
											<c:if test="${p.discount != 0}">
												<span style="color: red"><fmt:formatNumber value = "${p.price - p.discount}" type="number" maxFractionDigits="0"/>đ</span> (<span style="text-decoration: line-through"><fmt:formatNumber value = "${p.price}" type="number" maxFractionDigits="0"/>đ</span>)
											</c:if>
										</span>
									</div>
	
									<div class="block2-txt-child2 flex-r p-t-3">
										<a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
											<img class="icon-heart1 dis-block trans-04" src="${imageResource}/icons/icon-heart-01.png" alt="ICON">
											<img class="icon-heart2 dis-block trans-04 ab-t-l" src="${imageResource}/icons/icon-heart-02.png" alt="ICON">
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
</body>
<script>
	function addToCartt(quantity, productId) {
		var input = document.getElementById('quantity');
		if(input.value < 1) {
			alert("Chọn số lượng trước khi thêm vào giỏ hàng!")
		} else if (quantity < input.value) {
			alert("Bạn đã nhập quá số lượng sản phẩm trong kho!")
		} else {
			var url = "http://localhost:8080/efarm/cart/add?productId=" + productId + "&quantity=" + input.value
			window.open(url, '_self').focus();
		}
	}
</script>
<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>