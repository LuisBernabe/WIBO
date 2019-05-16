$(document).ready(function () {
    var aventuras = ["PASTELERIA","PINTURA","ZOOLOGICO","CARRERA","SUPERMERCADO","PIZZERIA"];

    var aventura = window.location.search.split("=")[1];

    //validar que este dentro de las paginas permitidas xd

    $('nav>a').text("Wibo en: "+aventura);

    $('[data-toggle="popover"]').popover();

    function sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
});
