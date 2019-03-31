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


### Try it myself?

It's quite easy. Make sure you have
[sbt](https://www.scala-sbt.org/)
installed. Within it, execute the `fastOptJS` command, and
open the `html/index.html` file in any browser.


### Entry point?

As any Scala application, the entry point is some `main`
method of a top level `object`. In this case, you'll find
it at `src/main/scala/main/LaminarTourOfHeroes`. In here,
it mainly renders the top component, called `appComponent`.
