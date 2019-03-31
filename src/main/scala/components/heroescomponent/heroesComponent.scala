package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.{Hero, Heroes}
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {

  private val hero: Var[Hero] = Var(Hero(1, "Windstorm"))

  private val heroes: Var[List[Hero]] = Var(Heroes.heroes)

  private val $heroesLI = heroes.signal.map(_.map(h => li(span(cls := "badge", h.id.toString), h.name)))

  private val styles = HeroesComponentStyles

  /**
    * <h2>My Heroes</h2>
    * <ul class="heroes">
    *   <li>
    *     <span class="badge">{{hero.id}}</span> {{hero.name}}
    *   </li>
    * </ul>
    * <h2>{{hero.name | uppercase}} Details</h2>
    * <div><span>id: </span>{{hero.id}}</div>
    * <div><span>name: </span>{{hero.name}}</div>
    * <div>
    *   <label>name:
    *     <input [(ngModel)]="hero.name" placeholder="name"/>
    *   </label>
    * </div>
    */
  val rel: ReactiveElement[html.Div] = div(
    h2("My Heroes"),
    ul(
      cls := styles.heroes.name,
      children <-- $heroesLI
    ),
    h2(
      child <-- hero.signal.map(_.name.toUpperCase),
      " Details"
    ),
    div(span("id: "), hero.now().id.toString),
    div(span("name: "), child <-- hero.signal.map(_.name)),
    div(
      label("name:",
        input(
          placeholder := "name",
          inContext(thisInput => onInput.mapTo(hero.now().copy(name = thisInput.ref.value)) --> hero.writer)
        )
      )
    )
  )

}
