<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<!doctype html>
<html lang="en">
  <head>
        <jsp:include page="/WEB-INF/template/head.jsp"/>
  </head>

  <body onload="uncheckArtista()">
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container mt-6">
        <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:40rem;">
        <div class="card-body">
        
        <%
        HashMap<String, String> form = (HashMap<String, String> ) session.getAttribute("form");
        %>

        <h4> Crear Paquete de Espectáculos </h4>
        <br>
        <%if((Boolean)session.getAttribute("nombreexiste")){%> 
          <div class="alert alert-danger" role="alert">
            El nombre del paquete ya se encuentra en uso.
          </div>
          <%}%>
       	<%if((Boolean)session.getAttribute("fechaInvalida")){%> 
          <div class="alert alert-danger" role="alert">
            La fecha de inicio debe ser mayor o igual a la fecha actual y menor o igual a la fecha de finalización.
          </div>
        <%}%>
         
        <br>       
        <form action="crearPaquete" method="POST">
            <div class="form-group">
              <label>Nombre</label>
              <input type="text" class="form-control" name="nombre" placeholder="Ej. Paquete de Bandas"  value="<%= form.get("nombre") %>" required>
            </div>
            <div class="form-group">
              <label>Descripción</label>
              <textarea class="form-control" name="descripcion" placeholder="Ej. Bandas de los 90's"><%= form.get("descripcion") %></textarea>
            </div>
            <div class="form-group">
              <label>Fecha de inicio</label>
              <input type="date" name="fechaini" class="form-control" required value="<%= form.get("fechaIni") %>">
            </div>
            <!-- aca hay que agregar fecha de nacimiento -->
            <div class="form-group">
              <label>Fecha de finalización</label>
              <input type="date" name="fechafin" class="form-control" required value="<%= form.get("fechaFin") %>">
            </div>
            <div class="form-group">
              <label>Descuento</label>
              <input type="number" name="descuento" class="form-control" min="0" max="100" required value="<%= form.get("descuento") %>">
            </div>
            <div class="form-group">
               <label>Elegir imagen</label>
               <input id="imagen" type="imagen" class="form-control" name = "imagen" placeholder="Ej. https://bit.ly/ijgjr" value="<%= form.get("imagen") %>">
            </div>
            <div id="msg"></div>
            <button type="submit" class="btn btn-primary">Confirmar</button>
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
			  crossorigin="anonymous"></script>    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="../js/navbar.js"></script>
    <script src="resources/js/registro.js"></script>
    <script src="resources/js/imagecheck.js"></script>
</body>
</html>