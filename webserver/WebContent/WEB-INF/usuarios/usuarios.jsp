<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, logica.Usuario, java.util.TreeMap" %>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <title>CoronaTickets.uy</title>
      </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        <div class="container">
               
        <% Map<String, Usuario> mapadesordenado = (Map<String, Usuario>) session.getAttribute("usuarios");
        Map<String, Usuario> m = new TreeMap();
        for (Map.Entry<String, Usuario> entry : mapadesordenado.entrySet()) {   
        	m.put(entry.getKey(), entry.getValue());
        	}
        int i = 0;
        for (Map.Entry<String, Usuario> entry : m.entrySet()) {      	
	        	String key = entry.getKey();
	        	Usuario value = entry.getValue();

        		String descripcion = value.getNombre() + " " + value.getApellido();
        	
        		 if ((i % 3) == 0) { %>
        		<div class="card-deck pt-3">
        		<% } %>
        		<carta-usuario class="card carta" img="<%=value.getImagen()%>" descripcion="<%=descripcion%>" titulo="<%=key%>" style="width:18rem;"></carta-usuario>
        		<% if ((i % 3) == 2 || i == m.size()) { %>
	        		<% if (i == m.size() && (i % 3 == 0)) { %>
	        			<carta-usuario class="card carta" img="<%=value.getImagen()%>" descripcion="" titulo="" style="width:18rem;visibility:hidden"></carta-usuario>
	        		<% } %>
	        		<% if (i == m.size() && (i % 3 == 1)) { %>
	        			<carta-usuario class="card carta" img="<%=value.getImagen()%>" descripcion="" titulo="" style="width:18rem;visibility:hidden"></carta-usuario>
	        			<carta-usuario class="card carta" img="<%=value.getImagen()%>" descripcion="" titulo="" style="width:18rem;visibility:hidden"></carta-usuario>
	        		<% } %>
        		
        		</div>
        		<% }
        		i++;
        		%>
        		
        <% } %>
        </div>
        <br>
        <!-- <div id="usuarios-lista" class="container">
        </div>-->
		
        

    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/usuarios.js"></script>
    <script src="resources/js/cartaUsuario.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>