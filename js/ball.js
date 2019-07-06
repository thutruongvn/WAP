$(function(){
    $("#ball").css("left", $(window).width()/2 + "px");
    setInterval(update, 10);
});
var ballVelocity = 0;
function update() {
    ballVelocity += 1;
    if (parseInt($("#ball").css('top')) > $(window).height()) {
      ballVelocity *= -.9;
    }
    $("#ball").css('top', function(idx, old) {
      return parseInt(old) + ballVelocity + 'px';
    });
}