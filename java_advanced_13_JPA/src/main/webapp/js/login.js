function loginRegisterSwitch() {
    $('form').animate({
        height: "toggle", opacity: "toggle"
    }, "slow");
}

function showAlertAfterRegistration() {
    $('div.alert.alert-success').show();
}

$('.message a').click(function (event) {
    event.preventDefault();
    loginRegisterSwitch();
});

$("button.register").click(function (event) {
    event.preventDefault();
    var firstName = $("form.register-form input.firstName").val();
    var lastName = $("form.register-form input.lastName").val();
    var email = $("form.register-form input.email").val();
    var password = $("form.register-form input.password").val();
    var userType = $("form.register-form select.userType").val();

    if (firstName == '' || lastName == '' || email == '' || password == '' || userType == '') {
        alert("Please fill all fields...!!!!!!");
        return false;
    } else if ((password.length) < 8) {
        alert("Password should be at least 8 characters long...!!!!!!");
        return false;
    } else {
        var userRegistration = {
            firstName: firstName, lastName: lastName, email: email, password: password, userType: userType
        };

        // Check if email exists
        $.post("check_email", {email: email}, function (data) {
            if (data !== 'Email is available') {
                alert(data);
                return false;
            } else {
                // Email is available, proceed with registration
                $.post("register", userRegistration, function (data) {
                    if (data !== 'Success') {
                        alert(data);
                        return false;
                    } else {
                        $("form")[0].reset();
                        $("form")[1].reset();
                        loginRegisterSwitch();
                        showAlertAfterRegistration();
                    }
                });
            }
        });
    }
});

$("button.login").click(function (event) {
    event.preventDefault();
    var email = $("form.login-form input.email").val();
    var password = $("form.login-form input.password").val();

    if (email == '' || password == '') {
        alert("Please fill login form!");
        return false;
    } else {
        var userLogin = {
            email: email, password: password
        };

        $.post("login", userLogin, function (data) {
            if (data !== '') {
                var customUrl = '';
                var urlContent = window.location.href.split('/');
                for (var i = 0; i < urlContent.length - 1; i++) {
                    customUrl += urlContent[i] + '/';
                }
                customUrl += data.destinationUrl;
                window.location = customUrl;
            }
            $("form")[1].reset();
        });
    }
});
