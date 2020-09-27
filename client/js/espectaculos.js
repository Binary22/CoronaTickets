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

var mytable = "<div class=\"row\">"

var desc = "<p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>"

var boton = "<a href=\"#\" class=\"btn btn-primary\">Ver Espectaculo</a>"

function cargarDatos(espectaculos) {
    console.log(espectaculos);
    for( var i=0; i<espectaculos.length; i++) {
        titulo = espectaculos[i][2];
        desc = espectaculos[i][3];
        if ((i+1)%3 == 1 && i !=1) {
            mytable += "</div><div class=\"row\">";
        }
        mytable += `<div class=\"card mt-3 ml-5\" style=\"width:18rem\">
                        <div class=\"card-body\">
                            <h5 class=\"card-title\">`+ titulo +`</h5>`
                            + desc + "<br/>"
                            + boton +
                        `</div>
                    </div>`;
    }
    espectaculosLista.innerHTML = mytable;

}