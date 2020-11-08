<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<!doctype html>
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
  <body onload="uncheckArtista()">

    
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
        <form action="registro" method="POST">
            <div class="form-group" >
              <label>Nickname</label>
              <input type="text" class="form-control" name = "nickname" placeholder="Ej. Rigo23" value="<%= form.get("nickname") %>" required>
            </div>
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
              <input type="email" class="form-control" name = "mail" placeholder="Ej. rigo23@gmail.com" value="<%= form.get("mail") %>" required>
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
                <textarea class="form-control" name = "descripcion" placeholder="Ej. El proyecto solista de Rigoberto" value="<%= form.get("descrip") %>"></textarea>
              </div>
              <div class="form-group">
                <label>Biografía</label>
                <textarea class="form-control" name = "biografia" placeholder="Ej. Rigoberto Rock empezo como proyecto personal en 1995." value="<%= form.get("bio") %>"></textarea>
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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>
</body>
</html>