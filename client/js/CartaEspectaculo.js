const template = document.createElement('template');

template.innerHTML = `
<div class=\"card mt-3 ml-5\" style=\"width:18rem\">
    <div class=\"card-body\">
        <h5 class=\"card-title\"><slot name="titulo"></slot></h5>
        <div class="card-text">
        </div>
    </div>
    <div class="card-footer">
        <a href="#" class="btn btn-primary">Ver Espectaculo</a>
    </div>
</div>`

class espectaculoCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(template.content.cloneNode(true));
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('.card-text').innerHTML = this.getAttribute('descripcion');
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-espectaculo', espectaculoCard);