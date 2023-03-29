package com.example.gerenciador.acao;

import com.example.gerenciador.modelo.Banco;
import com.example.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MostraEmpresa implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEmpresa = Long.valueOf(request.getParameter("id"));
        Banco banco = new Banco();
        Empresa empresa = banco.getEmpresaById(idEmpresa);
        request.setAttribute("empresa", empresa);

        request.setAttribute("empresa", empresa);
        return "forward:formAlteraEmpresa.jsp";
    }
}
