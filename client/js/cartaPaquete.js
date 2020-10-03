const templatePaquete = document.createElement('template');

templatePaquete.innerHTML = `
    <img class="card-img-top" alt="...">
    <div class=\"card-body\">
        <h5 class="card-title"><slot name="titulo"></slot></h5>
        <p class="card-text">
        </p>
        <ul class="list-group list-group-horizontal">
            <a href="../html/detallesPaquete.html" class="list-group-item card-link active flex-fill">Ver Paquete</a>
            <li id="precio" class="list-group-item flex-fill"></li>
        </ul>
    </div>
    `

class paqueteCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatePaquete.content.cloneNode(true));
        this.setAttribute('class',"card carta");
        this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('.card-text').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
        this.querySelector('#precio').innerHTML += this.getAttribute('precio') + '% OFF';
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-paquete', paqueteCard);