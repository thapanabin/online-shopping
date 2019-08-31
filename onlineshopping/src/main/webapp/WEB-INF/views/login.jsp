<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
</script>

<script>
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- use bootswatch theme-->
<link href="${css}/bootswatchtheme.css" rel="stylesheet">

<!--Datatables bootstrap  -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
				</div>
			</div>
		</nav>
		<!--this will be displayed only if  username password is wrong  -->
		<c:if test="${ not empty message}">
		<div class="container">
		<div class="row">
		<div class="col-md-offset-3 col-md-6">
		<div class="alert alert-danger">${message}</div>
		</div>
		</div>
		</div>
		</c:if>
		
		<!--Forms  -->
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4>Login</h4>
						</div>

						<div class="panel-body">
							<form action="${contextRoot}/login" method="POST"
								class="form-horizontal" id="loginform">
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Email:</label>
									<div class="col-md-8">
									<!-- by default name is username if you want to change it to email then you need to change it to security file as well by using username-parameter="email" -->
										<input type="text" name="username" id="username"
											class="form-control" />
									</div>
								</div>

								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Password:</label>
									<div class="col-md-6">
										<input type="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="submit" value="Login" class="btn btn-primary">
										<!--CSRF  -->
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									</div>
								</div>

							</form>
						</div>
						<div class="panel-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>

		<!--Page Content  -->
		
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		
		<!--JQuery  -->
		<script src="${js}/jquery.js"></script>
		
		<!--JQuery Validation plugin downloaded from jqueryvalidation.org -->
		<script src="${js}/jquery.validate.js"></script>
		
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!--DataTable plugin  -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!--DataTable Bootstrap script  -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!--Bootbox  -->
		<script src="${js}/bootbox.min.js"></script>


		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
