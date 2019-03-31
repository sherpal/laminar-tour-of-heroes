package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {

  val hero: String = "Windstorm"

  val rel: ReactiveElement[html.Div] = div(
    hero
  )

}
