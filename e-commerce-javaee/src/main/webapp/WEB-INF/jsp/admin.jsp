<%@include file="fichierEntete.jsp"%>

<!DOCTYPE html>
<html>
<head> 
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>crud dashboard</title>
	    <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	    <!----css3---->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
		
		
		<!--police de google -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	
	
	   <!--icon de meteriel google-->
      <link href="https://fonts.googleapis.com/css2?family=Material+Icons"rel="stylesheet">
</head>
<body>



	<div class="wrapper">
	
		<div class="body-overlay"></div>
		<%@include file="adminSidebar.jsp" %>
	    <%@include file="adminContent.jsp" %>
	
	</div>

	<!-------complete html----------->
	
	    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/custom.js"></script>


</body>
</html>