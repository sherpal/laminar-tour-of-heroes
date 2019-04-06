package components.withheroescomponents

import com.raquo.airstream.signal.Var
import heroes.Hero
import services.HeroService

import scala.concurrent.ExecutionContext.Implicits.global

trait WithHeroes {

  protected val heroService: HeroService

  protected val heroes: Var[List[Hero]] = Var(Nil)

  // getHeroes in Angular
  def fetchHeroes(): Unit = {
    for (hs <- heroService.heroes.map(_.map(_.hero))) {
      heroes.set(hs)
    }
  }

}
