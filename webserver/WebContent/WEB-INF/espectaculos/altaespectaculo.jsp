<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set" %>


<!doctype html>
<html lang="en">
  <head>
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

        <h4> Alta de espectaculo </h4>
        <br>
        
              
        <form action="altaespectaculo" method="POST">
            <div class="form-group">
              <label>Plataforma</label>
              <select required name="nomPlataforma" class="form-control">
              <% List<String> plataformas = (List<String>) session.getAttribute("plataformas"); 
              	for(String plat: plataformas) { %>
              		<option> <%= plat %> </option>
              <% } %>
              </select>
            </div>
            <div class="form-group">
          	<% 
          		HashMap<String, String> form = (HashMap<String, String> ) session.getAttribute("form");
          		if (session.getAttribute("error") != "no"){
          			
          	%> 
            	
           		<div class="alert alert-danger">
           			<%= session.getAttribute("error") %>
           		</div>
           	
           	<% } %>
           	
          		<label>Nombre*</label>
            	<input required name="nombre" type="text" class="form-control"  placeholder="Ej. Los Rolling 50 años">
              
            </div>
            <div class="form-group">
                <label>Descripción</label>
                <textarea name="descripcion" class="form-control" placeholder="Ej. Tour en conememoración de los 50 años de los Rolling Stones"><%= form.get("descripcion") %></textarea>
            </div>
            <label>Duración*</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input required value="<%= form.get("duracion") %>" name="horas" type="number" min="0" max="23" class="form-control"  placeholder="Horas">
              </div>
              <div class="form-group col-md-6">
                <input required value="<%= form.get("minutos") %>" name="minutos" type="number" min="0" max="60" class="form-control"  placeholder="Minutos">
              </div>
            </div>
            
            <label>Premio</label>
            <div class="form-row">
            	<div class="form-group col-md-12">
            	<textarea name="descPremio" class="form-control" placeholder="Ej. Television Samsung"><%= form.get("premio") %></textarea>
            	</div>
              	<br>
              	<div class="form-group col-md-6">
                <input value="<%= form.get("cantPremios") %>" name="cantPremios" type="number" min="0" class="form-control"  placeholder="Cantidad de Premios">
                </div>
            </div>
            
            <label>Máximo y mínimo de espectadores*</label>
            <div class="form-row">
              <div class="form-group col-md-6">
                <input required value="<%= form.get("maximo") %>" name="max" type="number" min="0" class="form-control"  placeholder="Máximo">
              </div>
              <div class="form-group col-md-6">
                <input required value="<%= form.get("minimo") %>" name="min" type="number" min="0" class="form-control"  placeholder="Mínimo">
              </div>
            </div>
            <div class="form-group">
              <label>URL*</label>
              <input required value="<%= form.get("url") %>" name="url" type="url" class="form-control"  placeholder="Ej. https://www.instagram.com/LosVillageVolvieron">
            </div>
            
            <div class="form-group">
              <label>Categorias</label>
              <select name ="categoria" class="form-control" multiple>
              <%
              	
              	List<String> categorias = (List<String>) session.getAttribute("categorias");
              	for (String cat : categorias) {
              	%>
              	
              	<option> <%=cat %></option>
              	
              	<%} %>
              </select>
            </div>
            <div class="form-group">
              <label>Costo*</label>
              <input required value="<%= form.get("costo") %>" name="costo" type="number" min="0" class="form-control"  placeholder="Ej. 300">
            </div>
            <div class="form-group">
               <label>Elegir imagen</label>
               <input id="imagen" type="url" value="<%= form.get("imagen") %>" class="form-control" name="imagen" placeholder="Ej. https://bit.ly/ijgjr">
            </div>
            <div id="msg"></div>
            <div class="form-group">
              <label>Elegir video</label>
              <input value="<%= form.get("video") %>" name="video" class="form-control"  placeholder="Ej. CS9OO0S5w2k">
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
<script
			  src="https://code.jquery.com/jquery-3.5.1.js"
			  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
			  crossorigin="anonymous"></script>    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/login.js"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/imagecheck.js"></script>
    

</body>
</html>