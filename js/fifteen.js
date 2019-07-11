"use strict";
$( function() {
    init();
    $("#puzzlearea div").click(clickPuzzle);
    $("#shufflebutton").click(shuffleAlg);
});
function shuffleAlg() {
    const moveTimes = Math.floor(Math.random() * 100) + 6;
    for(let i = 0; i < moveTimes; i++) {
        const pList = $("#puzzlearea .movablepiece");
        const randomIndex = Math.floor(Math.random() * pList.length);
        const p = $("#puzzlearea .movablepiece")[randomIndex];
        p.click();
    }
}
function clickPuzzle(evt) {
    // console.log(evt);
    // let e = $(evt.target);
    let e = $(this);
    let x = parseInt(e.attr("x"));
    let y = parseInt(e.attr("y"));
    let neighborTopPos = (y >= 100) ? {x, y: y-100} : null;
    let neighborLeftPos = (x >= 100) ? {x: x -100, y} : null;
    let neighborBottomPos = (y <= 200) ? {x, y: y+100} : null;
    let neighborRightPos = (x <= 200) ? {x: x+100, y} : null;
    switch(e.attr("movable")) {
        case "left":
            x -= 100; 
            setPosition(e, x, y);
            updateNeighbors(neighborTopPos, neighborBottomPos, null, neighborRightPos);
            e.attr("movable", "right");
            e.addClass("movablepiece");
            break;
        case "up":
            y -= 100;
            setPosition(e, x, y);
            updateNeighbors(null, neighborBottomPos, neighborLeftPos, neighborRightPos);
            e.attr("movable", "down");
            e.addClass("movablepiece");
            break;
        case "right":
            x += 100;
            setPosition(e, x, y);
            updateNeighbors(neighborTopPos, neighborBottomPos, neighborLeftPos, null);
            e.attr("movable", "left");
            e.addClass("movablepiece");
            break;
        case "down":
            y += 100;
            setPosition(e, x, y);
            updateNeighbors(neighborTopPos, null, neighborLeftPos, neighborRightPos);
            e.attr("movable", "up");
            e.addClass("movablepiece");
            break;
        case "none":
            console.log("cannot move!");
            break;
        default:
            console.log("movable does not have value");
    }
    // console.log(x + " " + y);
}
function updateNeighbors(neighborTopPos, neighborBottomPos, neighborLeftPos, neighborRightPos) {
    $("#puzzlearea div").attr("movable", "none").removeClass("movablepiece");
    if (neighborTopPos) {
        let top = $("#puzzlearea div[x=" + neighborTopPos.x + "][y="+ neighborTopPos.y + "]");
        top.attr("movable", "down");
        top.addClass("movablepiece");
        // console.log(top);
    }
    if (neighborBottomPos) {
        let bottom = $("#puzzlearea div[x=" + neighborBottomPos.x + "][y="+ neighborBottomPos.y + "]");
        bottom.attr("movable", "up");
        bottom.addClass("movablepiece");
    }
    if (neighborLeftPos) {
        let left = $("#puzzlearea div[x=" + neighborLeftPos.x + "][y="+ neighborLeftPos.y + "]");
        left.attr("movable", "right");
        left.addClass("movablepiece");
    }
    if (neighborRightPos) {
        let right = $("#puzzlearea div[x=" + neighborRightPos.x + "][y="+ neighborRightPos.y + "]");
        right.attr("movable", "left");
        right.addClass("movablepiece");
    }
}
function init() {
    let divs = $("#puzzlearea div");
      
    // initialize each piece
    for (var i=0; i< divs.length; i++) {
        let div = divs[i];
        
        // calculate x and y for this piece
        let x = ((i % 4) * 100) ;
        let y = (Math.floor(i / 4) * 100) ;
        $(div).addClass("puzzlepiece");
        setPosition(div, x, y, true);
        $(div).attr("movable", (i == 14) ? "right" : (i ==11) ? "down" : "none");
    }        
    $("#puzzlearea div[movable!='none']").addClass("movablepiece");
}
function setPosition(div, x, y, newPiece=false) {    
    if (newPiece) {
        $(div).css({
            "backgroundPosition": -x + 'px ' + (-y) + 'px'
        });
    }
    $(div).css({
        "left": x + 'px',
        "top": y + 'px'
    });
    // store x and y for later
    $(div).attr("x", x);
    $(div).attr("y", y);
}