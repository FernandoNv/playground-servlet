package com.example.gerenciador.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AutorizacaoFilter - Rodando...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession sessao = request.getSession();
        String entradaParam = request.getParameter("acao");
        boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
        boolean achaoProtegida = !(entradaParam.equals("Login") || entradaParam.equals("LoginForm"));

        if(!usuarioLogado && achaoProtegida){
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
