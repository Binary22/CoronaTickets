<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Pagina de error</title>
<head>
<body id="error_page">
    <div id="body-container">
        <div class="gameover">500: GAME OVER</div>

        <p>
        Ocurrió un error al procesar la página. Puedes intentar recargar o 
        <a href="home">volver</a> al inicio.
        </p>
    
        <div id="dead_mario"></div>
        <div class="main">
            <pre><%= exception.getClass().getName() %>: <%= exception.getMessage() %>
<% for(StackTraceElement ste: exception.getStackTrace()){ %><%= ste.toString() %>
<% } %></pre>
        </div>
    </div>
</body>
</html>