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
		});