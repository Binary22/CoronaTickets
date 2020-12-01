<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" href="home" style="font-family: 'Lobster', cursive; font-size: x-large;"><img style="max-height: 1.7em;" src="resources/media/coronatickets.svg"></a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li id="home" class="nav-item">
            <a class="nav-link" href="home">Inicio <span class="sr-only">(current)</span></a>
        </li>
        <li id="espectaculos" class="nav-item">
            <a class="nav-link" href="espectaculos">Espectáculos</a>
        </li>
        <li id="paquetes" class="nav-item">
            <a class="nav-link" href="paquetes">Paquetes</a>
        </li>
        <li id="usuarios" class="nav-item">
            <a class="nav-link" href="usuarios">Usuarios</a>
        </li>
    </ul>
    
    <div class="navbar-collapse">
	    <form id="busqueda-form" class="form-inline my-2 my-lg-0" action="buscar" method="GET">
    		<div class="input-group">
		        <input class="form-control" type="text" name="busqueda" placeholder="Buscar..." aria-label="Usuario" aria-describedby="button-addon2">
		        <div class="input-group-append">
	    			<button class="btn btn-outline-secondary" type="submit" id="button-addon2">
	    				<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  			<path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
				  			<path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
						</svg>
					</button>
	  			</div>
	  		</div>		
	    </form>
	</div>
    
    <% if (session.getAttribute("estado_sesion") == "LOGIN_CORRECTO") {  
    	String nickname = (String)session.getAttribute("usuario_logueado"); %>
    <div id='miperfil' class="navbar-nav">
	    <li class="nav-item avatar">
	        <a class="nav-link p-0" href="#">
	          <img src="<%=(String)session.getAttribute("usuario_avatar")%>" class="rounded-circle z-depth-0 mr-2"
	            alt="avatar image" height="40" style="max-width:40px">
	    </a>
        <li class="nav-item dropdown">
        
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%=nickname%>
            </a>
            
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
            	<%if((boolean)session.getAttribute("esArtista")){ %>
                <h5 class="dropdown-header"> Menu de artista </h5>
                <div class="dropdown-divider"></div>

                <a class="dropdown-item" href="altaespectaculo">Alta de espectáculo</a>
                <a class="dropdown-item" href="altafuncion">Alta de función de espectáculo</a>
                <a class="dropdown-item" href="crearPaquete">Crear paquete de espectáculos</a>
                <a class="dropdown-item" href="agregarEspectaculoaPaquete">Agregar espectáculo a paquete</a>
                <a class="dropdown-item" href="espectaculosfinalizados">Consultar espectáculos finalizados</a>
                <div class="dropdown-divider"></div>
                <%} %>
                <h5 class="dropdown-header"> Menu de usuario </h5>
                <div class="dropdown-divider"></div>
                <% String url = "detallesUsuario?name=" + nickname; %>
                <a class="dropdown-item" href="<%=url%>"> Mi perfil </a>
                <a class="dropdown-item" href="verPremios"> Premios </a>
                <a class="dropdown-item" href="modificarusuario"> Modificar usuario</a>
                <a class="dropdown-item" id="logout" href="logout">Salir de mi perfil</a>
                
                <!-- <div class="dropdown-divider"></div>
        		<a class="dropdown-item" href="cargardatos">Cargar Datos</a> -->
        	</div>
        </li>
    </div>
    
    <% } else { %>
    <form id="login-form" class="form-inline my-2 my-lg-0" action="login" method="POST">
        <input class="form-control mr-sm-2" type="text" name="nickname" placeholder="Nickname" aria-label="Usuario">
        <input class="form-control mr-sm-2" type="password" name="password" placeholder="Contraseña">
        <button id="registrarse" type="submit" class="btn btn-outline-success my-2 my-sm-0 " style="margin-right:5px">Ingresar</button>
        <a type="button" class="btn btn-outline-primary my-2 my-sm-0" href="registro">Registrarse</a>
    </form>
    <% } %>


</div>
</nav>