<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 28/03/2023
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <form action="${linkEntradaServlet}" method="post">
    Login: <input type="text" name="login" placeholder="Login" />
    Senha: <input type="password" name="senha" placeholder="Senha" />
    <input type="hidden" name="acao" value="Login" />

    <button type="submit">Enviar</button>
  </form>
</body>
</html>
