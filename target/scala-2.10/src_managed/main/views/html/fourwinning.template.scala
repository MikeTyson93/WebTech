
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
object fourwinning extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""
"""),_display_(Seq[Any](/*2.2*/main("Welcome to Four Winning")/*2.33*/{_display_(Seq[Any](format.raw/*2.34*/("""
<!DOCTYPE html>
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
      </button>
      <a class="navbar-brand" href="#">Connect 4</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="http://localhost:9000/">Home</a></li>
        <li><a href="http://localhost:9000/strategie/">Strategie und Taktik</a></li>
        <li class="active"><a href="http://localhost:9000/fourwinning/">Vier gewinnt</a></li>
        <li><a href="http://localhost:9000/contact/">Kontakt</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><img id="htwg" src=""""),_display_(Seq[Any](/*54.31*/routes/*54.37*/.Assets.at("images/htwg-logo.jpg"))),format.raw/*54.71*/("""" class="logo"/></p>
    </div>
    <div class="col-sm-8 text-middle">
      <h1>Das Spiel</h1>
      <p>	"""),_display_(Seq[Any](/*58.12*/Html(game))),format.raw/*58.22*/("""
      </p>
    </div>
    <div class="col-sm-2 sidenav">
      <a style="display:block" href="http://theater.htwg-konstanz.de/2016/update-strasser-jetzt-noch-besser/">
      <div class="well">
        <p><img id="strasser" src=""""),_display_(Seq[Any](/*64.37*/routes/*64.43*/.Assets.at("images/strasser.jpg"))),format.raw/*64.76*/("""" /></p>
      </div>
      </a>
      <div class="well">
        <p>Hier könnte Ihre Werbung stehen!</p>
      </div>
    </div>
  </div>
</div>
	
</body>
""")))})))}
    }
    
    def render(game:String): play.api.templates.HtmlFormat.Appendable = apply(game)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (game) => apply(game)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 08 19:33:58 CET 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/fourwinning.scala.html
                    HASH: 11654f2ff69a8a5fa86d406a16c07b2988bb10a8
                    MATRIX: 780->1|888->15|925->18|964->49|1002->50|1593->605|1608->611|1665->646|1793->746|1822->747|1905->803|1933->804|2050->893|2079->894|2168->956|2196->957|3273->1998|3288->2004|3344->2038|3491->2149|3523->2159|3795->2395|3810->2401|3865->2434
                    LINES: 26->1|29->1|30->2|30->2|30->2|42->14|42->14|42->14|45->17|45->17|48->20|48->20|51->23|51->23|54->26|54->26|82->54|82->54|82->54|86->58|86->58|92->64|92->64|92->64
                    -- GENERATED --
                */
            