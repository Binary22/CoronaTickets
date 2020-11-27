window.addEventListener('load', inicio);
function inicio(){
	document.getElementById($('#funcionesList').val()).style.display = "block";
}
   
$('#funcionesList').change(function(){
	$(".borrar").css("display", "none");
	document.getElementById($('#funcionesList').val()).style.display = "block"; 
});

