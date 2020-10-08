function uncheckArtista() {
    document.getElementById("artista").checked = false;
}

function mostrarCamposArtista() {
    if (document.getElementById("artista").checked == true) { 
        document.getElementById("camposArtista").style.display = "block";   
    } 
    else {
        document.getElementById("camposArtista").style.display = "none";   
    }
}