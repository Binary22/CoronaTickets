<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.DataEspectaculo"%>
<%@page import="logica.DataEspectaculo.SetFunciones"%>
<%@page import="logica.DataPaquete"%>
<%@page import="logica.DataFuncion"%>
<%@page import="logica.Funcion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="logica.Paquete"%>
<%@page import="java.util.HashMap"%>

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
         <% if ((Boolean) session.getAttribute("Mobile") != null) { %>
    	<jsp:include page="/WEB-INF/template/NavbarMobile.jsp"/>
    <% } else { %>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
      <% } %>
        
        <% DataEspectaculo espect = (DataEspectaculo)session.getAttribute("espectaculo_selected");%>
        <div id="espectaculo" class="container">
            <div class="row">
                <div class="col-sm-6 pt-5 pb-5">
                    <div class="card" style="width: 100%;">
                        <img class="card-img-top" src="<%=espect.getImagen() %>" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></slot>Espectáculo:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getNombre() %></h6>
                            <% if(espect.getPuntajes().size() != 0) { %>
                            <h5 class="card-title">
                            <%
                            int promedio = 0;
                            for (int i : espect.getPuntajes()) {
                            	promedio += i*2;
                            }
                            promedio = promedio / (espect.getPuntajes().size());
                            for (int i= 0; i< promedio/2; i++) { %>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="blue" xmlns="http://www.w3.org/2000/svg">
							  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<%} 
							if ((promedio % 2) == 1) { %>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-half" fill="blue" xmlns="http://www.w3.org/2000/svg">
							  <path fill-rule="evenodd" d="M5.354 5.119L7.538.792A.516.516 0 0 1 8 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0 1 16 6.32a.55.55 0 0 1-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 0 1-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 0 1-.171-.403.59.59 0 0 1 .084-.302.513.513 0 0 1 .37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 0 1 .163-.505l2.906-2.77-4.052-.576a.525.525 0 0 1-.393-.288L8.002 2.223 8 2.226v9.8z"/>
							</svg>
							<%
							promedio+=1;
							}  for (int i=promedio/2; i<5; i++) {%>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star" fill="blue" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288l1.847-3.658 1.846 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.564.564 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
								</svg>
							<%} %>
							<br>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getPuntajes().size() %> valoraciones.</h6>
							<%}%>
							</h5>
                            <h5 class="card-title">Artista:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getArtista() %></h6>
                            <h5 class="card-title">Descripcion:</h6>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getDescripcion() %></h6>
                            <h5 class="card-title">Categorias:</h6>
                            <%
                            String PrettyCategorias = "";
                            if (!espect.getCategorias().isEmpty()){
                            	String catPrimera = espect.getCategorias().get(0);
                                 PrettyCategorias = catPrimera;
                                for (String cat : espect.getCategorias()){
                                	if (cat != catPrimera) {
                                		PrettyCategorias += ", " + cat;
                                	}
                                }
                            } else {
                            	 PrettyCategorias = "El Artista no ha definido una categoria para el Espectáculo.";
                            }
                            
                            %>
                            <h6 class="card-subtitle mb-2 text-muted"><%= PrettyCategorias %></h6>
                            <h5 class="card-title">Duracion:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getDuracion() %></h6>
                            <h5 class="card-title"></slot>Link:</h5>
                            <h6 href="https://twitter.com/PimpinelaNet/" class="card-subtitle mb-2 text-muted"><%=espect.getUrl() %></h6>
                            <h5 class="card-title"></slot>Precio:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">$<%=espect.getCosto() %></h6>
                            <h5 class="card-title"></slot>Plataforma:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getPlataforma() %></h6>
                            <h5 class="card-title"></slot>Espectadores:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">De <%=espect.getMinEspectadores() %> a <%=espect.getMaxEspectadores() %></h6>
                            <h5 class="card-title"></slot>Fecha de alta:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getFechaReg() %></h6>
                            <%if(!espect.getDescPremio().isEmpty()){ %>
                            <h5 class="card-title">Premio:</h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getDescPremio() %></h6>
                            <%} %>  
                            <% if( espect.getVideo() != "" && espect.getVideo() != null ) { %>
                            <h5 class="card-title"></slot>Video:</h5>
	                		<div class="embed-responsive embed-responsive-4by3">
	  						<iframe class="embed-responsive-item" style="" src="https://www.youtube.com/embed/<%=espect.getVideo()%>"></iframe>
							</div>
							<br>
							<%}%>
                        </div>  
                    </div>
                </div>
                
                
                <div class="col-sm-3 pt-5 pb-5 .px-2">
               
                    
                    <%Map<String, DataFuncion> funciones = (HashMap<String, DataFuncion>)session.getAttribute("funciones_espectaculo");
                    
	                    if(!funciones.isEmpty()){%>
	                    	<h3 class="title">Funciones:</h3>
		                    <%ArrayList<String> nombres = new ArrayList<String>(funciones.keySet());
		                    nombres.sort(String::compareToIgnoreCase);
		                  		for(String key : nombres){
		                  			String var = "";
		                  			List<String> artistas = funciones.get(key).getArtistasInvitados();
		                  			if(!artistas.isEmpty()){
			                  			int fin = artistas.size()-1;
			                  			for(int i = 0; i < fin; i++){
			                  				var = var + artistas.get(i) + ",";
			                  			}
			                  			var = var + artistas.get(fin);
		                  			}
		                  			if((boolean)session.getAttribute("esArtistaOrg")){
		                  				if(funciones.get(key).isFueSorteado()){%>
  					                    	<carta-funcion-sorteada img="resources/media/espectaculos/maracas.jpg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>" nombreEspectaculo = "<%=espect.getNombre() %>" ></carta-funcion-sorteada>
		                  					
		                  					
		                  				<%}else if(funciones.get(key).isFinalizo() && (espect.getDescPremio() != null && espect.getDescPremio() != "") && espect.getCantPremios() > 0){%>
  					                    		<carta-funcion-premio img="resources/media/espectaculos/maracas.jpg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>" nombreEspectaculo = "<%=espect.getNombre() %>" ></carta-funcion-premio>
		                  					
		                  					<% }else{%>
		                  						<carta-funcion img="resources/media/espectaculos/maracas.jpg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>" nombreEspectaculo = "<%=espect.getNombre() %>" ></carta-funcion>
		                  			
		                  			<%} %>
                  			
                  		<%}else{%>
                    	<carta-funcion img="resources/media/espectaculos/maracas.jpg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>" nombreEspectaculo = "<%=espect.getNombre() %>" ></carta-funcion>
                    <%}
		                  		
                    }
                  }%>
		             
					
                </div>
                
                <% if (session.getAttribute("Mobile") == null) { %>
                <div class="col-sm-3 pt-5 pb-5 .px-2">
                <%List<DataPaquete> paquetes = (List<DataPaquete>) session.getAttribute("paquetes");
                  if(!paquetes.isEmpty()){%>
                    <h2 class="title">Paquetes:</h2>
                    <%for(int i = 0; i < paquetes.size(); i++){ %>
                    <carta-paquete img="<%=paquetes.get(i).getImagen()%>" titulo="<%=paquetes.get(i).getNombre() %>" descripcion="<%=paquetes.get(i).getDescripcion() %>" precio="<%=paquetes.get(i).getDescuento() %>" class="card carta"></carta-paquete>
                    <%} %>
                <%} %>
                </div>
                <%} %>
                
            </div>
        </div>
        

        

    <!-- javascript -->
    <script src="../js/papaparse.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/espectaculos.js"></script>
    <script src="resources/js/cartaFuncionPremio.js"></script>
    <script src="resources/js/cartaFuncionSorteada.js"></script>
    <script src="resources/js/cartaFuncion.js"></script>
    <script src="resources/js/cartaPaquete.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>