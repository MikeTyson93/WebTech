var cols = 7;
var rows = 7;
var counter = 0;

function emptyGame() {
    var innerhtml = "";
    for (var i=0; i < rows; i++){
        innerhtml = '<tr align="center">';
        for (var j=0; j < cols; j++){
            counter++;
            var s = String(i) + "," + String(j);
            if (i == 0){
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
}

function buildGame(){
    document.getElementById('toggle').style.visibility = 'hidden';
    var innerhtml = "";
    for (var i=0; i < rows; i++){
        innerhtml += '<tr align="center">';
        for (var j=0; j < cols; j++){
            var s = String(i) + "," + String(j);
            if (i == 0){
                innerhtml += makeString(j, "pfeil");
                continue;
            }
            innerhtml += makeString(s, "leer");
        }
        innerhtml += "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;
}

function makeString(index, target) {
    return '<td><img id=' + index + ' class="img-responsive throwChip" src="@routes.Assets.at("images/' + target + '.gif")"/></td>';
}