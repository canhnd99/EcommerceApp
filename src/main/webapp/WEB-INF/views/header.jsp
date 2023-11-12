<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="/resources/images/icons/favicon.png"/>
	<link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/linearicons-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/slick/slick.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/MagnificPopup/magnific-popup.css">
	<link rel="stylesheet" type="text/css" href="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
<body>
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">
						Miễn phí ship cho đơn hàng lớn hơn 500.000 VNĐ
					</div>
					<c:if test="${account == null}">
						<div class="right-top-bar flex-w h-full">
							<a href="${rootPath}/account/signin-form" class="flex-c-m trans-04 p-lr-25">
								Đăng nhập
							</a>
						</div>
					</c:if>
					<c:if test="${account != null}">
						<div class="right-top-bar flex-w h-full">
							 <a style="font-size: 18	px" class="flex-c-m trans-04 p-lr-25">Chào ${account.username}!</a>
							 <a href="${rootPath}/account/signout" class="flex-c-m trans-04 p-lr-25">Đăng xuất</a>
						</div>
					</c:if>
				</div>
			</div>

			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">
					
					<!-- Logo desktop -->		
					<a href="${rootPath}/" class="logo">
						<img src="/resources/images/logo_v1.jpg" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							
							<c:if test="${currentMenu == 'homePage'}">
								<li class="active-menu">
									<a href="${rootPath}/">Trang chủ</a>
								</li>
							</c:if>
							
							<c:if test="${currentMenu != 'homePage'}">
								<li >
									<a href="${rootPath}/">Trang chủ</a>
								</li>
							</c:if>
							
							<c:if test="${currentMenu == 'productPage'}">
								<li class="active-menu">
									<a href="${rootPath}/products/paging">Sản phẩm</a>
									<ul class="sub-menu">
										<li><a href="${rootPath}/products/newest">Sản phẩm mới nhất</a></li>
										<li><a href="${rootPath}/products/discount">Sản phẩm giảm giá</a></li>
										<li><a href="${rootPath}/products/bestsale">Sản phẩm bán chạy</a></li>
									</ul>
								</li>
							</c:if>
							<c:if test="${currentMenu != 'productPage'}">
								<li>
									<a href="${rootPath}/products/paging">Sản phẩm</a>
									<ul class="sub-menu">
										<li><a href="${rootPath}/products/newest">Sản phẩm mới nhất</a></li>
										<li><a href="${rootPath}/products/discount">Sản phẩm giảm giá</a></li>
										<li><a href="${rootPath}/products/bestsale">Sản phẩm bán chạy</a></li>
									</ul>
								</li>
							</c:if>

							<c:if test="${currentMenu == 'productFeaturePage'}">
								<li class="label1 active-menu" data-label1="hot">
									<a href="${rootPath}/products/feature">Nổi bật</a>
								</li>
							</c:if>
							<c:if test="${currentMenu != 'productFeaturePage'}">
								<li class="label1" data-label1="hot">
									<a href="${rootPath}/products/feature">Nổi bật</a>
								</li>
							</c:if>

							<c:if test="${currentMenu == 'productFeaturePage'}">
							</c:if>
							

							<li>
								<a href="${rootPath}/contact">Liên hệ</a>
							</li>
						</ul>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<c:if test="${cart.quantity == null}">
							<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="0">
								<i class="zmdi zmdi-shopping-cart"></i>
							</div>
						</c:if>
						<c:if test="${cart.quantity != null}">
							<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="${cart.quantity}">
								<i class="zmdi zmdi-shopping-cart"></i>
							</div>
						</c:if>

						<a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
							<i class="zmdi zmdi-favorite-outline"></i>
						</a>
					</div>
				</nav>
			</div>	
		</div>

		<!-- Header Mobile -->
		<div class="wrap-header-mobile">
			<!-- Logo moblie -->		
			<div class="logo-mobile">
				<a href="index.html"><img src="/resources/images/icons/logo-01.png" alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m m-r-15">
				<div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
					<i class="zmdi zmdi-search"></i>
				</div>

				<div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="2">
					<i class="zmdi zmdi-shopping-cart"></i>
				</div>

				<a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti" data-notify="0">
					<i class="zmdi zmdi-favorite-outline"></i>
				</a>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box">
					<span class="hamburger-inner"></span>
				</span>
			</div>
		</div>


		<!-- Menu Mobile -->
		<div class="menu-mobile">
			<ul class="topbar-mobile">
				<li>
					<div class="left-top-bar">
						Miễn phí ship cho đơn hàng lớn hơn 500.000 VNĐ
					</div>
				</li>

				<li>
					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m p-lr-10 trans-04">
							Đăng nhập
						</a>
					</div>
				</li>
			</ul>

			<ul class="main-menu-m">
				<li>
					<a href="${rootPath}/">Trang chủ</a>
					<span class="arrow-main-menu-m">
						<i class="fa fa-angle-right" aria-hidden="true"></i>
					</span>
				</li>

				<li>
					<a href="${rootPath}/products/paging">Sản phẩm</a>
					<ul class="sub-menu">
						<li><a href="${rootPath}/products/newest">Sản phẩm mới nhất</a></li>
						<li><a href="${rootPath}/products/discount">Sản phẩm giảm giá</a></li>
						<li><a href="${rootPath}/products/bestsale">Sản phẩm bán chạy</a></li>
					</ul>
				</li>

				<li>
					<a href="${rootPath}/products/feature" class="label1 rs1" data-label1="hot">Nổi bật</a>
				</li>

				<li>
					<a href="${rootPath}/about">Thông tin</a>
				</li>

				<li>
					<a href="${rootPath}/contact">Liên hệ</a>
				</li>
			</ul>
		</div>

		<!-- Modal Search -->
		<div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="/resources/images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search" placeholder="Search...">
				</form>
			</div>
		</div>
	</header>
</body>
</html>