<%-- 
    Document   : index
    Created on : 04/09/2015, 15:57:10
    Author     : marcio
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  type="text/css" href="<c:url value="/css/styles.css"/>"/> 
        <link rel="stylesheet" href="css/animate.min.css">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Gerente Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>${msg}</h1>
            </div>

            <div class="row">
                <a  id="chamarSenha" class="btn" href="${linkTo[GerenteController].chamarSenha}">Chamar Senha</a>
                <a  class="btn" href="${linkTo[GerenteController].gerarSenhas}">Iniciar senhas</a>
            </div>

            <div class="row z-depth-1" id="senhasDisponiveis">
                <c:if test="${not empty senhas}">
                    <h4>Senhas geradas</h4>
                    <ul>
                        <c:forEach items="${senhas}" var="s">
                            <li>
                                <div>${s}</div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${empty senhas}">
                    <h4>Não há senhas disponiveis</h4>
                </c:if>
            </div>
            <div class="row z-depth-1">
                <c:if test="${not empty senhaChamada}">
                    <h4>Senha chamada : ${senhaChamada}</h4>                    
                </c:if>    
                <c:if test="${empty senhaChamada}">
                    <h4>Nenhuma senha chamada ${senhaChamada}</h4>                    
                </c:if>  
            </div>
        </div>
        <script type="text/javascript" src="js/jquery211.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>
