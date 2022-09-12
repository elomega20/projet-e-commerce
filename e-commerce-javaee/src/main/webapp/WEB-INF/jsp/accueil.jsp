<%@include file="fichierEntete.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Accueil</title>
	<%@include file="/WEB-INF/jsp/link.jsp"%>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
    <%@include file="barDeNavigation.jsp" %>
    
    
    <%@include file="carouel.jsp" %>
    
    
	<%@include file="/WEB-INF/jsp/linkScript.jsp" %>
</body>
</html>