<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logica.DataPremio, java.util.List" %>
<!DOCTYPE html>
<html>
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
		
		<div class="container">
			<h3 class="title">Premios Ganados:</h3>
					<%List<DataPremio> premios = (List<DataPremio>)session.getAttribute("premios_usuario");
					if(!premios.isEmpty()){
						int size = premios.size();
				        int j = 0;
				        int i = 0;
				        while(i < size){
						  %>
					        	<div class="card-deck pt-3">
							        <%for(j = i; j <= i + 2 && j < size; j++){%>
										<carta-premio class="card carta" titulo="<%=premios.get(j).getDescripcion() %>" fecha="<%=premios.get(j).getFechaSorteado() %>" espectaculo="<%=premios.get(j).getFuncion().getEspectaculo() %>" funcion="<%=premios.get(j).getFuncion().getNombre() %>"  style="width:18rem;"></carta-premio>
								  	<%} %>
					     		</div>
						  <%i = j;} 
					}else{%>
						 <h5 class="card-subtitle mb-2 text-muted">No ha ganado ningún premio</h5>
						
					<%} %>
		
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