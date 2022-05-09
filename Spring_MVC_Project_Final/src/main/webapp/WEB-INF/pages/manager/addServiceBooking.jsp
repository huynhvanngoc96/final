<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Booking</title>
<jsp:include page="/WEB-INF/pages/include/management/css-page.jsp" />
<jsp:include page="/WEB-INF/pages/include/management/js-page.jsp" />
</head>
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
		<jsp:include page="/WEB-INF/pages/include/management/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="/WEB-INF/pages/include/management/menu-page.jsp"></jsp:include>
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Service Booking</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Booking</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Service Booking</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Service Booking</header>
									<button id="panel-button"
										class="mdl-button mdl-js-button mdl-button--icon pull-right"
										data-upgraded=",MaterialButton">
										<i class="material-icons">more_vert</i>
									</button>
									<ul
										class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
										data-mdl-for="panel-button">
										<li class="mdl-menu__item"><i class="material-icons">assistant_photo</i>Action</li>
										<li class="mdl-menu__item"><i class="material-icons">print</i>Another
											action</li>
										<li class="mdl-menu__item"><i class="material-icons">favorite</i>Something
											else here</li>
									</ul>
								</div>
								<spring:form action="doAddServiceBooking" method="post" modelAttribute="bookingDetail">
									<div class="form-body">
										<spring:hidden path="id" />

										<div class="col-lg-2 col-md-2 col-sm-2 col-2">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path=""
													readonly="true" />

												<label class="mdl-textfield__label">Booking Number</label>
											</div>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-2">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input"
													path="" readonly="true" />

												<label class="mdl-textfield__label">Room Number</label>
											</div>
										</div>

										
										<div class="table-scrollable">
											<table
												class="table table-hover table-checkable order-column full-width"
												id="example4">
												<thead>
													<tr>
														<th class="center">Name</th>
														<th class="center">Price</th>
														<th class="center">Quantity</th>
														<th class="center">Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${serviceBookingList }" var="item">
														<tr>
															<td class="center">${item.service.name }</td>
															<td class="center">$${item.price }</td>
															<td class="center">${item.quantity }</td>
															<td class="center"><a
																href="removeService?id=${item.id }">
																	<button type="button" class="btn btn-primary">Remove</button>
															</a> </td>
														</tr>

													</c:forEach>
												</tbody>
											</table>
										</div>

										<div class="col-lg-12 p-t-20 text-center">
											<input type="submit" value="Save"
												class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" />
											<a href="viewBooking">
												<button type="button"
													class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Cancel</button>
											</a>
										</div>
									</div>
								</spring:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end page content -->
		</div>
		<jsp:include page="/WEB-INF/pages/include/management/footer-page.jsp"></jsp:include>
	</div>
	
</body>
</html>