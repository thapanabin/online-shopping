
<!-- Navigation -->
<nav
	class="navbar navbar-expand-lg navbar-light bg-light  navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container ">
		<a class="navbar-brand" id="home" href="${contextRoot}/home">PK'S
			Online Shopping</a> <span class="navbar-toggler-icon"></span>
		<div class="collapse navbar-collapse" id="navbarResponsive ">
			<ul class=" nav navbar-nav  ">
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>

				<li class="nav-item" id="manageProducts"><a class="nav-link"
					href="${contextRoot}/manage/products">Manage Products</a></li>
					
				
			</ul>
			<!--added login and signup  -->
			<ul class=" nav navbar-nav navbar-right ">
			<li class="nav-item" id="register"><a class="nav-link"
					href="${contextRoot}/register">Sign Up</a>
					</li>
					
					<li class="nav-item" id="login"><a class="nav-link"
					href="${contextRoot}/login">Login</a>
					</li>
					
					<li class="dropdown">
						<a href="javascript:void(0)" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						${userModel.fullName}
						<!-- <span class="caret"></span> -->
						</a>
						
						<ul class="dropdown-menu">
						
						<li>
							<a href="${contextRoot}/cart">
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span class="badge">${userModel.cart.cartLines}</span>
							- &#36; ${ userModel.cart.grandTotal }
							</a>
						</li>
						<li class="divider" role="separator"></li>
						
						<li>
						<a href="${contextRoot}/logout">Logout</a>
						</li>
						
						</ul>
					
					</li>
			</ul>
			
		</div>
	</div>
</nav>
