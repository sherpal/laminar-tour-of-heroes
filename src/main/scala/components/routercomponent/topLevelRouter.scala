package components.routercomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import org.scalajs.dom
import services.routing.Router

final case class topLevelRouter() extends Component[dom.html.Div] {

  val rel: ReactiveElement[dom.html.Div] = div(
    child <-- Router.$child.map(_.rel)
  )

}
