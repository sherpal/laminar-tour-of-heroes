package components.appcomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import components.messagescomponent.messagesComponent
import components.routercomponent.topLevelRouter
import org.scalajs.dom.html
import services.routing.Router

/**
  * Entry point of the Tour of Heroes application.
  * It is rendered in the dom in the main.LaminarTourOfHeroes$main method.
  */
final case class appComponent() extends Component[html.Div] {

  val title: String = "Tour of Heroes"

  val rel: ReactiveElement[html.Div] = div(
    h1(title),
    Router.makeNav(
      Map(
        "/" -> "Dashboard",
        "/heroes" -> "Heroes"
      )
    ),
    topLevelRouter(),
    messagesComponent()
  )

}
