
$('#valButton').click(function () {
    $.ajax({
        type: "GET",
        url: "emailCheck",
        data: {"email": $("#email").val()},
        success: function (data) {
            if(!data) {
                if($('#email').val().indexOf('@') > 0) {
                    if($('#email').val() !== '') {
                        $('#checkMsg').html('<span style="color:blue"> 사용가능한 이메일입니다 </span>');
                        $('#registerBtn').attr('disabled', false);
                    }
                } else {
                    $('#checkMsg').html('<span style="color:red"> 이메일 형식이 아닙니다 </span>');
                    $('#registerBtn').attr('disabled', true);
                }
            } else {
                if($('#email').val() !== '') {
                    $('#checkMsg').html('<span style="color:red"> 이미 사용중인 이메일입니다 </span>');
                    $('#email').val('');
                    $('#email').focus();
                    $('#registerBtn').attr('disabled', true);
                }
            }
        }
    })
})