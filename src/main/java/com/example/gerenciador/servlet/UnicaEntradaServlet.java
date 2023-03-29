package com.example.gerenciador.servlet;

import com.example.gerenciador.acao.Acao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

//@WebServlet(name = "UnicaEntradaServlet", urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UnicaEntradaServlet - Rodando...");

        String entradaParam = request.getParameter("acao");
        String nome = null;

        try {
            Class classe = Class.forName("com.example.gerenciador.acao." + entradaParam);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");

        if(tipoEEndereco[0].equals("forward")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            requestDispatcher.forward(request, response);
        }
        if(tipoEEndereco[0].equals("redirect")){
            response.sendRedirect(tipoEEndereco[1]);
        }
    }
}
