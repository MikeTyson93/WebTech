console.log("sheep.js");

var scale = 20;     // image scale in percent

var jumpHeight = 30;    // default jump height
var jumpVariance = 25;  // max amount of variance on jump height (+/-)

var speedVariance = 2;  // to individualize sheep move speed

var varianceEachStep = 0.2;     // at each move, the sheep's jump height and move speed will vary by max this value

var padding = 10;   // for initial sheep placement: spawn area leaves how much % free to each side?

var time = 0;

var maxSheep = 22;  // create new sheep unless we have maxSheep on screen

var width = 0;      // default values, overwritten on load
var height = 0;     // default values, overwritten on load

function doSheep() {

    // load page width and height from util.js
    width = getWidth();
    height = getHeight();

    // spawn sheep repeatedly
    setInterval(spawn, 1000);

    setInterval(function() {

        // get a collection of all elements classed "sheep"
        var sheeps = document.getElementsByClassName("sheep");

        // make them move!
        for(i = 0; i < sheeps.length; i++) {
            move(sheeps[i]);
        }

        // tick tock tick tock
        time++;
    }, 50);
}

function move(sheep) {
    // get current position of this sheep
    var rect = sheep.getBoundingClientRect();
    var x = rect.left;
    var y = rect.top;

    //console.log(x + ", " + y);

    if (x > width || x < 0) {    // kill those sheep that strayed off
        sheep.parentNode.removeChild(sheep);
        return;
    }

    // to make the sheep jump
    var dy = -Math.abs(Math.sin(time / 5)) * sheep.jumpHeight;

    // move the sheep
    sheep.style.left = x + sheep.speed + 'px';
    sheep.style.top =  sheep.baseY + dy + 'px';

    /*
    // make it wobble
    sheep.style.width =  scale + dy / 60 + '%';
    sheep.style.height = scale - dy / 20 + '%';
    */

    // apply variance
    sheep.jumpHeight += varianceEachStep * 2 * Math.random() - varianceEachStep;
    sheep.speed += varianceEachStep * 2 * Math.random() - varianceEachStep;
}

function spawn() {
    // abort if we're already at max
    if (document.getElementsByClassName("sheep").length > maxSheep)
        return;

    // create a new image called sheep
    var sheep = document.createElement("img");
    sheep.src = '@routes.Assets.at("javascript/util.js")';
    sheep.className = "sheep";
    sheep.style.position = "absolute";
    sheep.style.width = scale + '%';
    sheep.style.height = scale + '%';

    var w = getWidth() - sheep.style.width;
    var h = getHeight() - sheep.style.height;

    // get a random position on screen, with 10% padding
    var x = width * padding / 100 + Math.random() * width * (100 - padding) / 100;
    var y = height * padding / 100 + Math.random() * height * (100 - padding) / 100;

    // position the sheep
    sheep.style.left = x;
    sheep.baseX = x;
    sheep.style.top = y;
    sheep.baseY = y;

    // set individual jump height
    sheep.jumpHeight = jumpHeight + 2 * jumpVariance * Math.random() - jumpVariance;
    // set individual move speed
    sheep.speed = sheep.jumpHeight / 30 + 2 * speedVariance * Math.random() - speedVariance;

    // append the new sheep to the HTML page's DOM
    var body = document.getElementById("content");
    body.appendChild(sheep);

    // make a quick move to not show default position
    move(sheep);
}