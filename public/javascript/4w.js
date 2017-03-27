var cols = 7;
var rows = 6;
var counter = 0;

function emptyGame() {
    var innerhtml = "";
    for (var i=0; i < rows; i++){
        innerhtml = '<tr align="center">';
        for (var j=0; j < cols; j++){
            counter++;
            var s = String(i) + "," + String(j);
            if (i === 0){
                innerhtml += makeString(j, "pfeil");
                continue;
            }

            switch(counter % 3) {
                case 0:
                    innerhtml += makeString(s, "leer");
                    continue;

                case 1:
                    innerhtml += makeString(s, "gelb");
                    continue;

                case 2:
                    innerhtml += makeString(s, "rot");
                    continue;
            }
        }
        innerhtml += "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;
}

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