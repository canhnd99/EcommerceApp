<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Header -->
<jsp:include page="header.jsp" flush="true"/>

<body class="animsition">
	<!-- Cart -->
	<jsp:include page="./cart.jsp" flush="true"/>

	<!-- breadcrumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
				Trang chủ
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<span class="stext-109 cl4">
				Shoping Cart
			</span>
		</div>
	</div>

	<!-- Shoping Cart -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">Sản phẩm</th>
									<th class="column-2"></th>
									<th class="column-3">Giá</th>
									<th class="column-4">Số lượng</th>
									<th class="column-5">Tổng</th>
								</tr>

								<c:forEach items="${cart.items}" var="item">
									<tr class="table_row">
										<td class="column-1">
											<div class="how-itemcart1">
												<img src="${item.product.picture}" alt="IMG">
											</div>
										</td>
										<td class="column-2">${item.product.name}</td>
										<td class="column-3"><fmt:formatNumber value = "${item.product.price - item.product.discount}" type="number" maxFractionDigits="0"/>đ</td>
										<td class="column-4">
											<div class="wrap-num-product flex-w m-l-auto m-r-0">
												<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
													<i class="fs-16 zmdi zmdi-minus"></i>
												</div>
	
												<input class="mtext-104 cl3 txt-center num-product" name="num-product1" value="${item.quantity}">
													
												<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
													<i class="fs-16 zmdi zmdi-plus"></i>
												</div>
											</div>
										</td>
										<td class="column-5"><fmt:formatNumber value = "${(item.product.price - item.product.discount) * item.quantity}" type="number" maxFractionDigits="0"/>đ</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
<!-- 							<div class="flex-w flex-m m-r-20 m-tb-5"> -->
<!-- 								<input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5" type="text" name="coupon" placeholder="Coupon Code"> -->
									
<!-- 								<div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"> -->
<!-- 									Apply coupon -->
<!-- 								</div> -->
<!-- 							</div> -->

							<div class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
								Cập nhật giỏ hàng
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">
							Đơn hàng
						</h4>

						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">
								<span class="stext-110 cl2">
									Sản phẩm:
								</span>
							</div>

							<div class="size-209">
								<span class="mtext-110 cl2">
									<fmt:formatNumber value = "${cart.totalPrice}" type="number" maxFractionDigits="0"/>đ
								</span>
							</div>
						</div>

						<div class="flex-w flex-t bor12 p-t-15 p-b-30">
							<div class="size-208 w-full-ssm">
								<br/>
								
								<c:if test="${ACCOUNT != null}">
									<span class="stext-110 cl2">
										Khách hàng: ${ACCOUNT.fullName}
									</span>
									<br/>
									
									<span class="stext-110 cl2">
										Địa chỉ: ${ACCOUNT.address}
									</span>
									<br/>
									
									<span class="stext-110 cl2">
										Số điện thoại: ${ACCOUNT.phone}
									</span>
									<br/>
								</c:if>
								
								<c:if test="${ACCOUNT == null}">
									<form>
										<label>Tên khách hàng: </label>
										<input name="custName" id="custName" type="text">
										
										<label>Địa chỉ: </label>
										<input name="custName" id="custName" type="text">
										
										<label>Số điện thoại: </label>
										<input name="custName" id="custName" type="text">
									</form>
								</c:if>
								
								<span class="stext-110 cl2">
									<c:if test="${cart.totalPrice >= 500000}">
										Phí giao hàng: <span style="font-family: Poppins-Bold; color: red"> Miễn phí </span>
									</c:if>
									<c:if test="${cart.totalPrice < 500000}">
										Phí giao hàng: <span style="font-family: Poppins-Bold; color: red"> 25,000đ </span>
									</c:if>
								</span>
								<br/>
								
								<span class="stext-110 cl2">
									HT vận chuyển:
								</span>
								<br/> 
								<select style="font-family: Poppins-Bold" name="province">
									<c:forEach items="${transports}" var="t">
										<option value="${t.transportName}">${t.transportName}</option>
									</c:forEach>
								</select>
								<div class="dropDownSelect2"></div>

								<br/>
								
								<span class="stext-110 cl2">
									HT thanh toán:
								</span>
								<br/> 
								<select style="font-family: Poppins-Bold" name="province">
									<c:forEach items="${payments}" var="p">
										<option value="${p.payName}">${p.payName}</option>
									</c:forEach>
								</select>
								<div class="dropDownSelect2"></div>
							</div>
						</div>

						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
								<span class="mtext-101 cl2">
									Thành tiền: 
								</span>
							</div>

							<div class="size-209 p-t-1">
								<span class="mtext-110 cl2">
									<c:if test="${cart.totalPrice < 500000}">
										<fmt:formatNumber value = "${cart.totalPrice + 25000}" type="number" maxFractionDigits="0"/>đ
									</c:if>
									
									<c:if test="${cart.totalPrice > 500000}">
										<fmt:formatNumber value = "${cart.totalPrice}" type="number" maxFractionDigits="0"/>đ
									</c:if>
								</span>
							</div>
						</div>

						<button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
							THANH TOÁN
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>