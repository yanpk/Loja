<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt">
    <head>
        <title>Cadastrar Mercadoria</title>
        <link rel="stylesheet" type="text/css" href="scripts/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="scripts/css/estilo.css">
    </head>
    <body> 
        
        <!-- Cabeçalho -->
        <div class="container-fluid-cad bg-5 text-center">
            <div class="row">
                <h1 class="margin">Cadastro de Mercadorias</h1>  
            </div>
        </div><!-- Cabeçalho -->

        <div align="center" class="container-fluid-mid bg-2 text-center">
            <div class="container">
                <form class="form-horizontal" method="POST" action="MercadoriaController">                                     

                    <div class="form-group">
                        <label class="control-label col-sm-2">CÓDIGO:</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="readonly" class="form-control" name="id" value="${mercadoria.id}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">TIPO:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="tipo" required value="${mercadoria.tipo}" placeholder="TIPO DE MERCADORIA">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">NOME:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nome" required value="${mercadoria.nome}" placeholder="NOME DA MERCADORIA">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label col-sm-2">QUANTIDADE:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="quantidade" required value="${mercadoria.quantidade}" placeholder="QUANTIDADE DE MERCADORIAS">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label col-sm-2">PREÇO:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="preco" required value="${mercadoria.preco}" placeholder="PREÇO DA MERCADORIA">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label col-sm-2">NEGÓCIO:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="tiponegocio" required value="${mercadoria.tiponegocio}" placeholder="TIPO DE NEGÓCIO (COMPRA OU VENDA)">
                        </div>
                    </div>

                    <div align="center" class="container-fluid-mid bg-2 text-center">
                        <div class="btn-group">
                            <button class="btn btn-default" type="submit" name="Cadastrar" value="Cadastrar">
                                <span class="glyphicon glyphicon-floppy-disk icone-botao"></span> 
                                <span>&nbsp; Cadastrar</span>
                            </button>           
                            <button class="btn btn-default" type="submit" name="editar" value="Editar">
                                <span class="glyphicon glyphicon-floppy-disk icone-botao"></span> 
                                <span>&nbsp; Salvar Alteração</span>
                            </button>                               
                            <button class="btn btn-default" type="reset">
                                <span class="glyphicon glyphicon-erase icone-botao"></span> 
                                <span>&nbsp; Apagar</span>
                            </button>
                            <a class="btn btn-default" href="lista_mercadoria.jsp">Ver Mercadorias</a>
                        </div>  
                    </div>
                </form>
            </div>   
        </div>
                        
        <!-- Footer -->
        <footer class="container-fluid-footer-cad bg-4 text-center">
            <div class="row">
                <div class="col-sm-6">
                    <h3>Desenvolvido por: Yan</h3> 
                </div>
                <div class="col-sm-6">
                    <h3>Projeto Valemobi</h3>
                </div>
            </div>
        </footer>
    </body>
</html>