$( function() {
    $("#people .person").addClass("boy");
    $("#add").click(addPersons);
    $("#kill").click(killPersons);
    $("#cleanup").click(cleanUp);
    $("#stomp").click(stompKill);
    $("#enrage").click(enrage);
    $("#patrol").click(patrol);
});
    
function getGender() {
    return $('input:checked').val();
}
function addPersons() {
    let gender = "person " + getGender();
    for (var i = 0; i < 5; i++) {
        $("#people").append($("<div>",{class: gender}));
    }
}
function killPersons() {
    let gender = getGender();
    let peeps = $("#people ." + gender);
    let len = peeps.length;
    len = (len > 0 && len < 5) ? 5 : len;
    for (var i = 0; i < parseInt(len/5); i++) {
        let randomIndex = Math.floor(Math.random() * peeps.length);
        let e = $(peeps[randomIndex]);
        e.removeClass(gender);
        e.addClass("splat");
    }
}
function cleanUp() {
    $("#people .splat").remove();
}
function stompKill() {
    $("#raptor").toggleClass("move");
    let peeps = $("#people .person").not(".splat");
    let len = peeps.length;
    len = (len > 0 && len < 5) ? 5 : len;
    for (var i = 0; i < parseInt(len/5); i++) {
        let randomIndex = Math.floor(Math.random() * peeps.length);
        let e = $(peeps[randomIndex]);
        e.attr("class","person splat");
    }
}
function enrage() {
    $("h1").toggleClass("enrage");
    $("#raptor").width(function(idx, old) {
        return ($("h1.enrage").length > 0) ? old + 50 : old - 50;
    });
}
var myVar;
function patrol() {
    clearInterval(myVar);
    $("#raptor").css("left","10px");
    myVar = setInterval(patrolRight, 20);
}
function patrolRight() {
    $("#raptor").css("left", (idx, old) => {
        if (parseInt(old) >= 300) {
            clearInterval(myVar);
            myVar = setInterval(patrolLeft, 20);
        }
        return  parseInt(old) + 4 + "px";
    });
}
function patrolLeft() {
    $("#raptor").css("left", (idx, old) => {
        if (parseInt(old) <= 10) {
            clearInterval(myVar);
            $("#raptor").css("left","10px");
        }
        return  parseInt(old) - 4 + "px";
    });
}