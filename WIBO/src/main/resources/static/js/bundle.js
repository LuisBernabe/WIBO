window.addEventListener("load", function (evt) {
    //RELOJ


    let canvas = document.getElementById("reloj");
    let context = canvas.getContext("2d");
    
    context.beginPath();
    context.lineWidth = 3;
    context.arc(50, 50, 32, 0, 2* Math.PI);
    context.stroke();
    context.closePath();

    context.beginPath();
    context.lineWidth = 3;
    context.arc(50, 50, 8, 0, 2* Math.PI);
    context.stroke();
    context.closePath();

    let lastTime = Date.now();
    let current = 0;
    let elapsed = 0;
    let max_elapsed_wait = 30 / 1000;
    let counter_time = 0;
    let time_step = 0.1;
    let animacion;
    let tiempo = 120; //TIEMPO RESTANTE EN SEGUNDOS


    function gameLoop() {
        current = Date.now();
        elapsed = (current - lastTime) / 1000;
        if (elapsed > max_elapsed_wait) {
            elapsed = max_elapsed_wait;
        }





        counter_time += elapsed;

        //
        context.beginPath();
        context.lineWidth = 20;
        context.strokeStyle = '#cc0000' ;
        //contexto.fillStyle = "#ff0000";
        context.arc(50, 50, 20, 0, (counter_time / tiempo) * Math.PI);
        //contexto.fill();
        context.stroke();
        //dubujo del reloj con canvas


        lastTime = current;
        animacion = window.requestAnimationFrame(gameLoop);
        if ((counter_time / tiempo) > 2) {
            alert("Tiempo agotado"); //FIN DEL JUEGO
            window.cancelAnimationFrame(animacion);

        }
    }

    window.requestAnimationFrame(gameLoop);


    //JUEGO
    $('#cas').on('dragover', function (e) {
        e.preventDefault();
    });



    let ingredientesDom = document.getElementsByClassName("ingre");
    let ingredientes = new Array();
    let datos;


    function generaReceta() {
        let actual=[];

        $('img').attr('draggable', false);
        for (let index = 1; index < 6; index++) {
            let tipoa=(Math.floor(Math.random() * (9 - 1) + 1)).toString();
            while (actual.indexOf(tipoa)!=-1) {
                tipoa=(Math.floor(Math.random() * (9 - 1) + 1)).toString();
            }
            actual.push(tipoa);
            let elemento=$('.ingre[tipo='+tipoa.toString()+']');
            elemento.attr("draggable", true);
            elemento.on("dragstart", function (params) {
                console.log("enraaa i");
                datos = { id: this.id, contador: this.getAttribute("numero"), tipo: this.getAttribute("tipo") }; 
            });
            elemento.on("dragend", function(e) {});
            elemento.attr("numero", index);
            ingredientes[index] = index;

            $('[objeto='+index.toString()+']').attr("src","/images/cocina/"+elemento.attr("tipo")+".png");
        }
    }
generaReceta();



        // elemento.addEventListener("dragstart", iniciar, false);
        // elemento.addEventListener("dragend", iniciar, false);
        // elemento.setAttribute("numero", Math.floor(Math.random() * (6 - 1) + 1));
        // ingredientes[parseInt(elemento.getAttribute("tipo"))] = parseInt(elemento.getAttribute("numero"));

  



    //METODO QUE SE SEJECUTA AL TOMAR UN ELEMENTO


    //METODO QUE SE EJECUTA AL SOLTAR UN ELEMENTO EN LA CAEULA
    $('#cas').on('drop', function (e) {
        e.preventDefault();
        e.stopPropagation();
        --ingredientes[parseInt(datos.contador)];
        if (ingredientes[parseInt(datos.contador)] < 0) {
            alert("receta fallida");
        }
        let bandera=true;
        for (let index = 1; index < 6; index++) {
            console.log(ingredientes[index]!=0);
            if (ingredientes[index]!=0) {
                bandera=false;   
            }
            
        }
        if(bandera==true) {
            alert("cambio");
            generaReceta();
            let score=$("#score").text();
            score=(parseInt(score)+10).toString();
            $("#score").text(score);
        }
    });




});