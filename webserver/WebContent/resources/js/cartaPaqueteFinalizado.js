const templatePaquete = document.createElement('template');

templatePaquete.innerHTML = `
    <img class="card-img-top" style="object-fit: cover; height:15rem; height:15rem" style="flex: 0 0 30%;">
    <div class="card-body d-flex flex-column" style="flex: 0 0 30%;">
        <h5 class="card-title"></h5>
        <p class="card-text">
        </p>
        <ul class="list-group mt-auto list-group-horizontal">
            <li id="precio" class="list-group-item flex-fill"></li>
        </ul>
    </div>
    `

class paqueteCardFinalizado extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatePaquete.content.cloneNode(true));
        this.setAttribute('class',"card carta");
        this.setAttribute('style',"flex: 0 0 30%;");
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

window.customElements.define('carta-paquete-finalizado', paqueteCardFinalizado);