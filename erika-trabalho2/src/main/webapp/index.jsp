<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="index-titulo" /></title>

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
	

<footer class=" mb-3 container-fluid bg-dark text-white py-5">
        <div class="row">
           
            <div class="col">
               <div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col">
            <h2> <fmt:message key="index-menssage" /></h2>
            
        </div>
    </div>
</div>
            </div>
        </div>
    </footer>
     <style>
        html {
            background-color: #333; /* Cor de fundo do footer */
        }

        .col {
            text-align: center; /* Alinhamento central do texto dentro das colunas */
        }

        h2 {
            color: #fff; /* Cor do título h2 */
        }

        p {
            color: #ddd; /* Cor dos parágrafos */
        }

    </style>
    </body>
</html>

