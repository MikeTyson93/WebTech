var scale = 20;     // in percent

var jumpHeight = 10;
var speed = 3;

var time = 0;

var maxSheep = 22;

function start() {

    setInterval(spawn, 1000);

    setInterval(function() {

        var sheeps = document.getElementsByClassName("sheep");

        for(i = 0; i < sheeps.length; i++) {
            move(sheeps[i]);
        }

        time++;
    }, 50);
}

function move(sheep) {
    var dy = -Math.abs(Math.sin(time / 5)) * jumpHeight;

    var rect = sheep.getBoundingClientRect();

    var x = rect.left;
    var y = rect.top;

    sheep.style.left = x + speed + 'px';
    sheep.style.top =  sheep.baseY + dy + 'px';

    /*
    sheep.style.width =  scale + dy / 60 + '%';
    sheep.style.height = scale - dy / 20 + '%';
    */
}

function spawn() {
    if (document.getElementsByClassName("sheep").length > maxSheep)
        return;

    var img = document.createElement("img");
    img.src = "https://openclipart.org/download/1744/TheStructorr-sheep.svg";
    img.className = "sheep";
    img.style.position = "absolute";
    img.style.width = scale + '%';
    img.style.height = scale + '%';

    var x = 100 + Math.random() * 1800;
    var y =  80 + Math.random() * 800;

    img.style.left = x;
    img.baseX = x;
    img.style.top = y;
    img.baseY = y;

    var body = document.getElementById("content");
    body.appendChild(img);

    move(img);
}