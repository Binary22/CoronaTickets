<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, logica.Espectaculo, logica.Paquete" %>
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
        
        <div class="row">
		    <div class="col-2">
		    </div>
		    <div class="col-8">
		    <br>
		    <h2 style="text-align:center">Resultados de la busqueda de "<%=(String) session.getAttribute("search")%>":</h2>
		    <br>
		    <% List<Espectaculo> le =  (List<Espectaculo>) session.getAttribute("espectaculos"); 
		    if (le.isEmpty()) { %>
		    <h3 style="text-align:center">No hay espectaculos que coincidan con esa busqueda</h3>
		    <br>
		    <% } else { %>
		    	<h3>Espectaculos:</h3>
			    <% for (Espectaculo e : le) {  %>
			    <div class="card mb-3" style="max-width: 200em;">
				  <div class="row no-gutters">
				    <div class="col-md-5">
				      <img src="resources/media/usuarios/Emma-Watson-1.jpg" class="card-img" style="object-fit: cover; height:10rem;">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				        <h5 class="card-title"><%=e.getNombre()%></h5>
				        <p><%=e.getDescripcion()%></p>
				        <a href="#acahayqueponerellinkdelespectaculo" class="btn btn-primary card-text">Ver espectaculo</a>
				      </div>
				    </div>
				  </div>
				</div>
				<% } %>
			<% } %>
			<% List<Paquete> lp =  (List<Paquete>) session.getAttribute("paquetes");
			if (lp.isEmpty()) { %>
			<h3 style="text-align:center">No hay paquetes que coincidan con esa busqueda</h3>
			<% } else { %>
				<h3>Paquetes:</h3>
				<% for (Paquete p : lp) {  %>
			     <div class="card mb-3" style="max-width: 200em;">
				  <div class="row no-gutters">
				    <div class="col-md-5">
				      <img src="resources/media/usuarios/Emma-Watson-1.jpg" class="card-img" style="object-fit: cover; height:10rem;">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				        <h5 class="card-title"><%=p.getNombre()%></h5>
				        <p><%=p.getDescripcion()%></p>
				        <a href="#acahayqueponerellinkalpaquete" class="btn btn-success card-text">Ver paquete</a>
				      </div>
				    </div>
				  </div>
				</div>
				<% } %>
			<% } %>
		    
		    </div>
		    <div class="col-2">
		    </div>
		</div>
      
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