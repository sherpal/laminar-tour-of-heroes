package components.css

import scalatags.stylesheet.StyleSheet

trait ComponentStyleSheet extends StyleSheet {
  CSS.addStyle(this.styleSheetText)
}
