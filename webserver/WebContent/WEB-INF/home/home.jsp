<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- <%@page errorPage="/WEB-INF/500.jsp"%> --%>
<%@page import="java.util.ArrayList,java.util.List, java.util.Collection, logica.Espectaculo, java.util.Iterator, logica.DataPaquete, logica.DataEspectaculo, logica.DataUsuario"%>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <div class="container">
        <br>
            <h3>Espectáculos seleccionados</h3>  
        <br>
        <%
       	List<DataEspectaculo> espectaculos = (List<DataEspectaculo>) session.getAttribute("espectaculos");
        if (espectaculos.size() >= 3) { %>
        		<div class="card-deck pt-3">
        		<%  int i = 0;
        		for (DataEspectaculo e: espectaculos) {
        			if (i > 2) {
        				break;
        			}
        			%>
        			
        			
        			
        			<div class="card" style="flex: 0 0 30%;">
						    <img class="card-img-top" style="object-fit: cover; height:15rem;" src="<%=e.getImagen() %>">
						    <div class="card-body d-flex flex-column">
						    	<div class="row">
						    		<div class="col-9">
								        <h5 class="card-title"><%=e.getNombre() %></h5>
								        <h6 class="card-subtitle mb-2 text-muted"><%=e.getArtista() %></h6>
								    </div>
								    <div class="col-3">	
									<!--  esto es para lo del favorito -->
									<p style="float:right" class="text-muted">
		                        	
	                        	<% if (session.getAttribute("estado_sesion")  == "LOGIN_CORRECTO") {
	                        		DataUsuario userlogged = (DataUsuario) session.getAttribute("userlogged");
	                        		            
	                        		if (userlogged.getFavoritos().contains((String) e.getNombre())) { 
			                        	
			                        	%>
			                        		<a href="favoritos?espec=<%=e.getNombre()%>&user=<%=userlogged.getNickname()%>&accion=quitar"><img src="resources/media/coralleno.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } else {  %>
			                        		<a href="favoritos?espec=<%=e.getNombre()%>&user=<%=userlogged.getNickname()%>&accion=agregar"><img src="resources/media/coravacio.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } %>
			                        	
		                       		<% } else { %>
		                       		<a href="registro"><img src="resources/media/coravacio.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
		                       		<% } %>
		                       		
		                       		<%=e.getFavoritos()%>
		                            </p>

									<!--  termina lo del favorito -->
								    </div>
							    </div>
						        <p id="desc" class="card-text"><%=e.getDescripcion() %></p>
						        <ul class="list-group mt-auto list-group-horizontal">
						            <a class="list-group-item card-link active flex-fill" href="detallesEspectaculo?name=<%=e.getNombre() %>">Ver Espectaculo</a>
						            <li id="precio" class="list-group-item">$<%=e.getCosto() %></li>
						        </ul>
						    </div>
						</div>
        			
        			
        			
        			
        			
        			<% 
        			i++;
        		} %>
				</div>
		<% } %>
  
          <!--paquetes-->

        <br>
        <br>
            <h3>Paquetes seleccionados</h3>
        <br>
  
        <%
       	Collection<DataPaquete> paquetes = (Collection<DataPaquete>) session.getAttribute("paquetes");
        if (paquetes.size() >= 3) { %>
        		<div class="card-deck pt-3">
        		<%  int i = 0;
        		for (DataPaquete p: paquetes) {
        			if (i > 2) {
        				break;
        			}
        			%>
        			<carta-paquete img="<%=p.getImagen() %>" descripcion="<%=p.getDescripcion() %>" precio="<%= p.getDescuento() %>" titulo="<%= p.getNombre() %>"></carta-paquete>
				<%
        			i++;
        		} %>
				</div>
		<% } %>

        <br>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<script src="resources/js/espectaculos.js"></script>
	<script src="resources/js/cartaEspectaculo.js"></script>
	<link rel="stylesheet" href="resources/css/main.css"></style>
	<script src="resources/js/cartaPaquete.js"></script>
	
	</body>
</html>