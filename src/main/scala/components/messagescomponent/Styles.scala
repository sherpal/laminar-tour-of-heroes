package components.messagescomponent

import components.css.CascadingComponentStyleSheet
import scalatags.Text.all._

private[messagescomponent] object Styles extends CascadingComponentStyleSheet {
  initStyleSheet()

  val clear = cls(
    fontFamily := "Arial",
    backgroundColor := "#eee",
    border := "none",
    padding := "5px 10px",
    borderRadius := "4px",
    cursor := "pointer",
    cursor := "hand",
    color := "#888",
    marginBottom := "12px"
  )

  val topLevel = cls(
    margin := "2em",
    color := "crimson",
    fontFamily := "Cambria, Georgia",

    h2(
      color := "red",
      fontFamily := "Arial, Helvetica, sans-serif",
      fontWeight := "lighter"
    ),

    button.hover(
      backgroundColor := "#cfd8dc"
    ),

    button.disabled(
      backgroundColor := "#eee",
      color := "#aaa",
      cursor := "auto"
    )
  )
}
