<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" href="home" style="font-family: 'Lobster', cursive; font-size: medium;"><img style="max-height: 1.7em;" src="resources/media/coronatickets.svg"></a>

<a class="navbar-brand" style=" font-size: small;"><img style="max-height: 1.7em;">
	Bienvenido <%= (String)session.getAttribute("usuario_logueado") %>
</a>

<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>



<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li id="espectaculos" class="nav-item">
            <a class="nav-link" href="espectaculos">Espectáculos</a>
        </li>
        <li id="espectaculos" class="nav-item">
            <a class="nav-link" href="logout">Cerrar Sesion</a>
        </li>
    </ul>
    
    
    
    


</div>
</nav>