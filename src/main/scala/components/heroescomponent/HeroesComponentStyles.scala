package components.heroescomponent

import components.css.CascadingComponentStyleSheet
import scalatags.Text.all._

private[heroescomponent] object HeroesComponentStyles extends CascadingComponentStyleSheet {
  initStyleSheet()

  val selected = cls(
    backgroundColor := "#CFD8DC !important",
    color := "white"
  )

  val text = cls()

  val badge = cls()

  val heroes = cls(
    margin := "0 0 2em 0",
    listStyleType := "none",
    padding := "0",
    width := "15em",
    li(
      cursor := "pointer",
      position := "relative",
      left := "0",
      backgroundColor := "#EEE",
      margin := ".5em",
      padding := ".3em 0",
      height := "1.6em",
      borderRadius := "4px",
      selected.hover(
        backgroundColor := "#BBD8DC !important",
        color := "white"
      )
    ),
    li.hover(
      color := "#607D8B",
      backgroundColor := "#DDD",
      left := ".1em"
    ),
    text(
      position := "relative",
      top := "-3px"
    ),
    badge(
      display := "inline-block",
      fontSize := "small",
      color := "white",
      padding := "0.8em 0.7em 0 0.7em",
      backgroundColor := "#607D8B",
      lineHeight := "1em",
      position := "relative",
      left := "-1px",
      top := "-4px",
      height := "1.8em",
      marginRight := ".8em",
      borderRadius := "4px 0 0 4px"
    )
  )

}
