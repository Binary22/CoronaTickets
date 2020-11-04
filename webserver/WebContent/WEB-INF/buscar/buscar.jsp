<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map, logica.Espectaculo, logica.Paquete, logica.Plataforma, logica.Categoria, logica.Plataforma, java.util.Set" %>
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
		    
			<% List<Paquete> lp =  (List<Paquete>) session.getAttribute("paquetes");
			if (lp.isEmpty()) { %>
			<h3 style="text-align:center">No hay paquetes que coincidan con esa busqueda</h3>
			<% } else { %>
				<div id="contenedorpaq" style="display:block;">
				<h3>Paquetes:</h3>
				<% for (Paquete p : lp) {  %>
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
				        <% for (Espectaculo e : p.getEspectaculos().values()) { %>
				        	<li><%=e.getNombre()%> | <%=e.getArtista().getNickname()%></li>
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
			
			
			<% List<Espectaculo> le =  (List<Espectaculo>) session.getAttribute("espectaculos"); 
		    if (le.isEmpty()) { %>
		    <h3 style="text-align:center">No hay espectaculos que coincidan con esa busqueda</h3>
		    <br>
		    <% } else { %>
		    	<div id="contenedoresp">
		    	<h3>Espectaculos:</h3>
			    <% for (Espectaculo e : le) {  %>
			    <% List<String> categorias = e.listarCategorias();
			    String strclaves = "";
			    String strcat = "";
			    for (String s : categorias) {
			    	strclaves = strclaves + " " + mapeoclave.get(s);
			    	strclaves = strclaves + " " + mapeoclave.get(e.getPlataforma().getNombre());
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
				        <p><%=e.getArtista().getNickname()%> | <%=e.getArtista().getNombre()%> <%=e.getArtista().getApellido()%></p>  
				        <p><%=e.getDescripcion()%></p>
				        <p><%=e.getPlataforma().getNombre()%> | <%=strcat%></p>
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