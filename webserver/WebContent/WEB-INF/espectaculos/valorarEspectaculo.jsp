<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.DataEspectaculo"%>
<%@page import="logica.DataEspectaculo.SetFunciones"%>
<%@page import="logica.DataPaquete"%>
<%@page import="logica.DataFuncion"%>
<%@page import="logica.Funcion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="logica.Paquete"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <head>
        <!-- Required meta tags -->
        <jsp:include page="/WEB-INF/template/head.jsp"/>

        <title>CoronaTickets.uy</title>
        <style>
	    div.stars {
      width: 270px;
      display: inline-block;
    }
    input.star { display: none; }
    label.star {
      float: right;
      padding: 10px;
      font-size: 36px;
      color: #444;
      transition: all .2s;
    }
    input.star:checked ~ label.star:before {
      content: '\f005';
      color: #FD4;
      transition: all .25s;
    }
    input.star-5:checked ~ label.star:before {
      color: #FE7;
      text-shadow: 0 0 20px #952;
    }
    input.star-1:checked ~ label.star:before { color: #F62; }
    label.star:hover { transform: rotate(-15deg) scale(1.3); }
    label.star:before {
      content: '\f006';
      font-family: FontAwesome;
    }
    </style>
      </head>
</head>
<body>

    <div class="custom-control custom-switch" style="margin-left:1em; display:none;">
	  <input type="checkbox" class="custom-control-input" id="darkSwitch" />
	  <label class="custom-control-label" for="darkSwitch"></label>
	</div>
	<script src="resources/js/dark-mode-switch.js"></script>
	

	<div class="container">
			        <div class="container mt-6">
			
			            <div class="d-flex justify-content-center">
				            <div class="card input-group mt-3" style="width:40rem;">
								<% if(session.getAttribute("exito") != null) { %>
								<div class="card-body">
									<h4> Espectaculo valorado con exito! </h4>
									<a href="home" class="btn btn-primary card-text">Volver al inicio.</a>
									<br>
								</div>
								<%} else if (session.getAttribute("errorValorar") != null) { %>
								<div class="card-body">
									<h4> Lo sentimos, solo puede evaluar cada espectaculo una unica vez. </h4>
									<br>
									<a href="home" class="btn btn-primary card-text">Volver al inicio.</a>
								</div>
								<%} else { %>
								<br>
					            <div class="card-body">
						           <%
								    DataEspectaculo espect = (DataEspectaculo) session.getAttribute("espectaculo");
						           %>         
						             <form class="mt-2" action = "votarEspectaculo" method = "POST">
						                <div class="form-group">
						                    <h3 class="card-title">Valorar Espectaculo </h3>
						                </div>
						                <br>
						               	<div >
						               			<h4 class="card-title"><%= espect.getNombre() %></h4>
						               			<img class="card-img" style="object-fit: cover;" src=<%= espect.getImagen() %>>
											    <%
											    if(espect.getPuntajes().size() != 0) { %>
					                            <%
					                            int promedio = 0;
					                            for (int i : espect.getPuntajes()) {
					                            	promedio += i*2;
					                            }
					                            promedio = promedio / (espect.getPuntajes().size());
					                            for (int i= 0; i< promedio/2;i++) { %>
					                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FD4" xmlns="http://www.w3.org/2000/svg">
												  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
												</svg>
												<%} 
												if ((promedio % 2) == 1) { %>
													<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-half" fill="#FD4" xmlns="http://www.w3.org/2000/svg">
												  <path fill-rule="evenodd" d="M5.354 5.119L7.538.792A.516.516 0 0 1 8 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0 1 16 6.32a.55.55 0 0 1-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 0 1-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 0 1-.171-.403.59.59 0 0 1 .084-.302.513.513 0 0 1 .37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 0 1 .163-.505l2.906-2.77-4.052-.576a.525.525 0 0 1-.393-.288L8.002 2.223 8 2.226v9.8z"/>
												</svg>
												<%
												promedio+=1;
												}  for (int i=promedio/2; i<5; i++) {%>
													<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star" fill="#FD4" xmlns="http://www.w3.org/2000/svg">
													  <path fill-rule="evenodd" d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288l1.847-3.658 1.846 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.564.564 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
													</svg>
												<%} %>
												
					                            <h6 class="card-subtitle mb-2 text-muted" style="margin-top:2px"><%=espect.getPuntajes().size() %> valoraciones.</h6>
												<%} else { %>
												<br>
													<h5 class="card-subtitle"> El espectaculo no ha sido evaluado aun.</h5>
												<br>
												<% } %>
						               	</div>
						          		    <div class="stars">
										      <form action="votarEspectaculo" method="post">
										        <input value="5" class="star star-5" id="star-5" type="radio" name="puntaje"/>
										        <label class="star star-5" for="star-5"></label>
										        <input value="4" class="star star-4" id="star-4" type="radio" name="puntaje"/>
										        <label class="star star-4" for="star-4"></label>
										        <input value="3" class="star star-3" id="star-3" type="radio" name="puntaje"/>
										        <label class="star star-3" for="star-3"></label>
										        <input value="2" class="star star-2" id="star-2" type="radio" name="puntaje"/>
										        <label class="star star-2" for="star-2"></label>
										        <input value="1" class="star star-1" id="star-1" type="radio" name="puntaje"/>
										        <label class="star star-1" for="star-1"></label>
										       	<button type="submit" class="btn btn-primary">Valorar</button>
										        
										      </form>
										    </div>
						            </form>
					            </div>
					            <%} %>
				            </div>
			            </div>
			    
			        </div>
		 </div>
		 	 
		     <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</body>
</html>