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
		var socket = new WebSocket("ws://localhost:9000/socket");

		message('Socket Status: '+socket.readyState + ' (ready)');  

		socket.onopen = function(){  message('Socket Status: '+socket.readyState+' (open)');  }  ;

		socket.onmessage = function(msg){
			var msg = JSON.parse(msg.data);
			buildNewGameField(msg);
		} ;
		socket.onclose = function(){ message('Socket Status: '+socket.readyState+' (Closed)');  }  ;          

		function send(){  
			var grid = "";
			socket.send(grid);  
			message('Sent grid '); 
		}  

		function message(msg){  
			$('#wsLog').append('<p>' + msg +'</p>');  
		}  


	}//End connect  
});

function buildNewGameField(msg){
    var rows = 7;

    var data = msg.meta;
    var columns = data.columns;
    var arrayOfArrays = data.feld;

    var innerhtml = "";
    for (var row = 0; row < rows; row++){
        innerhtml += '<tr align="center">';
        for (var col = 0; col < columns; col++){
            var s = String(row) + "," + String(col);
            if (row == 0) {
                innerhtml += makeString(col, "pfeil"); // '<td><img id=' + col + ' class="img-responsive throwChip" src="/assets/images/pfeil.gif"/></td>';
            } else {
                var owner = arrayOfArrays[row][col].owner
                var color = "leer";

                if (owner)
                {
                    // TODO: generify
                    if (owner.name === "Michael") color = "gelb";
                    if (owner.name === "Stephan") color = "rot";
                }

                innerhtml += makeString(s, color); //'<td><img id=' + s + ' class="img-responsive throwChip" src="/assets/images/' + color + '.gif"/></td>';
            }
        }
        innerhtml += "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;
}
