<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.Plataforma"%>
<%@page import="logica.Espectaculo"%>
<%@page import="java.util.Map"%>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <jsp:include page="/WEB-INF/template/head.jsp"/>

        <title>CoronaTickets.uy</title>
      </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <div class="container">
        
            <fieldset class="mt-2">
                <h2>Plataforma:</h2>
                    <select class="form-control" id="plataforma" onchange="plataformaSelected(value)">
                    <option default disabled selected value="">--Elegir Plataforma--</option>
                    <% Map<String, Plataforma> plataformas = (Map<String, Plataforma>)session.getAttribute("plataformas");
			        	for(String key : plataformas.keySet()){
						%>
						<option value="" id = "<%= plataformas.get(key).getNombre() %>"><%= plataformas.get(key).getNombre() %></option>
                         <% } %>
                    </select>
                
            </fieldset>
           
        </div>
        <br>
        <br>
        <br>
        
        
        <div class = "container">
	        <%Map<String, Espectaculo> espectaculos = (Map<String, Espectaculo>)session.getAttribute("espectaculos");
	        int i = 0;
	        int size = espectaculos.size();
	        for(String key : espectaculos.keySet()){ %>
		        
		       	<%if(i % 3 == 0){%>
		        <div class="row">
			        
					<div class="col-md-4"  >        
				        <img class="card-img-top" alt="..." src="resources/media/espectaculos/3.jpeg">
					    <div class="card-body d-flex flex-column">
					        <h5 class="card-title"><%=espectaculos.get(key).getNombre() %></h5>
					        <h6 class="card-subtitle mb-2 text-muted"></h6>
					        <p id="desc" class="card-text">
					        </p>
					        <ul class="list-group mt-auto list-group-horizontal">
					            <a href="detallesEspectaculo" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
					            <li id="precio" class="list-group-item">$</li>
					        </ul>
					    </div>
				    </div>
					  	
			     </div>
			     <%}else{ %>
			     		<div class="col-md-4" >        
				        <img class="card-img-top" alt="..." src="resources/media/espectaculos/3.jpeg">
					    <div class="card-body d-flex flex-column">
					        <h5 class="card-title"><%=espectaculos.get(key).getNombre() %></h5>
					        <h6 class="card-subtitle mb-2 text-muted"></h6>
					        <p id="desc" class="card-text">
					        </p>
					        <ul class="list-group mt-auto list-group-horizontal">
					            <a href="detallesEspectaculo" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
					            <li id="precio" class="list-group-item">$</li>
					        </ul>
					    </div>
				    </div>
				    <%} %>
				    
				 <%i++;} %>
			     
			
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