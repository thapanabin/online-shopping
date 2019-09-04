<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container navbar nav">
	<div class="row">
		<!-- To display Side Bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!--To display actual products  -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickViewProducts == true }">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>

					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">

				<div class="col-xs-12">
					<div class="container-fluid">
						<div class="table-responsive">
							<table id="productListTable"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty. Avaiable</th>
										<th></th>
									</tr>
								</thead>

								<tfoot>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty. Avaiable</th>
										<th></th>
									</tr>
								</tfoot>


							</table>



						</div>

					</div>

				</div>

			</div>
		</div>
	</div>
</div>
