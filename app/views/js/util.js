// http://stackoverflow.com/questions/1038727/how-to-get-browser-width-using-javascript-code
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