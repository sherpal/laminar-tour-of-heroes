package components.messagescomponent

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import org.scalajs.dom
import services.messages.MessageService

final case class messagesComponent() extends Component[dom.html.Div] {

  val rel: ReactiveElement[dom.html.Div] = div(
    cls := Styles.topLevel.name,
    display <-- MessageService.messages.signal.map(_.nonEmpty).map(if (_) "block" else "none"),
    h2("Messages"),
    button(cls := Styles.clear.name, "Clear", onClick --> (_ => MessageService.clear())),
    children <-- MessageService.messages.signal.map(_.map(message => div(message.msg)))
  )

}
