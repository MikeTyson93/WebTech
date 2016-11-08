
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Four Winning")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Vier Gewinnt</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" 
                       href='"""),_display_(Seq[Any](/*14.31*/routes/*14.37*/.Assets.at("stylesheets/style.css"))),format.raw/*14.72*/("""'>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar """),format.raw/*17.13*/("""{"""),format.raw/*17.14*/("""
      margin-bottom: 0;
      border-radius: 0;
    """),format.raw/*20.5*/("""}"""),format.raw/*20.6*/("""
    
    /* Add a gray background color and some padding to the footer */
    footer """),format.raw/*23.12*/("""{"""),format.raw/*23.13*/("""
      background-color: #f2f2f2;
      padding: 25px;
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""
  </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Connect 4</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="http://localhost:9000/strategie/">Strategie und Taktik</a></li>
        <li><a href="http://localhost:9000/fourwinning/">Vier gewinnt</a></li>
        <li><a href="http://localhost:9000/contact/">Kontakt</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><img id="htwg" src=""""),_display_(Seq[Any](/*56.31*/routes/*56.37*/.Assets.at("images/htwg-logo.jpg"))),format.raw/*56.71*/("""" class="logo"/></p>
    </div>
    <div class="col-sm-8 text-left">
      <h1>Vier Gewinnt</h1>
      <p>Spielen Sie jetzt den absoluten Klassiker unter den Denkern.<br></br> 
      </p>
      <hr>
      <h3>Beschreibung</h3>
      <p>
            Das klassische Brettspiel wird auf einem senkrecht stehenden hohlen Spielbrett gespielt, in das die Spieler abwechselnd ihre Spielsteine fallen lassen. 
            Das Spielbrett besteht Spalten (Senkrecht) und Reihen (Waagrecht). 
            Wenn ein Spieler einen Spielstein in eine Spalte fallen lässt, besetzt dieser den untersten freien Platz der Spalte.
            Gewinner ist der Spieler, der es als erster schafft, vier seiner Spielsteine waagerecht, senkrecht oder diagonal in eine Linie zu bringen. 
            Das Spiel endet unentschieden, wenn das Spielbrett komplett gefüllt ist, ohne dass ein Spieler gewonnen hat.
            <br></br>Quelle: <a href="http://de.wikipedia.org/wiki/Vier_Gewinnt" >Wikipedia</a>
                
      </p>
        <h3>Vorsicht, hoher Frustrationsfaktor!</h3>
        <div class="center">
        <p>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/Mr-eJ_x_MW0" frameborder="0" allowfullscreen></iframe><br></br>
        </p>
        </div>
    </div>
    <div class="col-sm-2 sidenav">
      <a style="display:block" href="http://theater.htwg-konstanz.de/2016/update-strasser-jetzt-noch-besser/">
      <div class="well">
        <p><img id="strasser" src=""""),_display_(Seq[Any](/*83.37*/routes/*83.43*/.Assets.at("images/strasser.jpg"))),format.raw/*83.76*/("""" /></p>
      </div>
      </a>
      <div class="well">
        <p>Hier könnte Ihre Werbung stehen!</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>

""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 08 19:30:14 CET 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/index.scala.html
                    HASH: aa51b89cbde84923fead7926ee5a4333b8676d09
                    MATRIX: 774->1|885->18|924->23|963->54|1002->56|1576->594|1591->600|1648->635|1776->735|1805->736|1888->792|1916->793|2033->882|2062->883|2151->945|2179->946|3277->2008|3292->2014|3348->2048|4903->3567|4918->3573|4973->3606
                    LINES: 26->1|29->1|31->3|31->3|31->3|42->14|42->14|42->14|45->17|45->17|48->20|48->20|51->23|51->23|54->26|54->26|84->56|84->56|84->56|111->83|111->83|111->83
                    -- GENERATED --
                */
            