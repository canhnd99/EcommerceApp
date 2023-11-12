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
</style>

<body>
	<div class="cover">
		<button style="width: 150px" onclick="location.href='${rootPath}/admin/new-product-form'" 
			class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"> Thêm mới </button>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Phương thức thanh toán</th>
		      <th scope="col">Mã đơn hàng</th>
		      <th scope="col">Thời điểm thanh toán</th>
		      <th scope="col">Số tiền</th>
		      <th scope="col">Người thanh toán</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${payments}" var="p">
		  			<tr>
		  			  <c:if test="${p.paymentType == 1}">
		  			  	<td>Thanh toán khi nhận hàng</td>
		  			  </c:if>
				      <c:if test="${p.paymentType == 2}">
		  			  	<td>Chuyển khoản</td>
		  			  </c:if>
				      <td>${p.orderCode}</td>
				      <td>${p.createTime}</td>
				      <td>${p.price}</td>
				      <td>${p.status}</td>
				      <td>${p.discount}</td>
				      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.startDateDiscount}" /></td>
				      <td>${p.description}</td>
				      <td><button>Cập nhật</button></td>
				      <td><button>Xóa</button></td>
				    </tr>
			</c:forEach>	
		  </tbody>
		</table>
	</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true" />