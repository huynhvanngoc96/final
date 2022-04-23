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
        <title>JSP Page</title>
        <jsp:include page="include/user/css-page.jsp" />
    </head>
    <body>
        <div class="super_container">
            <jsp:include page="include/user/header-page.jsp" />
            <jsp:include page="include/user/menu-page.jsp" />
            <div class="home">
                <div class="home_slider_container">

                    <!-- Home Slider -->
                    <div class="owl-carousel owl-theme home_slider">

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(<c:url value="resources/images/home_slider_1.jpg"/>)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title">A new Online Shop experience.</div>
                                                <div class="home_slider_subtitle">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viverra velit venenatis fermentum luctus.</div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(<c:url value="resources/images/home_slider_1.jpg"/>)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title">A new Online Shop experience.</div>
                                                <div class="home_slider_subtitle">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viverra velit venenatis fermentum luctus.</div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(<c:url value="resources/images/home_slider_1.jpg"/>)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title">A new Online Shop experience.</div>
                                                <div class="home_slider_subtitle">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viverra velit venenatis fermentum luctus.</div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Home Slider Dots -->

                    <div class="home_slider_dots_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_slider_dots">
                                        <ul id="home_slider_custom_dots" class="home_slider_custom_dots">
                                            <li class="home_slider_custom_dot active">01.</li>
                                            <li class="home_slider_custom_dot">02.</li>
                                            <li class="home_slider_custom_dot">03.</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>	
                    </div>
                </div>
            </div>

            <div class="avds">
                <div class="avds_container d-flex flex-lg-row flex-column align-items-start justify-content-between">
                    <div class="avds_small">
                        <div class="avds_background" style="background-image:url(<c:url value="resources/images/avds_small.jpg"/>)"></div>
                        <div class="avds_small_inner">
                            <div class="avds_discount_container">
                                <img src="<c:url value="resources/images/discount.png"/>" alt="">
                                <div>
                                    <div class="avds_discount">
                                        <div>20<span>%</span></div>
                                        <div>Discount</div>
                                    </div>
                                </div>
                            </div>
                            <div class="avds_small_content">
                                <div class="avds_title">Smart Phones</div>
                                <div class="avds_link"><a href="categories.html">See More</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="avds_large">
                        <div class="avds_background" style="background-image:url(<c:url value="resources/images/avds_large.jpg"/>)"></div>
                        <div class="avds_large_container">
                            <div class="avds_large_content">
                                <div class="avds_title">Professional Cameras</div>
                                <div class="avds_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viver ra velit venenatis fermentum luctus.</div>
                                <div class="avds_link avds_link_large"><a href="categories.html">See More</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="products">
                <div class="container">
                    <div class="row">
                        <div class="col">

                            <div class="product_grid">

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_1.jpg"/>" alt=""></div>
                                    <div class="product_extra product_new"><a href="categories.html">New</a></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_2.jpg"/>" alt=""></div>
                                    <div class="product_extra product_sale"><a href="categories.html">Sale</a></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_3.jpg"/>" alt=""></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_4.jpg"/>" alt=""></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_5.jpg"/>" alt=""></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_6.jpg"/>" alt=""></div>
                                    <div class="product_extra product_hot"><a href="categories.html">Hot</a></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_7.jpg"/>" alt=""></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                                <!-- Product -->
                                <div class="product">
                                    <div class="product_image"><img src="<c:url value="resources/images/product_8.jpg"/>" alt=""></div>
                                    <div class="product_extra product_sale"><a href="categories.html">Hot</a></div>
                                    <div class="product_content">
                                        <div class="product_title"><a href="product.html">Smart Phone</a></div>
                                        <div class="product_price">$670</div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="include/user/footer-page.jsp" />
        </div>
        <jsp:include page="include/user/js-page.jsp"/>
    </body>
</html>
