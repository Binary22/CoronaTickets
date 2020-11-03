<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="logica.Funcion"%>
<%@page import="logica.Vale"%>
<%@page import="logica.Registro"%>
<%@page import="logica.Espectaculo"%>
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
			
			<%if((boolean)session.getAttribute("funciones_vacias")){ %>
            <div class="alert alert-danger" role="alert">
            
  				No se seleccionó ningún registro previo, por favor vuelva a intentarlo
			</div>
			<%} %>
			
            <br>
                    
             <form class="mt-2" action = "registroafuncion" method = "POST">
                <div class="form-group">
                    <label>Función</label>
                    <%List<Funcion> funciones = (List<Funcion>)session.getAttribute("funcionesEspectaculo"); %>
                    <select class="form-control" name = "funcion_seleccionada">
                    <%for(int i = 0; i < funciones.size(); i++){ %>
                      <option><%= funciones.get(i).getNombre() %></option>
                     <%  }%>
                    </select>
                </div>
                <div class="form-group">
                    <label> Forma de registro</label><br>
                    
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
                    <%List<Registro> registros = (List<Registro>)session.getAttribute("registros_canjear"); 
                      if(!registros.isEmpty()){%>
                        <label>Elegir registros a canjear</label>
                        <select class="form-control"  name = "registros_previos" multiple>
                        <%for(int i = 0; i < registros.size(); i++){ %>
                          <option><%=registros.get(i).getFuncion().getNombre() %></option>
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
                        <label>Elegir vales a canjear</label>
                       
                        <select class="form-control" multiple>
                       
                          <option>g</option>
                       
                        </select>
                        <h6>Precio a abonar:</h6>
                        <h6 class="card-subtitle mb-2 text-muted">$0.00</h6>
                    </div>
                </div>
                
                
                
                <div id="campotradicional" style="display: none;">
                    	<%Espectaculo espect = (Espectaculo)session.getAttribute("espectaculo_fun"); %>
                        <h6>Precio a abonar: </h6>
                        <h6 class="card-subtitle mb-2 text-muted">$<%=espect.getCosto() %></h6>
                   
                </div>    
               
                	
                	<button type="submit" class="btn btn-primary">Registrar</button>
                
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
    <script src="resources/js/login.js"></script>
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/registroafuncion.js"></script>

</body>
</html>