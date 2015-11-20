$(document).ready(function () {

    var invalidLoginPanel = $('#invalid-login');

    $('#sign-in-btn').click(function () {
        //unfosus signin button
        this.blur();

        //obtain login and password
        var login = $.trim($('#login').val());
        var password = $.trim($('#password').val());
        var contextPath = $('#context-path').val();

        //validate and login
        if (validate(login, password)) {
            //create object
            var credentials = {
                "login": login,
                "passwordHash": password
            };
            $.ajax({
                type: 'POST',
                url: contextPath + '/login',
                headers: {
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                },
                data: JSON.stringify(credentials),
                success: function (data) {
                    //if success login redirect to page in "redirect" parameter
                    window.location.href = data.redirect;
                },
                error: function (data) {
                    //obtain server error
                    var error = data.responseJSON;
                    var errorText = error.error;

                    invalidLoginPanel.removeClass('non-visible');
                    invalidLoginPanel.text(errorText);
                }
            });
        }
        return false;
    });

    //handle login on "Enter" button
    $('body').keypress(function (eventCode) {
        if (eventCode.keyCode == 13) {
            $('#sign-in-btn').click();
        }
    });

    function validate(login, password) {
        var error = "";
        var formGroupLogin = $('#form-group-login');
        var formGroupPassword = $('#form-group-password');

        if (!login) {
            formGroupLogin.removeClass('has-success');
            formGroupLogin.addClass('has-error');
            error += "Login is required! ";
        }
        if (!password) {
            formGroupPassword.removeClass('has-success');
            formGroupPassword.addClass('has-error');
            error += "Password is required! ";
        }
        if (error) {
            //show error is exist
            invalidLoginPanel.removeClass('non-visible');
            invalidLoginPanel.text(error);
            return false;
        } else {
            //hide error if it is absent
            invalidLoginPanel.addClass('non-visible');
            return true;
        }
    }

});


