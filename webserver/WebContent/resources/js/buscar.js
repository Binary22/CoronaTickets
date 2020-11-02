var $divsesp = $("div.divesp");
var orden = $('#orden').find(":selected").text();

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

$('#numBnt').on('click', function () {
    var numericallyOrderedDivs = $divs.sort(function (a, b) {
        return $(a).find("h2").text() > $(b).find("h2").text();
    });
    $("#container").html(numericallyOrderedDivs);
});