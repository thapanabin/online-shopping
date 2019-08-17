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
		<%@include file="./shared/navbar.jsp"%>

		<!--Page Content  -->
		<div class="content">
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Loading About only when user click About -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Loading Contact only when user click Contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- Loading products only when user click viewProducts -->
			<c:if test="${userClickViewProducts == true or userClickCategoryProducts == true}">
			<%@include file="listProducts.jsp" %>
			</c:if>
			
			<!--Loading single product only when user click show product -->
			<c:if test="${userClickShowProduct == true}">
			<%@include file="singleProduct.jsp" %>
			</c:if>
			
			
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<script src="${js}/jquery.js"></script>
		
		<!--DataTable plugin  -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!--DataTable Bootstrap script  -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
