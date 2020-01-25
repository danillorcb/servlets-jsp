<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/alteraEmpresa" var="linkEntradaServlet"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>
<form action="${ linkEntradaServlet }" method="POST">
	Nome da empresa: <input type="text" name="nome" value="${ empresa.nome }">
	<br>
	Data de abertura: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>">
	<br>
	<input type="hidden" name="id" value="${ empresa.id }" >
	<input type="submit"> 
</form>
</body>
</html>