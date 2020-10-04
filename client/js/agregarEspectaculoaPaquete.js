var obj_csv = {
    size:0,
    dataFile:[]
};

var espectaculo3 = ["Cyndi Lauper","Twitter Live","Memphis Blues World","Espectáculo promoviendo álbum Memphis Blues.",110,5,1000,"https://twitter.com/cyndilauper",800,30/05/2020,"../media/espectaculos/3.jpeg"];
var espectaculo5 = ["Pimpinela Pimpinela","Twitter Live","Bien de Familia","El dúo estará presentando sus más sonados éxitos y también nuevas canciones.",150,10,500,"https://twitter.com/PimpinelaNet",500,08/07/2020,"../media/espectaculos/5.jpeg"];
var espectaculo6 = ["Violeta Alcides", "Twitter Live","30 años","Espectáculo conmemorandolos 30 años de Violeta.",80,30,150,"https://twitter.com/alcides_shows",450,31/07/20,"../media/espectaculos/6.jpeg"]
 
var espectaculo1 = ["Village People","Instagram Live","Los Village Volvieron","Espectáculo de retorno de los Village People.",90,10,800,"https:// www.instagram.com/realvillagepeop",550,31/03/2020,"../media/espectaculos/1.jpeg"];
var espectaculo2 = ["Depeche Mode","Facebook Watch","Global Spirit","Espectáculo donde se presenta el álbum Spirit.",120,30,1300,"https://es-la.facebook.com/depechemode/",750,20/04/2020,"../media/espectaculos/2.jpeg"];

var espectaculo4 = ["Bruce Springsteen","Youtube","Springsteen on Broadway","Springsteen tocando guitarra o piano y relatando anécdotas recogidas en su autobiografíade 2016, Born to Run.",100,100,1500,"https:// www.youtube.com/BruceSpringsteen",980,07/06/2020,"../media/espectaculos/4.jpeg"]


document.querySelector('#plataforma').value="";

var espectaculosLista = document.querySelector("#espectaculos-lista2");


function cargarDatos(espectaculos) {
    var mytable = '<div class="card-deck pt-3">';
    console.log(espectaculos);
    for( var i=0; i<espectaculos.length; i++) {
        titulo = espectaculos[i][2];
        desc = espectaculos[i][3];
        if ((i+1)%3 == 1 && i !=0) {
            mytable += '</div><div class="card-deck pt-3">';
        }
        mytable += `<carta-espectaculo class="carta" img='${espectaculos[i][10]}' titulo='${espectaculos[i][2]}' artista='${espectaculos[i][0]}' descripcion="${espectaculos[i][3]}" precio="${espectaculos[i][8]}"></carta-espectaculo>`;
    }
    if  (!((i+1)%3 == 1)) {
        mytable+='</div>'
    }
    espectaculosLista.innerHTML = mytable;
};

function mostrarDatosPaquete(value){
    if (value == "Instagram Live") {
        cargarDatos([espectaculo1]);
    }
    if (value == "Facebook Watch") {
        cargarDatos([espectaculo2]);
    }
    if (value == "Twitter Live") {
        cargarDatos([espectaculo3,espectaculo5,espectaculo6]);
    }
	if (value == "Youtube"){
		cargarDatos([espectaculo4]);
	}
}