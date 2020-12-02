$(document).ready(function() {
			$("#nickname").on("blur", function(e) {
				$('#msg').hide();
				if ($('#nickname').val() == null || $('#nickname').val() == "") {
					$('#msg').show();
					$("#msg").html("Username is required field.").css("color", "red");
				} else {
					$.ajax({
						type: "POST",
						url: "http://localhost:8080/webserver/usernameChecker",
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