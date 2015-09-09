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
        <title>Index Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row center-align">
                <div class="col s12"><h1> ${msg}</h1></div>
                <div class="col s6 "><a  class="btn  " href="<c:url value="/index/gerente"/>">Ir para Gerente</a></div>
                <div class="col s6 "><a  class="btn " href="<c:url value="/index/cliente"/>">Ir para Cliente</a></div>
            </div> 
            <div class="row card-panel teal lighten-2">
                <div class="col s12 white-text"><p>Modelo de teste para de cargo Analista de sistemas III - Paripassu</p></div>
                <div class="col s6 white-text"><p>Felipe Antonio Zadinello</p></div>
                <div class="col s6 white-text"><p>felipezad@gmail.com</p></div>
               
            </div>
        </div>
        <script type="text/javascript" src="js/jquery211.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>

</html>
