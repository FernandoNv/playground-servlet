package com.example.gerenciador.acao;

import com.example.gerenciador.modelo.Banco;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RemoveEmpresa implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEmpresa = Long.valueOf(request.getParameter("id"));

        Banco banco = new Banco();
        banco.remove(idEmpresa);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
