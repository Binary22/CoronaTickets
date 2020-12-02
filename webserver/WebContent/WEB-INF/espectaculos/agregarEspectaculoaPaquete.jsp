<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
  <head>
    <jsp:include page="/WEB-INF/template/head.jsp"/>
  </head>
  <body>

    
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container">
      <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:30rem;"">
        <div class="card-body">
            <!-- esto es un ejemplo de los carteles que tienen que salir si se ingresa un campo mal
            <div class="alert alert-danger" role="alert">
                Ingrese una duración mayor a 0.
            </div> -->

            <h4> Agregar espectaculo a paquete </h4>
            <br>  
            <form action="agregarEspectaculoaPaquete" method="POST">
                <div class="form-group">
                    <label>Paquetes</label>
                    <select class="form-control" id="paquete" name="paquetes" required>
                        <%List<String> paquetes = (ArrayList) session.getAttribute("paquetes");
						for(String paq: paquetes){%>
                  		<option><%=paq%></option>
                  		<%}%>
                    </select>
                </div>
                <div class="form-group">
                    <label>Plataformas</label>
                    <select class="form-control" id="plataforma" name="plataformas" required>
                        <%List<String> plataformas = (ArrayList) session.getAttribute("plataformas");
						for(String plat: plataformas){%>
                  		<option> <%=plat%> </option>
                  		<%}%>	
                    </select>
                </div>                
				<button type="submit" class="btn btn-success" style="display: inline-block">Elegir</button>
           </form>
        </div>
        </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/agregarEspectaculoaPaquete.js"></script>
    <script src="resources/js/cartaEspectaculoElegir.js"></script>

</body>
</html>