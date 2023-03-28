<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Nova Empresa</title>
</head>
<body>
  <form action="${linkServletNovaEmpresa}" method="POST">
      Nome: <input placeholder="Nome da empresa" type="text" name="nome" />
      Data Abertura: <input placeholder="01/01/1999" type="text" name="data" />
    <button type="submit">Enviar</button>
  </form>
</body>
</html>