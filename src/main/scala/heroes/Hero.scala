package heroes

import com.raquo.airstream.signal.Var

final class Hero(val id: Int, initialName: String) {
  val name: Var[String] = Var(initialName)
}
