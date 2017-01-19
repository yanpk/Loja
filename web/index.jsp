<%-- 
    Document   : index
    Created on : 19/01/2017, 12:41:54
    Author     : YAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <jsp:forward page="/MercadoriaController?acao=listaMercadoria" />
    </body>
</html>
