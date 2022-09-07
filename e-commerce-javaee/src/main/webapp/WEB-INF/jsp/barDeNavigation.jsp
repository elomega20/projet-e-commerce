<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Logo et nom du site</a>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<form class="d-flex" role="search">
				<input style="width: 500px; border-color:  #191970;" class="form-control me-2" type="search" placeholder="Chercher un produit , une marque ou une catégorie"
					aria-label="Search">
				<button style="color:  #191970; border-color:  #191970;" class="btn btn-outline-success" type="submit">Rechercher</button>
			</form>
			
			<div class="btn-group" style="margin-left: 20px; height: 40px;">
				<button class="btn btn-secondary dropdown-toggle"
					type="button" data-bs-toggle="dropdown" aria-expanded="false"
					style="background-color: white; color: black; border: none">
					<div style="float: left;"><ion-icon size="large" name="person-outline"></ion-icon></div>
					<div style="float: left; margin-left: 5px;"><span>Compte</span></div>
			    </button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Menu item</a></li>
					<li><a class="dropdown-item" href="#">Menu item</a></li>
					<li><a class="dropdown-item" href="#">Menu item</a></li>
				</ul>
			</div>
			
			<div class="btn-group" style="margin-left: 20px; height: 40px;">
				<button id="btn-aide" class="btn btn-secondary dropdown-toggle"
					type="button" data-bs-toggle="dropdown" aria-expanded="false"
					style="background-color: white; color: black; border: none">
					<div style="float: left;"><ion-icon name="help-circle-outline" size="large"></ion-icon></div>
					<div style="float: left; margin-left: 5px;"><span>Aide</span></div>
			    </button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Menu item</a></li>
					<li><a class="dropdown-item" href="#">Menu item</a></li>
					<li><a class="dropdown-item" href="#">Menu item</a></li>
				</ul>
			</div>

			<div style="margin-left: 20px;">
				<a style="color: black;" href="#"> 
				    <svg id="i-cart" xmlns="http://www.w3.org/2000/svg"
						viewBox="0 0 32 32" width="32" height="28" fill="none"
						stroke="currentcolor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2">
                        <path
							d="M6 6 L30 6 27 19 9 19 M27 23 L10 23 5 2 2 2" />
                        <circle cx="25" cy="27" r="2" />
                        <circle cx="12" cy="27" r="2" />
                    </svg> 
                    <span>Panier</span>
				</a>
			</div>
		</div>
	</div>
</nav>