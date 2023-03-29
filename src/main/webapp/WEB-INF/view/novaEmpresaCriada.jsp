<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 27/03/2023
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
    <c:if test="${not empty empresa}">
        Empresa ${empresa} criada com sucesso!!
    </c:if>
    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada!
    </c:if>
</body>
</html>
