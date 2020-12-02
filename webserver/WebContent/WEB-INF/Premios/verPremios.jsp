<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logica.DataPremio, java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/template/head.jsp"/>

	</head>
	<body>
		<jsp:include page="/WEB-INF/template/navbar.jsp"/>
		
		<div class="container">
		<div class="row d-flex justify-content-center">
		<div class="col-md-8">
			<h3 class="title">Premios Ganados:</h3>
					<%List<DataPremio> premios = (List<DataPremio>)session.getAttribute("premios_usuario");
					if(!premios.isEmpty()){
						int size = premios.size();
				        int j = 0;
				        int i = 0;
				        while(i < size){
						  %>
					        	
							        <%for(j = i; j <= i + 2 && j < size; j++){%>
										<carta-premio class="card carta" titulo="<%=premios.get(j).getDescripcion() %>" fecha="<%=premios.get(j).getFechaSorteado() %>" espectaculo="<%=premios.get(j).getFuncion().getEspectaculo() %>" funcion="<%=premios.get(j).getFuncion().getNombre() %>"></carta-premio>
								  	<%} %>
					     		
						  <%i = j;} 
					}else{%>
						 <h5 class="card-subtitle mb-2 text-muted">No ha ganado ningún premio</h5>
						 <img alt="" src="resources/media/stuartTriste.png">
						
					<%} %>
		
		</div>
		</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	    <script src="resources/js/cartaPremio.js"></script>
	    <script src="resources/js/navbar.js"></script>
	
	    <!-- style -->
	    <link rel="stylesheet" href="resources/css/main.css"></style>

	</body>
</html>