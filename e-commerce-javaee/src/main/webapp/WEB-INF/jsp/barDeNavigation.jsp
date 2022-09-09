<div class="row">
    <div class="col-md-12 col-lg-12">
	    <nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid" id="id-container">
			    <div  id="id-div-logo">
		      	    <a class="navbar-brand" href="#">
		      	       <img id="id-logo" alt="mon logo" src="<c:url value="STOCKAGE/images/logo.png"/>"/>
		      	    </a>
			    </div>
				<div class="collapse navbar-collapse" id="navbarScroll">
				    <div id="id-div-input-rechercher">
					    <form class="d-flex" role="search">
							<input id="id-input-rechercher" class="form-control me-2" type="search" placeholder="Chercher un produit , une marque ou une catégorie"
								aria-label="Search">
							<button id="id-btn-rechercher" class="btn btn-outline-success" type="submit">Rechercher</button>
						</form>
				    </div>
					
					<div class="btn-group" id="btn-color">
						<button class="btn btn-secondary dropdown-toggle" id="btn-compte"
							type="button" data-bs-toggle="dropdown" aria-expanded="false">
							<div id="btn-compte-icon"><ion-icon size="large" name="person-outline"></ion-icon></div>
							<div id="btn-compte-span"><span>Compte</span></div>
					    </button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Mon profile</a></li>
							<li><a class="dropdown-item" href="#">Se deconnecter</a></li>
						</ul>
					</div>
					
					<div class="btn-group" id="id-div-aide">
						<button class="btn btn-secondary dropdown-toggle"
							type="button" data-bs-toggle="dropdown" aria-expanded="false" id="id-btn-aide">
							<div id="id-btn-aide-icon"><ion-icon name="help-circle-outline" size="large"></ion-icon></div>
							<div id="id-btn-aide-span"><span>Aide</span></div>
					    </button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Centre d'assistance</a></li>
	                    </ul>
					</div>
		
					<div id="id-div-panier">
						<a  id="id-a-panier" href="#"> 
						    <svg id="i-cart" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 32 32" width="32" height="32" fill="none"
								stroke="currentcolor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2">
		                        <path
									d="M6 6 L30 6 27 19 9 19 M27 23 L10 23 5 2 2 2" />
		                        <circle cx="25" cy="27" r="2" />
		                        <circle cx="12" cy="27" r="2" />
		                        <span id="id-nb-panier" class="badge rounded-pill">5</span>
		                        <span id="id-panier">Panier</span>
		                    </svg>
						</a>
					</div>
				</div>
			</div>
		</nav>
    </div>
</div>
