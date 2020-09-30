var obj_csv = {
    size:0,
    dataFile:[]
};
 
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

var mytable = '<div class="card-deck pt-3">';

function cargarDatos(espectaculos) {
    console.log(espectaculos);
    for( var i=0; i<espectaculos.length; i++) {
        titulo = espectaculos[i][2];
        desc = espectaculos[i][3];
        if ((i+1)%3 == 1 && i !=0) {
            mytable += '</div><div class="card-deck pt-3">';
        }
        mytable += `<carta-espectaculo class="carta" img='${espectaculos[i][10]}' titulo='${espectaculos[i][2]}' artista='${espectaculos[i][0]}' descripcion="${espectaculos[i][3]}" precio="${espectaculos[i][8]}"></carta-espectaculo>`;
    }
    espectaculosLista.innerHTML = mytable;

}