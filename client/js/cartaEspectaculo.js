const template = document.createElement('template');

template.innerHTML = `
    </style>
    <img class="card-img-top" alt="...">
    <div class=\"card-body\">
        <h5 class="card-title"><slot name="titulo"></slot></h5>
        <p id="desc" class="card-text">
        </p>
        <ul class="list-group list-group-horizontal">
            <a href="#" class="list-group-item list-group-item-action">Ver Espectaculo</a>
            <li id="precio" class="list-group-item">$</li>
        </ul>
    </div>
    `

class espectaculoCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(template.content.cloneNode(true));
        this.setAttribute('class',"card");
        this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#desc').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
        this.querySelector('#precio').innerHTML += this.getAttribute('precio');
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-espectaculo', espectaculoCard);