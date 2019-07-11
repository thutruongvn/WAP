"use strict";
var start = false;
$( function() {
    $("#maze .boundary").mouseover( () => {
        // let e = $(this);
        // console.log($("#boundary1"));
        // e.css("background-color", "#ff8888");
        // $("#boundary1").css("background-color", "#ff8888");
        if(start) {
            $(".boundary").addClass("youlose");
        }

    });

    $("#start").click( () => {
        $("#maze .boundary").removeClass("youlose");
        start = true;
    });

    $("#end").mouseover( () => {
        let e = $("#maze .youlose");
        // console.log(e.length);
        if (start) {
            let txt = e.length > 0 ? "Sorry, you lost. :[" : "You win! :]";
            $("#status").text(txt);
            start = false;
            // alert("Sorry, you lost. :[");
            // alert("You win! :]")
        } 
    });
});