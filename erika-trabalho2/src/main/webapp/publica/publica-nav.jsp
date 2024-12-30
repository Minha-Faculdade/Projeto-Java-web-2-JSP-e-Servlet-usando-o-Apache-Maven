<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">@_@</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown navbar-dark bg-dark" >
      <ul class="navbar-nav">
       <li class="nav-item">
					<a class="nav-link active" aria-current="page" href="#">
						<fmt:message key="publica-nav.home" />
					</a>
				</li>
      
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             <fmt:message key="publica-nav-cadastros" />
          </a>
          <ul class="dropdown-menu bg-light">
            <li>
            <a class="dropdown-item" 
            href="${pageContext.request.contextPath}/publica?acao=cadastro">
            <fmt:message key="publica-nav-livro.cadastro"/>
            </a>
            </li>
            
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cliente?acao=cadastro">
             <fmt:message key="publica-nav-cliente.cadastro"/></a></li>
           
           
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/fornecedor?acao=cadastro">
             <fmt:message key="publica-nav-fornecedor.cadastro"/></a></li>
          </ul>
        </li>
        
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <fmt:message key="publica-nav-listagens" />
          </a>
          <ul class="dropdown-menu bg-light">
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/auth/admin/livro?acao=listar">
            <fmt:message key="publica-nav-livro.listar" /></a></li>
            
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/auth/admin/cliente?acao=listar">
            <fmt:message key="publica-nav-cliente.listar" /></a></li>
            
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/auth/admin/fornecedor?acao=listar">
            <fmt:message key="publica-nav-fornecedor.listar" /></a></li>
          </ul>
        </li>
        
                <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             <fmt:message key="publica-nav-idiomas" />
          </a>
          <ul class="dropdown-menu bg-light">
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/I18nControle?lingua=en_US">
						<fmt:message key="publica-nav.ingles" />
					</a></li>
					
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/I18nControle?lingua=pt_BR">
						<fmt:message key="publica-nav.portugues" />
					</a></li>
          </ul>
        </li>
        
      </ul>
    </div>
  </div>
</nav>
