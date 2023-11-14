<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp" flush="true"/>

<body>
	<h1>${message}</h1>
	<a href="http://localhost:8080/account/signin-form"> Quay lại </a>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp" flush="true"/>