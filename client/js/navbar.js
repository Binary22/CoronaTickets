const navTemplate = document.createElement('template');
navTemplate.innerHTML = `
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#" style="font-family: 'Lobster', cursive; font-size: x-large;">CoronaTickets.uy</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li id="home" class="nav-item">
                <a class="nav-link" href="index.html">Inicio <span class="sr-only">(current)</span></a>
            </li>
            <li id="espectaculos" class="nav-item">
                <a class="nav-link" href="espectaculos.html">Espectaculos</a>
            </li>
            <li id="paquetes" class="nav-item">
                <a class="nav-link" href="#">Paquetes</a>
            </li>
            <li id="usuarios" class="nav-item">
                <a class="nav-link" href="#">Usuarios</a>
            </li>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Menu Artista
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Alta de espectáculo</a>
                <a class="dropdown-item" href="#">Alta de función de espectáculo</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Crear paquete de espectáculos</a>
                <a class="dropdown-item" href="#">Agregar espectáculo a paquete</a>
            </div>
            </li>
        </ul>
        <form id="login-form" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2 d-none d-md-block" type="email" placeholder="Email" aria-label="Usuario">
            <input class="form-control mr-sm-2 d-none d-md-block" type="password" placeholder="Contraseña">
            <button id="registrarse" type="submit" class="btn btn-outline-success my-2 my-sm-0 " style="margin-right:5px">Ingresar</button>
            <button type="button" class="btn btn-outline-primary my-2 my-sm-0">Registrarse</button>
        </form>
        <div id='miperfil' class="navbar-nav" hidden>
            <li class="nav-item dropleft">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Mi Perfil
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Editar Perfil</a>
                    <a class="dropdown-item" id="logout" href="#">Salir de mi perfil</a>
                </div>
            </li>
        </div>
    </div>
    </nav>
`

class NavBar extends HTMLElement {
    constructor() {
        super();
        this.appendChild(navTemplate.content.cloneNode(true));
        let active = this.getAttribute('active');
        this.querySelector('#' + active).setAttribute('class','nav-item active')
    }

    onSubmit(e) {
        e.preventDefault();
        console.log('loggeado');
        this.querySelector('#login-form').toggleAttribute('hidden');
        this.querySelector('#miperfil').toggleAttribute('hidden');
    }

    logOut() {
        this.querySelector('#login-form').toggleAttribute('hidden');
        this.querySelector('#miperfil').toggleAttribute('hidden');
    }

    connectedCallback() {
        this.querySelector('#login-form').addEventListener('submit', (e) => this.onSubmit(e));
        this.querySelector('#logout').addEventListener('click', () => {
            this.logOut();
        });
    }
    
}

window.customElements.define('navbar-component', NavBar);