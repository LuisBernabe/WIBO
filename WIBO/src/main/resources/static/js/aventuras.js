$(document).ready(function() {
    var div = function (n) {
        if(n == 0)
            return "<div class='carousel-item active'>";
        else
            return "<div class='carousel-item'>";

    };
    var img = function (background_n) {
                return "<img class='d-block w-100 h-auto' src='/images/aventuras/aventura"+
                    background_n+".jpg' alt='"+background_n+"'>";
            };
    var button = function (nombre_aventura) {
            return "<div class='col'></div><div class='col over'>"+
                "<button type='submit' class='btn w-75 ml-auto mr-auto btn-primary'"+
                "value ='"+nombre_aventura+"'>Jugar</button></div><div class='col'></div>";
        };
    var div_c = "</div>";

    var aventuras = ["ZOOLÓGICO","PINTURA","PASTELERÍA"];

    aventuras.forEach(function(aventura,key) {
        var aventura_html = div(key)+img(key+1)+button(aventura)+div_c;
        $('#aventuras').append(aventura_html);
    });
});
