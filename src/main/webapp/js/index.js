$(function () {
    $('#userName').bind('blur', function () {
        isUserNameUsable(this.val());
    });
    $('#email').bind('blur', function () {
        isEmailUsable(this.val());
    });
    $('#phone').bind('blur', function () {
        isPhoneUsable(this.val());
    });
});

function isUserNameUsable(userName) {
    $.ajax({
        url: '/user/check_username',
        type: 'post',
        data: {'userName': userName},
        dataType: 'JSON',
        success: function (result) {
            console.log(result);
        },
        error: function () {

        }
    });
}

function isEmailUsable(email) {

}

function isPhoneUsable(phone) {

}