// is called when index.html finishes loading it's body
console.log("main.js loaded!");
function start() {
    alert("Geht doch!");
}

$(document).ready(function() {

    console.log("document ready");

    $('#throwChip').click(function(event) {
        console.log("throwChip event");
        throwChip(event);
    });
});