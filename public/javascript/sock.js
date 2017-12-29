"use strict";   // https://www.w3schools.com/js/js_strict.asp

var socket;
var cols = 7;
var rows = 6;
var counter = 0;
var playtrigger = 0;
var playername = "";
var active = "";
var firstplayer = false;

$(function() {
    // add a click handler to the button
    $("#getMessageButton").click(function(event) {
        // make an ajax get request to get the message
        jsRoutes.controllers.MessageController.getMessage().ajax({
            success: function(data) {
                //console.log(data)
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
		    if (playtrigger === 1){
		        return;
		    }
		    var datastring = String(msg.data);
		    //console.log(msg.data);
		    if (datastring.startsWith("Game Over!")){
		        swal(msg.data);
		    } else if (datastring.startsWith("Draw")){
		        swal(msg.data);
		    } else if (datastring.startsWith("Spieler")){
		        active = msg.data.split(" ")[1];
		        console.log(active);
		        swal(msg.data);
		    } else if (datastring.startsWith("Warten")){
		        active = playername;
		        firstplayer = true;
		        swal(msg.data);
		    } else if (datastring.startsWith("Das Spiel")){
		        playtrigger = 1;
		        swal(msg.data);
		    } else if (datastring.startsWith("Starte")){
		        swal.close();
		        buildGame();
		        
		        if (firstplayer == true){
		            swal({
                      title: "Are you sure?",
                      text: "Sie sind an der Reihe!",
                      type: "warning",
                      showCancelButton: true,
                      confirmButtonColor: "#DD6B55",
                      confirmButtonText: "Yes, delete it!"
                    }, function(){
                      console.log("Now we run the next line of code!"); });
                } else {
                    swal({
                    title: "Are you sure?",
                    text: "Ihr Gegner ist an der Reihe!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "Yes, delete it!"
                }, function(){
                  console.log("No we run the next line of code!"); });
		        }
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
    // Check if it is the turn of the player
    if (playername != active){
        swal("Sie sind momentan nicht an der Reihe.");
        return;
    }
    //console.log(col);
    if (socket) {
        //console.log("Try to set the stone!");
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
                var owner = arrayOfArrays[row][col].owner
                var color = "leer";
                
                if (owner)
                {
                    if (owner["identification"] == 1) color = "gelb";
                    if (owner["identification"] == 2) color = "rot";
                }

                innerhtml += '<td><img id=' + s + ' class="img-responsive throwChip" src="/assets/images/' + color + '.gif"/></td>';//makeString(s, color);
            }
        }
        innerhtml += "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;
}

function buildGame(){
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

function resetPlayTrigger(){
    playtrigger === 0;
}

function sendPlayerName(name){
    if (socket) {
        if (socket.readyState === socket.OPEN) {
            socket.send("Spieler " + name);
            playername = name;
        } else {
            console.log("Error: 'socket' state:");
            console.log(socket.readyState);
        }
    } else console.log("Error: 'socket' not defined yet");
}