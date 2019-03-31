package components.css

import scalatags.stylesheet.CascadingStyleSheet

trait CascadingComponentStyleSheet extends CascadingStyleSheet {
  CSS.addStyle(this.styleSheetText)
}
