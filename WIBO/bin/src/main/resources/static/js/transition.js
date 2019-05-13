$(document).ready(function() {
    //TRANSICIONES ENTRE PÁGINAS HTML.
    $("body").css("display", "none");
    $("body").fadeIn(2000);
    $("body").delay(1000).fadeOut(2000, redireccionarPag);



    function redireccionarPag() {
    	/*var form = document.createElement("form"); // crear un form
    	with(form) {
    	setAttribute("id", "myform"); //nombre del form
    	setAttribute("th:action", "@{'/login'}"); // action por defecto
    	setAttribute("method", "get"); // method POST }
    	}
    	document.getElementsByTagName("body")[0].appendChild(form); 
    	
    	
    	document.getElementById("myform").submit();
    	alert("no jaja");*/
    	window.location.href = "${pageContext.request.contextPath}/registro"
    	
    }

});
