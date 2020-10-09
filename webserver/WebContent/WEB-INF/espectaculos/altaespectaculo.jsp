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
  <body>

    
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container">
      <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:40rem;"">
        <div class="card-body">
          <!-- esto es un ejemplo de los carteles que tienen que salir si se ingresa un campo mal
          <div class="alert alert-danger" role="alert">
            Ingrese una duración mayor a 0.
          </div> -->

        <h4> Alta de espectaculo </h4>
        <br>
                
        <form>
            <div class="form-group">
              <label>Plataforma</label>
              <select class="form-control">
                <option>Facebook Live</option>
                <option>Instagram Live</option>
                <option>Twitter Live</option>
                <option>Youtube</option>
              </select>
            </div>
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control"  placeholder="Ej. Los Rolling 50 años">
            </div>
            <div class="form-group">
                <label>Descripción</label>
                <textarea class="form-control" placeholder="Ej. Tour en conememoración de los 50 años de los Rolling Stones"></textarea>
            </div>
            <label>Duración</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input type="number" class="form-control"  placeholder="Horas">
              </div>
              <div class="form-group col-md-6">
                <input type="number" class="form-control"  placeholder="Minutos">
              </div>
            </div>
            <label>Máximo y mínimo de espectadores</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input type="number" class="form-control"  placeholder="Máximo">
              </div>
              <div class="form-group col-md-6">
                <input type="number" class="form-control"  placeholder="Mínimo">
              </div>
            </div>
            <div class="form-group">
              <label>URL</label>
              <input type="url" class="form-control"  placeholder="Ej. https://youtube.com/rollingstoneslive">
            </div>
            <div class="form-group">
              <label>Categorias</label>
              <select class="form-control" multiple>
                <option>Rock</option>
                <option>Pop</option>
                <option>Duos</option>
                <option>Murga</option>
                <option>Solistas</option>
                <option>Cumbia</option>
              </select>
            </div>
            <div class="form-group">
              <label>Costo</label>
              <input type="number" class="form-control"  placeholder="Ej. 300">
            </div>
            <div class="form-group">
              <label>Elegir imagen</label>
              <br>
              <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg">
            </div>

            <button type="submit" class="btn btn-primary"> Dar de alta el espectaculo</button>
        </form>
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

</body>
</html>