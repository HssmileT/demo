(function ($) {
    "use strict";


    /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function () {
        $(this).on('blur', function () {
            if ($(this).val().trim() != "") {
                $(this).addClass('has-val');
            } else {
                $(this).removeClass('has-val');
            }
        })
    })


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit', function () {
        // 		var check = true;
        //
        // 		for (var i = 0; i < input.length; i++) {
        // 			if (validate(input[i]) == false) {
        // 				showValidate(input[i]);
        // 				check = false;
        // 			}
        // 		}
        //
        // 		return check;
        return false;
    });


    $('.validate-form .input100').each(function () {
        $(this).focus(function () {
            hideValidate(this);
        });
    });

    function validate(input) {
        if ($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if ($(input).val().trim().match(
                /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/
            ) == null) {
                return false;
            }
        } else {
            if ($(input).val().trim() == '') {
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }


})(jQuery);


//用户类
var user = {
    username: "",
    password: "",
    phone: "",
    email: "",
    /*Ajax请求登录*/
    login: function () {
        $("#signIn .login100-form-subtitle").text("");
        user = checkUtil.checkLogin(this)
        if ($("#signIn .login100-form-subtitle").text()!="") {
            $("#signIn .login100-form-subtitle").velocity({opacity:1}, {duration: 400});
            return;
        }
        $.ajax({
            type: "POST",
            url: "user/login",
            data: "username=" + this.username + "&password=" + this.password,
            success: function (data) {
                if (data == "Success") {
                    $("#signIn .login100-form-subtitle").css("opacity:0");
                    $("#signIn .login100-form-subtitle").text("");
                    window.location="/";
                }else{
					$("#signIn .login100-form-subtitle").text("用户名或密码错误");
				}
            }
        });
    },
    /*Ajax请求注册*/
    signUp: function () {
        $("#signUp .login100-form-subtitle").text("");
        user = checkUtil.checksignUp(this);
        if ($("#signUp .login100-form-subtitle").text()!="") {
            $("#signUp .login100-form-subtitle").velocity({opacity:1}, {duration: 400});
            return;
        }
        $.ajax({
            type: "POST",
            url: "user/signUp",
            data: "username=" + this.username + "&password=" + this.password+ "&phone=" + this.phone+ "&email=" + this.email,
            success: function (data) {
                if (data == "Success") {
                    $("#signUp .login100-form-subtitle").css("opacity:0");
                    $("#signUp .login100-form-subtitle").text("");
                    window.location="/";
                }else{
                    $("#signUp .login100-form-subtitle").text("登陆失败");
                }
            }
        });
    }
};

//检查类
var checkUtil = {
    //正则验证用户名密码
    checkLogin: function (user) {
        var usernameReg = /^[a-zA-Z][a-zA-Z0-9]{6,15}$/;
        var passwordReg = /^[a-zA-Z0-9]{6,15}$/;
        var username = $("#signIn input[name='username']").val();
        var password = $("#signIn input[name='pass']").val();
        if (usernameReg.test(username) ) {
            //用户名或密码正确则赋值并返回对象
            user.username = username;
        }else{
            $("#signIn .login100-form-subtitle").text("请输入正确的用户名");
        }
        if(passwordReg.test(password)){
            user.password = password;
        }else{
            $("#signIn .login100-form-subtitle").text("请输入正确的密码");
        }
        return user;
    },
    //正则验证用户基本信息
    checksignUp: function (user) {
        var usernameReg = /^[a-zA-Z][a-zA-Z0-9]{6,15}$/;
        var passwordReg = /^[a-zA-Z0-9]{6,15}$/;
        var phoneReg = /^1\d{10}$/;
        var emailReg = /^\w+@\w+\.(com)$|(cn)$/;
        var username = $("#signup input[name='username']").val();
        var password = $("#signup input[name='pass']").val();
        var checkPassword = $("#signup input[name='checkPass']").val();
        var phone = $("#signup input[name='phone']").val();
        var email = $("#signup input[name='email']").val();
        //判断用户名密码等信息
        if (usernameReg.test(username) ) {
            user.username=username;
        } else {
            $("#signup .login100-form-subtitle").text("用户名格式错误(字母开头，数字加字母长度为15)");
        }
        if (passwordReg.test(password) ) {
            user.password=password;
        } else {
            $("#signup .login100-form-subtitle").text("密码格式错误(字母+数字长度为6-15)");
        }
        if (checkPassword != password) {
            $("#signup .login100-form-subtitle").text("两次输入密码不一致");
        }
        if (phoneReg.test(phone)) {
                user.phone=phone;
        } else {
            $("#signup .login100-form-subtitle").text("手机号格式错误(1+数字长度为11)");

        }
        if (emailReg.test(email)) {
            user.email=email;
        } else {
            $("#signup .login100-form-subtitle").text("邮箱格式错误(email@XXX.com)");
        }
        return user;
    }
}

//工具类
var util = {
    /*登陆注册窗口切换*/
    showSignUp: function () {
        $("#signIn").parent().velocity("fadeOut", {
            duration: 400,
            complete: function () {
                $("#signIn").css("display","none");
                $("#signUp").css("display","inline-block");
                $("#signIn").parent().velocity("fadeIn", {duration: 400});
            }
        });
    },
    showSignIn: function () {
        $("#signIn").parent().velocity("fadeOut", {
            duration: 400,
            complete: function () {
                $("#signUp").css("display","none");
                $("#signIn").css("display","inline-block");
                $("#signIn").parent().velocity("fadeIn", {duration: 400});
            }
        });
    }
}


