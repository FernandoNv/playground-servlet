<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/editaEmpresa" var="linkServletEditaEmpresa" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Nova Empresa</title>
</head>
<body>
  <form action="${linkServletEditaEmpresa}" method="POST">
      Nome: <input placeholder="Nome da empresa" type="text" name="nome" value="${empresa.nome}" />
      Data Abertura: <input placeholder="01/01/1999" type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
      <input type="hidden" name="id" value="${empresa.id}" />
      <button type="submit">Enviar</button>
  </form>
</body>
</html>