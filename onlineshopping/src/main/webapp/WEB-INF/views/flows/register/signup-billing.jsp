<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Address</h4>
				</div>
				<div class="panel-body">
					<!-- Form Elements  -->

					<sf:form class="form-horizontal" method="POST" id="billigForm" modelAttribute="billing">


						<div class="form-group">
							<label class="control-label col-md-4 " for="addressLineOne">Address Line One
							 </label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" placeholder="Enter Address Line One"
									class="form-control" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
							<div class="col-md-8">
								<!-- parameter on path should be same as the name in the user class -->
								<sf:input type="text" path="addressLineTwo" placeholder="Enter Address Line Two"
									class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="city">City </label>
							<div class="col-md-8">
								<sf:input type="text" path="city" placeholder="Enter City Name"
									class="form-control" />
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code
								 </label>
							<div class="col-md-8">
								<sf:input type="number" class="form-control"
									path="postalCode" placeholder="XXXXXX " />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="state">State
							</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" placeholder="Enter State Name"
									class="form-control" />
							</div>

						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country
							</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" placeholder="Enter Country Name"
									class="form-control" />
							</div>

						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<!--Submit button  -->
								<button type="submit" class="btn btn-primary" name="_eventId_personal">
								<span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal 
								
								</button>
								
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">
								Next - Confirm<span class="glyphicon glyphicon-chevron-right"></span>
								
								</button>
							</div>
						</div>

					</sf:form>

				</div>

			</div>
		</div>
	</div>
</div>


<%@include file="../shared/flows-footer.jsp"%>
