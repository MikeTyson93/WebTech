
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>
<html>
<head>
    <link rel='shortcut icon' type='image/png' href='"""),_display_(Seq[Any](/*6.55*/routes/*6.61*/.Assets.at("images/favicon.png"))),format.raw/*6.93*/("""'>
    <link rel='stylesheet' href='"""),_display_(Seq[Any](/*7.35*/routes/*7.41*/.WebJarAssets.at(WebJarAssets.locate("bootstrap.min.css")))),format.raw/*7.99*/("""'>
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*8.42*/routes/*8.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js")))),format.raw/*8.102*/("""'></script>
    <style>
    body """),format.raw/*10.10*/("""{"""),format.raw/*10.11*/("""
        margin-top: 50px;
   """),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""" 
    </style>
</head>
<body>
<div class="container">
    """),_display_(Seq[Any](/*17.6*/content)),format.raw/*17.13*/("""
</div>
</body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 08 18:30:49 CET 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/main.scala.html
                    HASH: 8bfb571843ce1ae88d88b5e4b83b6046a4ae582d
                    MATRIX: 778->1|902->31|1028->122|1042->128|1095->160|1168->198|1182->204|1261->262|1341->307|1355->313|1431->367|1494->402|1523->403|1582->435|1610->436|1709->500|1738->507
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|38->10|38->10|40->12|40->12|45->17|45->17
                    -- GENERATED --
                */
            