# Laminar Tour of Heroes

This is a proof of concept to demonstrate how 
[Laminar](https://github.com/raquo/Laminar)
can be used to implement the 
[Angular](https://angular.io/)
tutorial, the 
*[Tour of Heroes](https://angular.io/tutorial)*.

## FAQ

### Laminar?

Laminar is an HTML framework made in Scala, using 
[Scala.js](http://www.scala-js.org/),
and based on the Functional Reactive Programming (FRP)
principles.


In one word, the goal of FRP is to free you from callbacks,
"replacing" them with *variables* and *streams*.


### Proof of concept?

The goal is to demonstrate the capabilities of Laminar,
as well as a some kind of tutorial.

We are not an expert in Angular, nor in Laminar, for that
matter, so we're going to follow the tour of heroes, and
implement it as we go.

### Tour of heroes?

This is the name of the Angular tutorial. The goal is
to build a small application involving displaying
information about some heroes, modify them...


### How to use this?

As said above, we are gonna implement the tutorial as we go,
without knowing what comes ahead. In particular, this means
that there might be better ways of doing things that we do.
Furthermore, we do not "prepare the ground" for the future
when we find something new.

Every part of the Tour of Heroes will be put in a commit, so
you can follow the commit history if you like.

### Components?

Laminar builds a layer of `ReactiveElement`s on top the the
usual HTML DOM. This layer enhances the DOM with the FRP
principles, allowing for powerful, concise and robust DOM
manipulation.

Angular, for its part, is base on so-called *components*. A
Component is a kind of *super-DOM-element* with a rich inner
HTML structure, defined in some adjacent HTML file.

In here, Components are a trait `Component[T]`, where `T` is
a DOM type. As for Angular component, you can create a rich
HTML structure. The difference is that this structure is build
through Laminar, in Scala, which is more robust and more
customizable.

Components can be easily inserted within the default Laminar
reactive elements via implicit conversion.

In here, every component will live in its own Scala
package, within the `components` package.


### Try it myself?

It's quite easy. Make sure you have
[sbt](https://www.scala-sbt.org/)
installed. Within it, execute the `fastOptJS` command, and
open the `html/index.html` file in any browser.


### CSS?

We decided to use 
[ScalaTags](http://www.lihaoyi.com/scalatags/)
for doing CSS. ScalaTags allows for making type-safe
CSS style-sheet within the Scala code, and it
generates for us the desired CSS code.

In order to make component-specific style, the way we
do it is to make a `StyleSheet` or
`CascadingStyleSheet` `object` in the same package as 
the component. This `object` can for example be
package-private, so that it is only available for
its component. Then, the `cls` reactive attribute
of the elements can be set as the `name` property
of the ScalaTags CSS classes.

The generated CSS needs to be inserted in a 
`<style>` element in the head of the document. This
is done automatically for you if you extend
`ComponentStyleSheet` or
`CascadingComponentStyleSheet`.

#### Example

Here we make a simple component `Foo` that displays
a `<span>` with red background colour. This background
colour will come from a CSS class.

In `FooStyles.scala`:
```scala
package components.foo

import components.css.CascadingComponentStyleSheet
import scalatags.Text.all._

private[foo] object FooStyles extends CascadingComponentStyleSheet {
  initStyleSheet()
  val redBG = cls(backgroundColor := "red")
}
```
In `Foo.scala`:
```scala
package components.foo

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import org.scalajs.dom

final class Foo extends Component[dom.html.Span] {
  val rel: ReactiveElement[dom.html.Span] =
    span(cls := FooStyles.redBG.name, "Hello")
}
```




### Entry point?

As any Scala application, the entry point is some `main`
method of a top level `object`. In this case, you'll find
it at `src/main/scala/main/LaminarTourOfHeroes`. In here,
it mainly renders the top component, called `appComponent`.
