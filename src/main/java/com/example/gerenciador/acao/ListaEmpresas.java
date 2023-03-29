package com.example.gerenciador.acao;

import com.example.gerenciador.modelo.Banco;
import com.example.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();

        request.setAttribute("empresas", empresas);

        return "forward:listaEmpresas.jsp";
    }
}
