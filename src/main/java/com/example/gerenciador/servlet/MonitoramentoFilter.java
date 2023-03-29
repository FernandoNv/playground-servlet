package com.example.gerenciador.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MonitoramentoFilter - Rodando...");
        long inicio = System.currentTimeMillis();
        String acao = request.getParameter("acao");

        filterChain.doFilter(request, response);

        long fim = System.currentTimeMillis();
        System.out.println("Tempo decorreido da ação " + acao + " " + (fim-inicio));
    }
}
