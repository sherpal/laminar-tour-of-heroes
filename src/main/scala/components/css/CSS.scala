package components.css

import org.scalajs.dom

import scala.scalajs.js.timers.setTimeout

private[css] object CSS {
  // call by name since the styleText is not immediately available
  def addStyle(styleText: => String): Unit = {
    setTimeout(0) {
      val style = dom.document.createElement("style").asInstanceOf[dom.html.Style]
      style.innerHTML = styleText
      dom.document.head.appendChild(style)
    }
  }
}
