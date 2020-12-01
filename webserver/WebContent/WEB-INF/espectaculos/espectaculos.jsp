<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.Plataforma"%>
<%@page import="logica.DataEspectaculo"%>
<%@page import="logica.DataUsuario"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <jsp:include page="/WEB-INF/template/head.jsp"/>

        <title>CoronaTickets.uy</title>
      </head>

    <body>
    <% if ((Boolean) session.getAttribute("Mobile") != null) { %>
    	<jsp:include page="/WEB-INF/template/NavbarMobile.jsp"/>
    <% } else { %>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
      <% } %>
        <div class="container">
        
            <form class="mt-2" action = "espectaculos" method = "POST">
                <h2>Plataforma:</h2>
                    <select class="form-control" id="plataforma" name = "opcionesPlat" >
                    <option default disabled selected value="">--Elegir Plataforma--</option> 
                    <% List<String> plataformas = (List<String>) session.getAttribute("plataformas");
			        	for(String key : plataformas){
						%>
						<option value="<%= key %>" id = "idPlat"><%= key %></option>
                         <% } %>
                    </select>
                    <br>
                    <button id="registrarse" type="submit" class="btn btn-outline-success my-2 my-sm-0 " style="margin-right:5px">Filtrar</button>

                    <br>
           </form>
           
        </div>
        <br>
        
        
        
        <div class = "container">
	        <%
	       
	      	ArrayList<DataEspectaculo> espectaculos = (ArrayList<DataEspectaculo>)session.getAttribute("espectaculosPlat");
	       
	        int size = espectaculos.size();
	        int j = 0;
	        int i = 0;
	        while(i < size){ %>
		        
		       
	        	<div class="card-deck pt-3">
			        <%for(j = i; j <= i + 2 && j < size; j++){%>
						
				    	
				    	<div class="card carta" style="flex: 0 0 30%;">
						    <img class="card-img-top" style="object-fit: cover; height:15rem;" src="<%=espectaculos.get(j).getImagen() %>">
						    <div class="card-body d-flex flex-column">
						    	<div class="row">
						    		<div class="col-9">
								        <h5 class="card-title"><%=espectaculos.get(j).getNombre() %></h5>
								        <h6 class="card-subtitle mb-2 text-muted"><%=espectaculos.get(j).getArtista() %></h6>
								    </div>
								    <div class="col-3">	
									<!--  esto es para lo del favorito -->
									<p style="float:right" class="text-muted">
		                        	
	                        	<% 
	                        	if ((session.getAttribute("Mobile") == null)) {
	                        		if ((session.getAttribute("estado_sesion")  == "LOGIN_CORRECTO") ) {
	                        		DataUsuario userlogged = (DataUsuario) session.getAttribute("userlogged");
	                        		            
	                        		if (userlogged.getFavoritos().contains((String) espectaculos.get(j).getNombre())) { 
			                        	
			                        	%>
			                        		<a href="favoritos?espec=<%=espectaculos.get(j).getNombre()%>&user=<%=userlogged.getNickname()%>&accion=quitar"><img src="resources/media/coralleno.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } else {  %>
			                        		<a href="favoritos?espec=<%=espectaculos.get(j).getNombre()%>&user=<%=userlogged.getNickname()%>&accion=agregar"><img src="resources/media/coravacio.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } %>
			                        	
		                       		<% } else { %>
		                       		<a href="registro"><img src="resources/media/coravacio.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
		                       		<% } %>
		                       		
		                       		<%=espectaculos.get(j).getFavoritos()%>
		                            </p>
									<% } %>
									<!--  termina lo del favorito -->
								    </div>
							    </div>
						        <p id="desc" class="card-text"><%=espectaculos.get(j).getDescripcion() %></p>
						        <ul class="list-group mt-auto list-group-horizontal">
						            <a class="list-group-item card-link active flex-fill" href="detallesEspectaculo?name=<%=espectaculos.get(j).getNombre() %>">Ver Espectaculo</a>
						            <li id="precio" class="list-group-item">$<%=espectaculos.get(j).getCosto() %></li>
						        </ul>
						    </div>
						</div>
				    	
				  	<%} %>
	     		</div>
			     
				    
		 	<%i = j;} %>
			     
			
	    	</div>

        	<br>
        	<br>

    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/espectaculos.js"></script>
    <script src="resources/js/cartaEspectaculo.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>