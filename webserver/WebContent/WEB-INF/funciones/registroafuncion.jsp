<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataFuncion"%>
<%@page import="logica.DataVale"%>
<%@page import="logica.DataRegistro"%>
<%@page import="logica.DataEspectaculo"%>
<!doctype html>
<html lang="en">
  <head>
    <jsp:include page="/WEB-INF/template/head.jsp"/>
  </head>
  <body>

    
    <jsp:include page="/WEB-INF/template/navbar.jsp"/>

    <div class="container">
    	<div class="row">
        	<div class="col-sm-6 pt-5 pb-5">
			        <div class="container mt-6">
			
			            <div class="d-flex justify-content-center">
				            <div class="card input-group mt-3" style="width:40rem;"">
					            <div class="card-body">
					    
						            <h4> Registro a función </h4>
						            <%if((boolean)session.getAttribute("noEligioTres")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				Debe seleccionar 3 registros previos!
									</div>
									<%} %>
									
									<%if((boolean)session.getAttribute("errorExisteRegFun")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				Ya existe un registro a esa función, seleccione otra!
									</div>
									<%} %>
									
									<%if((boolean)session.getAttribute("errorFunAlcanzoLimite")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				Lo sentimos, la función seleccionada alcanzó el máximo de espectadores, eliga otra
									</div>
									<%} %>
									
									<%if((boolean)session.getAttribute("fecha_invalida")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				La función ya fue realizada, por favor seleccione otra!
									</div>
									<%} %>
									
									<%if((boolean)session.getAttribute("funciones_vacias")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				No se seleccionó ningún registro previo, por favor vuelva a intentarlo
									</div>
									<%} %>
									
									<%if((boolean)session.getAttribute("vale_vacio")){ %>
						            <div class="alert alert-danger" role="alert">
						            
						  				Debe seleccionar un vale para realizar el canje
									</div>
									<%} %>
									
						            <br>
						                    
						             <form class="mt-2" action = "registroafuncion" method = "POST">
						                <div class="form-group">
						                    <h6>Función</h6>
						                    <%List<DataFuncion> funciones = (List<DataFuncion>)session.getAttribute("funcionesEspectaculo");
						                       %>
						                    <select class="form-control" name = "funcion_seleccionada" id = "funcionesList">
						                    <%for(int i = 0; i < funciones.size(); i++){ %>
						                      <option value = "<%= funciones.get(i).getNombre() %>"><%= funciones.get(i).getNombre() %></option>
						                     <%  }%>
						                    </select>
						                </div>
						                <br>
						               	<div >
						               		<%for(int i = 0; i < funciones.size(); i++){ %>
								                <div class = "borrar" id="<%= funciones.get(i).getNombre() %>" style="display: none;">
								                		<h5>Información de la función</h5>
								                		
								                		<%String var = "";
							                  			List<String> artistas = funciones.get(i).getArtistasInvitados();
							                  			if(!artistas.isEmpty()){
								                  			int fin = artistas.size()-1;
								                  			for(int j = 0; j < fin; j++){
								                  				var = var + artistas.get(j) + " - ";
								                  			}
								                  			var = var + artistas.get(fin);
							                  			} %>
								                        <h6>Fecha: </h6>
								                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= funciones.get(i).getFecha() %></h6>
								                      	<h6>Hora de inicio: </h6>
								                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= funciones.get(i).getHoraInicio() %></h6>
								                      	<h6>Artistas Invitados: </h6>
								                      	<h6 class="card-subtitle mb-2 text-muted" id = "fecha"><%= var %></h6>
								                </div> 
								                <%} %>
						               	</div>
						                
						                
						                <br>
						                <div class="form-group">
						                    <h6> Forma de registro</h6>
						                    
							                    <input type="radio" name="forma" id="registro" value="canjeregistros" onclick="mostrarCampos(this)">
							                    <label for="canjeregistros">Canje de registros previos</label><br>
							                    <input type="radio" name="forma" id="vale" value="canjevale" onclick="mostrarCampos(this)">
							                    <label for="canjevale">Canje de vales (paquetes)</label><br>
							                    <input type="radio" name="forma" id="tradicional" value="tradicional" checked onclick="mostrarCampos(this)">
							                    <label for="tradicional">Registro tradicional (abonando)</label>
						                    
						                </div>
						
						                <!-- Esto solo es visible si se desea canjear registros previos -->
						                
						                <div id="camposregistro" style="display: none;">
						                    <div class="form-group">
						                    <%List<DataRegistro> registros = (List<DataRegistro>)session.getAttribute("registros_canjear"); 
						                      if(!registros.isEmpty()){%>
						                        <label>Elegir registros a canjear</label>
						                        <h6 class="card-subtitle mb-2 text-muted">Para realizar un canje con registros previos debe seleccionar 3</h6>
						                        <select class="form-control"  name = "registros_previos" multiple>
						                        <%for(int i = 0; i < registros.size(); i++){ %>
						                          <option><%=registros.get(i).getFuncion() %></option>
						                          <%} %>
						                        </select>
						                        <h6>Precio a abonar:</h6>
						                        <h6 class="card-subtitle mb-2 text-muted">$0.00</h6>
						                        <%}else{ %>
						                        	 <h6 class="card-subtitle mb-2 text-muted">No posee registros previos</h6>
						                        	 <%} %>
						                    </div>
						                </div>
						                
						                
						
						                <!-- Esto solo es visible si se desea canjear un vale de un paquete -->
						                <div id="campospaquete" style="display: none;">
						                    <div class="form-group">
						                    <%List<DataVale> vales = (List<DataVale>)session.getAttribute("vales_canjear");
						                      DataEspectaculo espect = (DataEspectaculo)session.getAttribute("espectaculo_fun");
						                      if(!vales.isEmpty()){%>
						                    
						                        <label>Elegir vales a canjear</label>
						                        <select class="form-control" multiple name = "vale_seleccionado" id = "valesList">
						                        <%for(int i = 0; i < vales.size(); i++){ %>
						                          <option value = "<%=vales.get(i).getPaquete()%>"><%=vales.get(i).getPaquete() %></option>
						                       <%} %>
						                        </select>
						                        
						                        <h6>Precio a abonar:</h6>				                        
						                        <%
						                          float precio = espect.getCosto();
						                          for(int j = 0; j < vales.size(); j++){				                        	  	
						                        	  float dto = vales.get(j).getDtoPaquete();
						                          %>
						                        <div class = "vales_borrar" id="<%= vales.get(j).getPaquete() %>" style="display: none;" >
						                        	<h6 class="card-subtitle mb-2 text-muted">$<%=precio - precio*(dto/100) %></h6>
						                        </div>
						                        <%} %>
						                        <%}else{%>
						                        	<h6 class="card-subtitle mb-2 text-muted">No posee vales previos</h6>
						                        
						                        <% }%>
						                    </div>
						                </div>
						                
						                
						                
						                <div id="campotradicional" style="display: none;">
						                    	
						                        <h6>Precio a abonar: </h6>
						                        <h6 class="card-subtitle mb-2 text-muted">$<%=espect.getCosto() %></h6>
						                   
						                </div>    
						               
						                	
						                	<button type="submit" class="btn btn-primary">Registrar</button>
						                
						            </form>
					            </div>
				            </div>
			            </div>
			    
			        </div>
		        </div>
		        
		        <div class="col-sm-3 pt-5 pb-5 .px-2">
		        	
                    <%List<DataRegistro> regs = (List<DataRegistro>)session.getAttribute("registros_usuario");
                    if(!regs.isEmpty()){ %>
	                    <h4> Funciones a la que se registró: </h4>
	                    <%for(int i = 0; i < regs.size(); i++){
	                    	String var = " ";
	                    	if(regs.get(i).isYaFueCanjeado() && regs.get(i).getCosto() == 0){
	                    		var = "Canjeado";
	                    	}else{
	                    		var = "Abonado";
	                    	}
			                  		%>
	                    	<carta-funcion-chica img="resources/media/espectaculos/maracas.jpg" titulo= "<%=regs.get(i).getFuncion() %>" precioreg = "<%= regs.get(i).getCosto() %>" fechareg = "<%=regs.get(i).getFecha() %>" canjeadoreg = <%=var %> ></carta-funcion-chica>
	                    <%}
                    }%>
                </div>
	        </div>
        <br>

    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/login.js"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registroafuncion.js"></script>
    <script src="resources/js/cartaFuncionChica.js"></script>

</body>
</html>