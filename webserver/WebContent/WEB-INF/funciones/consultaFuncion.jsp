<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataFuncion"%>
<%@page import="logica.DataEspectaculo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Consulta de Funcion</title>
    <jsp:include page="/WEB-INF/template/head.jsp"/>

</head>
<body>
	    <jsp:include page="/WEB-INF/template/NavbarMobile.jsp"/>
	    
	    <div class="container">
	    <form class="mt-2" action = "registroafuncion" method = "POST">
               <div class="form-group">
                   <h6>Función</h6>
                   <%List<DataFuncion> funciones = (List<DataFuncion>)session.getAttribute("funcionesEspectaculo");
                      %>
                   <select class="form-control" name = "funcion_seleccionada" id = "funcionesList">
                   <%for(int i = 0; i < funciones.size(); i++){ %>
                     <option value = "<%= funciones.get(i).getNombre() %>"><%= funciones.get(i).getNombre() %></option>
                    <%  }%>
                   </select>
               </div>
               <br>
              	<div >
              		<%for(int i = 0; i < funciones.size(); i++){ %>
	                <div class = "borrar" id="<%= funciones.get(i).getNombre() %>" style="display: none;">
	                		<h5>Información de la función</h5>
	                		
	                		<%String var = "";
                  			List<String> artistas = funciones.get(i).getArtistasInvitados();
                  			if(!artistas.isEmpty()){
	                  			int fin = artistas.size()-1;
	                  			for(int j = 0; j < fin; j++){
	                  				var = var + artistas.get(j) + " - ";
	                  			}
	                  			var = var + artistas.get(fin);
                  			} %>
	                        <h6>Fecha: </h6>
	                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= funciones.get(i).getFecha() %></h6>
	                      	<h6>Hora de inicio: </h6>
	                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= funciones.get(i).getHoraInicio() %></h6>
	                      	<h6>Artistas Invitados: </h6>
	                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= var %></h6>
	                </div> 
	                <%} %>
              	</div>
         </form>
         </div>
              	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
			    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
			    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
				<script src="resources/js/consultafuncion.js"></script>
</body>
</html>