function mostrarCampos() {
    if (document.getElementById("registro").checked == true) { 
        document.getElementById("campospaquete").style.display = "none";   
        document.getElementById("camposregistro").style.display = "block";
		document.getElementById("campotradicional").style.display = "none";
    } 
    else if (document.getElementById("vale").checked == true) {
        document.getElementById("campospaquete").style.display = "block";   
        document.getElementById("camposregistro").style.display = "none";
		document.getElementById("campotradicional").style.display = "none";  
    } else {
        document.getElementById("campotradicional").style.display = "block";   
        document.getElementById("camposregistro").style.display = "none";
		document.getElementById("campospaquete").style.display = "none";  
    }
}