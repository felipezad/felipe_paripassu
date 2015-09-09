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
        <!--<meta http-equiv="refresh" content="1">-->
        <link rel="stylesheet"  type="text/css" href="<c:url value="/css/styles.css"/>"/> 
        <link rel="stylesheet" href="css/animate.min.css">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Cliente Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>${msg}</h1>
            </div>                    

            <div class="row">
                <a class="btn" href="${linkTo[ClienteController].pegarSenhaNormal}">Solicitar Senha Normal</a>
                <a class="btn" href="${linkTo[ClienteController].pegarSenhaPreferencial}">Solicitar senha preferencial</a>
            </div> 
            <div class="row z-depth-1">
                <c:if test="${not empty senha}">
                    <h4>Sua Senha : ${senha}</h4>
                </c:if>
                <c:if test="${empty senha}">
                    <h4>${msgSenha}</h4>
                </c:if>
            </div>
            <div id="senhaAtual" class="row z-depth-1 teal-text text-lighten-2">
                <h4 >Senha Chamada</h4>
                <h1 id="passCurrentValue" >

                </h1>
            </div>
        </div>  





        <script type="text/javascript" src="js/jquery211.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/websocket.js"></script>
    </body>
</html>
