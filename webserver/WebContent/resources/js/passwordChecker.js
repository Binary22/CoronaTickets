$(document).ready(function() {
    $("#pass2").on("blur", (e) => {
        $("#msgPass").hide();
        
        var contra = $("#pass").val();
        var contra2 = $("#pass2").val();
        
        if ((contra == contra2) && (contra != "") && (contra != null)) {
            // image exists and is loaded
            $('#msgPass').show();
            $("#msgPass").html("✔ Las contraseñas coinciden").css("color", "green");
            console.log("passhola");
        }
        else if (contra != contra2){
            // image did not load

            $('#msgPass').show();
            $("#msgPass").html("✗ Las contraseñas deben coincidir").css("color", "red");
            console.log("passholan't");
        } else {
            $('#msgPass').show();
            $("#msgPass").html("✗ La contraseña es un campo requerido.").css("color", "red");
        }
        
        msg = $("#imagen").val();
        console.log("pass sanity check \n")

    })

    $("#pass").on("blur", (e) => {
        $("#msgPass").hide();
        
        var contra = $("#pass").val();
        var contra2 = $("#pass2").val();
        
        if ((contra == contra2) && (contra != "") && (contra != null)) {
            // image exists and is loaded
            $('#msgPass').show();
            $("#msgPass").html("✔ Las contraseñas coinciden").css("color", "green");
            console.log("passhola");
        }
        else if (contra != contra2){
            // image did not load

            $('#msgPass').show();
            $("#msgPass").html("✗ Las contraseñas deben coincidir").css("color", "red");
            console.log("passholan't");
        } else {
            $('#msgPass').show();
            $("#msgPass").html("✗ La contraseña es un campo requerido.").css("color", "red");
        }
        
        msg = $("#imagen").val();
        console.log("pass sanity check \n")
    })
});