<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <jsp:include page="/WEB-INF/template/head.jsp"/>
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

        <h4> Alta de funcion de espectaculo </h4>
        <br>
                
        <form action="altafuncion" method="POST">
            <div class="form-group">
              <label>Espectaculo</label>
              <% 
				List<String> espectaculos = request.getAttribute("espectaculos");

				for(String esp: espectaculos){
			  %>
              <select class="form-control" name="espectaculo">
                <option><%=esp%></option>
              </select>
              <%}%>
            </div>
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control" name="nombre" placeholder="Ej. Los Rolling 50 años">
            </div>
            <label>Fecha y hora</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input type="date" name="fecha" class="form-control">
              </div>
              <div class="form-group col-md-6">
                <input type="time" name="hora" class="form-control">
              </div>
            </div>
            <div class="form-group">
                <label>Artistas invitados</label>
                <% 
				List<String> artistas = request.getAttribute("artistas");

				for(String art: artistas){
			  	%>
                <select class="form-control" name="artistasinv" multiple>
                  <option><%=art%></option>
                </select>
                <%}%>
            </div>
            <div class="form-group">
              <label>Elegir imagen</label>
              <br>
              <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg">
            </div>

            <button type="button" class="btn btn-primary"> Dar de alta la función</button>
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
    <script src="resource/js/login.js"></script>
    <script src="resource/js/navbar.js"></script>

</body>
</html>