<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="publica-cadastro-titulo.fornecedor" /></title>

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
				<h2><fmt:message key="publica-cadastro-titulo.fornecedor" /></h2>			
			<br>				

				
				<form
					action="${pageContext.request.contextPath}/fornecedor?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-nome.fornecedor"/></label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="nome">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-cnpj.fornecedor"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="cnpj">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="cadastro-telefone.fornecedor"/></label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="telefone">
						</div>
					</div>

							

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
</div>
</body>
</html>