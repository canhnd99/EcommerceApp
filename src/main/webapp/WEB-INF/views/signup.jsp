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
		<form action="${rootPath}/account/signup" style="border:1px solid #ccc">
		  <div class="container">
		    <h1 style="text-align: center; padding-top: 20px">Tạo Tài Khoản</h1>
		    <hr>
		
		    <label for="email"><b>Họ và tên</b></label>
		    <input type="text" placeholder="VD: Nguyễn Văn An.." name="fullname" required>
		    
		    <label for="email"><b>Username</b></label>
		    <input type="text" placeholder="VD: annv123" name="username" required>
		    
		    <label for="email"><b>Email</b></label>
		    <input type="text" placeholder="VD: annv@gmail.com" name="email" required>
		    
		    <label for="address"><b>Địa chỉ</b></label>
		    <input type="text" placeholder="VD: 144 Xuân Thủy, Dịch Vọng Hậu..." name="address" required>
		    
		    <label for="phone"><b>Số điện thoại</b></label>
		    <input type="text" placeholder="VD: 0357623918" name="phone" required>
		
		    <label for="password"><b>Mật khẩu</b></label>
		    <input type="password" placeholder="..........." name="password" required>
		
		    <div class="clearfix">
		      <div class="submit-btn">
		      	<button type="submit" class="signupbtn">Đăng ký</button>
		      </div>
		    </div>
		  </div>
		</form>
	</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>