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

var usuarios = [];
 
function parseData(data){
    let csvData = [];
    let lbreak = data.split("nl");
    lbreak.forEach(res => {
        csvData.push(res.split(";"));
    });
    cargarDatos(csvData);
}

var usuariosLista = document.querySelector("#usuarios-lista");

var mytable = '<div class="card-deck pt-3">';

function cargarDatos(usuarios) {
    console.log(usuarios);
    for( var i=0; i<usuarios.length; i++) {
        titulo = usuarios[i][2];
        desc = usuarios[i][3];
        if ((i+1)%3 == 1 && i !=0) {
            mytable += '</div><div class="card-deck pt-3">';
        }
        mytable += `<carta-usuario class="carta" img='${usuarios[i][10]}' nickname='${usuarios[i][2]}'></carta-usuarios>`;
    }
    usuariosLista.innerHTML = mytable;

}