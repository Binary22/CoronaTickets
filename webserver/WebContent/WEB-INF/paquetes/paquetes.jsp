<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map, logica.Paquete" %>
<!doctype = html>
<html lang="en">
    <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        <div class="container">
              
         <% Map<String, Paquete> m = (Map<String, Paquete>) session.getAttribute("paquetes");
        int i = 0;
        for (Map.Entry<String, Paquete> entry : m.entrySet()) {      	
	        	String key = entry.getKey();
	        	Paquete value = entry.getValue();
	
	    		String descripcion = value.getDescripcion();
	    		String imagen = value.getImagen();
	    		
	    		int descuento = value.getDescuento();
        	
        		 if ((i % 3) == 0) { %>
        		<div class="card-deck pt-3">
        		<% } %>
        		<carta-paquete class="card carta" img="<%= imagen %>" descripcion="<%=descripcion%>" precio="<%= descuento %>" titulo="<%=key%>" style="width:18rem; flex: 0 0 30%;"></carta-paquete>
        		<% if ((i % 3) == 2 || i == m.size()) { %>
	        		<% if (i == m.size() && (i % 3 == 0)) { %>
	        			<carta-paquete class="card carta" img="<%= imagen %>" descripcion="<%=descripcion%>" precio="<%= descuento %>" titulo="<%=key%>" style="width:18rem;visibility: hidden; flex: 0 0 30%;"></carta-paquete>
	        		<% } %>
	        		<% if (i == m.size() && (i % 3 == 1)) { %>
	        			<carta-paquete class="card carta" img="<%= imagen %>" descripcion="<%=descripcion%>" precio="<%= descuento %>" titulo="<%=key%>" style="width:18rem;visibility: hidden; flex: 0 0 30%;"></carta-paquete>
	        			<carta-paquete class="card carta" img="<%= imagen %>" descripcion="<%=descripcion%>" precio="<%= descuento %>" titulo="<%=key%>" style="width:18rem;visibility: hidden; flex: 0 0 30%;"></carta-paquete>
	        		<% } %>
        		
        		</div>
        		<% }
        		i++;
        		%>
        		
        <% } %>
        </div>
        <br>

        

    <!-- javascript -->
    <script src="../js/papaparse.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/paquetes.js"></script>
    <script src="resources/js/cartaPaquete.js"></script>
    

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style> 

    </body>
</html>