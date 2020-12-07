<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <jsp:include page="/WEB-INF/template/head.jsp"/>
  </head>
  <body onload="uncheckArtista()">

    <div class="custom-control custom-switch" style="margin-left:1em; display:none;">
	  <input type="checkbox" class="custom-control-input" id="darkSwitch" />
	  <label class="custom-control-label" for="darkSwitch"></label>
	</div>
	<script src="resources/js/dark-mode-switch.js"></script>
    
    
    
    <!--<navbar-component active="home"></navbar-component>-->

    <div class="container mt-6">
        <br>
        <div class="text-center">
          <a class="mt-6" href="home"><img style="max-height: 3em;" src="resources/media/coronatickets.svg"></a>
        </div>
        <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:40rem;"">
        <div class="card-body">
        <% 
          HashMap<String, String> form = (HashMap<String, String> ) session.getAttribute("form");	
        %>

        <h4> Registro </h4>
        <br>
        <%if((Boolean)session.getAttribute("contraNoCoincide")){%> 
          <div class="alert alert-danger" role="alert">
            Las contraseñas deben coincidir.
          </div>
        <%}%>
        <%if((Boolean)session.getAttribute("fechaInvalida")){%> 
          <div class="alert alert-danger" role="alert">
            La fecha de nacimiento debe ser menor o igual a la actual.
          </div>
        <%}%>
        <%if((Boolean)session.getAttribute("mismoNick")){%> 
          <div class="alert alert-danger" role="alert">
            El nick que desea utilizar ya esta en uso.
          </div>
        <%}%>
        <%if((Boolean)session.getAttribute("mismoMail")){%> 
          <div class="alert alert-danger" role="alert">
            El mail que desea utilizar ya esta en uso.
          </div>
        <%}%>
        <br>
        <form action="registro" method="POST" id="signupform">
            <div class="form-group" >
              <label>Nickname</label>
              <input id="nickname" type="text" class="form-control" name = "nickname" placeholder="Ej. Rigo23" value="<%= form.get("nickname") %>" required>
            </div>
            <div id="msg"></div>
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control" name = "nombre" placeholder="Ej. Rigoberto" value="<%= form.get("nombre") %>" required>
            </div>
            <div class="form-group">
              <label>Apellido</label>
              <input type="text" class="form-control" name = "apellido"  placeholder="Ej. Ramirez" value="<%= form.get("apellido") %>" required>
            </div>
            <div class="form-group">
              <label>Mail</label>
              <input id="email" type="email" class="form-control" name = "mail" placeholder="Ej. rigo23@gmail.com" value="<%= form.get("mail") %>" required>
              <div id="msg2"></div>
            </div>
            <div class="form-group">
              <label>Fecha de nacimiento</label>
              <input type="date" class="form-control" name = "fechaNac"  placeholder="Ej. rigo23@gmail.com" value="<%= form.get("fechanac") %>" required>
            </div>
            <!-- aca hay que agregar fecha de nacimiento -->
            <div class="form-group">
              <label>Contraseña</label>
              <input type="password" class="form-control" name = "password" placeholder="Ej. 123456" value="<%= form.get("password") %>" required>
            </div>
            <div class="form-group">
              <label>Confirmar contraseña</label>
              <input type="password" class="form-control" name = "confPassword" placeholder="Ej. 123456" value="<%= form.get("confipassword") %>" required>
            </div>
            <div class="form-group">
               <label>Elegir imagen</label>
               <input type="url" class="form-control" name = "imagen" placeholder="Ej. https://bit.ly/ijgjr" value="<%= form.get("imagen") %>">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" name = "esArtista" class="form-check-input" id="artista" onclick="mostrarCamposArtista(this)"> 
              <label class="form-check-label"> Artista </label>
            </div>
            <!-- Esto solo es visible si se desea agregar a un artista -->
            <div id="camposArtista" style="display: none;">
              <div class="form-group">
                <label>Descripción</label>
                <textarea class="form-control" name = "descripcion" placeholder="Ej. El proyecto solista de Rigoberto" ><%= form.get("descrip") %></textarea>
              </div>
              <div class="form-group">
                <label>Biografía</label>
                <textarea class="form-control" name = "biografia" placeholder="Ej. Rigoberto Rock empezo como proyecto personal en 1995." ><%= form.get("bio") %></textarea>
              </div>
              <div class="form-group">
                <label>Website</label>
                <input type="url" class="form-control" name = "website" placeholder="Ej. https://rigobertorock.com" value="<%= form.get("website") %>">
              </div>
            </div>

            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
        </div>
        </div>
        </div>

    </div>
    <br>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
			  src="https://code.jquery.com/jquery-3.5.1.js"
			  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
			  crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>
    <script src="resources/js/usernamecheck.js"></script>
</body>
</html>