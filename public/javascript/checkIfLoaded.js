// in this file, we check if certain modules (jQuery, bootstrap) have been loaded successfully.
// source: http://stackoverflow.com/questions/13933000/how-to-check-if-twitter-bootstrap-is-loaded

var jqLoaded = (jQuery != 'undefined');
var bsLoaded = ($.fn.tooltip != 'undefined');

var jqString = jqLoaded ? " (version " + jQuery.fn.jquery + ") " : " not";
var bsString = bsLoaded ? " (version " + $.fn.tooltip.Constructor.VERSION + ")" : " not";

console.log("jQuery" + jqString + " loaded.");
console.log("Bootstrap" + bsString + " loaded.");