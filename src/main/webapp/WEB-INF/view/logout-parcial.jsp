<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="entrada" var="linkEntradaServlet" />
<c:url value="${linkEntradaServlet}?acao=Logout" var="linkServletLogout" />
<a href="${linkServletLogout}">Sair</a>
<br>