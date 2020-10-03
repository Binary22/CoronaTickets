const template = document.createElement('template');

template.innerHTML = `
    <img class="card-img-top" alt="...">
    <div class=\"card-body\">
        <h5 class="card-title"></slot></h5>
        <h6 class="card-subtitle mb-2 text-muted"></h6>
        <p id="desc" class="card-text">
        </p>
        <ul class="list-group list-group-horizontal">
            <a href="../html/detallesUsuario.html" class="list-group-item card-link active flex-fill">Ver Usuario</a>
            <li id="precio" class="list-group-item">$</li>
        </ul>
    </div>
    `

class espectaculoCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(template.content.cloneNode(true));
        this.setAttribute('class',"card carta");
        this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#nickname').innerHTML = this.getAttribute('nickname');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-usuario', usuarioCard);