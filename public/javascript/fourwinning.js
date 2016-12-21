function openSocket(){
    socket = new WebSocket('http://localhost:9000/ws');
    socket.onopen = function(){
        socket.send('hello');
    }
    socket.onmessage = function(s){
        alert('got reply: ' + s)
    }
}

function throwChip(elementID)
{
    console.log("Element ID: ", elementID);
}