<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Pagina de error</title>
</head>
<body>
<% if(response.getStatus() == 500){ %>
<font color="red">Error: <%=exception.getMessage() %></font><br> 

<%-- include login page --%>
<jsp:include page="/WEB-INF/home/home.jsp"/>
<%}else {%>
Ha ocurrido un error inesperado, el código del error es el siguiente: <%=response.getStatus() %><br>
Por favor rediríjase a <a href="home">Página de inicio</a>
<%}%>
</body>
</html>