<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
        <jsp:include page="/WEB-INF/template/head.jsp"/>
  </head>
  <style>
  button{
  	margin-top: 20px; 
  }
  </style>
  <body onload="uncheckArtista()">
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container mt-6">
        <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:40rem;"">
        <div class="card-body">

        <h4> Crear Paquete de Espectáculos </h4>
        <br>
                
        <form>
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control"  placeholder="Ej. Paquete de Bandas">
            </div>
            <div class="form-group">
              <label>Descripción</label>
              <textarea class="form-control" placeholder="Ej. Bandas de los 90's"></textarea>
            </div>
            <div class="form-group">
              <label>Fecha de inicio</label>
              <input type="date" class="form-control">
            </div>
            <!-- aca hay que agregar fecha de nacimiento -->
            <div class="form-group">
              <label>Fecha de finalización</label>
              <input type="date" class="form-control">
            </div>
           
            <div class="form-group">
              <label>Elegir imagen</label>
              <br>
              <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg">
            </div>
            <button type="submit" class="btn btn-primary">Confirmar</button>
            <button style="margin-left:20px" type="submit" class="btn btn-primary">Cancelar</button>
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
    <script src="../js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>
</body>
</html>