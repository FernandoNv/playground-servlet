package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveEmpresaServlet", value = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEmpresa = Long.valueOf(request.getParameter("id"));

        Banco banco = new Banco();
        banco.remove(idEmpresa);

        response.sendRedirect("listaEmpresas");
    }
}
