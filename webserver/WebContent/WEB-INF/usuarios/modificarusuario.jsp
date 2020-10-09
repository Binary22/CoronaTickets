<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container">
        <div class="container mt-6">

            <div class="d-flex justify-content-center">
            <div class="card input-group mt-3" style="width:40rem;"">
            <div class="card-body">
    
            <h4> Modificar usuario </h4>
            <br>
                    
            <form>
                <div class="form-group">
                  <label>Nickname</label>
                  <input type="text" class="form-control"  value="Rigo23" readonly>
                </div>
                <div class="form-group">
                  <label>Nombre</label>
                  <input type="text" class="form-control"  value="Rigoberto">
                </div>
                <div class="form-group">
                  <label>Apellido</label>
                  <input type="text" class="form-control"  value="Ramirez">
                </div>
                <div class="form-group">
                  <label>Mail</label>
                  <input type="email" class="form-control"  value="rigo23@gmail.com">
                </div>
                <div class="form-group">
                  <label>Fecha de nacimiento</label>
                  <input type="date" class="form-control"  value="2000-03-22">
                </div>
                <!-- aca hay que agregar fecha de nacimiento -->
                <div class="form-group">
                  <label>Contraseña</label>
                  <input type="password" class="form-control" value="123456">
                </div>
                <div class="form-group">
                  <label>Confirmar contraseña</label>
                  <input type="password" class="form-control" value="123456">
                </div>
                <div class="form-group">
                  <label>Elegir imagen</label>
                  <br>
                  <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg">
                </div>
                <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="artista" onclick="mostrarCamposArtista(this)"> 
                  <label class="form-check-label"> Artista </label>
                </div>
                <!-- Esto solo es visible si se desea agregar a un artista -->
                <div id="camposArtista" style="display: none;">
                  <div class="form-group">
                    <label>Descripción</label>
                    <!-- quizas haya que usar javascript para actualizar estos textarea
                    parece que tienden a recordar los cambios que se les hizo antes-->
                    <textarea class="form-control">El proyecto solista de Rigoberto.</textarea>
                  </div>
                  <div class="form-group">
                    <label>Biografía</label>
                    <textarea class="form-control">Rigoberto Rock empezo como proyecto personal en 1995.</textarea>
                  </div>
                  <div class="form-group">
                    <label>Website</label>
                    <input type="url" class="form-control" value="rigobertorock.com">
                  </div>
                </div>
    
                <button type="submit" class="btn btn-primary">Registrar</button>
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
    <script src="../js/login.js"></script>
    <script src="../js/navbar.js"></script>
    <script src="../js/registro.js"></script>

</body>
</html>