<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="publica-listagem-titulo.livro" /></title>


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
					<fmt:message key="publica-listagem-titulo.livro" />
				
				</h2>
				<br>
				<table class="table table-striped">
				
					<thead>
						<tr>
							<th><fmt:message key="livro.id" /></th>
							<th><fmt:message key="livro.isbn" /></th>
							<th><fmt:message key="livro.titulo" /></th>
							<th><fmt:message key="livro.edicao" /></th>
							<th><fmt:message key="livro.publicacao" /></th>
							<th><fmt:message key="livro.descricao" /></th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="livro" items="${listaLivros}">
							<tr>
								<td><c:out value="${livro.id}" /></td>
								<td><c:out value="${livro.isbn}" /></td>
								<td><c:out value="${livro.titulo}" /></td>
								<td><c:out value="${livro.edicao}" /></td>
								<td><c:out value="${livro.publicacao}" /></td>
								<td><c:out value="${livro.descricao}" /></td>
																
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('<fmt:message key="admin-listar-livro.confirmacaoapagar" />');"
									href="${pageContext.request.contextPath}/auth/admin/livro?acao=apagar&id=<c:out value="${livro.id}" />">
									<fmt:message key="admin-listar-livro.botaoapagar" /></a>
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
