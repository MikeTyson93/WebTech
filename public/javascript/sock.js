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
    var cols = 7;
    var rows = 7;
    var innerhtml = "";
    var path = '"@routes.Assets.at("/images/leer.gif")"';
    console.log(msg);
    for (var i=0; i < rows; i++){
        innerhtml = innerhtml + '<tr align="center">';
        for (var j=0; j < cols; j++){
            var s = String(i) + "," + String(j);
            if (i === 0){
                innerhtml = innerhtml + '<td><img id=' + j + ' class="img-responsive throwChip" src="/assets/images/pfeil.gif"/></td>'; 
                continue;
            }
            innerhtml = innerhtml + '<td><img id=' + s + ' class="img-responsive throwChip" src="/assets/images/leer.gif"/></td>';
        }
        innerhtml = innerhtml + "</tr>";
    }
    document.getElementById("gamefield").innerHTML = innerhtml;

}
