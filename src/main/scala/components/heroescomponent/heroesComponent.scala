package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.{Hero, Heroes}
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {
  private val styles = HeroesComponentStyles

  private val selectedHero: Var[Option[Hero]] = Var(None)
  private val heroes: List[Hero] = Heroes.heroes.map(_.hero)

  private val heroesLIs = heroes.map(
    h => li(
      // change the class to "selected" if this hero is clicked
      cls <-- selectedHero.signal.map(s => s.isDefined && s.get == h).map(if (_) styles.selected.name else ""),
      span(cls := styles.badge.name, h.id.toString), // id of this hero
      child <-- h.name.signal.map(s => s), // name of this hero
      onClick.mapTo(Some(h)) --> selectedHero.writer // switch selected hero on click
    )
  )

  val rel: ReactiveElement[html.Div] = div(
    h2("My Heroes"),
    // list of all heroes
    ul(cls := styles.heroes.name, heroesLIs),
    /** change the [[selectedHeroComponent]] when a Hero in the list is clicked */
    child <-- selectedHero.signal.map({
      case None       => ""
      case Some(hero) => selectedHeroComponent(hero)
    })
  )
}
