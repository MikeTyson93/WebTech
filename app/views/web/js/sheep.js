function start() {

    var x = 700;
    var y = 150;

    var scale = 20;     // in percent
    var jumpHeight = 50;

    setInterval(spawn, 1000);

    setInterval(function() {
        var sheeps = document.getElementsByClassName(sheep);

        console.log(sheeps);

        return;
        var sheep = document.getElementById("sheep");

        var dy = -Math.abs(Math.sin(x / 20)) * jumpHeight;

        sheep.style.position = "absolute";
        sheep.style.left = x+'px';
        sheep.style.top = y+dy+'px';
        sheep.style.width = scale+dy/60+'%';
        sheep.style.height = scale+dy/20+'%';

        x--;
    }, 2220);
    //document.getElementsByClassName(klass)
}

function spawn() {
    var img = document.createElement("img");
    img.src = "https://openclipart.org/download/1744/TheStructorr-sheep.svg";

    var body = document.getElementById("content");
    body.appendChild(img);
}