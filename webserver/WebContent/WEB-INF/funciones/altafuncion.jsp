<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
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
        <div class="card input-group mt-3" style="width:40rem;">
        <div class="card-body">
        
        <%
        HashMap<String, String> form = (HashMap<String, String> ) session.getAttribute("form");
        %>
        
        <h4> Alta de funcion de espectaculo </h4>
        <br>
        
         <!--esto es un ejemplo de los carteles que tienen que salir si se ingresa un campo mal -->
          <%if((Boolean)session.getAttribute("escero")){%> 
          <div class="alert alert-danger" role="alert">
            Ingrese una duración mayor a 0.
          </div>
          <%}%>
          <!-- esto es un ejemplo de los carteles que tienen que salir si se ingresa un campo mal-->
        <%if((Boolean)session.getAttribute("nombreexiste")){%> 
          <div class="alert alert-danger" role="alert">
            El nombre que deséa utilizar ya se encuentra en uso.
          </div> 
		<%}%>
		<%if((Boolean)session.getAttribute("fechaInvalida")){%> 
          <div class="alert alert-danger" role="alert">
            La fecha debe ser igual o posterior a la actual.
          </div>
        <%}%>
		
		<br>   
        <form action="altafuncion" method="POST">
            <div class="form-group">
              <label>Espectaculo</label>
              <select class="form-control" name="espectaculo" required>
              <%List<String> espectaculos = (ArrayList) session.getAttribute("espectaculos");
				for(String esp: espectaculos){%>
              		<option><%=esp%></option>
              <%}%>
              </select>
            </div>
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control" name="nombre" placeholder="Ej. Los Rolling 50 años" value="<%= form.get("nombre") %>" required>
            </div>
            <label>Fecha y hora</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input type="date" id="fecha" name="fecha" class="form-control" value="<%= form.get("fecha") %>" required>
              </div>
              <div class="form-group col-md-6">
                <input type="time" name="hora" class="form-control" value="<%= form.get("horaInicio") %>" required>
              </div>
            </div>
            <div class="form-group">
                <label>Artistas invitados</label>
                <select class="form-control" name="artistasinv" multiple>
                <%List<String> artistas = (ArrayList) session.getAttribute("artistas");
				for(String art: artistas){%>
                  <option><%=art%></option>
                <%}%>
                </select> 
            </div>

            <button type="submit" class="btn btn-primary"> Dar de alta la función</button>
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