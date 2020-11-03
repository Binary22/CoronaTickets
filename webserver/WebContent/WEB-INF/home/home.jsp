<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- <%@page errorPage="/WEB-INF/500.jsp"%> --%>
<%@page import="java.util.ArrayList, java.util.Collection, logica.Espectaculo, java.util.Iterator, logica.Paquete"%>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <div class="container">
        <br>
            <h3>Próximos Espectáculos</h3>  
        <br>
        <%
       	Collection<Espectaculo> espectaculos = (Collection<Espectaculo>) session.getAttribute("espectaculos");
        if (espectaculos.size() >= 3) { %>
        		<div class="card-deck pt-3">
        		<%  int i = 0;
        		for (Espectaculo e: espectaculos) {
        			if (i > 2) {
        				break;
        			}
        			%>
        			<carta-espectaculo  id = "<%=e.getPlataforma().getNombre() %>" titulo = "<%=e.getNombre() %>" descripcion = "<%=e.getDescripcion() %>"
				    	img = "<%=e.getImagen() %>" precio = <%=e.getCosto() %> artista = <%=e.getArtista().getNombre() %>></carta-espectaculo>
        			<% 
        			i++;
        		} %>
				</div>
		<% } %>
  
          <!--paquetes-->

        <br>
        <br>
            <h3>Paquetes seleccionados</h3>
        <br>
  
        <%
       	Collection<Paquete> paquetes = (Collection<Paquete>) session.getAttribute("paquetes");
        if (paquetes.size() >= 3) { %>
        		<div class="card-deck pt-3">
        		<%  int i = 0;
        		for (Paquete p: paquetes) {
        			if (i > 2) {
        				break;
        			}
        			%>
        			<carta-paquete img="<%=p.getImagen() %>" descripcion="<%=p.getDescripcion() %>" precio="<%= p.getDescuento() %>" titulo="<%= p.getNombre() %>"></carta-paquete>
				<%
        			i++;
        		} %>
				</div>
		<% } %>

        <br>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<script src="resources/js/espectaculos.js"></script>
	<script src="resources/js/cartaEspectaculo.js"></script>
	<link rel="stylesheet" href="resources/css/main.css"></style>
	<script src="resources/js/cartaPaquete.js"></script>
	
	</body>
</html>