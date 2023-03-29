package com.example.gerenciador.acao;

import com.example.gerenciador.modelo.Banco;
import com.example.gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login implements Acao{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if (usuario != null){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresas";
        }

        return "redirect:entrada?acao=LoginForm";
    }
}
