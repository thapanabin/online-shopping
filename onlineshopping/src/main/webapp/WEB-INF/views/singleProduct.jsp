<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="container">

	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

	</div>
</div>

<div class="row">

	<!-- Display the product Image -->
	<div class="col-xs-12 col-sm-4">
		<div class="thumbnail">
			<img alt="" src="${images}/${product.code}.jpg"
				class="img img-responsive">
		</div>
	</div>
	<!-- Display the product Description -->
	<div class=" col-xs-12 col-sm-8">
		<h3>${product.name}</h3>
		<hr/>
		<p>${product.description}</p>
		<hr />
		<h4>
			Price:<strong> &#36; ${product.unitPrice} /-</strong>
		</h4>
		<hr />
		
		<security:authorize access="hasAuthority('USER')">
		<c:choose>
		<c:when test="${product.quantity <1}">
		
		<h6>Qty. Avaiable: <span style="color:red">Out of Stock</span></h6>
		
		<a href="javascript:void(0)"
			class="btn btn-success disabled"> <strike><span
			class="glyphicon glyphicon-shopping-cart"></span><strike>Add to Cart
		</a>
		</c:when>
		<c:otherwise>
		<h6>Qty. Avaiable: ${product.quantity}</h6>
		
		<a href="${contextRoot}/cart/add/${product.id}/product"
			class="btn btn-success"> <span
			class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
		</a> 
		
		</c:otherwise>
		</c:choose>
		</security:authorize >
		
		<security:authorize access="hasAuthority('ADMIN')">
		<a href="${contextRoot}/manage/${product.id}/product"
			class="btn btn-warning"> <span
			class="glyphicon glyphicon-shopping-pencil"></span>Edit
		</a>
		
		</security:authorize>
		

		<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
	</div>

</div>