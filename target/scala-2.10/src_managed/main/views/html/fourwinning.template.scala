package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object fourwinning_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class fourwinning extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(game: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.16*/("""

"""),_display_(/*3.2*/main("Welcome to Fourwinning")/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""

    """),format.raw/*5.5*/("""<code> """),_display_(/*5.13*/Html(game)),format.raw/*5.23*/(""" """),format.raw/*5.24*/("""</code>

""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(game:String): play.twirl.api.HtmlFormat.Appendable = apply(game)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (game) => apply(game)

  def ref: this.type = this

}


}

/**/
object fourwinning extends fourwinning_Scope0.fourwinning
                /*
                    -- GENERATED --
                    DATE: Fri Oct 14 13:34:28 CEST 2016
                    SOURCE: C:/Users/Michi/Vier_gewinnt/app/views/fourwinning.scala.html
                    HASH: 69881cdbb72672ac524c1277acd0d545d2bf2d45
                    MATRIX: 774->1|885->18|922->21|961->52|1000->54|1041->61|1069->68
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5
                    -- GENERATED --
                */
          
            