<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logica.DataUsuario, logica.DataFuncion, java.util.List" %>
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
		<%DataFuncion funcion = (DataFuncion)session.getAttribute("funcion_sorteada");%>
				<form class="mt-2" action = "sorteoPremios" method = "POST">
					<!-- <h2 class="title">Premio:</h2>
					<h5 class="card-title">Descripción:</h5>
                    <h6 class="card-subtitle mb-2 text-muted"><%=funcion.getDescriPremio() %></h6> -->
					<%if(funcion.isFueSorteado()){ %>
						<h5 class="card-title">Fecha Sorteo:</h5>
	                    <h6 class="card-subtitle mb-2 text-muted"><%=funcion.getFechaSorteo() %></h6>
	                    <h3 class="title">Espectadores de la función:</h3>
	                    
	                    <%List<DataUsuario> usuarios = (List<DataUsuario>)session.getAttribute("espectadores_premiados");
	                      int size = usuarios.size();
				          int j = 0;
				          int i = 0;
				          while(i < size){%>
				          		<div class="card-deck pt-3">
							        <%for(j = i; j <= i + 2 && j < size; j++){
										String descripcion = usuarios.get(j).getNombre() + " " + usuarios.get(j).getApellido(); %>
										<carta-usuario class="card carta" img="<%=usuarios.get(j).getImagen() %>" descripcion="<%=descripcion %>" titulo="<%=usuarios.get(j).getNickname() %>" style="width:18rem;"></carta-usuario>
								  	<%} %>
					     		</div>
						  <%i = j;} %>
					<%}else{ %>
						<h3 class="title">Espectadores de la función:</h3>
						
						<%List<DataUsuario> usuarios = (List<DataUsuario>)session.getAttribute("espectadores_premios");
						int size = usuarios.size();
				        int j = 0;
				        int i = 0;
				        while(i < size){
						  %>
					        	<div class="card-deck pt-3">
							        <%for(j = i; j <= i + 2 && j < size; j++){
										String descripcion = usuarios.get(j).getNombre() + " " + usuarios.get(j).getApellido(); %>
										<carta-usuario class="card carta" img="<%=usuarios.get(j).getImagen() %>" descripcion="<%=descripcion %>" titulo="<%=usuarios.get(j).getNickname() %>" style="width:18rem;"></carta-usuario>
								  	<%} %>
					     		</div>
						  <%i = j;} %>
						
						<br>
						
						<button type="submit" class="btn btn-success">Sortear</button>
					<%} %>
				</form>
		
		</div>
		
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/cartaUsuario.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="resources/css/main.css"></style>
		

	</body>
</html>