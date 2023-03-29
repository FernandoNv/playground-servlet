package com.example.gerenciador.acao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
//        sessao.removeAttribute("usuarioLogado");
        sessao.invalidate();
        return "redirect:entrada?acao=LoginForm";
    }
}
