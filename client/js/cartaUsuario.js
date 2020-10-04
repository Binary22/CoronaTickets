const templateUser = document.createElement('template');

templateUser.innerHTML = `
    <img class="card-img-top" style="height:300px" alt="...">
    <div class="card-body d-flex flex-column">
        <h5 class="card-title"></h5>
        <p class="card-text">
        </p>
        <ul class="list-group mt-auto list-group-horizontal">
            <a href="../html/detallesPaquete.html" class="list-group-item card-link active flex-fill">Seguir</a>
        </ul>
    </div>
    `

class userCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templateUser.content.cloneNode(true));
        this.setAttribute('class',"card carta");
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

window.customElements.define('carta-usuario', userCard);