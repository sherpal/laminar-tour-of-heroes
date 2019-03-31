package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.{Hero, Heroes}
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {

  private val selectedHero: Var[Hero] = Var(Hero(1, "Windstorm"))

  private val heroes: Var[List[Hero]] = Var(Heroes.heroes)

  private val $heroesLI = heroes.signal.map(
    _.map(h => li(
      span(cls := "badge", h.id.toString), h.name,
      onClick --> (_ => selectedHero.set(h))
    ))
  )

  private val styles = HeroesComponentStyles

  val rel: ReactiveElement[html.Div] = div(
    h2("My Heroes"),
    ul(
      cls := styles.heroes.name,
      children <-- $heroesLI
    ),
    h2(
      child <-- selectedHero.signal.map(_.name.toUpperCase),
      " Details"
    ),
    div(span("id: "), child <-- selectedHero.signal.map(_.id.toString)),
    div(span("name: "), child <-- selectedHero.signal.map(_.name)),
    div(
      label("name:",
        input(
          placeholder := "name",
          inContext(thisInput => onInput.mapTo(selectedHero.now().copy(name = thisInput.ref.value)) --> selectedHero.writer)
        )
      )
    )
  )

}
