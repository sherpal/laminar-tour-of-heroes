package components.dashboardcomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import components.withheroescomponents.WithHeroes
import org.scalajs.dom
import services.HeroService

final case class dashboard(protected val heroService: HeroService) extends Component[dom.html.Div] with WithHeroes {
  import Styles._

  fetchHeroes()

  val rel: ReactiveElement[dom.html.Div] = div(
    cls := topLevel.name,
    h3("Top Heroes"),
    div(
      display := "flex",
      children <-- heroes.signal.map(_.slice(1, 5)).map(_.map(hero => {
        a(
          cls := `col-1-4`.name,
          div(
            cls := List(module.name),
            h4(child <-- hero.name.signal.map(s => s))
          )
        )
      }))
    )
  )

}
