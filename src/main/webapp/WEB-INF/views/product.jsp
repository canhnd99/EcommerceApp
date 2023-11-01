<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Header -->
<jsp:include page="header.jsp" flush="true"/>

<style>
 .pagination a {
   color: black;
   float: left;
   padding: 8px 16px;
   text-decoration: none;
   transition: background-color .3s;
 }
 .pagination a.active {
   background-color: dodgerblue;
   color: white;
 }
 .pagination a:hover:not(.active) {
   background-color: #ddd;
 }
</style>

<body class="animsition">
	<!-- Cart -->
	<jsp:include page="./cart.jsp" flush="true"/>
	
	<!-- Product -->
	<div class="bg0 m-t-23 p-b-140">
		<div class="container">
			<div class="flex-w flex-sb-m p-b-52">
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
					<button onclick="location.href='${rootPath}/products/paging'" 
							class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5">
						Tất cả
					</button>
					<c:forEach items="${categories}" var="c">
						<button onclick="location.href='${rootPath}/products/category?categoryId=${c.categoryId}'" 
							class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5">
							${c.name}
						</button>
					</c:forEach>
				</div>

				<div class="flex-w flex-c-m m-tb-10">
<!-- 					<div class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter"> -->
<!-- 						<i class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i> -->
<!-- 						<i class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i> -->
<!-- 						 Filter -->
<!-- 					</div> -->

					<!-- Search product -->
<!-- 					<div class="panel-search"> -->
<!-- 						<div class="bor8 dis-flex p-l-15"> -->
<!-- 							<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04"> -->
<!-- 								<i class="zmdi zmdi-search"></i> -->
<!-- 							</button> -->
	
<!-- 							<input class="mtext-107 cl2 size-114 plh2 p-r-15" id="searchBox" type="text" name="search-product" placeholder="Tìm kiếm theo tên"> -->
<!-- 						</div>	 -->
<!-- 					</div> -->
					<!-- Search product -->
					<div class="panel-search">
						<div class="bor8 dis-flex p-l-15">
							<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
								<i class="zmdi zmdi-search"></i>
							</button>
	
							<input class="mtext-107 cl2 size-114 plh2 p-r-15" id="searchBox" type="text" name="search-product" placeholder="Tìm kiếm theo tên">
						</div>	
					</div>
				</div>
				
				<!-- Search product -->
				<div class="dis-none panel-search w-full p-t-10 p-b-15">
					<div class="bor8 dis-flex p-l-15">
						<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
							<i class="zmdi zmdi-search"></i>
						</button>

						<input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text" name="search-product" placeholder="Search">
					</div>	
				</div>
			</div>

			<div class="row isotope-grid">
				<c:forEach items="${products}" var="p">
					<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
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
											<span style="color: red"><fmt:formatNumber value = "${p.price - p.discount}" type="number" maxFractionDigits="0"/>đ</span> (<a style="text-decoration: line-through"><fmt:formatNumber value = "${p.price}" type="number" maxFractionDigits="0"/>đ</a>)
										</c:if>
									</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Load more -->
			<div>
				<c:if test="${pageName == 'newest'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/newest?page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${pageName == 'feature'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/feature?page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${pageName == 'paging'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/paging?page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${pageName == 'category'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/category?categoryId=${currentCategoryId}&page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${pageName == 'bestsale'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/bestsale?page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${pageName == 'discount'}">
					<div class="pagination">
						<c:forEach items="${pageInfo}" var="p">
							<a href="${rootPath}/products/discount?page=${p.page}">${p.page}</a>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>
</body>

<script>
	var input = document.getElementById("searchBox");
	input.addEventListener("keypress", function(event) {
	  if (event.key === "Enter") {
	    event.preventDefault();
	    var url = "http://localhost:8080/efarm/products/search?key=" + input.value
	    window.open(url, '_self').focus();
	  }
	});
</script>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>