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



var mytable = '<div class="card-deck pt-3">';

function cargarDatos(paquetes) {
    var paquetesLista = document.querySelector("#paquetes-lista");
    console.log(paquetes);
    for( var i=0; i<paquetes.length; i++) {
        titulo = paquetes[i][2];
        desc = paquetes[i][3];
        if ((i+1)%3 == 1 && i !=0) {
            mytable += '</div><div class="card-deck pt-3">';
        }
        mytable += `<carta-paquete img='${paquetes[i][6]}' titulo='${paquetes[i][0]}' descripcion="${paquetes[i][1]}" precio="${paquetes[i][2]}"></carta-paquete>`;
    }
    paquetesLista.innerHTML = mytable;

}