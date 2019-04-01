package services

import heroes.IHero

import scala.concurrent.Future

trait HeroService {

  def heroes: Future[List[IHero]]

}
