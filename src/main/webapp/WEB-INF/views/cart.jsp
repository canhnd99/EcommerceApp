<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div class="wrap-header-cart js-panel-cart">
		<div class="s-full js-hide-cart"></div>

		<div class="header-cart flex-col-l p-l-65 p-r-25">
			<div class="header-cart-title flex-w flex-sb-m p-b-8">
				<span class="mtext-103 cl2">
					Giỏ hàng
				</span>

				<div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
					<i class="zmdi zmdi-close"></i>
				</div>
			</div>
			
			<div class="header-cart-content flex-w js-pscroll">
				<c:if test="${cart == null}">
					<span style="font-family: Poppins-Bold; font-size: 17px">Chưa có sản phẩm nào!</span>
				</c:if>
				<c:if test="${cart != null}">
					<ul class="header-cart-wrapitem w-full">
						<c:if test="${cart != null}">
							<c:forEach items="${cart.items}" var="item">
								<li class="header-cart-item flex-w flex-t m-b-12">
									<div class="header-cart-item-img">
										<img src="/resources/images/${item.product.picture}" alt="IMG">
									</div>
			
									<div class="header-cart-item-txt p-t-8">
										<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
											${item.product.name}
										</a>
			
										<span class="header-cart-item-info">
											${item.quantity} x <fmt:formatNumber value = "${item.product.price - item.product.discount}" type="number" maxFractionDigits="0"/>đ
										</span>
									</div>
								</li>
							</c:forEach>
						</c:if>
					</ul>
					<div class="w-full">
						<div class="header-cart-total w-full p-tb-40">
							Tổng: <fmt:formatNumber value = "${cart.totalPrice}" type="number" maxFractionDigits="0"/>đ
						</div>
	
						<div class="header-cart-buttons flex-w w-full">
							<a href="${rootPath}/cart/view" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
								Xem giỏ hàng
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>