
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
    
    <a href="/fourwinning"> play Four winning </a>

""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 14 13:34:28 CEST 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/index.scala.html
                    HASH: 69881cdbb72672ac524c1277acd0d545d2bf2d45
                    MATRIX: 774->1|885->18|922->21|961->52|1000->54|1041->61|1069->68
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5
                    -- GENERATED --
                */
            