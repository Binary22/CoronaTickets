<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
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

    
    <navbar-component active="home"></navbar-component>

    <div class="container">
      <div class="d-flex justify-content-center">
        <div class="card input-group mt-3" style="width:30rem;"">
        <div class="card-body">
            <!-- esto es un ejemplo de los carteles que tienen que salir si se ingresa un campo mal
            <div class="alert alert-danger" role="alert">
                Ingrese una duración mayor a 0.
            </div> -->

            <h4> Agregar espectaculo a paquete </h4>
            <br>
                    
            <form>
                <div class="form-group">
                    <label>Paquetes</label>
                    <select class="form-control" id="paquete">
                        <option default disabled selected value="">--Elegir paquete--</option>
                        <option value="Bandas">Bandas</option>
                        <option value="Solistas">Solistas</option>
                        <option value="Latino">Latino</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Plataformas</label>
                    <select class="form-control" id="plataforma" onchange="mostrarEspectaculos(value)">
                        <option default disabled selected value="">--Elegir plataforma--</option>
                        <option value="Instagram Live">Instagram Live</option>
                        <option value="Facebook Watch">Facebook Watch</option>
                        <option value="Twitter Live">Twitter Live</option>
                        <option value="Youtube">Youtube</option>
                    </select>
                </div>
	            <div class="form-group">
				    <label for="exampleFormControlSelect2">Espectáculos</label>
				    <select multiple class="form-control" id="Espectaculos">
				      <option>Los Village Volvieron</option>
				      <option>Global Spirit</option>
				      <option>Memphis Blues World</option>
				      <option>Springsteen on Broadway</option>
				      <option>Bien de Familia</option>
				      <option>30 años</option>
				    </select>
				</div>
				<button type="submit" class="btn btn-primary" style="display: inline-block">Confirmar</button>
      			<button type="submit" class="btn btn-primary"  style="display: inline-block">Cancelar</button>
           </form>
        </div>
        </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="../js/navbar.js"></script>
    <script src="../js/agregarEspectaculoaPaquete.js"></script>
    <script src="../js/cartaEspectaculoElegir.js"></script>

</body>
</html>