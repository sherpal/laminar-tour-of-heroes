package components

import com.raquo.laminar.nodes.ReactiveElement
import org.scalajs.dom

import scala.language.implicitConversions

trait Component[T <: dom.Element] {
  val rel: ReactiveElement[T]
  def ref: T = rel.ref
}

object Component {
  implicit def componentIsReactiveElement[T <: dom.Element](component: Component[T]): ReactiveElement[T] = component.rel
}