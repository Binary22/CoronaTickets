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
        <div class="container mt-6">

            <div class="d-flex justify-content-center">
            <div class="card input-group mt-3" style="width:40rem;"">
            <div class="card-body">
    
            <h4>Compra de paquete de espectáculos </h4>
            <br>
                    
            <form action="comprapaquete" method="POST">
                <div class="form-group">
                    <label>Paquete</label>
                    <select class="form-control" name="paquetes">
                    <%List<String> paquetes = (ArrayList) session.getAttribute("paquetes");
					for(String paq: paquetes){%>
						<%if(session.getAttribute("paqueteComprar") != paq){%>	 
                      		<option><%=paq%></option>
                      	<%}%>
                      	<%if(session.getAttribute("paqueteComprar") == paq){%>	
                      		<option selected><%=paq%></option>
                      	<%}%>
                    <%}%>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Comprar</button>
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

</body>
</html>