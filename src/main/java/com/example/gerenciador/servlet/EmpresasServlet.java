package com.example.gerenciador.servlet;

import com.example.gerenciador.modelo.Banco;
import com.example.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServlet", value = "/empresas")
public class EmpresasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();

        String contentType = request.getHeader("Accept");
        if(contentType.contains("xml")){
            XStream xstream = new XStream();
            xstream.alias("empresa", Empresa.class);
            String xml = xstream.toXML(empresas);

            response.setContentType("application/xml");
            response.getWriter().print(xml);

            return;
        }

        if (contentType.contains("json")){
            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            response.setContentType("application/json");
            response.getWriter().print(json);

            return;
        }

        response.setContentType("application/json");
        response.getWriter().print("'message': 'no content'");

//        XStream xstream = new XStream();
//        xstream.alias("empresa", Empresa.class);
//        String xml = xstream.toXML(empresas);
//
//        response.setContentType("application/xml");
//        response.getWriter().print(xml);
    }

}
