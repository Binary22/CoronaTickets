<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.Plataforma"%>
<%@page import="logica.DataEspectaculo"%>
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
						
				    	<carta-espectaculo  id = "<%=espectaculos.get(j).getPlataforma() %>" titulo = "<%=espectaculos.get(j).getNombre() %>" descripcion = "<%=espectaculos.get(j).getDescripcion() %>"
				    	img = "<%=espectaculos.get(j).getImagen() %>" precio = <%=espectaculos.get(j).getCosto() %> artista = <%=espectaculos.get(j).getArtista() %>></carta-espectaculo>
				  	<%} %>
	     		</div>
			     
				    
		 	<%i = j;} %>
			     
			
	    	</div>

        

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