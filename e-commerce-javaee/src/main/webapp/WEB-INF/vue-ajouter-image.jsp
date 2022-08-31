<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ !empty nomImage }">
		<p>
			<c:out value="Le fichier ${ nomImage } a été uploadé !" />
		</p>
		<img alt="mon image" src="<c:url value="STOCKAGE/images/${ nomImage }"/>"/>
	</c:if>
	<form method="post" action="vue-ajouter-image" enctype="multipart/form-data">
		<label for="fichier">ajouter une image:</label> <input type="file"
			name="fichier"> <input type="submit" value="ajouter">
	</form>
</body>
</html>