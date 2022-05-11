<%-- 
    Document   : home-user
    Created on : Mar 26, 2022, 6:54:56 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<c:url value="resources/image/favicon.png" />" type="image/png">
        <title>Royal Hotel</title>
        <jsp:include page="include/user/css-page.jsp" />
    </head>
    <body>
       <jsp:include page="include/user/header-page.jsp" />
       <jsp:include page="include/user/banner-page.jsp" />
       <jsp:include page="include/user/accomodation.jsp" />
       <jsp:include page="include/user/facilities.jsp" />
       <jsp:include page="include/user/abouthistory.jsp" />
       <jsp:include page="include/user/testimonial.jsp" />
       <jsp:include page="include/user/latestblog.jsp" />
       <jsp:include page="include/user/footer-page.jsp" />
       <jsp:include page="include/user/js-page.jsp" />
       </body>
</html>
