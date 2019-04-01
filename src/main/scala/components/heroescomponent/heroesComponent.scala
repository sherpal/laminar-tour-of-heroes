package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.Hero
import org.scalajs.dom.html
import services.HeroService

import scala.concurrent.ExecutionContext.Implicits.global

final case class heroesComponent(heroService: HeroService) extends Component[html.Div] {
  private val styles = HeroesComponentStyles

  private val selectedHero: Var[Option[Hero]] = Var(None)
  private val heroes: Var[List[Hero]] = Var(Nil)

  // getHeroes in Angular
  def fetchHeroes(): Unit = {
    for (hs <- heroService.heroes.map(_.map(_.hero))) {
      heroes.set(hs)
    }
  }

  fetchHeroes()

  private val heroesLIs = children <-- heroes.signal.map(_.map(
    h => li(
      // change the class to "selected" if this hero is clicked
      cls <-- selectedHero.signal.map(s => s.isDefined && s.get == h).map(if (_) styles.selected.name else ""),
      span(cls := styles.badge.name, h.id.toString), // id of this hero
      child <-- h.name.signal.map(s => s), // name of this hero
      onClick.mapTo(Some(h)) --> selectedHero.writer // switch selected hero on click
    )
  ))

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
