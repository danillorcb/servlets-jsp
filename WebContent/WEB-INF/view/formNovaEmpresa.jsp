<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>
<form action="${ linkEntradaServlet }" method="POST">
	Nome da empresa: <input type="text" name="nome" >
	<br>
	Data de abertura: <input type="text" name="data" >
	<br>
	<input type="hidden" name="acao" value="NovaEmpresa">
	<input type="submit"> 
</form>
</body>
</html>