package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditaEmpresaServlet", value = "/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEmpresa = Long.valueOf(request.getParameter("id"));
        Banco banco = new Banco();

        Empresa empresa = banco.getEmpresaById(idEmpresa);

        String nomeEmpresa = request.getParameter("nome");
        String paramDataEmpresa = request.getParameter("data");
        Date dataAberturaEmpresa;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataAberturaEmpresa = simpleDateFormat.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAberturaEmpresa);

        response.sendRedirect("listaEmpresas");
    }
}
