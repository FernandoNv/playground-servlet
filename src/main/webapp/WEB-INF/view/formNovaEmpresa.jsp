<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Nova Empresa</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
    <form action="${linkEntradaServlet}" method="POST">
      Nome: <input placeholder="Nome da empresa" type="text" name="nome" />
      Data Abertura: <input placeholder="01/01/1999" type="text" name="data" />
      <input type="hidden" name="acao" value="NovaEmpresa" />
    <button type="submit">Enviar</button>
    </form>
</body>
</html>