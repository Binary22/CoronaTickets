const template = document.createElement('template');

template.innerHTML = `
    <img class="card-img-top" style="object-fit: cover; height:15rem;  alt="...">
    <div class="card-body d-flex flex-column">
        <h5 class="card-title"></slot></h5>
        <h6 class="card-subtitle mb-2 text-muted"></h6>
        <p id="desc" class="card-text">
        </p>
        <ul class="list-group mt-auto list-group-horizontal">
            <a class="list-group-item card-link active flex-fill">Ver Espectaculo</a>
            <li id="precio" class="list-group-item">$</li>
        </ul>
    </div>
    `

class espectaculoCardFinalizado extends HTMLElement {
    constructor() {
        super();
        this.appendChild(template.content.cloneNode(true));
        this.setAttribute('class',"card carta");
        this.setAttribute('style',"flex: 0 0 30%;");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#desc').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
        this.querySelector('#precio').innerHTML += this.getAttribute('precio');
        this.querySelector('.card-subtitle').innerHTML += this.getAttribute('artista');
		this.querySelector('a').href = 'detallesEspectaculoFinalizado?name=' + this.getAttribute('titulo');


    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-espectaculo-finalizado', espectaculoCardFinalizado);