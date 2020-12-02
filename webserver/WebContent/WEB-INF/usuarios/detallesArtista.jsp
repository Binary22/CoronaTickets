<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="logica.Artista, logica.Usuario, logica.Espectaculo" %>
    <%@page import="logica.DataUsuario, logica.DataRegistro, logica.DataEspectaculo, java.util.Map,java.util.List,java.util.ArrayList,  logica.DataPaquete, logica.DataCompra"%>
<!doctype = html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/template/head.jsp"/>
      </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        <br>
        <center>
        <h3>Datos del artista</h3>
        </center>
        <br>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                       <div class="card">
                       	   <% DataUsuario a = (DataUsuario) session.getAttribute("usuario"); %>
	                       <img class="card-img-top" src="<%=a.getImagen()%>" class="rounded" width="155"> 
	                        
	                        
	                        <div class="card-body">
		                        <h4 class="card-title" style="text-align:center"><%=a.getNickname()%></h4> 
		                        <div class=" w-100">
		                        	<div style="text-align:center;"><%=a.getSiguiendo().size() %> seguidores</div>
		                         	<div style="text-align:center;"><%=a.getSeguidos().size() %> seguidos</div>
		                         	<br>
		                        </div>
		                        <% if (session.getAttribute("estado_sesion")  == "LOGIN_CORRECTO") { 
				                        DataUsuario userlogged = (DataUsuario) session.getAttribute("userlogged");
				                        if (!a.getNickname().equals(userlogged.getNickname())) {
				                        	if (userlogged.getSeguidos().contains(a.getNickname())) { %>
				                        		<form action="detallesUsuario" method="POST">
				                        			<input type="hidden" name="usuariologueado" value="<%=userlogged.getNickname()%>" />
				                        		 	<input type="hidden" name="usuarioaseguir" value="<%=a.getNickname()%>"/>
				                        		 	<input type="hidden" name="accion" value="dejardeseguir"/>
				                        			<button type="submit" class="btn btn-outline-primary btn-block active">Siguiendo</button>
				                        		</form>
				                        <% 	} else { %>
				                        		<form action="detallesUsuario" method="POST">
				                        		 	<input type="hidden" name="usuariologueado" value="<%=userlogged.getNickname()%>" />
				                        		 	<input type="hidden" name="usuarioaseguir" value="<%=a.getNickname()%>"/>
				                        		 	<input type="hidden" name="accion" value="seguir"/>
													<button type="submit" class="btn btn-outline-primary btn-block">Seguir</button>
				                        		</form>
				                        <%	}
				                        }
			                        
		                        } else { %>
		                        	<a href="registro"  class="btn btn-outline-primary btn-block">Seguir</a>
		                      <%  }
			                      %>
		                       
		                    </div>
	                        
                          </div>
                            
                    </div>
                
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"></slot>Nickname:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getNickname()%></h6>
                                <h5 class="card-title"></slot>Nombre:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getNombre()%></h6>
                                <h5 class="card-title">Apellido:</h6>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getApellido()%></h6>
                                <h5 class="card-title">e-mail:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getEmail()%></h6>
                                <h5 class="card-title"></slot>Fecha de Nacimiento:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getFechaNacimiento()%></h6>
                                <h5 class="card-title">Descripción:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getDescripcion()%></h6>
                                <h5 class="card-title">Biografía:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getBiografia()%></h6>
                                <h5 class="card-title">Website:</h5>
                                <a href="https://<%=a.getWebsite()%>" class="card-subtitle mb-2"><%=a.getWebsite()%></a>
                                
                            </div>
                        </div>
                        <br>
                                   
                        
                        <% 
                        Map<String, DataEspectaculo> mapaespec = (Map<String, DataEspectaculo>) session.getAttribute("mapaespec");
                        List<String> especsart = a.getEspectaculos();
                        
                        boolean res = false;
                        List<String> espectaculosAceptados = new ArrayList<String>();
                        for (String s : especsart) {
                        	if ( mapaespec.get(s).isAceptado() && !mapaespec.get(s).isFinalizado() ) {
                        		res = true;
                        		espectaculosAceptados.add(s);
                        	}	
                        }
                        
                        if (res) {%>
                        
                        <h4>Espectáculos organizados</h4>
                        
	                        <% for (String e : espectaculosAceptados) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="<%=mapaespec.get(e).getImagen()%>" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e%></h5>
								        <p><%=mapaespec.get(e).getDescripcion()%></p> 
								        <a href="detallesEspectaculo?name=<%=e%>" class="btn btn-success card-text">Ver espectaculo</a>
								        <%if (a.getNickname().equals(session.getAttribute("usuario_logueado")) && (session.getAttribute("estado_sesion") == "LOGIN_CORRECTO") ){%>
								        <form action="finalizarespectaculo" method="POST">
								        	<input type="hidden" name="nombreEsp" value="<%=e%>">
								        	<br>
								        	<button type="submit" class="btn btn-danger">Finalizar</button>
								        </form>
								        <%}%>
								      </div>
								    </div>
								  </div>
								</div>
							<% } %>
						<% } 
						
                        res = false;
                        List<String> espectaculosSinAceptar = new ArrayList<String>();
                        for (String s : especsart) {
                        	if (!mapaespec.get(s).isYaFueValuado()) {
                        		res = true;
                        		espectaculosSinAceptar.add(s);
                        	}	
                        }
						
						
						%>					
                        <% if (a.getNickname().equals(session.getAttribute("usuario_logueado")) && session.getAttribute("estado_sesion") == "LOGIN_CORRECTO" && res) {%>
                        
                        <br>
                        <h4>Espectáculos ingresados</h4>
                        <% for (String e : espectaculosSinAceptar) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="<%=mapaespec.get(e).getImagen()%>" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e%></h5>
								        <p><%=mapaespec.get(e).getDescripcion()%></p> 
								        <a href="detallesEspectaculo?name=<%=e%>" class="btn btn-primary card-text">Ver espectaculo</a>
								      </div>
								    </div>
								  </div>
								</div>
							<% } %>
						<% }
                        
                        res = false;
                        List<String> espectaculosRechazados = new ArrayList<String>();
                        for (String s : especsart) {
                        	if (mapaespec.get(s).isYaFueValuado() && !(mapaespec.get(s).isAceptado())) {
                        		res = true;
                        		espectaculosRechazados.add(s);
                        	}	
                        }
                        
                        
                        %>					
                        <% if (a.getNickname().equals(session.getAttribute("usuario_logueado")) && session.getAttribute("estado_sesion") == "LOGIN_CORRECTO" && res){%>
                        
                        <br>
                        <h4>Espectáculos rechazados</h4>
                        <% for (String e : espectaculosRechazados) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="<%=mapaespec.get(e).getImagen()%>" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e%></h5>
								        <p><%=mapaespec.get(e).getDescripcion()%></p> 
								        <a href="detallesEspectaculo?name=<%=e%>" class="btn btn-danger card-text">Ver espectaculo</a>
								      </div>
								    </div>
								  </div>
								</div>
							<% } %>
						<% } %>	    
                        
                    </div>
                </div>
            </div>
            <br>
        </section>
         
        

        <!-- javascript -->
        <script src="../js/papaparse.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="resources/js/espectaculos.js"></script>
        <script src="resources/js/cartaPaquete.js"></script>
        <script src="resources/js/navbar.js"></script>

        <!-- style -->
        <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>