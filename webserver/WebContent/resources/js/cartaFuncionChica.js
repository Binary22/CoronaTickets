const templatefuncard = document.createElement('template');

templatefuncard.innerHTML = `
    <img class="card-img-top" style="width: 100%; object-fit: cover;" alt="...">
    <div class="card-body d-flex flex-column">
        <h6 class="card-title"></h6>
	
        <h6 class="card-subtitle mb-2 text-muted">Artistas Invitados:</h6>
        <li id="artista1" hidden class="card-subtitle mb-2 text-muted"></li>
        <li id="artista2" hidden class="card-subtitle mb-2 text-muted"></li>
        <li id="artista3" hidden class="card-subtitle mb-2 text-muted"></li>
        <p id="desc" class="card-text">
        </p>
		<h6>Precio:</h6>
		<p id="precioregistro" class="card-text">
        </p>
		<h6>Fecha:</h6>
		<p id="fecharegistro" class="card-text">
        </p>
		<p id="canjeadoregistro" class="card-text">
        </p>
		
        
    </div>
    `

class funcionCard extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatefuncard.content.cloneNode(true));
        this.setAttribute('class',"card carta mt-3");
        //this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#desc').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
        this.querySelector('.card-subtitle').innerHTML = this.getAttribute('artistas');
		this.querySelector('#precioregistro').innerHTML = this.getAttribute('precioreg');
		this.querySelector('#canjeadoregistro').innerHTML = this.getAttribute('canjeadoreg');
		this.querySelector('#fecharegistro').innerHTML = this.getAttribute('fechareg');

      
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-funcion-chica', funcionCard);