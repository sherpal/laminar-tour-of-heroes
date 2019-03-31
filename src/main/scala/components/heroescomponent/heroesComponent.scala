package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import heroes.Hero
import org.scalajs.dom.html

final case class heroesComponent() extends Component[html.Div] {

  private val hero: Var[Hero] = Var(Hero(1, "Windstorm"))

  /**
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
