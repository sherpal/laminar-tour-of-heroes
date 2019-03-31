package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.Hero
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {

  val hero: Hero = new Hero(1, "Windstorm")

  /**
    * <h2>{{hero.name}} Details</h2>
    * <div><span>id: </span>{{hero.id}}</div>
    * <div><span>name: </span>{{hero.name}}</div>
    */

  val rel: ReactiveElement[html.Div] = div(
    h2(s"${hero.name} Details"),
    div(span("id: "), hero.id.toString),
    div(span("name: "), hero.name)
  )

}
