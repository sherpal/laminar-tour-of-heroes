package components.appcomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import components.heroescomponent.heroesComponent
import components.messagescomponent.messagesComponent
import heroes.Heroes
import org.scalajs.dom.html

/**
  * Entry point of the Tour of Heroes application.
  * It is rendered in the dom in the main.LaminarTourOfHeroes$main method.
  */
final case class appComponent() extends Component[html.Div] {

  val title: String = "Tour of Heroes"

  val rel: ReactiveElement[html.Div] = div(
    h1(title),
    heroesComponent(Heroes),
    messagesComponent()
  )

}
