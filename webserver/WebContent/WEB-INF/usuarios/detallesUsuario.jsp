<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logica.Usuario,logica.Registro,logica.Funcion,logica.Espectaculo,logica.Compra,logica.Paquete,java.util.List, java.util.ArrayList, java.time.LocalDate" %>
<%@page import="logica.DataUsuario, logica.DataRegistro, logica.DataEspectaculo, java.util.Map, logica.DataPaquete, logica.DataCompra"%>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../css/colorFlecha.css">


        <title>CoronaTickets.uy</title>
      </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        <br>
        <center>
        <h3>Datos del usuario</h3>
        </center>
        <br>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
	                	<div class="card">
	                	<% DataUsuario u = (DataUsuario) session.getAttribute("usuario"); %>
	                       <img class="card-img-top" src="<%=u.getImagen()%>" class="rounded" width="155"> 
	                        
	                        
	                        <div class="card-body">
		                        <h4 class="card-title" style="text-align:center"><%=u.getNickname()%></h4> 
		                        <div class=" w-100">
		                        	<div style="text-align:center;"><%=u.getSiguiendo().size() %> seguidores</div>
		                         	<div style="text-align:center;"><%=u.getSeguidos().size() %> seguidos</div>
		                         	<br>
		                        </div>
		                        <% if (session.getAttribute("estado_sesion")  == "LOGIN_CORRECTO") { 
				                        DataUsuario userlogged = (DataUsuario) session.getAttribute("userlogged");
				                        if (!u.getNickname().equals(userlogged.getNickname())) {
				                        	if (userlogged.getSeguidos().contains(u.getNickname())) { %>
				                        		<form action="detallesUsuario" method="POST">
				                        			<input type="hidden" name="usuariologueado" value="<%=userlogged.getNickname()%>" />
				                        		 	<input type="hidden" name="usuarioaseguir" value="<%=u.getNickname()%>"/>
				                        		 	<input type="hidden" name="accion" value="dejardeseguir"/>
				                        			<button type="submit" class="btn btn-outline-primary btn-block active">Siguiendo</button>
				                        		</form>
				                        <% 	} else { %>
				                        		<form action="detallesUsuario" method="POST">
				                        		 	<input type="hidden" name="usuariologueado" value="<%=userlogged.getNickname()%>" />
				                        		 	<input type="hidden" name="usuarioaseguir" value="<%=u.getNickname()%>"/>
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
                                <h6 class="card-subtitle mb-2 text-muted"><%=u.getNickname()%></h6>
                                <h5 class="card-title"></slot>Nombre:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=u.getNombre()%></h6>
                                <h5 class="card-title">Apellido:</h6>
                                <h6 class="card-subtitle mb-2 text-muted"><%=u.getApellido()%></h6>
                                <h5 class="card-title">e-mail:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=u.getEmail()%></h6>
                                <h5 class="card-title"></slot>Fecha de Nacimiento:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=u.getFechaNacimiento()%></h6>
                                
                            </div>
                        </div>
                        <br>
                        	 <% if (!u.getRegistros().isEmpty()) { %>
	                        
		                        <h4>Funciones a las que se registro: </h4>
		                        <% List<DataRegistro> l = u.getRegistros();
		                        Map<String, DataEspectaculo> mapaespec = (Map<String, DataEspectaculo>) session.getAttribute("mapaespec");
		                        for (DataRegistro r : l) {  %>
		                       
			                        <div class="card mb-3" style="max-width: 200em;">
									  <div class="row no-gutters">
									    <div class="col-md-5">
									      <img src="<%=mapaespec.get(r.getEspectFuncion()).getImagen()%>" class="card-img" style="object-fit: cover; height:10rem;">
									    </div>
									    <div class="col-md-7">
									      <div class="card-body">
									        <h5 class="card-title"><%=r.getFuncion()%></h5>
									        <p><%=mapaespec.get(r.getEspectFuncion()).getNombre()%></p>
									        <a href="detallesEspectaculo?name=<%=mapaespec.get(r.getEspectFuncion()).getNombre()%>" class="btn btn-primary card-text">Ver espectaculo</a>
									        <% if(LocalDate.parse((r.getFechaFuncion())).isBefore(LocalDate.now()) && (u.getNickname().equals(session.getAttribute("usuario_logueado"))) && (!mapaespec.get(r.getEspectFuncion()).getVotantes().contains(u.getNickname()))) { %>
									        <a href="votarEspectaculo?name=<%=mapaespec.get(r.getEspectFuncion()).getNombre()%>" class="btn btn-success card-text">Valorar espectaculo</a>
									        <%} %>
									      </div>
									    </div>
									  </div>
									</div>
								<% } %>
							<% } %>
						
				 	<% if (!u.getCompraPaquete().isEmpty() && u.getNickname().equals(session.getAttribute("usuario_logueado")) && session.getAttribute("estado_sesion") == "LOGIN_CORRECTO")  { 
				 	%>
                        
                        <h4>Paquetes comprados</h4>
                        
	                        <% List<DataCompra> l = u.getCompraPaquete();
	                        Map<String, DataPaquete> mapapaquetes = (Map<String, DataPaquete>) session.getAttribute("mapapaquetes");
			                for (DataCompra c : l) {  %>
	                        
	                        <div class="card mb-3" style="max-width: 200em;">
							  <div class="row no-gutters">
							    <div class="col-md-5">
							    
							      <img src="<%=mapapaquetes.get(c.getPaquete()).getImagen()%>" class="card-img" style="object-fit: cover; height:10rem;">
							    </div>
							    <div class="col-md-7">
							      <div class="card-body">
							        <h5 class="card-title"><%=c.getPaquete()%></h5>
							        <p><%=mapapaquetes.get(c.getPaquete()).getDescripcion()%></p>
							        <a href="detallesPaquete?name=<%=c.getPaquete()%>" class="btn btn-success card-text">Ver paquete</a>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="resources/js/espectaculos.js"></script>
        <script src="resources/js/cartaPaquete.js"></script>

        <!-- style -->
        <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>