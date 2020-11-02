var obj_csv = {
    size:0,
    dataFile:[]
};




 
document.querySelector('#plataforma').value="";

function readImage(input) {
    console.log(input)
 if (input.files && input.files[0]) {
 let reader = new FileReader();
        reader.readAsText(input.files[0]);
 reader.onload = function (e) {
 console.log(e);
 obj_csv.size = e.total;
 obj_csv.dataFile = e.target.result
            console.log(obj_csv.dataFile)
            parseData(obj_csv.dataFile)
            
 }
 }

 document.querySelector('#file-input').toggleAttribute('hidden');
}

var espectaculos = [];
 
function parseData(data){
    let csvData = [];
    let lbreak = data.split("nl");
    lbreak.forEach(res => {
        csvData.push(res.split(";"));
    });
    cargarDatos(csvData);
}

var espectaculosLista = document.querySelector("#espectaculos-lista");


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

var espectaculo3 = ["Cyndi Lauper","Twitter Live","Memphis Blues World","Espectáculo promoviendo álbum Memphis Blues.",110,5,1000,"https://twitter.com/cyndilauper",800,30/05/2020,"resources/media/espectaculos/3.jpeg"];
var espectaculo5 = ["Pimpinela Pimpinela","Twitter Live","Bien de Familia","El dúo estará presentando sus más sonados éxitos y también nuevas canciones.",150,10,500,"https://twitter.com/PimpinelaNet",500,08/07/2020,"resources/media/espectaculos/5.jpeg"];
var espectaculo6 = ["Violeta Alcides", "Twitter Live","30 años","Espectáculo conmemorandolos 30 años de Violeta.",80,30,150,"https://twitter.com/alcides_shows",450,31/07/20,"resources/media/espectaculos/6.jpeg"]

function plataformaSelected(value){
   console.log(value);
	var lista = document.querySelectorAll(".cartita");
	lista.forEach((i) => filtrar(i, value));
}

function filtrar(i, value) {
  if (i.id == value) {
    i.style.display = "block";
}else{
	i.style.display = "none";
}
}

