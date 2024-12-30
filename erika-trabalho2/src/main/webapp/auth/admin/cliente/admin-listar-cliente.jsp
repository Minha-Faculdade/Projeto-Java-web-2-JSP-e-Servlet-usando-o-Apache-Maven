<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="publica-listagem-titulo.cliente" /></title>


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
					<fmt:message key="publica-listagem-titulo.cliente" />	
				</h2>
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th><fmt:message key="cliente.id" /></th>
							<th><fmt:message key="cliente.nome"/></th>
							<th><fmt:message key="cliente.nascimento" /></th>
							<th><fmt:message key="cliente.idade"/></th>
						
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cliente" items="${listaClientes}">
							<tr>
								<td><c:out value="${cliente.id}" /></td>
								<td><c:out value="${cliente.nome}" /></td>
								<td><fmt:formatDate value='${cliente.data_nascimento}'
										type='date' pattern='dd/MM/yyyy' /></td>
								<td><c:out value="${cliente.idade}" /></td>
								
									
															
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('<fmt:message key="admin-listar-cliente.confirmacaoapagar" />');"
									href="${pageContext.request.contextPath}/auth/admin/cliente?acao=apagar&id=<c:out value="${cliente.id}" />">
									<fmt:message key="admin-listar-cliente.botaoapagar" /></a>
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
