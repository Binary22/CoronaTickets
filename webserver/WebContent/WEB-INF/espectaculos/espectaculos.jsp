<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype = html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <jsp:include page="/WEB-INF/template/head.jsp"/>

        <title>CoronaTickets.uy</title>
      </head>

    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <div class="container">
            <fieldset class="mt-2">
                <h2>Plataforma:</h2>
                    <select class="form-control" id="plataforma" onchange="plataformaSelected(value)">
                        <option default disabled selected value="">--Elegir Plataforma--</option>
                        <option value="Twitter Live">Twitter Live</option>
                        <option value="Facebook Watch">Facebook Watch</option>
                        <option value="Instagram Live">Instagram Live</option>
                        <option value="Youtube">Youtube</option>
                    </select>
                </select>
            </fieldset>
        </div>
        <div id="espectaculos-lista" class="container">
            
        </div>

        

    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="resources/js/espectaculos.js"></script>
    <script src="resources/js/cartaEspectaculo.js"></script>
    <script src="resources/js/navbar.js"></script>

    <!-- style -->
    <link rel="stylesheet" href="../css/main.css"></style>

    </body>
</html>