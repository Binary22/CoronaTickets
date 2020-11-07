<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Artista"%>
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
  <body>

    
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container">
        <div class="container mt-6">

            <div class="d-flex justify-content-center">
            <div class="card input-group mt-3" style="width:40rem">
            <div class="card-body">
    		<%Usuario usuariolog = (Usuario)session.getAttribute("usuariolog");%>
            <h4> Modificar usuario </h4>
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
          <br>
            <form action="modificarusuario" method="POST">
                <div class="form-group">
                  <label>Nickname</label>
                  <input type="text" class="form-control disabled" name = "nickname" value="<%=usuariolog.getNickname()%>" disabled>
                </div>
                <div class="form-group">
                  <label>Nombre</label>
                  <input type="text" class="form-control" name = "nombre" value="<%=usuariolog.getNombre()%>">
                </div>
                <div class="form-group">
                  <label>Apellido</label>
                  <input type="text" class="form-control" name = "apellido" value="<%=usuariolog.getApellido()%>">
                </div>
                <div class="form-group">
                  <label>Mail</label>
                  <input type="email" class="form-control" name="mail" value="<%=usuariolog.getEmail()%>" disabled>
                </div>
                <div class="form-group">
                  <label>Fecha de nacimiento</label>
                  <input type="date" class="form-control" name = "fechanac" value="<%=usuariolog.getFechaNacimiento().toString()%>">
                </div>
                <!-- aca hay que agregar fecha de nacimiento -->
                <div class="form-group">
                  <label>Contraseña</label>
                  <input type="password" class="form-control" id="password" name = "password"  value="<%=usuariolog.getPassword()%>">
                </div>
                <div class="form-group">
                  <label>Confirmar contraseña</label>
                  <input type="password" class="form-control" id="confirmpassword" name= "confirmpassword"  value="<%=usuariolog.getPassword()%>">
                </div>              
                <div class="form-group">
                  <label>Elegir imagen</label>
                  <br>
                  <input type="url" class="form-control" id="avatar" name="avatar" value="<%=usuariolog.getImagen()%>">
                </div>
                <% if(usuariolog.esArtista()){%>
                <%Artista usuarioArtlog = (Artista)session.getAttribute("usuariolog");%>
                <!-- Esto solo es visible si se desea agregar a un artista -->
                <div id="camposArtista">
                  <div class="form-group">
                    <label>Descripción</label>
                    <!-- quizas haya que usar javascript para actualizar estos textarea
                    parece que tienden a recordar los cambios que se les hizo antes-->
                    <textarea class="form-control" name = "descripcion" ><%=usuarioArtlog.getDescripcion()%></textarea>
                  </div>
                  <div class="form-group">
                    <label>Biografía</label>
                    <textarea class="form-control" name = "biografia"><%=usuarioArtlog.getBiografia()%></textarea>
                  </div>
                  <div class="form-group">
                    <label>Website</label>
                    <input type="url" class="form-control" name = "website" value="<%=usuarioArtlog.getWebsite()%>">
                  </div>
                </div>
                <%}%>
                <button type="submit" class="btn btn-primary">Modificar Perfil</button>
            </form>
            </div>
            </div>
            </div>
    
        </div>
        <br>

    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/login.js"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>

</body>
</html>