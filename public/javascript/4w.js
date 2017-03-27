var cols = 7;
var rows = 6;
var counter = 0;

function buildGame(){
    document.getElementById('toggle').style.visibility = 'hidden';
    var innerhtml = "";
    for (var i=-1; i < rows; i++){
        innerhtml += '<tr align="center">';
        for (var j=0; j < cols; j++){
            var s = String(i) + "," + String(j);
            if (i === -1){
                innerhtml += '<td><img id=' + j + ' class="img-responsive throwChip" onclick="send(id)" src="/assets/images/pfeil.gif"/></td>';
                
            } else {
                innerhtml += '<td><img id=' + s + ' class="img-responsive throwChip" src="/assets/images/leer.gif"/></td>';
            }
        }
        innerhtml += "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;
}

function makeString(index, target) {
    //var buildstring = "@routes.Assets.at("images/rot.gif")";
    //return '<td><img id=' + index + ' class="img-responsive throwChip" src="' + buildstring + '"/></td>';
}