$(document).ready(function() {
    //TRANSICIONES ENTRE PÁGINAS HTML.
    $("body").css("display", "none");
    $("body").fadeIn(2000);
    $("body").delay(1000).fadeOut(2000, redireccionarPag);

    //Nada más cambiar por los path que serán ya en producción.
    var path = {"/Wibo-Adventures/templates/": "/Wibo-Adventures/templates/login.html"};

    function redireccionarPag() {
        linkDestino = window.location.origin+path[window.location.pathname];
        window.location = linkDestino;
    }

});
