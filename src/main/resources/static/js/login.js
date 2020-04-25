$(function () {

    /**
     * 刷新验证码
     * @type {*|jQuery}
     */
    var verifyCodeImageSrc = $('#verifyCodeImage').attr('src');
    $('#verifyCodeImage').click(function () {
        refreshVerifyCode($(this), verifyCodeImageSrc);
    });
    function refreshVerifyCode(_this, verifyCodeImageSrc) {
        _this.attr('src', verifyCodeImageSrc + '?_=' + Math.random());
    }


});
