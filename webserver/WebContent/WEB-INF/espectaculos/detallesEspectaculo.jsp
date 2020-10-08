<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <navbar-component active="espectaculos"></navbar-component>
        
        <div id="espectaculo" class="container">
            <div class="row">
                <div class="col-sm-6 pt-5 pb-5">
                    <div class="card" style="width: 100%;">
                        <img class="card-img-top" src="../media/espectaculos/5.jpeg" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></slot>Espectaculo:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Bien de Familia</h6>
                            <h5 class="card-title"></slot>Artista:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Pimpinela Pimpinela</h6>
                            <h5 class="card-title">Descripcion:</h6>
                            <h6 class="card-subtitle mb-2 text-muted">El dúo estará presentandosus más sonados éxitos y también nuevas canciones.</h6>
                            <h5 class="card-title">Duracion:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">150</h6>
                            <h5 class="card-title"></slot>Link:</h5>
                            <h6 href="https://twitter.com/PimpinelaNet/" class="card-subtitle mb-2 text-muted">Twitter.com/PimpinelaNet</h6>
                            <h5 class="card-title"></slot>Precio:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">$500</h6>
                            <h5 class="card-title"></slot>Plataforma:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Twitter Live</h6>
                            <h5 class="card-title"></slot>Espectadores:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">De 10 a 500</h6>
                            <h5 class="card-title"></slot>Fecha de alta:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">08/07/2020</h6>
                        </div>  
                    </div>
                </div>
                <div class="col-sm-3 pt-5 pb-5 .px-2">
                    <h2 class="title">Funciones:</h2>
                    <carta-funcion img="../media/espectaculos/3.jpeg" titulo="Bien de Familia - A" artista1="Alcides Violeta"></carta-funcion>
                    <carta-funcion img="../media/espectaculos/3.jpeg" titulo="Bien de Familia - B" artista1="La Triple Nelson" ></carta-funcion>
                    <carta-funcion img="../media/espectaculos/3.jpeg" titulo="Bien de Familia - C" ></carta-funcion>
                </div>
                <div class="col-sm-3 pt-5 pb-5 .px-2">
                    <h2 class="title">Paquetes:</h2>
                    <carta-paquete img="../media/paquetes/1.jpeg" titulo="Paquete Solistas" descripcion="Paquete de solistas." precio="30" class="card carta"></carta-paquete>
                    <carta-paquete img="../media/paquetes/2.jpg" titulo="Paquete Solistas" descripcion="Paquete de solistas." precio="30" class="card carta"></carta-paquete>
                </div>
            </div>
        </div>

        

    <!-- javascript -->
    <script src="../js/papaparse.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="../js/espectaculos.js"></script>
    <script src="../js/cartaFuncion.js"></script>
    <script src="../js/cartaPaquete.js"></script>
    <script src="../js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="../css/main.css"></style>

    </body>
</html>