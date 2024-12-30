<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="publica-cadastro-titulo.livro"/></title>

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
			<br>
				<h2><fmt:message key="publica-cadastro-titulo.livro"/></h2>			
				
<br>
				
				<form
					action="${pageContext.request.contextPath}/publica?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-isbn.livro"/></label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="isbn">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-titulo.livro"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="titulo">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-edicao.livro"/></label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="edicao">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-publicacao.livro"/></label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="publicacao">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-descricao.livro"/></label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="descricao">
						</div>
					</div>

		

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
</div>
</body>
</html>