<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map, java.util.Map.Entry, logica.DataEspectaculo, logica.DataPaquete, logica.Plataforma, logica.Categoria, logica.Plataforma, java.util.Set" %>
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
            <div class="row">
            	<div class="col-6">
	            	<form>
		                <div class="form-group">
		                    <label>Ordenar por:</label>
		                    <select class="form-control" id="orden">
		                      <option value="alfa" selected="selected">Ordenar alfabéticamente (ascendente)</option>
		                      <option value="fecha">Ordenar por fecha de publicación (descendente)</option>
		                    </select>
		                </div>
	            	</form>
            	</div>
            	<div class="col-6">
	            	<form>
		                <div class="form-group">
		                    <label>Filtrar por:</label>
		                    <select class="form-control" id="filtro">
		                      <option value="todo" selected="selected">Todas las categorias y plataformas</option>
		                      <optgroup label="Categorias">
		                      	<% Set<String> setcats = (Set<String>) session.getAttribute("categorias");
		                      	Set<String> setplats = (Set<String>) session.getAttribute("plataformas");
		                      	Map mapeoclave = new HashMap(); 
		                      	int indice = 0;
		                      	for (String s : (Set<String>) session.getAttribute("categorias")) { %>
							  	<option value="c<%=indice%>"><%=s%></option>
							  	<% mapeoclave.put(s, "c" + indice); 
							  	indice++; %>
							  	<% } %>
							  </optgroup>
							  <optgroup label="Plataformas">
							  	<% for (String s : (Set<String>) session.getAttribute("plataformas")) { %>
							  	<option value="c<%=indice%>"><%=s%></option>
							    <% mapeoclave.put(s, "c" + indice);
							    indice++;
							    } %>
							  </optgroup>		            	                      
		                    </select>
		                </div>
	            	</form>
            	</div>
            </div>
            <br>
		    
			<% List<DataPaquete> lp =  (List<DataPaquete>) session.getAttribute("paquetes");
			Map<String, DataEspectaculo> mapatodoslosesp =  (Map<String, DataEspectaculo>) session.getAttribute("mapatodoslosesp");
			if (lp.isEmpty()) { %>
			<h3 style="text-align:center">No hay paquetes que coincidan con esa busqueda</h3>
			<% } else { %>
				<div id="contenedorpaq" style="display:block;">
				<h3>Paquetes:</h3>
				<% for (DataPaquete p : lp) {  %>
			     <div class="card mb-3 divpaq" style="max-width: 170em;">
				  <div class="row no-gutters">
				    <div class="col-md-5">
				      <img src=" <%= p.getImagen() %>" class="card-img" style="object-fit: cover; height:12rem;">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				      	<div class="d-flex w-100 justify-content-between">
                        	<h5><%=p.getNombre()%></h5>
                            <small><%=p.getFechaAlta().toString()%></small>
                        </div>
				        <p><%=p.getDescripcion()%></p>
				      
				        <ul>
				        <% for (String e : p.getEspectaculos()) { %>    
				        	<li><%=mapatodoslosesp.get(e).getNombre() %> | <%=mapatodoslosesp.get(e).getArtista()%></li>    
				        <% } %>   
				        </ul>
				        <a href="detallesPaquete?name=<%=p.getNombre()%>" class="btn btn-success card-text">Ver paquete</a>
				      </div>
				    </div>
				  </div>
				</div>
				<% } %>
				</div>
			<% } %>
			
			
			<% List<DataEspectaculo> le =  (List<DataEspectaculo>) session.getAttribute("espectaculos"); 
		    if (le.isEmpty()) { %>
		    <h3 style="text-align:center">No hay espectaculos que coincidan con esa busqueda</h3>
		    <br>
		    <% } else { %>
		    	<div id="contenedoresp">
		    	<h3>Espectaculos:</h3>
			    <% for (DataEspectaculo e : le) {  %>
			    <% List<String> categorias = e.getCategorias();
			    String strclaves = "";
			    String strcat = "";
			    for (String s : categorias) {
			    	strclaves = strclaves + " " + mapeoclave.get(s);
			    	strclaves = strclaves + " " + mapeoclave.get(e.getPlataforma());
			    	strcat = strcat + " " + s;
			    }
			    %>
			    <div class="card mb-3 divesp cardespectaculo <%=strclaves%>" style="max-width: 240em; display:block;">
				  <div class="row no-gutters">
				    <div class="col-md-5">
				      <img src="<%=e.getImagen()%>" class="card-img" style="object-fit: cover; height:12rem;">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				      	<div class="d-flex w-100 justify-content-between">
                        	<h5><%=e.getNombre()%></h5>
                            <small><%=e.getFechaReg().toString()%></small>
                        </div>
				        <p><%=e.getArtista()%> <%-- | <%=e.getArtista().getNombre()%> <%=e.getArtista().getApellido()%> --%> </p>  
				        <p><%=e.getDescripcion()%></p>
				        <p><%=e.getPlataforma()%> | <%=strcat%></p>
				        <p><% if (e.getPuntajes().size() != 0) {
                            int promedio = 0;
                            for (int i : e.getPuntajes()) {
                            	promedio += i*2;
                            }
                            promedio = promedio / (e.getPuntajes().size());
                            for (int i= 0; i< promedio/2; i++) { %>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
							  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<%} 
							if ((promedio % 2) == 1) { %>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-half" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
							  <path fill-rule="evenodd" d="M5.354 5.119L7.538.792A.516.516 0 0 1 8 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0 1 16 6.32a.55.55 0 0 1-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 0 1-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 0 1-.171-.403.59.59 0 0 1 .084-.302.513.513 0 0 1 .37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 0 1 .163-.505l2.906-2.77-4.052-.576a.525.525 0 0 1-.393-.288L8.002 2.223 8 2.226v9.8z"/>
							</svg>
							<%
							promedio+=1;
							}  for (int i=promedio/2; i<5; i++) {%>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288l1.847-3.658 1.846 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.564.564 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
								</svg>
							<%} %>
							</p>
				        	<% } else { %>
								<p> El espectacculo aun no fue valorado.</p>
							<% } %>
				        <a href="detallesEspectaculo?name=<%=e.getNombre()%>" class="btn btn-primary card-text">Ver espectaculo</a>
				      </div>
				    </div>
				  </div>
				</div>
				<% } %>
				</div>
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
    <script src="resources/js/buscar.js"></script>


    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>