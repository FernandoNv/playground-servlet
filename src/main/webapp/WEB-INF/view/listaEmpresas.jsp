<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="entrada" var="linkEntradaServlet" />
<c:url value="${linkEntradaServlet}?acao=RemoveEmpresa" var="linkServletRemoveEmpresa" />
<c:url value="${linkEntradaServlet}?acao=MostraEmpresa" var="linkServletMostraEmpresa" />
<c:url value="${linkEntradaServlet}?acao=NovaEmpresaForm" var="linkServletNovaEmpresaForm" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
  <c:if test="${not empty empresa}">
    Empresa ${empresa} criada com sucesso!!
  </c:if>
  </br>
  Lista de empresas: <br />
  <ul>
    <c:forEach items="${empresas}" var="empresa">
      <li>
          ${empresa.nome} -  <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
            <a href="${linkServletMostraEmpresa}&id=${empresa.id}">edita</a>
            <a href="${linkServletRemoveEmpresa}&id=${empresa.id}">remover</a>
      </li>
    </c:forEach>
  </ul>
  <a href="${linkServletNovaEmpresaForm}">Adiciona</a>
</body>
</html>