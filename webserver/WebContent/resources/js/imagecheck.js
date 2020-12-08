$(document).ready(function() {
    $("#imagen").on("blur", (e) => {
        $("#msg").hide();
        var image = new Image();
        
        image.onload = function() {
            // image exists and is loaded
            $('#msg').show();
            $("#msg").html("✔ imagen valida").css("color", "green");
            console.log("hola");
        }
        image.onerror = function() {
            // image did not load

            $('#msg').show();
            $("#msg").html("✗ imagen invalida").css("color", "red");
            console.log("holan't");
        }
        
        msg = $("#imagen").val();
        console.log(msg);
        image.src = msg;
        console.log("hola sanity check \n")

    })
});