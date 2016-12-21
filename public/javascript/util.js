// http://stackoverflow.com/questions/1038727/how-to-get-browser-width-using-javascript-code
<<<<<<< HEAD
console.log("util.js");

=======
>>>>>>> 484721f5a0bc3652a9efc59faae7b8f7ece28efe
function getWidth() {
  if (self.innerWidth) {
    return self.innerWidth;
  }

  if (document.documentElement && document.documentElement.clientWidth) {
    return document.documentElement.clientWidth;
  }

  if (document.body) {
    return document.body.clientWidth;
  }
}

// http://stackoverflow.com/questions/1038727/how-to-get-browser-width-using-javascript-code
function getHeight() {
  if (self.innerHeight) {
    return self.innerHeight;
  }

  if (document.documentElement && document.documentElement.clientHeight) {
    return document.documentElement.clientHeight;
  }

  if (document.body) {
    return document.body.clientHeight;
  }
}