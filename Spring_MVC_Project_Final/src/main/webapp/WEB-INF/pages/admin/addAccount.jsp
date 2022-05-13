<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<jsp:include page="/WEB-INF/pages/include/admin/css-page.jsp" />
<jsp:include page="/WEB-INF/pages/include/admin/js-page.jsp" />
</head>
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
		<jsp:include page="/WEB-INF/pages/include/admin/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="/WEB-INF/pages/include/admin/menu-page.jsp"></jsp:include>
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Add Account</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Manage Account</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Add Account</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Add Account</header>
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
								<spring:form action="doAddAccount" method="post"
									modelAttribute="user">
									<div class="card-body row">

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="fullName" />
												<spring:errors path="fullName" cssStyle="color:red" />
												<label class="mdl-textfield__label">Name</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="email"
													type="email" />
												<spring:errors path="email" cssStyle="color:red" />
												<label class="mdl-textfield__label">Email</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="password"
													type="password" />

												<label class="mdl-textfield__label">Password</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input"
													path="phoneNumber" />

												<label class="mdl-textfield__label">Phone Number</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="address" />

												<label class="mdl-textfield__label">Address</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input path="birthDate" id="date"
													class="floating-label mdl-textfield__input"
													placeholder="BirthDay" />
													<spring:errors path="birthDate" cssStyle="color: red"/>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<div class="form-group">
													<spring:select path="gender" cssClass="form-control">
														<spring:option value="">Select</spring:option>
														<spring:option value="Male">Male</spring:option>
														<spring:option value="Female">Female</spring:option>
														<spring:option value="Other">Other</spring:option>
													</spring:select>

												</div>
											</div>
										</div>



										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<div class="form-group">
													<spring:select path="status" cssClass="form-control">
														<spring:option value="">Select</spring:option>
														<spring:options items="${status}" />
													</spring:select>
													<spring:errors path="status" cssStyle="color:red" />
												</div>
											</div>
										</div>

										
										<div class="col-lg-12 p-t-20 text-center">
											<input type="submit" value="Add"
												class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" />
											<a href="viewAccount">
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
		<jsp:include page="/WEB-INF/pages/include/admin/footer-page.jsp"></jsp:include>
	</div>
</body>
</html>