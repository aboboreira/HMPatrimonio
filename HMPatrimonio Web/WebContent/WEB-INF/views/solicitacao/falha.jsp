<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilo_sucesso.css" />"
	rel="stylesheet">
</head>
<title>Administrador Sucesso</title>
<body>
	
	
	<c:if test="${empty param.id}">
		<br/><br/><br/>
		<h1>N�o foi poss�vel concretizar a solicita��o, verifique todas as informa��es e tente novamente<br/>
		
		<img src='<c:url value="/resources/imgs/falha.jpg"/>'>
		</h1>
	</c:if>
	
	
<script lang="JavaScript">
	setTimeout("document.location = 'solicitar_movimentacao'", 2000)
</script>

</body>
</html>