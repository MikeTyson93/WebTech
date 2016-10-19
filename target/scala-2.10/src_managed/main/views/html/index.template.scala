
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

    """),_display_(Seq[Any](/*5.6*/message)),format.raw/*5.13*/("""

<!DOCTYPE html>

<html>

<head>

    <title>Vier Gewinnt mit Schafen!</title>

    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" charset="utf-8" src="js/main.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/util.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/sheep.js"></script>

</head>

<body onload="start()">

<!-- BEGIN: Sticky Header -->
<div id="header_container">

    <div id="header">
        Vier Gewinnt
    </div>

</div>
<!-- END: Sticky Header -->

<!-- BEGIN: Page Content -->
<div id="container">

    <div id="content">
Das Spiel wird auf einem senkrecht stehenden hohlen Spielbrett gespielt, in das die Spieler abwechselnd ihre Spielsteine<br></br> 
fallen lassen. Das Spielbrett besteht aus sieben Spalten (senkrecht) und sechs Reihen (waagerecht). <br></br>
Jeder Spieler besitzt 21 gleichfarbige Spielsteine. Wenn ein Spieler einen Spielstein in eine Spalte fallen l�sst, <br></br>
besetzt dieser den untersten freien Platz der Spalte. Gewinner ist der Spieler, der es als erster schafft, <br></br>
vier oder mehr seiner Spielsteine waagerecht, senkrecht oder diagonal in eine Linie zu bringen. <br></br>
Das Spiel endet unentschieden, wenn das Spielbrett komplett gef�llt ist, ohne dass ein Spieler eine Viererlinie gebildet hat.
    </div>

</div>
<!-- END: Page Content -->

<!-- BEGIN: Sticky Footer -->
<div id="footer_container">

    <div id="footer">

        <a href="http://localhost:9000/fourwinning/"> Link zum Spiel</a>

    </div>

</div>

<!-- END: Sticky Footer -->

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
                    DATE: Wed Oct 19 14:47:38 CEST 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/index.scala.html
                    HASH: 6d80dc6004b8e0802353429e10496c99a08cf3cc
                    MATRIX: 774->1|885->18|924->23|963->54|1002->56|1045->65|1073->72
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5
                    -- GENERATED --
                */
            