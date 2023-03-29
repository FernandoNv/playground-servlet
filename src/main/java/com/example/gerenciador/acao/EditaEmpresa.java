package com.example.gerenciador.acao;

import com.example.gerenciador.modelo.Banco;
import com.example.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditaEmpresa implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
