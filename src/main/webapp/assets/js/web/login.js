    let btnLogin = $('#btnLogin');
    btnLogin.on('click', () => {

    let username = $('#username').val();
    let password = $('#password').val();

    let user = {
        username : username,
        password : password
    }
    // console.log(user);
    $.ajax({
        "headers" : {
            "accept" : "application/json",
            "content-type" : "application/json"
        },
        "type" : "POST",
        "url" : "http://localhost:8080/api/auth/login",
        "data" : JSON.stringify(user)
    })
        .done((data) => {
            App.IziToast.showSuccessAlert("Login success");
            window.location.href = "/home";
        })
        .fail(() => {
            App.IziToast.showErrorAlert("Login Error")
        })
})
    let btnSignUp = $('#btnSignUp')
    btnSignUp.on('click', () => {
        let firstName = $('#firstName').val();
        let lastName = $('#lastName').val();
        let username = $('#usernameReg').val();
        let password = $('#passwordReg').val();
        let rePassword = $('#rePasswordReg').val();
        let roleId = $('#role').val();
        let roleCode = $("#role :selected").text()

        let user = {
            firstName : firstName,
            lastName : lastName,
            username : username,
            password : password,
            role : {
                id: roleId,
                code:  roleCode
            }
        }

        $.ajax({
            "headers" : {
                "accept" : "application/json",
                "content-type" : "application/json"
            },
            "type" : "POST",
            "url" : "http://localhost:8080/api/auth/signup",
            "data" : JSON.stringify(user)
        })
            .done((data) => {
                $('#username').val($('#usernameReg').val());
                $('#password').val($('#passwordReg').val());
                App.IziToast.showSuccessAlert("Sign up successful");
                // window.location.href = "/login";
            })
            .fail((jqXHR) => {
                App.IziToast.showErrorAlert("Sign up error");
            })
    })