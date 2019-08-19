<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class=" row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
				<button style="font-color = black" type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
				
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form Elements  -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4 " for="name">Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<em class="help-block">Please Enter Product Name!</em>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Brand</label>
							<div class="col-md-8">
								<!-- parameter on path should be same as the name in the product class -->
								<sf:input type="text" path="brand" id="name"
									placeholder="Brand Name" class="form-control" />
								<em class="help-block">Please Enter Brand Name!</em>
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description" class="form-control" />
								<em class="help-block">Please Enter Short Description!</em>
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price: </label>
							<div class="col-md-8">
								<sf:input class="form-control" type="number" path="unitPrice"
									id="unitPrice" placeholder="Unit Price in &#36; " />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Avaiable: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Avaiable" class="form-control" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />


							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!-- We should make it hidden otherwise it will return default values when we use the same form  to edit  -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />



							</div>
						</div>
					</sf:form>

				</div>




			</div>



		</div>

	</div>
</div>