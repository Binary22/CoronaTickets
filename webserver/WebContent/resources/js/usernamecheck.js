$(document).ready(function() {
			$("#nickname").on("blur", function(e) {
				$('#msg').hide();
				if ($('#nickname').val() == null || $('#nickname').val() == "") {
					$('#msg').show();
					$("#msg").html("El nombre de usuario es un campo requerido.").css("color", "red");
				} else {
					$.ajax({
						type: "POST",
						url: "/usernameChecker",
						data: $('#signupform').serialize(),
						dataType: "html",
						cache: false,
						success: function(msg) {
							$('#msg').show();
							$("#msg").html(msg);
						},
						error: function(jqXHR, textStatus, errorThrown) {
							$('#msg').show();
							$("#msg").html(textStatus + " " + errorThrown);
						}
					});
				}
            });
            
            $("#email").on("blur", function(e) {
				$('#msg2').hide();
				if ($('#email').val() == null || $('#email').val() == "") {
					$('#msg2').show();
					$("#msg2").html("El email es un campo requerido.").css("color", "red");
				} else {
					$.ajax({
						type: "POST",
						url: "/emailChecker",
						data: $('#signupform').serialize(),
						dataType: "html",
						cache: false,
						success: function(msg) {
							$('#msg2').show();
							$("#msg2").html(msg);
						},
						error: function(jqXHR, textStatus, errorThrown) {
							$('#msg2').show();
							$("#msg2").html(textStatus + " " + errorThrown);
						}
					});
				}
            });
            
            $("#imagen").on("blur", (e) => {
                $("#msg3").hide();
                var image = new Image();
                
                image.onload = function() {
                    // image exists and is loaded
                    $('#msg3').show();
                    $("#msg3").html("✔ imagen valida").css("color", "green");
                    console.log("hola");
                }
                image.onerror = function() {
                    // image did not load

                    $('#msg3').show();
                    $("#msg3").html("✗ imagen invalida").css("color", "red");
                    console.log("holan't");
                }
                
                msg = $("#imagen").val();
                console.log(msg);
                image.src = msg;
                console.log("hola sanity check \n")

            })
		});