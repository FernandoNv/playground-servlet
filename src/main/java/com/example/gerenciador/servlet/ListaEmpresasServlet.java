package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaEmpresasServlet", value = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();

        request.setAttribute("empresas", empresas);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
        requestDispatcher.forward(request, response);
    }

}
