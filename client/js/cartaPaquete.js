const templatePaquete = document.createElement('template');

templatePaquete.innerHTML = `
    </style>
    <img class="card-img-top" alt="...">
    <div class=\"card-body\">
        <h5 class="card-title"><slot name="titulo"></slot></h5>
        <p class="card-text">
        </p>
    </div>
    <div class="card-footer">
        <a href="#" class="btn btn-primary">Ver Espectaculo</a>
    </div>`

class paqueteCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatePaquete.content.cloneNode(true));
        this.setAttribute('class',"card");
        this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('.card-text').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-paquete', paqueteCard);