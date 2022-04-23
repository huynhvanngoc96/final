<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<jsp:include page="include/management/css-page.jsp" />
<jsp:include page="include/management/js-page.jsp" />
</head>
<body class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
	
		<jsp:include page="include/management/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="include/management/menu-page.jsp"></jsp:include>
			
			
			<jsp:include page="include/management/chat_sidebar-page.jsp"></jsp:include>
		</div>
		<jsp:include page="include/management/footer-page.jsp"></jsp:include>
	</div>
</body>
</html>