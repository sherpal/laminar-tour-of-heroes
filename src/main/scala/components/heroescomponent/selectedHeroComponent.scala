package components.heroescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import com.raquo.laminar.lifecycle.NodeDidMount
import components.Component
import heroes.Hero
import org.scalajs.dom

/**
  * This is the component that allows one to change a hero's name.
  * @param hero the [[Hero]] to be modified.
  */
private[heroescomponent] final case class selectedHeroComponent(hero: Hero) extends Component[dom.html.Div] {

  private val nameInput = input(
    placeholder := "name",
    inContext(thisInput => onInput.mapTo(thisInput.ref.value) --> hero.name.writer)
  )

  // pre-define the reactive children for nice display below
  private val uppercaseName = child <-- hero.name.signal.map(_.toUpperCase)
  private val name = child <-- hero.name.signal.map(s => s)

  val rel: ReactiveElement[dom.html.Div] = div(
    h2(uppercaseName, " Details"),
    div(span("id: "), hero.id.toString),
    div(span("name: "), name),
    div(label("name:", nameInput))
  )

  // puts the name of the hero in the input when it is created
  rel.mountEvents.filter(_ == NodeDidMount).addObserver(Observer(_ => {
    nameInput.ref.value = hero.name.now()
  }))(owner = rel)

}
