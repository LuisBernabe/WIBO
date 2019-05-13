$(function() {

    $('#login-form-link').click(function(e) {
        //Ocultamos el formulario de registro.
        $("#register-form").fadeOut(100);
        $('#register-form').addClass('d-none');
        $('#register-form').removeClass('d-block');
        $('#register-form-link').removeClass('active');

        //Mostramos el de login
        $("#login-form").delay(100).fadeIn(100);
        $('#login-form').removeClass('d-none');
        $('#login-form').addClass('d-block');
        $(this).addClass('active');

        e.preventDefault();
    });

    $('#register-form-link').click(function(e) {
        //Ocultamos el formulario de login
        $("#login-form").fadeOut(100);
        $('#login-form').addClass('d-none');
        $('#login-form').removeClass('d-block');

        //Mostramos el de registro
        $("#register-form").delay(100).fadeIn(100);
        $('#login-form-link').removeClass('active');
        $('#register-form').removeClass('d-none');
        $('#register-form').addClass('d-block');
        $(this).addClass('active');

        e.preventDefault();
    });

});
