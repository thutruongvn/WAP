$(function(){
    $("#ball").css("left", $(window).width()/2 + "px");
});
function update() {
    ballVelocity += 1;
    if (parseInt($("#ball").css('top')) > $(window).height()) {
      ballVelocity *= -.9;
    }
    $("#ball").css('top', function(idx, old) {
      return parseInt(old) + ballVelocity + 'px';
    });
}