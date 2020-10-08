<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- <%@page errorPage="/WEB-INF/500.jsp"%> --%>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/navbar.jsp"/>
        
        <!--  Esto se podria hacer dinamico con un jsp mas adelante -->
        
        <div class="container">
        <br>
            <h3>Próximos Espectáculos</h3>
        <br>
  
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              
              <div class="row">
              <div class="card-deck">
                <div class="col-md-4">
                  <div class="card h-100">
                    <img class="card-img-top" alt="..." src="resources/media/espectaculos/3.jpeg">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">Memphis Blues World</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Cyndi Lauper</h6>
                        <p id="desc" class="card-text">Espectáculo promoviendo álbum Memphis Blues.</p>
                        <ul class="list-group mt-auto list-group-horizontal">
                            <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                            <li id="precio" class="list-group-item">$800</li>
                        </ul>
                    </div>
                  </div>
                    
                </div>
    
                <div class="col-md-4 ">
                  <div class="card h-100">
                    <img class="card-img-top" alt="..." src="resources/media/espectaculos/5.jpeg">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">Bien de Familia</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Pimpinela Pimpinela</h6>
                        <p id="desc" class="card-text">El dúo estará presentando sus más sonados éxitos y también nuevas canciones.</p>
                        <ul class="list-group mt-auto list-group-horizontal">
                            <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                            <li id="precio" class="list-group-item">$500</li>
                        </ul>
                    </div>
                  </div>
                </div>
    
                <div class="col-md-4 ">
                  <div class="card h-100"> 
                    <img class="card-img-top" alt="..." src="resources/media/espectaculos/6.jpeg">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">30 años</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Violeta Alcides</h6>
                        <p id="desc" class="card-text">Espectáculo conmemorandolos 30 años de Violeta.</p>
                        <ul class="list-group mt-auto list-group-horizontal">
                            <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                            <li id="precio" class="list-group-item">$450</li>
                        </ul>
                    </div>
                  </div>

                
                </div>
                
              </div>
              </div>
    

            </div>
            <div class="carousel-item">
              <div class="row">
                <div class="card-deck">
                  <div class="col-md-4">
                    <div class="card h-100">
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/3.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">Memphis Blues World</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Cyndi Lauper</h6>
                          <p id="desc" class="card-text">Espectáculo promoviendo álbum Memphis Blues.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$800</li>
                          </ul>
                      </div>
                    </div>
                      
                  </div>
      
                  <div class="col-md-4 ">
                    <div class="card h-100">
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/5.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">Bien de Familia</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Pimpinela Pimpinela</h6>
                          <p id="desc" class="card-text">El dúo estará presentando sus más sonados éxitos y también nuevas canciones.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$500</li>
                          </ul>
                      </div>
                    </div>
                  </div>
      
                  <div class="col-md-4 ">
                    <div class="card h-100"> 
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/6.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">30 años</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Violeta Alcides</h6>
                          <p id="desc" class="card-text">Espectáculo conmemorandolos 30 años de Violeta.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$450</li>
                          </ul>
                      </div>
                    </div>
  
                  
                  </div>
                  
                </div>
                </div>
              
            </div>
            <div class="carousel-item">
              <div class="row">
                <div class="card-deck">
                  <div class="col-md-4">
                    <div class="card h-100">
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/3.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">Memphis Blues World</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Cyndi Lauper</h6>
                          <p id="desc" class="card-text">Espectáculo promoviendo álbum Memphis Blues.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$800</li>
                          </ul>
                      </div>
                    </div>
                      
                  </div>
      
                  <div class="col-md-4 ">
                    <div class="card h-100">
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/5.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">Bien de Familia</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Pimpinela Pimpinela</h6>
                          <p id="desc" class="card-text">El dúo estará presentando sus más sonados éxitos y también nuevas canciones.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$500</li>
                          </ul>
                      </div>
                    </div>
                  </div>
      
                  <div class="col-md-4 ">
                    <div class="card h-100"> 
                      <img class="card-img-top" alt="..." src="resources/media/espectaculos/6.jpeg">
                      <div class="card-body d-flex flex-column">
                          <h5 class="card-title">30 años</h5>
                          <h6 class="card-subtitle mb-2 text-muted">Violeta Alcides</h6>
                          <p id="desc" class="card-text">Espectáculo conmemorandolos 30 años de Violeta.</p>
                          <ul class="list-group mt-auto list-group-horizontal">
                              <a href="../html/detallesEspectaculo.html" class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
                              <li id="precio" class="list-group-item">$450</li>
                          </ul>
                      </div>
                    </div>
  
                  
                  </div>
                  
                </div>
                </div>
             
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

      

    

          <!--paquetes-->

        <br>
        <br>
            <h3>Paquetes seleccionados</h3>
        <br>
  
        <div class="row">
          <div class="col-md-6">
            <div class="card h-100">
              <img class="card-img-top" alt="..." src="https://bit.ly/3l9Vihe">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">Paquete de Bandas</h5>
                  <p class="card-text">Paquete de bandas musicales.</p>
                  <ul class="list-group mt-auto list-group-horizontal">
                      <a href="../html/detallesPaquete.html" class="list-group-item card-link active flex-fill">Ver Paquete</a>
                      <li id="precio" class="list-group-item flex-fill">20% OFF</li>
                  </ul>
              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card h-100">
              <img class="card-img-top" alt="..." src="https://bit.ly/2HSF4e0">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">Paquete Solistas</h5>
                  <p class="card-text">Paquete de solistas.</p>
                  <ul class="list-group mt-auto list-group-horizontal">
                      <a href="../html/detallesPaquete.html" class="list-group-item card-link active flex-fill">Ver Paquete</a>
                      <li id="precio" class="list-group-item flex-fill">30% OFF</li>
                  </ul>
              </div>
            </div>
          </div>
        </div>
      
        <br>

        <div class="row">
          <div class="col-md-6">
            <div class="card h-100">        
              <img class="card-img-top" alt="..." src="https://bit.ly/3ndBhIw">
              <div class="card-body d-flex flex-column">
                  <h5 class="card-title">Paquete Latino</h5>
                  <p class="card-text">Paquete de espectáculos latinos.</p>
                  <ul class="list-group mt-auto list-group-horizontal">
                      <a href="../html/detallesPaquete.html" class="list-group-item card-link active flex-fill">Ver Paquete</a>
                      <li id="precio" class="list-group-item flex-fill">15% OFF</li>
                  </ul>
              </div>
            </div>
          </div>
          <div class="col-md-6"></div>
        </div>

        <br>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="../js/login.js"></script>
    <script src="../js/navbar.js"></script>


	</body>
</html>