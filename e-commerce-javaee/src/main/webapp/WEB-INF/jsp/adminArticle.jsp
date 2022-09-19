<%@include file="fichierEntete.jsp"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<title>crud dashboard</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<!----css3---->
<link rel="stylesheet" href="<c:url value="/css/custom.css"/>">


<!--police de google -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">


<!--icon de meteriel google-->
<link href="https://fonts.googleapis.com/css2?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<div class="body-overlay"></div>
		<%@include file="adminSidebar.jsp"%>

		<!-------page-content start----------->

		<div id="content">

			<!------top-navbar-start----------->

			<div class="top-navbar">
				<div class="xd-topbar">
					<div class="row">
						<div
							class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
							<div class="xp-menubar">
								<span class="material-icons text-white">signal_cellular_alt</span>
							</div>
						</div>

						<div class="col-md-5 col-lg-3 order-3 order-md-2">
							<div class="xp-searchbar">
								<form>
									<div class="input-group">
										<input type="search" class="form-control" placeholder="Search">
										<div class="input-group-append">
											<button class="btn" type="submit" id="button-addon2">Go
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>


						<div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
							<div class="xp-profilebar text-right">
								<nav class="navbar p-0">
									<ul class="nav navbar-nav flex-row ml-auto">
										<li class="dropdown nav-item active"><a class="nav-link"
											href="#" data-toggle="dropdown"> <span
												class="material-icons">notifications</span> <span
												class="notification">4</span>
										</a>
											<ul class="dropdown-menu">
												<li><a href="#">You Have 4 New Messages</a></li>
												<li><a href="#">You Have 4 New Messages</a></li>
												<li><a href="#">You Have 4 New Messages</a></li>
												<li><a href="#">You Have 4 New Messages</a></li>
											</ul></li>

										<li class="nav-item"><a class="nav-link" href="#"> <span
												class="material-icons">question_answer</span>
										</a></li>

										<li class="dropdown nav-item"><a class="nav-link"
											href="#" data-toggle="dropdown"> <img src="img/user.jpg"
												style="width: 40px; border-radius: 50%;" /> <span
												class="xp-user-live"></span>
										</a>
											<ul class="dropdown-menu small-menu">
												<li><a href="#"> <span class="material-icons">person_outline</span>
														Profile
												</a></li>
												<li><a href="#"> <span class="material-icons">settings</span>
														Settings
												</a></li>
												<li><a href="#"> <span class="material-icons">logout</span>
														Logout
												</a></li>

											</ul></li>
									</ul>
								</nav>
							</div>
						</div>

					</div>
					<div class="xp-breadcrumbbar text-center">
						<h4 class="page-title">Dashboard</h4>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Vishweb</a></li>
							<li class="breadcrumb-item active" aria-curent="page">Dashboard</li>
						</ol>
					</div>
				</div>
			</div>
			<!------top-navbar-end----------->


			<!------main-content-start----------->

			<div class="main-content">
				<div class="row">
					<div class="col-md-12">
						<div class="table-wrapper">

							<div class="table-title">
								<div class="row">
									<div
										class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
										<h2 class="ml-lg-2">Articles</h2>
									</div>
									<div
										class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
										<a href="#addEmployeeModal" class="btn btn-success"
											data-toggle="modal"> <i class="material-icons">&#xE147;</i>
											<span>Ajouter Nouveau Article</span>
										</a> <a href="#deleteEmployeeModal" class="btn btn-danger"
											data-toggle="modal"> <i class="material-icons">&#xE15C;</i>
											<span>Supprimer</span>
										</a>
									</div>
								</div>
							</div>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th><span class="custom-checkbox"> <input
												type="checkbox" id="selectAll"> <label
												for="selectAll"></label>
										</span></th>
										<th>Id</th>
										<th>Designation</th>
										<th>Detail</th>
										<th>Prix Unitaire</th>
										<th>Stock</th>
										<th>Categorie</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="categorie" items="${ categories }">
										<c:set var="articles"
											value="${  catalogues.get(categorie.nom) }">
										</c:set>
										<c:forEach var="article" items="${ articles }">
											<tr>
												<th>
												    <span class="custom-checkbox"> 
												        <input type="checkbox" id="checkbox1" name="option" value="${ article.identifiant }">
														<label for="checkbox1"></label>
												    </span>
												</th>
												<th>${ article.identifiant }</th>
												<th>${ article.designation }</th>
												<th>${ article.detail }</th>
												<th>${ article.prixUnitaire }</th>
												<th>${ article.stock }</th>
												<th>${ article.identifiantCategorie }</th>
												<th>
												    <a href="#editEmployeeModal" class="edit"
													data-toggle="modal"> <i class="material-icons"
														data-toggle="tooltip" title="Edit">&#xE254;</i>
												    </a> 
												    <a href="#deleteEmployeeModal${article.identifiant}" class="delete"
													data-toggle="modal"> <i class="material-icons"
														data-toggle="tooltip" title="Delete">&#xE872;</i>
												    </a>
												    <!----delete-modal start--------->
                                                    <div class="modal fade" tabindex="-1" id="deleteEmployeeModal${article.identifiant}"
														role="dialog">
														<div class="modal-dialog" role="document">
															<form method="post"   action="<c:url value="/admin/articles"/>">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title">Supprimer Un Article</h5>
																		<button type="button" class="close" data-dismiss="modal"
																			aria-label="Close">
																			<span aria-hidden="true">&times;</span>
																		</button>
																	</div>
																	<div class="modal-body">
																		<p>Etez-vous sur de vouloir supprimer cette article(s)?</p>
																		<p class="text-warning">
																			<small>Cette action ne peut pas être annulée</small>
																		</p>
																	</div>
																	<div style="visibility: hidden;">
																	    <a href="#checkbox1"></a>
																	</div>
																	<input type="hidden" name="idArticle" value="${article.identifiant}"/>
																	<input type="hidden" name="operation" value="del"/> 
																	<div class="modal-footer">
																		<button type="button" class="btn btn-secondary"
																			data-dismiss="modal">Non</button>
																		<button type="submit" class="btn btn-success">Oui</button>
																	</div>
																 </div>
														  	 </form>
														 </div>
													 </div>
                                                     <!----delete-modal end--------->
                                                     
                                                     <!----edit-modal start--------->
													 <div class="modal fade" tabindex="-1" id="editEmployeeModal"
														role="dialog">
														<div class="modal-dialog" role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title">Edit Employees</h5>
																	<button type="button" class="close" data-dismiss="modal"
																		aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">
																	<div class="form-group">
																		<label>Name</label> <input type="text" class="form-control"
																			required>
																	</div>
																	<div class="form-group">
																		<label>Email</label> <input type="emil" class="form-control"
																			required>
																	</div>
																	<div class="form-group">
																		<label>Address</label>
																		<textarea class="form-control" required></textarea>
																	</div>
																	<div class="form-group">
																		<label>Phone</label> <input type="text" class="form-control"
																			required>
																	</div>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">Cancel</button>
																	<button type="button" class="btn btn-success">Save</button>
																</div>
															</div>
														</div>
													 </div>
													<!----edit-modal end--------->
												</th>
											</tr>

										</c:forEach>
									</c:forEach>
								</tbody>
							</table>

							<div class="clearfix">
								<div class="hint-text">
									showing <b>5</b> out of <b>25</b>
								</div>
								<ul class="pagination">
									<li class="page-item disabled"><a href="#">Previous</a></li>
									<li class="page-item "><a href="#" class="page-link">1</a></li>
									<li class="page-item "><a href="#" class="page-link">2</a></li>
									<li class="page-item active"><a href="#" class="page-link">3</a></li>
									<li class="page-item "><a href="#" class="page-link">4</a></li>
									<li class="page-item "><a href="#" class="page-link">5</a></li>
									<li class="page-item "><a href="#" class="page-link">Next</a></li>
								</ul>
							</div>
						</div>
					</div>


					<!----add-modal start--------->
					<div class="modal fade" tabindex="-1" id="addEmployeeModal"
						role="dialog">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Ajouter Article</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form method="post"   action="<c:url value="/admin/articles"/>">
								    <div class="modal-body">
										<div class="form-group">
											<label>Designation</label> 
											<input name="designation" type="text" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Detail</label> 
											<textarea name="detail" class="form-control" required></textarea>
										</div>
										<div class="form-group">
											<label>Prix Unitaire</label>
											<input name="prixUnitaire" type="number" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Stock</label> 
											<input name="stock" type="number" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Categorie</label> 
											<select name="select-categorie">
											    <c:forEach var="categorie" items="${ categories }">
											        <option value="${categorie.identifiant}"> ${ categorie.nom } </option>
											    </c:forEach>
											</select>
										</div>
										<input type="hidden" name="operation" value="post"/>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Annuler</button>
										<button type="submit" class="btn btn-success">Ajouter</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!----add-modal end--------->
					
				</div>
			</div>

			<!----footer-design------------->

			<footer class="footer">
				<div class="container-fluid">
					<div class="footer-in">
						<p class="mb-0">&copy 2022 elomega20 . All Rights Reserved.</p>
					</div>
				</div>
			</footer>

		</div>

		<!------main-content-end----------->


	</div>

	<!-------complete html----------->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value="/js/jquery-3.3.1.slim.min.js"/>"></script>
	<script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/js/custom.js"/>"></script>


</body>
</html>
