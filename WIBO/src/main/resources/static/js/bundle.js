window.addEventListener("load", function(evt) {
    //RELOJ
	var x = document.getElementById("inicial"); 
	x.volume = 0.2;
	var b = document.getElementById("myamya"); 
	x.volume = 0.2;
	var ha = document.getElementById("nyahaha"); 
	var n1 = document.getElementById("n1"); 
	var n2 = document.getElementById("n2"); 
	var n3 = document.getElementById("n3"); 
	var n4 = document.getElementById("n4"); 
	var n5 = document.getElementById("n5"); 
	let escore=0;
	let acabados=0;
	let nrecetas=0;
	
	let numeros=[ha,n1,n2,n3,n4,n5];

    let canvas = document.getElementById("reloj");
    let context = canvas.getContext("2d");
    
    context.beginPath();
    context.lineWidth = 3;
    context.arc(45, 45, 32, 0, 2* Math.PI);
    context.stroke();
    context.closePath();

    context.beginPath();
    context.lineWidth = 3;
    context.arc(45, 45, 8, 0, 2* Math.PI);
    context.stroke();
    context.closePath();
    
    let cuenta = 4;
    let lastTime = Date.now();
    let current = 0;
    let elapsed = 0;
    let max_elapsed_wait = 30 / 1000;
    let counter_time = 0;
    let time_step = 0.1;
    let animacion;
    let tiempo = 15; //TIEMPO RESTANTE EN SEGUNDOS


    function gameLoop() {
    	
        current = Date.now();
        elapsed = (current - lastTime) / 1000;
        if (elapsed > max_elapsed_wait) {
            elapsed = max_elapsed_wait;
        }
        counter_time += elapsed;
        lastTime = current;
        animacion = window.requestAnimationFrame(gameLoop);

       if (cuenta>0) {
           if (counter_time > 0.0 && counter_time < 1.0) {
               $("#cuchito").css({
                   opacity: (1 - counter_time).toString(),
               });

           }
           if (counter_time > 1.0) {
               --cuenta;
               if (cuenta) {				
            	   numeros[cuenta].play();
               }
               $("#cuchito").text(cuenta);
               $("#cuchito").css({
                   opacity: '1.0',
               });
               counter_time=0;
               if (cuenta==0) {
               $("#cuchito").text("");
                   x.play();
                   
                   counter_time=0;
               }
           }  
		
       } else {

    	   $("#tiempo").text(tiempo*2-counter_time.toFixed(0));
           context.beginPath();
           context.lineWidth = 20;
           context.strokeStyle = '#cc0000' ;
           context.arc(45, 45, 20, 0, (counter_time / tiempo) * Math.PI);
           context.stroke();
           if ((counter_time / tiempo) > 2) {
        	   $("#escore").text(escore);
        	   $("#nrecetas").text(nrecetas);
               $('#final').modal('show');
               window.cancelAnimationFrame(animacion);

           }

       }



    }
    
    window.requestAnimationFrame(gameLoop);
    
    $( "#pausar" ).click(function() {
    	window.cancelAnimationFrame(animacion);
    	x.pause();
    	});
 
    $( "#resume" ).click(function() {
    	animacion = window.requestAnimationFrame(gameLoop);
    	x.play();
    });

    $( ".reintentar" ).click(function() {
    	window.location ="/logeado/juego";
    });
    $( "#terminar" ).click(function() {
    	window.location ="/logeado/menuaventuras";
    });


    //JUEGO
    $('#cas').on('dragover', function (e) {
        e.preventDefault();
    });




    let ingredientes = new Array();
    let respaldo = new Array();
    let datos={};

    function generaReceta() {
        let actual=[];

        $('img').attr('draggable', false);
        for (let index = 1; index < 5; index++) {
            let tipoa=(Math.floor(Math.random() * (11 - 1) + 1)).toString();
            while (actual.indexOf(tipoa)!=-1) {
                tipoa=(Math.floor(Math.random() * (11 - 1) + 1)).toString();
            }
            actual.push(tipoa);

            let elemento=document.querySelector('img[tipo=\''+tipoa+'\']');
            elemento.addEventListener("dragstart", iniciar, false);
            elemento.addEventListener("dragend", terminar, false);
            elemento.setAttribute("draggable", "true");
            elemento.setAttribute("indx", index-1);
            elemento.setAttribute("numero", Math.floor(Math.random() * (6 - 1) + 1));
            ingredientes[index-1] = parseInt(elemento.getAttribute("numero"));
            respaldo[index-1]=parseInt(elemento.getAttribute("numero"));
            $('[objeto='+index.toString()+']').attr("src","/images/cocina/"+tipoa+".png");
            $('[simbolo='+index.toString()+']').attr("src","/images/cocina/s"+ingredientes[index-1].toString()+".png");
        }
    }


generaReceta();
console.log(ingredientes);

function iniciar(e){
	
	datos = { indx: this.getAttribute("indx") }; 
}

function terminar(e){;}

  



    //METODO QUE SE SEJECUTA AL TOMAR UN ELEMENTO

    //METODO QUE SE EJECUTA AL SOLTAR UN ELEMENTO EN LA CAEULA
    $('#cas').on('drop', function (e) {
        e.preventDefault();
        e.stopPropagation();
        numeros[ingredientes[datos.indx]].play();
        --ingredientes[datos.indx];
        
        
        if (ingredientes[datos.indx]==0) {
        	++acabados;
        	$('#cas').attr('src', '/images/cocina/c'+acabados+'.png')
		}

        if (ingredientes[datos.indx] < 0) {
            for (let ind = 0; ind < 4; ind++) {
                ingredientes[ind]=respaldo[ind];
				}
            acabados=0;
            $('#cas').attr('src', '/images/cocina/c0.png');
            if (escore>=2) {
            	escore=$("#score").text();
            	escore=(parseInt(escore)-2).toString();
            	$("#score").text(escore);
       
            }
        }
        let bandera=true;
        for (let index = 0; index < 4; index++) {
            if (ingredientes[index]!=0) {
                bandera=false;   
            }
            
        }
        if(bandera==true) {
        	++nrecetas;
        	acabados=0;
        	$('#cas').attr('src', '/images/cocina/c0.png')
        	var tururu = document.getElementById("tururu"); 
        	tururu.play();
            generaReceta();
            escore=$("#score").text();
            escore=(parseInt(escore)+10).toString();
  
            $("#score").text(escore);
        }
    });




});