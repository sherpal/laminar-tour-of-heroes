package main

import com.raquo.laminar.api.L.render
import components.appcomponent.appComponent
import org.scalajs.dom

object LaminarTourOfHeroes {

  def main(args: Array[String]): Unit = {
    println("This is an implementation of the Angular " +
      "Tour of Heroes tutorial using Laminar.")
  }

  render(dom.document.getElementById("app"), appComponent())

}
