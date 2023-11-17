<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" flush="true" />

<style>
.cover {
	width: 65%;
	margin: auto;
	padding-top: 40px;
	padding-bottom: 30px;
	font-family: Poppins-Medium;
}

input[type=text], input[type=password] {
	opacity: 45%;
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

button {
	background-color: #f44336;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.regis_link {
	padding-left: 10px;
	padding-top: 10px;
}

button:hover {
	opacity: 1;
}

.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

.cancelbtn, .signupbtn {
	float: left;
	width: 100%;
}

.container {
	padding: 16px;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}

.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

.tab button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #ccc;
}

.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>

<body>
	
	<div class="cover">
		<div style="padding-bottom: 10px">
			<h3>QUẢN LÝ THÔNG TIN SẢN PHẨM, ĐƠN HÀNG, THANH TOÁN</h3>
		</div>
		<div class="tab" style="display: flex">
		  <button class="tablinks stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" style="width: 150px"  onclick="openCity(event, 'product')">Sản Phẩm</button>
		  <button class="tablinks stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" style="width: 150px"  onclick="openCity(event, 'order')">Đơn Hàng</button>
		  <button class="tablinks stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" style="width: 150px"  onclick="openCity(event, 'payment')">Thanh Toán</button>
		</div>
		
		<div id="product" class="tabcontent">
			<button style="width: 150px" onclick="location.href='${rootPath}/admin/new-product-form'" 
					class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"> Thêm mới </button>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Tên sản phẩm</th>
			      <th scope="col">Mã sản phẩm</th>
			      <th scope="col">Số lượng</th>
			      <th scope="col">Giá (VNĐ)</th>
			      <th scope="col">Trạng thái</th>
			      <th scope="col">Giảm giá</th>
			      <th scope="col">Ngày áp dụng giảm giá</th>
			      <th scope="col">Mô tả</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${products}" var="p">
			  			<tr>
					      <td>${p.name}</td>
					      <td>${p.productCode}</td>
					      <td>${p.quantity}</td>
					      <td>${p.price}</td>
					      <td>${p.status}</td>
					      <td>${p.discount}</td>
					      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.startDateDiscount}" /></td>
					      <td>${p.description}</td>
					      <td><button>Xóa</button></td>
					    </tr>
				</c:forEach>	
			  </tbody>
			</table>
		</div>
		
		<div id="order" class="tabcontent">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Mã đơn hàng</th>
			      <th scope="col">Giá (VNĐ)</th>
			      <th scope="col">Số lượng</th>
			      <th scope="col">Ngày tạo</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${orders}" var="p">
			  			<tr>
					      <td>${p.orderCode}</td>
					      <td>${p.price}</td>
					      <td>${p.quantity}</td>
					      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.createDate}" /></td>
					    </tr>
				</c:forEach>	
			  </tbody>
			</table>
		</div>
		
		<div id="payment" class="tabcontent">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Phương thức thanh toán</th>
			      <th scope="col">Mã đơn hàng</th>
			      <th scope="col">Ngày thanh toán</th>
			      <th scope="col">Số tài khoản</th>
			      <th scope="col">Chủ tài khoản</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${payments}" var="p">
			  			<tr>
			  			  <c:if test="${p.paymentType == 1}">
			  			  	<td>Thanh toán tiền mặt</td>	
			  			  </c:if>
			  			  <c:if test="${p.paymentType == 2}">
			  			  	<td>Chuyển khoản qua ngân hàng</td>
			  			  </c:if>
					      <td>${p.orderCode}</td>
					      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.createDate}" /></td>
					      <td>${p.accountNo}</td>
					      <td>${p.accountName}</td>
					    </tr>
				</c:forEach>	
			  </tbody>
			</table>
		</div>
	</div>
</body>

<script>
	function openCity(evt, cityName) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(cityName).style.display = "block";
	  evt.currentTarget.className += " active";
	}
</script>

<jsp:include page="footer.jsp" flush="true" />