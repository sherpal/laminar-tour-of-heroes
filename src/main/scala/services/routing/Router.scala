package services.routing

import com.raquo.airstream.eventbus.EventBus
import com.raquo.airstream.eventstream.EventStream
import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveElement
import components.Component
import components.dashboardcomponent.dashboard
import components.heroescomponent.heroesComponent
import heroes.Heroes
import org.scalajs.dom

object Router {

  private val childBus: EventBus[Component[_ <: dom.Element]] = new EventBus()

  def $child: EventStream[Component[_ <: dom.Element]] = childBus.events

  val routes: List[Route] = List(
    Route("/", () => dashboard(Heroes)),
    Route("/heroes", () => heroesComponent(Heroes))
  )

  private val routeMap: Map[String, Route] = routes.map(r => (r.path, r)).toMap

  private def goTo(path: String, needPush: Boolean): Unit = routeMap.get(path) match {
    case Some(route) =>
      if (needPush) {
        // don't do it currently because it requires a server
        // dom.window.history.pushState(null, "", path)
      }
      childBus.writer.onNext(route.component())
    case None =>
      goTo("/", needPush)
  }

  def moveTo(path: String): Unit =
    goTo(path, needPush = true)

  /**
    * Returns a nav element with a child `a` for every route.
    *
    * @param pathDisplay mapping from path to name to display
    * @return nav
    */
  def makeNav(pathDisplay: Map[String, String]): ReactiveElement[dom.html.Element] = nav(
    routes.map(_.path).map(path => a(
      marginRight := "10px",
      cursor := "pointer",
      onClick --> (_ => moveTo(path)),
      pathDisplay.getOrElse(path, path): String
    ))
  )

  def makeNav: ReactiveElement[dom.html.Element] = makeNav(Map())

  dom.window.onpopstate = (_: dom.Event) => {
    val path = dom.document.location.pathname

    goTo(path, needPush = false)
  }

}
