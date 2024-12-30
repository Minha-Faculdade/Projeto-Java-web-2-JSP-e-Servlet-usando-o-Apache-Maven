<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="publica-listagem-titulo.fornecedor" /></title>


<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">
			
		<div class="col">
				<h2>
				<br>
					<fmt:message key="publica-listagem-titulo.fornecedor" />
				</h2>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th><fmt:message key="fornecedor.id" /></th>
							<th><fmt:message key="fornecedor.nome" /></th>
							<th><fmt:message key="fornecedor.cnpj" /></th>
							<th><fmt:message key="fornecedor.telefone" /></th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fornecedor" items="${listaFornecedores}">
							<tr>
								<td><c:out value="${fornecedor.id}" /></td>
								<td><c:out value="${fornecedor.nome}" /></td>
								<td><c:out value="${fornecedor.cnpj}" /></td>
								<td><c:out value="${fornecedor.telefone}" /></td>
								
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('<fmt:message key="admin-listar-fornecedor.confirmacaoapagar" />');"
									href="${pageContext.request.contextPath}/auth/admin/fornecedor?acao=apagar&id=<c:out value="${fornecedor.id}" />">
									<fmt:message key="admin-listar-fornecedor.botaoapagar" /></a>
									
								</td>	
									
									
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
