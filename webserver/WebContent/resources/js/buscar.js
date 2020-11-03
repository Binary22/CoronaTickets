// esta parte ordena los espectaculos
var $divsesp = $("div.divesp");

$('#orden').change(function () {
	if ($(this).val() === "alfa") {
			var alphabeticallyOrderedDivs = $divsesp.sort(function (a, b) {
	        return $(a).find("h5").text() > $(b).find("h5").text();
	    });
	    $("#contenedoresp").html(alphabeticallyOrderedDivs);
	} 
	if ($(this).val() === "fecha") {
			var alphabeticallyOrderedDivs = $divsesp.sort(function (a, b) {
	        return $(a).find("small").text() < $(b).find("small").text();
	    });
	    $("#contenedoresp").html(alphabeticallyOrderedDivs);
	}
    
});

$(document).ready(function() {
	if ($('#orden').val() === "alfa") {
			var alphabeticallyOrderedDivs = $divsesp.sort(function (a, b) {
	        return $(a).find("h5").text() > $(b).find("h5").text();
	    });
	    $("#contenedoresp").html(alphabeticallyOrderedDivs);
	} 
	if ($(this).val() === "fecha") {
			var alphabeticallyOrderedDivs = $divsesp.sort(function (a, b) {
	        return $(a).find("small").text() < $(b).find("small").text();
	    });
	    $("#contenedoresp").html(alphabeticallyOrderedDivs);
	}
 
});

// esta parte ordena los paquetes
var $divspaq = $("div.divpaq");

$('#orden').change(function () {
	if ($(this).val() === "alfa") {
			var alphabeticallyOrderedDivs = $divspaq.sort(function (a, b) {
	        return $(a).find("h5").text() > $(b).find("h5").text();
	    });
	    $("#contenedorpaq").html(alphabeticallyOrderedDivs);
	} 
	if ($(this).val() === "fecha") {
			var alphabeticallyOrderedDivs = $divspaq.sort(function (a, b) {
	        return $(a).find("small").text() < $(b).find("small").text();
	    });
	    $("#contenedorpaq").html(alphabeticallyOrderedDivs);
	}
    
});

$(document).ready(function() {
	if ($('#orden').val() === "alfa") {
			var alphabeticallyOrderedDivs = $divspaq.sort(function (a, b) {
	        return $(a).find("h5").text() > $(b).find("h5").text();
	    });
	    $("#contenedorpaq").html(alphabeticallyOrderedDivs);
	} 
	if ($(this).val() === "fecha") {
			var alphabeticallyOrderedDivs = $divspaq.sort(function (a, b) {
	        return $(a).find("small").text() < $(b).find("small").text();
	    });
	    $("#contenedorpaq").html(alphabeticallyOrderedDivs);
	}
 
});

// esto es el codigo para filtrar espectaculos (y ocultar paquetes)

$('#filtro').change(function () {
	if ($(this).val() === "todo") {	
	    $("#contenedorpaq").css("display","block");
		$(".cardespectaculo").css("display", "block");
		$("#contenedoresp").childer.css("display", "block");
	} else {
		$("#contenedorpaq").css("display", "none");
		$(".cardespectaculo").css("display", "none");
		$("." + $(this).val()).css("display", "block");
	}
    
});

$(document).ready(function() {
	$("#contenedorpaq").css("display","block"); 
});




