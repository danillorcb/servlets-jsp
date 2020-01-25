<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.danillorcb.gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista das Empresas</title>
</head>
<body>
	<c:if test="${ not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<table border="2" bgcolor="#e6e6ff">
			<tr>
				<td colspan="4" align="center"><b>Lista de Empresas</b></td>
			</tr>
			<c:forEach items="${ empresas }" var="empresa">
				<tr>
					<td>${ empresa.nome }</td>
					<td><fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/></td>
					<td><a href="/gerenciador/mostraEmpresa?id=${ empresa.id }">Altera</a></td>
					<td><a href="/gerenciador/removeEmpresa?id=${ empresa.id }">Remove</a></td>
				</tr>	
			</c:forEach>
	</table>
	<a href="/gerenciador/formNovaEmpresa.jsp">Nova Empresa</a>
</body>
</html>