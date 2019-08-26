<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<!-- Form Elements  -->

					<sf:form class="form-horizontal" method="POST" id="registerForm" modelAttribute="user">


						<div class="form-group">
							<label class="control-label col-md-4 " for="firstName">First
								Name </label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" placeholder="First Name"
									class="form-control" />
									
									<sf:errors path="firstName" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="lastName">Last
								Name</label>
							<div class="col-md-8">
								<!-- parameter on path should be same as the name in the user class -->
								<sf:input type="text" path="lastName" placeholder="Last Name"
									class="form-control" />
									<sf:errors path="lastName" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="email">Email </label>
							<div class="col-md-8">
								<sf:input type="email" path="email" placeholder="abc@zyx.com"
									class="form-control" />
									<sf:errors path="email" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4" for="contactNumber">Contact
								Number </label>
							<div class="col-md-8">
								<sf:input type="number" class="form-control"
									path="contactNumber" placeholder="XXXXXXXXXX " />
									<sf:errors path="contactNumber" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="password">Password
							</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" placeholder="Password"
									class="form-control" />
									<sf:errors path="password" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="confirmPassword">Confirm Password
							</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" placeholder="Re-enter Password"
									class="form-control" />
									<sf:errors path="confirmPassword" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>

						<!--radio button using bootstrap class of radio-inline  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="selectRole">Select
								Role </label>
							<div class="col-md-8">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" />User
								</label> <label class="radio-inline"> <sf:radiobutton
										path="role" value="SUPPLIER" />Supplier
								</label>
							</div>

						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<!--Submit button  -->
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								
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
