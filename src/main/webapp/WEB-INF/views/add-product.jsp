<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" flush="true"/>

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

button:hover {
  opacity:1;
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
		<form action="${rootPath}/admin/product/add" style="border:1px solid #ccc">
		  <div class="container">
		    <h1 style="text-align: center; padding-top: 20px">Thêm Sản Phẩm Mới</h1>
		    <hr>
		
		    <label for="name"><b>Tên sản phẩm</b></label>
		    <input type="text" placeholder="VD: Mắt kính" name="name" required>
		    
		    <label for="quantity"><b>Số lượng</b></label>
		    <input type="text" placeholder="VD: 20" name="quantity" required>
		    
		    <label for="price"><b>Giá</b></label>
		    <input type="text" placeholder="VD: 500.000" name="price" required>
		    
		    <label for="description"><b>Mô tả</b></label>
		    <input type="text" placeholder="VD: Mô tả" name="description" required>
		    
		    <label for="category"><b>Danh mục</b></label>
		    <select name="category">
		    	<option value="1">Điện tử</option>
		    	<option value="2">Quấn áo</option>
		    	<option value="3">Gia dụng</option>
		    	<option value="4">Khác</option>
		    </select>
		
		    <div class="clearfix">
		      <div class="submit-btn">
		      	<button type="submit" class="signupbtn">Thêm</button>
		      </div>
		    </div>
		  </div>
		</form>
	</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>