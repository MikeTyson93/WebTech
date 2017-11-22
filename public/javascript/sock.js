"use strict";   // https://www.w3schools.com/js/js_strict.asp

var socket;
var cols = 7;
var rows = 6;
var counter = 0;

$(function() {
    // add a click handler to the button
    $("#getMessageButton").click(function(event) {
        // make an ajax get request to get the message
        jsRoutes.controllers.MessageController.getMessage().ajax({
            success: function(data) {
                console.log(data)
                $(".well").append($("<h1>").text(data.value))
            }
        })
    })
})

$(function() {  

	connect();  

	function connect(){       
		socket = new WebSocket("ws://localhost:9000/socket");

		message('Socket Status: '+socket.readyState + ' (ready)');  

		socket.onopen = function(){  message('Socket Status: '+socket.readyState+' (open)');  }  ;

		socket.onmessage = function(msg){
		    var datastring = String(msg.data);
		    console.log(msg.data);
		    if (datastring.startsWith("Game Over!")){
		        alert(msg.data);
		    } else if (datastring.startsWith("Draw")){
		        alert(msg.data);
		    } else if (datastring.startsWith("Spieler")){
		        alert(msg.data);
		    } else {
    		var gamefield = JSON.parse(msg.data);
	    	buildNewGameField(gamefield);
		    }
		        
		};
		socket.onclose = function(){ message('Socket Status: '+socket.readyState+' (Closed)');  }  ;          

		

		function message(msg){  
			$('#wsLog').append('<p>' + msg +'</p>');  
		}  


	}//End connect  
});

function send(col){
    //console.log(col);
    if (socket) {
        if (socket.readyState === socket.OPEN) {
            socket.send(col);
        } else {
            console.log("Error: 'socket' state:");
            console.log(socket.readyState);
        }
    } else console.log("Error: 'socket' not defined yet");
}

function buildNewGameField(msg){
    var rows = 6;
    var data = msg.meta;
    var columns = data.columns;
    var arrayOfArrays = data.feld;
    var innerhtml = "";
    for (var row = -1; row < rows; row++){
        innerhtml += '<tr align="center">';
        for (var col = 0; col < columns; col++){
            var s = String(row) + "," + String(col);
            if (row == -1) {
                innerhtml += '<td><img id=' + col + ' class="img-responsive throwChip" onclick="send(id)" src="/assets/images/pfeil.gif"/></td>'; //makeString(col, "pfeil"); //
            } else {

                //console.log("arrayOfArrays[%d][%d]: ", row, col);
                //console.log(arrayOfArrays[row][col]);

                var owner = arrayOfArrays[row][col].owner
                var color = "leer";

                if (owner)
                {
                    // TODO: generify
                    if (owner.name === "Michael") color = "gelb";
                    if (owner.name === "Stephan") color = "rot";
                }

                innerhtml += '<td><img id=' + s + ' class="img-responsive throwChip" src="/assets/images/' + color + '.gif"/></td>';//makeString(s, color);
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
