<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.Espectaculo"%>
<%@page import="logica.Funcion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="logica.Paquete"%>

<!doctype = html>
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
        
        <%Espectaculo espect = (Espectaculo)session.getAttribute("espectaculo_selected");%>
        <div id="espectaculo" class="container">
            <div class="row">
                <div class="col-sm-6 pt-5 pb-5">
                    <div class="card" style="width: 100%;">
                        <img class="card-img-top" src="resources/media/espectaculos/5.jpeg" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></slot>Espectaculo:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getNombre() %></h6>
                            <h5 class="card-title"></slot>Artista:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getArtista().getNombre() %></h6>
                            <h5 class="card-title">Descripcion:</h6>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getDescripcion() %></h6>
                            <h5 class="card-title">Duracion:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getDuracion() %></h6>
                            <h5 class="card-title"></slot>Link:</h5>
                            <h6 href="https://twitter.com/PimpinelaNet/" class="card-subtitle mb-2 text-muted"><%=espect.getUrl() %></h6>
                            <h5 class="card-title"></slot>Precio:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">$<%=espect.getCosto() %></h6>
                            <h5 class="card-title"></slot>Plataforma:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getPlataforma().getNombre() %></h6>
                            <h5 class="card-title"></slot>Espectadores:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">De <%=espect.getMinEspectadores() %> a <%=espect.getMaxEspectadores() %></h6>
                            <h5 class="card-title"></slot>Fecha de alta:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getFechaReg() %></h6>
                        </div>  
                    </div>
                </div>
                
                
                <div class="col-sm-3 pt-5 pb-5 .px-2">
               
                    <h2 class="title">Funciones:</h2>
                    <%Map<String,Funcion> funciones = espect.getAllFunciones();
                    ArrayList<String> nombres = new ArrayList<String>(funciones.keySet());
                    nombres.sort(String::compareToIgnoreCase);
                  		for(String key : nombres){
                  			String var = "";
                  			ArrayList<String> artistas = funciones.get(key).getArtistasInvitadosWeb();
                  			if(!artistas.isEmpty()){
	                  			int fin = artistas.size()-1;
	                  			for(int i = 0; i < fin; i++){
	                  				var = var + artistas.get(i) + ",";
	                  			}
	                  			var = var + artistas.get(fin);
                  			}
                  			
                  		%>
                    <carta-funcion img="resources/media/espectaculos/3.jpeg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>"></carta-funcion>
                    <%} %>
                </div>
                
                <div class="col-sm-3 pt-5 pb-5 .px-2">
                <%List<Paquete> paquetes = (List<Paquete>)session.getAttribute("paquetes");
                  if(!paquetes.isEmpty()){%>
                    <h2 class="title">Paquetes:</h2>
                    <%for(int i = 0; i < paquetes.size(); i++){ %>
                    <carta-paquete img="resources/media/paquetes/1.jpeg" titulo="<%=paquetes.get(i).getNombre() %>" descripcion="<%=paquetes.get(i).getDescripcion() %>" precio="<%=paquetes.get(i).getDescuento() %>" class="card carta"></carta-paquete>
                    <%} %>
                <%} %>
                </div>
            </div>
        </div>

        

    <!-- javascript -->
    <script src="../js/papaparse.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/espectaculos.js"></script>
    <script src="resources/js/cartaFuncion.js"></script>
    <script src="resources/js/cartaPaquete.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>