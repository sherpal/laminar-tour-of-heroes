package components.dashboardcomponent

import components.css.CascadingComponentStyleSheet
import scalatags.Text.all._

private[dashboardcomponent] object Styles extends CascadingComponentStyleSheet {
  initStyleSheet()

  val `col-1-4` = cls(
    width := "25%"
  )

  val module = cls(
    padding := "20px",
    textAlign := "center",
    color := "#eee",
    maxHeight := "120px",
    minWidth := "120px",
    backgroundColor := "#607d8b",
    borderRadius := "2px",
    &.hover(
      backgroundColor := "#eee",
      cursor := "pointer",
      color := "#607d8b"
    )
  )

  val topLevel = cls(
    `col-1-4`(),
    module(),
    a(
      textDecoration := "none"
    ),
    h3(
      textAlign := "center",
      marginBottom := "0px"
    ),
    h4(
      position := "relative"
    )
  )

}
