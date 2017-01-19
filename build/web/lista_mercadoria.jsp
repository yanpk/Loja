<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Mercadorias</title>
        <link rel="stylesheet" type="text/css" href="scripts/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="scripts/css/estilo.css">
    </head>
    <body>
        <div class="container-fluid-cad bg-5 text-center">
            <div class="row">
                <h1 class="margin">Relação de Mercadorias Cadastradas</h1>  
            </div>
        </div>
        
        <div align="center" class="container-fluid-mid-lista bg-list text-center">
        <table class="table table-bordered table-hover">
            <thead>            
                <tr>
                    <td>Código</td>
                    <td>Tipo</td>
                    <td>Nome</td>
                    <td>Quantidade</td>
                    <td>Preço</td>
                    <td>Tipo de Negócio</td>
  
                    <th>Apagar</th>
                    <th>Alterar</th>
                </tr>
            <tbody> 
                <c:forEach var="mercadoria" items="${mercadorias}">
                    <tr>
                        <td>${mercadoria.id}</td>
                        <td>${mercadoria.tipo}</td>
                        <td>${mercadoria.nome}</td>
                        <td>${mercadoria.quantidade}</td>
                        <td>${mercadoria.preco}</td>
                        <td>${mercadoria.tiponegocio}</td>

                        <td><a href="MercadoriaController?acao=deletar&id=${mercadoria.id}"><span class="glyphicon glyphicon-remove icone-lista"></span></a></td>                                     
                        <td><a href="MercadoriaController?acao=editar&id=${mercadoria.id}"><span class="glyphicon glyphicon-edit icone-lista"></span></a></td>                              
                    </tr>
                </c:forEach>
            </tbody>        
        </table>
        <c:if test="${fn:length(mercadorias) > 0}">
            Existem ${fn:length(mercadorias)} mercadorias cadastradas!
        </c:if><br><br> 		
        <a class="btn btn-default" href="mercadoria.jsp">Cadastrar Mercadoria</a>
        </div>
    </body>
</html>