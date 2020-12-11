<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp"/>

<meta charset="UTF-8">
<title>Coronatickets.uy</title>
</head>
<body>

    <div class="custom-control custom-switch" style="margin-left:1em; display:none;">
	  <input type="checkbox" class="custom-control-input" id="darkSwitch" />
	  <label class="custom-control-label" for="darkSwitch"></label>
	</div>
	<script src="resources/js/dark-mode-switch.js"></script>

	    <!--<navbar-component active="home"></navbar-component>-->
	<% if ((session.getAttribute("estado_sesion") != null && (session.getAttribute("estado_sesion").equals("LOGIN_CORRECTO")))) { %>
	<jsp:include page="/WEB-INF/template/NavbarMobile.jsp"/>
	<div class="container mt-6">
		<br>
		<h3> Bienvenide! </h3>
	</div>
	<% } else { %>
    <div class="container mt-6">
        <br>
        <div class="text-center">
          <a class="mt-6" href="home"><img style="max-height: 3em;" src="resources/media/coronatickets.svg"></a>
        </div>
        <div class="d-flex justify-content-center">
        	<div class="card input-group mt-3" style="width:40rem;"">
        		<div class="card-body">
        			<h4> Inicio de Sesion </h4>
        			<form action="login" method="POST">
        				<% if (session.getAttribute("estado_sesion") == "LOGIN_INCORRECTO") { %>
        					<div class="alert alert-danger">
			           			Lo sentimos, el usuario y/o la contraseña es incorrecto.
			           		</div>
        				<% } %>
            			<div class="form-group" >
			              <label>Usuario</label>
			              <input type="text" class="form-control" name = "nickname" placeholder="" value="" required>
			            </div>
			            <div>
			              <label>Contraseña</label>
			              <input type="password" class="form-control" name = "password" placeholder="" value="" required>
			            </div>
			            <br>
			            <div>
			            	<label>No cerrar sesión</label>
			            	<input type="checkbox" name="recordar" value="true">
			            </div>
			            <br>
            			<button type="submit" class="btn btn-primary">Iniciar Sesion</button>
        			</form>
       		 	</div>
        	</div>
        </div>
    </div>
    <% } %>
    <br>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>
</body>
</html>