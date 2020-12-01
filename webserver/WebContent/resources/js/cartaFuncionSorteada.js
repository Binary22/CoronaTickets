const templatefuncardsorteada = document.createElement('template');

templatefuncardsorteada.innerHTML = `
    <img class="card-img-top" style="width: 100%; object-fit: cover;" alt="...">
    <div class="card-body d-flex flex-column">
        <h5 class="card-title"></h5>
		<h6>Artistas Invitados:</h6>
        <h6 class="card-subtitle mb-2 text-muted">Artistas Invitados:</h6>
        <li id="artista1" hidden class="card-subtitle mb-2 text-muted"></li>
        <li id="artista2" hidden class="card-subtitle mb-2 text-muted"></li>
        <li id="artista3" hidden class="card-subtitle mb-2 text-muted"></li>
        <p id="desc" class="card-text">
        </p>
		
		 <ul class="list-group mt-auto list-group-horizontal">
			<a class="btn btn-success" role="button">Ver Sorteo</a>	
           
        </ul>
        
    </div>
    `

class funcionCardSorteada extends HTMLElement {
    constructor() {
        super();
        this.appendChild(templatefuncardsorteada.content.cloneNode(true));
        this.setAttribute('class',"card carta mt-3");
        //this.setAttribute('style',"width:18rem");
    }

    connectedCallback() {
        this.querySelector('.card-title').innerHTML = this.getAttribute('titulo');
        this.querySelector('#desc').innerHTML = this.getAttribute('descripcion');
        this.querySelector('.card-img-top').setAttribute('src',this.getAttribute('img'));
        this.querySelector('.card-subtitle').innerHTML = this.getAttribute('artistas');
		this.querySelector('a').href = 'sorteoPremios?name=' + this.getAttribute('nombreEspectaculo') + ";" + this.getAttribute('titulo');
		

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

window.customElements.define('carta-funcion-sorteada', funcionCardSorteada);