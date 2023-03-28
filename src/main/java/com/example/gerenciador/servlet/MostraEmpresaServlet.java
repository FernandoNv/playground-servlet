package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MostraEmpresaServlet", value = "/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEmpresa = Long.valueOf(request.getParameter("id"));
        Banco banco = new Banco();
        Empresa empresa = banco.getEmpresaById(idEmpresa);
        request.setAttribute("empresa", empresa);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        request.setAttribute("empresa", empresa);
        requestDispatcher.forward(request, response);
    }
}
