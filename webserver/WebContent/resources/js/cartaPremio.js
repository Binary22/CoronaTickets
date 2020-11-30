const templatefuncardpremio = document.createElement('template');

templatefuncardpremio.innerHTML = `
    <div class="card-body d-flex flex-column">
        <h5 class="card-title"></h5>
		<h6>Fecha Sorteo:</h6>
        <h6 id="fecha" class="card-subtitle mb-2 text-muted"></h6>
		<h6>Espectaculo:</h6>
        <h6 id="espect" class="card-subtitle mb-2 text-muted"></h6>
		<h6>Función:</h6>
        <h6 id="fun" class="card-subtitle mb-2 text-muted"></h6>
        
        <p id="desc" class="card-text">
        </p>
		
        
    </div>
    `

class funcionCardPremio extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatefuncardpremio.content.cloneNode(true));
        this.setAttribute('class',"card carta mt-3");
        //this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#desc').innerHTML = this.getAttribute('descripcion');
        this.querySelector('#fecha').innerHTML = this.getAttribute('fecha');
		this.querySelector('#espect').innerHTML = this.getAttribute('espectaculo');
		this.querySelector('#fun').innerHTML = this.getAttribute('funcion');
		//this.querySelector('a').href = 'pdf?name=' + this.getAttribute('espectaculo') + ";" + this.getAttribute('funcion');

		

        //let artistas = ['artista1','artista2','artista3']
        /*artistas.forEach( (el) => {
            if (this.getAttribute(el) != null) {
                this.querySelector('.card-subtitle').getAttribute('hidden') ? this.querySelector('.card-subtitle').toggleAttribute("hidden") : console.log('ok');
                this.querySelector('#'+el).toggleAttribute('hidden');
                this.querySelector('#'+el).innerHTML += this.getAttribute(el);
            }
        })*/
    }

    espectaculoDetails() {
        //todo
    }
}

window.customElements.define('carta-premio', funcionCardPremio);