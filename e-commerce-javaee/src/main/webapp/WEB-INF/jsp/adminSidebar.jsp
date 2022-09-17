	<!-------sidebar--design------------>

	<div id="sidebar">
		<div class="sidebar-header">
				<img id="id-logo" alt="mon logo" src="<c:url value="/STOCKAGE/images/logo.png"/>" style="width: 200px;"/>
		</div> 
		<ul class="list-unstyled component m-0">
			<li class="active">
			    <a href="http://localhost:8080/e-commerce-javaee/admin" class="dashboard" id="dashboard">
			        <i class="material-icons">dashboard</i>dashboard  
			    </a>
			</li>
			<li class="dropdown">
			    <a href="#homeSubmenu6" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
			        <i class="material-icons">grid_on</i>tables
			    </a>
				<ul class="collapse list-unstyled menu" id="homeSubmenu6">
				    <li><a href="#">Clients</a></li>
				    <li><a href="#">Categories</a></li>
					<li><a href="http://localhost:8080/e-commerce-javaee/admin/articles" id="article">Articles</a></li>
					<li><a href="#">Images</a></li>
					<li><a href="#">Commandes</a></li>
					<li><a href="#">Commandes_Articles</a></li>
					<li><a href="#">Payements</a></li>
					<li><a href="#">Livraisons</a></li>
					<li><a href="#">Livreurs</a></li>
				</ul>
			</li>
		</ul>
	</div>

	<!-------sidebar--design- close----------->