$( function() {
    
    $(document).scroll(myHandler);

})
function myHandler() {
    let scrollTop = $(window).scrollTop();
    let windowHeight = $(window).height();
    let docHeight = $(document.body).height();
    if (scrollTop + windowHeight >= docHeight) {
        $("body").append($("<div>").addClass('turtle'));
    }
}