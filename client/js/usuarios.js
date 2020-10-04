var usuario1 = ['eleven11','Eleven','Ten','eleven11@gmail.com',31/12/1971,'../media/usuarios/eleven.png'];
var usuario2 = ['costas','Gerardo','Costas','gcostas@gmail.com',15/11/1983,'../media/usuarios/ger.jpeg']
var usuario3 = ['waston','Emma','Watsone','watson@gmail.com',15/4/1990,'../media/usuarios/emma.jpeg']
var usuarios =[usuario1,usuario2,usuario3];

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
        mytable += `<carta-usuario class="carta" img='${usuarios[i][5]}' descripcion='${usuarios[i][1]} ${usuarios[i][2]}' titulo='${usuarios[i][0]}'></carta-usuario>`;
    }

    if  (!((i+1)%3 == 1)) {
        mytable+='</div>'
    }
    usuariosLista.innerHTML = mytable;

}

cargarDatos(usuarios);