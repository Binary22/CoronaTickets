<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="logica.DataEspectaculo"%>
<%@page import="logica.DataEspectaculo.SetFunciones"%>
<%@page import="logica.DataPaquete"%>
<%@page import="logica.DataUsuario"%>
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
        <jsp:include page="/WEB-INF/template/head.jsp"/>
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
                        	<div class="row">
                        		<div class="col-6">
		                            <h5 class="card-title"></slot>Espectáculo:</h5>
		                            <h6 class="card-subtitle mb-2 text-muted"><%=espect.getNombre() %></h6>
		                        </div>
		                        <div class="col-6"> 
		                        	<p style="float:right" class="text-muted">
		                        	
	                        	<% if (session.getAttribute("estado_sesion")  == "LOGIN_CORRECTO") {
	                        		DataUsuario userlogged = (DataUsuario) session.getAttribute("userlogged");
	                        		            
	                        		if (userlogged.getFavoritos().contains((String) espect.getNombre())) { 
			                        	
			                        	%>
			                        		<a><img src="resources/media/coralleno.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } else {  %>
			                        		<a><img src="resources/media/coravacio.svg" style="float:right; width: 1.5em; height: 1.5em; margin-left: 0.5em;"/></a>
			                        	<% } %>
			                        	
		                       		<%}%>
		                       		<%=espect.getFavoritos()%> favoritos
		                            </p>
		                        </div>
	                        </div>
                            <% if(espect.getPuntajes().size() != 0) { %>
                            <h5 class="card-title">
                            <%
                            float total = 0;
                            float cant5 = 0;
                            float cant4 = 0;
                            float cant3 = 0;
                            float cant2 = 0;
                            float cant1 = 0;
                            float promedioF = 0;
                            int promedio = 0;
                            for (int i : espect.getPuntajes()) {
                            	total++;
                            	if(i == 5)
                            		cant5++;
                            	if(i == 4)
                            		cant4++;
                            	if(i == 3)
                            		cant3++;
                            	if(i == 2)
                            		cant2++;
                            	if(i == 1)
                            		cant1++;
                            	promedio += i*2;
                            	promedioF += i;
                            }
                            promedio = promedio / (espect.getPuntajes().size());
                            for (int i= 0; i< promedio/2; i++) { %>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
							  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
							</svg>
							<%} 
							if ((promedio % 2) == 1) { %>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-half" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
							  <path fill-rule="evenodd" d="M5.354 5.119L7.538.792A.516.516 0 0 1 8 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0 1 16 6.32a.55.55 0 0 1-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 0 1-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 0 1-.171-.403.59.59 0 0 1 .084-.302.513.513 0 0 1 .37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 0 1 .163-.505l2.906-2.77-4.052-.576a.525.525 0 0 1-.393-.288L8.002 2.223 8 2.226v9.8z"/>
							</svg>
							<%
							promedio+=1;
							}  for (int i=promedio/2; i<5; i++) {%>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
								  <path fill-rule="evenodd" d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288l1.847-3.658 1.846 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.564.564 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
								</svg>
							<%} %>
							<br>
                            
                            <h6 class="card-subtitle mb-2 text-muted" ><%=espect.getPuntajes().size() %> valoraciones.</h6>
                           
						    <div class="row">
						        
			              
			                    <div class="col-md-4 col-sm-12 text-center">
			                        <h1 class="rating-num" style="margin-top: 0.95rem">
			                            <%= String.format("%.1f", (promedioF / total)) %></h1>
			                        <h6 class="card-subtitle mb-2 text-muted" >Promedio</h6>
			                        <div class="rating">
			                            <span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star">
			                            </span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star">
			                            </span><span class="glyphicon glyphicon-star-empty"></span>
			                        </div>
			                    </div>
			                    <div class="col-md-8 col-sm-12">
			                        <div class="row">
			                        	<div class="col-3">                      
			                            	<svg width="1.40em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
												<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
											</svg> 5     
										</div>
										<div class="col-6">  
			                                <div class="progress">
												<div class="progress-bar bg-success" role="progressbar" style="width:<%= total> 0 ? ((cant5 / total) * 100) : 0 %>%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</div>
										<div class="col-3">
											<%= total> 0 ? (int) ((cant5 / total) * 100) : 0 %>%
										</div>
									</div>
									<!-- fin 5 -->
			                        <div class="row">
			                        	<div class="col-3">                      
			                            	<svg width="1.40em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
												<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
											</svg> 4     
										</div>
										<div class="col-6">  
			                                <div class="progress">
												<div class="progress-bar bg-success" role="progressbar" style="width:<%= total> 0 ? ((cant4 / total) * 100) : 0 %>%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</div>
										<div class="col-3">
											<%= total> 0 ? (int) ((cant4 / total) * 100) : 0 %>%
										</div>
									</div>
									<!-- fin 4 -->
			                        <div class="row">
			                        	<div class="col-3">                      
			                            	<svg width="1.40em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
												<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
											</svg> 3     
										</div>
										<div class="col-6">  
			                                <div class="progress">
												<div class="progress-bar bg-warning" role="progressbar" style="width:<%= total> 0 ? ((cant3 / total) * 100) : 0 %>%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</div>
										<div class="col-3">
											<%= total> 0 ? (int) ((cant3 / total) * 100) : 0 %>%
										</div>
									</div>
									<div class="row">
			                        	<div class="col-3">                      
			                            	<svg width="1.40em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
												<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
											</svg> 2     
										</div>
										<div class="col-6">  
			                                <div class="progress">
												<div class="progress-bar bg-warning" role="progressbar" style="width:<%= total> 0 ? ((cant2 / total) * 100) : 0 %>%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</div>
										<div class="col-3">
											<%= total> 0 ? (int) ((cant2 / total) * 100) : 0 %>%
										</div>
									</div>
			                        <div class="row">
			                        	<div class="col-3">                      
			                            	<svg width="1.40em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="#FBE45D" xmlns="http://www.w3.org/2000/svg">
												<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
											</svg> 1
										</div>
										<div class="col-6">  
			                                <div class="progress">
												<div class="progress-bar bg-danger" role="progressbar" style="width:<%= total> 0 ? ((cant1 / total) * 100) : 0 %>%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</div>
										<div class="col-3">
											<%= total> 0 ? (int) ((cant1 / total) * 100) : 0 %>%
										</div>
									</div>
			                        
			                       
			               
			        				</div>
						    </div>
						</div>
						 <div class="container">
							<%}%>
							</h5>
                            <h5 class="card-title"></slot>Artista:</h5>
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
                            <% if( espect.getVideo() != "" && espect.getVideo() != null) { %>
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
               
                    
                    <%Map<String, DataFuncion> funciones = new HashMap<String, DataFuncion>();
                    for(DataEspectaculo.SetFunciones.Entry e : espect.getSetFunciones().getEntry()) {
                        funciones.put(e.getKey(), e.getValue());
                    }
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
		             
					if (session.getAttribute("Mobile") != null) { 	
                  		%>
                  			<div class="card" style="margin-top: 10px;">
						    	<div class="card-body d-flex flex-column">
						        <h6 class="card-title">
						      		 <%= funciones.get(key).getNombre() %>
						        </h6>
						        <h6 class="card-subtitle mb-2 text-muted">Artistas Invitados:</h6>
						        	
						        <p id="desc" class="card-text">
						        <%= var %>
						        </p>
			        			<ul class="list-group mt-auto list-group-horizontal">
            						<a class="list-group-item card-link active flex-fill" href="registroafuncion?name=<%=espect.getNombre()%>;<%=funciones.get(key).getNombre()%>">Consultar</a>
       							 </ul>
						    	</div>
						</div>
                    <%}	else { %>
					<carta-funcion-finalizada img="resources/media/espectaculos/maracas.jpg" titulo= "<%=funciones.get(key).getNombre() %>" artistas = "<%= var %>" nombreEspectaculo = "<%=espect.getNombre() %>" ></carta-funcion-finalizada>
					<%	} } }%>
                </div>
                
                <% if (session.getAttribute("Mobile") == null) { %>
                <div class="col-sm-3 pt-5 pb-5 .px-2">
                <%List<DataPaquete> paquetes = (List<DataPaquete>) session.getAttribute("paquetes");
                  if(!paquetes.isEmpty()){%>
                    <h2 class="title">Paquetes:</h2>
                    <%for(int i = 0; i < paquetes.size(); i++){ %>
                    <carta-paquete-finalizado img="<%=paquetes.get(i).getImagen()%>" titulo="<%=paquetes.get(i).getNombre() %>" descripcion="<%=paquetes.get(i).getDescripcion() %>" precio="<%=paquetes.get(i).getDescuento() %>" class="card carta"></carta-paquete-finalizado>
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
    <script src="resources/js/cartaFuncionFinalizada.js"></script>
    <script src="resources/js/cartaPaqueteFinalizado.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>

    </body>
</html>