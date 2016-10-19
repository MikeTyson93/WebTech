
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
	<code>"""),_display_(Seq[Any](/*3.9*/Html(game))),format.raw/*3.19*/("""</code>
""")))})))}
    }
    
    def render(game:String): play.api.templates.HtmlFormat.Appendable = apply(game)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (game) => apply(game)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 19 10:36:18 CEST 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/fourwinning.scala.html
                    HASH: 245b1a79279b519ce0bedadc67925f24a1b1d968
                    MATRIX: 780->1|888->15|925->18|964->49|1002->50|1046->60|1077->70
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3
                    -- GENERATED --
                */
            