package br.com.umc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.umc.dao.MercadoriaDAO;
import br.com.umc.model.Mercadoria;

public class MercadoriaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERIR_OU_EDITAR = "/mercadoria.jsp";
    private static final String LISTAR_MERCADORIAS = "/lista_mercadoria.jsp";
    private final MercadoriaDAO dao;

    public MercadoriaController() {
        super();
        dao = new MercadoriaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("acao");

        if (action.equalsIgnoreCase("deletar")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletaMercadoria(id);
            forward = LISTAR_MERCADORIAS;
            request.setAttribute("mercadorias", dao.getTodasMercadorias());    
        } else if (action.equalsIgnoreCase("editar")){
            forward = INSERIR_OU_EDITAR;
            int id = Integer.parseInt(request.getParameter("id"));
            Mercadoria mercadoria = dao.getMercadoriabyId(id);
            request.setAttribute("mercadoria", mercadoria);
        } else if (action.equalsIgnoreCase("listaMercadoria")){
            forward = LISTAR_MERCADORIAS;
            request.setAttribute("mercadorias", dao.getTodasMercadorias());
        } else {
            forward = INSERIR_OU_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mercadoria mercadoria = new Mercadoria();
        
        mercadoria.setTipo(request.getParameter("tipo"));
        mercadoria.setNome(request.getParameter("nome"));
        mercadoria.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        mercadoria.setPreco(Double.parseDouble(request.getParameter("preco")));
        mercadoria.setTiponegocio(request.getParameter("tiponegocio"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dao.addMercadoria(mercadoria);
        }
        else
        {
            mercadoria.setId(Integer.parseInt(id));
            dao.atualizaMercadoria(mercadoria);
        }
        request.setAttribute("mercadorias", dao.getTodasMercadorias());
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_MERCADORIAS);
        view.forward(request, response);
    }
}