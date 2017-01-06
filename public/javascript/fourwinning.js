function openSocket(){
    var socket = new WebSocket("ws://localhost:9000/socket");;
    socket.onopen = function(){  message('Socket Status: '+socket.readyState+' (open)');  }  ;
    
    socket.onclose = function(){ message('Socket Status: '+socket.readyState+' (Closed)');  }  ;    
    
    function send(col){ 
			socket.send(col);
		}  
		
    socket.onmessage = function(s){
        alert('got reply: ' + s)
    }
}

function throwChip(elementID)
{
    console.log("Element ID: ", elementID);
}

function throwChip(event) {
    console.log("click detected!");
    console.log("event info: ", event);
}


$('#throwChip').click(function(event) {
    console.log("click detected!");
    console.log("event info: ", event);
});