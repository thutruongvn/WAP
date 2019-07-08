"use strict";

$( function() {
    $("#boundary1").mouseover( () => {
        let e = $(this);
        e.addClass("youlose");
    });
});