"use strict";
$(function () {
    $(document).keypress(cheer);
});

function cheer(e) {
    $("<li>")
      .text(String.fromCharCode(e.which).toUpperCase() + "!")
      .appendTo($("#cheers"));
    setTimeout(removeCheer, 2000);
  }
  
  function removeCheer() {
    $("ul li").first().remove();
  }