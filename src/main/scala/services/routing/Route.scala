package services.routing

import components.Component
import org.scalajs.dom

final case class Route(path: String, component: () => Component[_ <: dom.Element])
