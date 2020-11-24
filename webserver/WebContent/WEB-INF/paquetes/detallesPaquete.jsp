<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logica.Artista, logica.Usuario, logica.DataPaquete, logica.DataEspectaculo, java.util.Map, java.util.List, java.util.Collection" %>
<!doctype = html>
<html lang="en">
    <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <% DataPaquete p = (DataPaquete) session.getAttribute("paquete"); %>
        
        <div id="espectaculo" class="container">
            <div class="row">
                <div class="col-sm pt-5 pb-5">
                    <div class="card" style="width: 100%;">
                        <img class="card-img-top" src="<%=p.getImagen()%>" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></slot>Paquete:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=p.getNombre()%></h6>
                            <h5 class="card-title">Descripcion:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=p.getDescripcion()%></h6>
                            <h5 class="card-title"></slot>Descuento:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=p.getDescuento()%>%</h6>
                            <h5 class="card-title"></slot>Fecha de alta:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=p.getFechaAlta()%></h6>
                            <ul class="list-group list-group-horizontal">
                            <%session.setAttribute("paqueteComprar",p.getNombre()); %>
                                <a href="comprapaquete" class="list-group-item card-link active flex-fill">Comprar</a>
                                <% float totalsindesc = 0;
                                for (DataEspectaculo e : (List<DataEspectaculo>) session.getAttribute("espectaculos")) {
                                	totalsindesc += e.getCosto();
                                }
                                float totalcondesc = totalsindesc - (totalsindesc * p.getDescuento() / 100);
                                
                                %>
                                <li id="precio" class="list-group-item"><i class="text-muted"style="text-decoration: line-through;">$<%=totalsindesc %></i><i>   $<%=totalcondesc %></i></li>
                                <li class="list-group-item flex-fill"><%=p.getDescuento()%>% OFF</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm pt-5 pb-5">
                    <h2>Espectaculos del Paquete:</h2>
                    <% for (DataEspectaculo e : (List<DataEspectaculo>) session.getAttribute("espectaculos")) { %>
                    
                    <carta-espectaculo img="<%=e.getImagen()%>" titulo="<%=e.getNombre()%>" artista="<%=e.getArtista()%>" precio="<%= e.getCosto() %>"></carta-espectaculo>
                    <div class="mb-4"></div>
                    
                    <% }%>
                </div>
            </div>
        </div>

        

    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/espectaculos.js"></script>
    <script src="resources/js/cartaEspectaculo.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="../css/main.css"></style>

    </body>
</html>