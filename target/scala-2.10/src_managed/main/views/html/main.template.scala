
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
    <title>"""),_display_(Seq[Any](/*6.13*/title)),format.raw/*6.18*/("""</title>
    <link rel='shortcut icon' type='image/png' href='"""),_display_(Seq[Any](/*7.55*/routes/*7.61*/.Assets.at("images/favicon.png"))),format.raw/*7.93*/("""'>
    <link rel='stylesheet' href='"""),_display_(Seq[Any](/*8.35*/routes/*8.41*/.WebJarAssets.at(WebJarAssets.locate("bootstrap.min.css")))),format.raw/*8.99*/("""'>
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*9.42*/routes/*9.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js")))),format.raw/*9.102*/("""'></script>
    <style>
    body """),format.raw/*11.10*/("""{"""),format.raw/*11.11*/("""
        margin-top: 50px;
    """),format.raw/*13.5*/("""}"""),format.raw/*13.6*/("""
    </style>
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a id="titleLink" class="brand" href="/">"""),_display_(Seq[Any](/*20.59*/title)),format.raw/*20.64*/("""</a>
            </div>
        </div>
    </div>
    <div class="container">
        """),_display_(Seq[Any](/*25.10*/content)),format.raw/*25.17*/("""
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
                    DATE: Fri Oct 14 11:25:59 CEST 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/main.scala.html
                    HASH: 400104062965fd61b1ab91eb54b0a3cfcc593236
                    MATRIX: 778->1|902->31|981->75|1007->80|1105->143|1119->149|1172->181|1244->218|1258->224|1337->282|1416->326|1430->332|1506->386|1567->419|1596->420|1654->451|1682->452|1924->658|1951->663|2074->750|2103->757
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|41->13|41->13|48->20|48->20|53->25|53->25
                    -- GENERATED --
                */
            