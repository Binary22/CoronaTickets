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
        <navbar-component active="paquetes"></navbar-component>
        
        <div id="espectaculo" class="container">
            <div class="row">
                <div class="col-sm pt-5 pb-5">
                    <div class="card" style="width: 100%;">
                        <img class="card-img-top" src="https://bit.ly/3ndBhIw" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></slot>Paquete:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Paquete Latino</h6>
                            <h5 class="card-title">Descripcion:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Paquete de espectaculos latinos.</h6>
                            <h5 class="card-title"></slot>Descuento:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">15%</h6>
                            <h5 class="card-title"></slot>Fecha de alta:</h5>
                            <h6 class="card-subtitle mb-2 text-muted">01/08/2020</h6>
                            <ul class="list-group list-group-horizontal">
                                <a href="../html/comprapaquete.html" class="list-group-item card-link active flex-fill">Comprar</a>
                                <li id="precio" class="list-group-item"><i class="text-muted"style="text-decoration: line-through;">$1300</i><i>   $1149</i></li>
                                <li class="list-group-item flex-fill">15% OFF</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm pt-5 pb-5">
                    <h2>Espectaculos del Paquete:</h2>
                    <carta-espectaculo img="../media/espectaculos/5.jpeg" titulo="Bien de Familia" artista="Pimpinela Pimpinela" precio="500"></carta-espectaculo>
                    <div class="mb-4"></div>
                    <carta-espectaculo img="../media/espectaculos/6.jpeg" titulo="30 años" artista="Alcides Violeta" precio="450"></carta-espectaculo>
                </div>
            </div>
        </div>

        

    <!-- javascript -->
    <script src="../js/papaparse.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="../js/espectaculos.js"></script>
    <script src="../js/cartaEspectaculo.js"></script>
    <script src="../js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="../css/main.css"></style>

    </body>
</html>