<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="logica.Artista, logica.Usuario, logica.Espectaculo" %>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="resources/css/colorFlecha.css">


        <title>CoronaTickets.uy</title>
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
                    <div class="col-md-3">
                       <div class="card">
                       	   <% Artista a = (Artista) session.getAttribute("usuario"); %>
	                       <img class="card-img-top" src="<%=a.getImagen()%>" class="rounded" width="155"> 
	                        
	                        
	                        <div class="card-body">
		                        <h4 class="card-title" style="text-align:center"><%=a.getNickname()%></h4> 
		                        <div class=" w-100">
		                            <div class="button mt-2 d-flex flex-row align-items-center"> 
		                                <button class="btn btn-sm btn-primary w-100 ml-2"> 
		                                    <div class="d-flex flex-column"> <span class="followers">Followers</span> <span class="number2">56,4mill</span> </div>
		                                </button> 
		                                <button class="btn btn-sm btn-primary w-100 ml-2">                                    
		                                    <div class="d-flex flex-column"> <span class="followers">Following</span> <span class="number2">2546</span> </div>
		                                </button> 
		                            </div>
		                        </div>
	                        </div>
                          </div>
                            
                    </div>
                
                    <div class="col-md-6">
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
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getFechaNacimiento().toString()%></h6>
                                <h5 class="card-title">Descripción:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getDescripcion()%></h6>
                                <h5 class="card-title">Biografía:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getBiografia()%></h6>
                                <h5 class="card-title">Website:</h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%=a.getWebsite()%></h6>
                                
                            </div>
                        </div>
                        <br>
                        
                        <% if (a.tieneEspectaculosAceptados()) {%>
                        
                        <h4>Espectáculos organizados</h4>
                        
	                        <% for (Espectaculo e : a.espectaculosAceptados()) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="resources/media/usuarios/Emma-Watson-1.jpg" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e.getNombre()%></h5>
								        <p><%=e.getDescripcion()%></p> 
								        <a href="#acahayqueponerellinkdelespectaculo" class="btn btn-success card-text">Ver espectaculo</a>
								      </div>
								    </div>
								  </div>
								</div>
							<% } %>
						<% } %>					
                        <% if (a.getNickname() == session.getAttribute("usuario_logueado") && a.tieneEspectaculosIngresadosSinAceptar()) {%>
                        
                        <br>
                        <h4>Espectáculos ingresados</h4>
                        <% for (Espectaculo e : a.espectaculosIngresadosSinAceptar()) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="resources/media/usuarios/Emma-Watson-1.jpg" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e.getNombre()%></h5>
								        <p><%=e.getDescripcion()%></p> 
								        <a href="#acahayqueponerellinkdelespectaculo" class="btn btn-success card-text">Ver espectaculo</a>
								      </div>
								    </div>
								  </div>
								</div>
							<% } %>
						<% } %>					
                        <% if (a.getNickname() == session.getAttribute("usuario_logueado") && a.tieneEspectaculosRechazados()){%>
                        
                        <br>
                        <h4>Espectáculos rechazados</h4>
                        <% for (Espectaculo e : a.espectaculosRechazados()) {  %>
	                        
		                    	<div class="card mb-3" style="max-width: 200em;">
								  <div class="row no-gutters">
								    <div class="col-md-5">
								      <img src="resources/media/usuarios/Emma-Watson-1.jpg" class="card-img" style="object-fit: cover; height:10rem;">
								    </div>
								    <div class="col-md-7">
								      <div class="card-body">
								        <h5 class="card-title"><%=e.getNombre()%></h5>
								        <p><%=e.getDescripcion()%></p> 
								        <a href="#acahayqueponerellinkdelespectaculo" class="btn btn-success card-text">Ver espectaculo</a>
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