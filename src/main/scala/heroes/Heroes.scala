package heroes

import services.HeroService
import services.messages.{Message, MessageService}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Heroes extends HeroService {

  /**
    * { id: 11, name: 'Mr. Nice' },
    * { id: 12, name: 'Narco' },
    * { id: 13, name: 'Bombasto' },
    * { id: 14, name: 'Celeritas' },
    * { id: 15, name: 'Magneta' },
    * { id: 16, name: 'RubberMan' },
    * { id: 17, name: 'Dynama' },
    * { id: 18, name: 'Dr IQ' },
    * { id: 19, name: 'Magma' },
    * { id: 20, name: 'Tornado' }
    */
  def heroes: Future[List[IHero]] = {
    MessageService.addMessage(Message("HeroService: fetched heroes"))
    Future(List(
      IHero(11, "Mr. Nice"),
      IHero(12, "Narco"),
      IHero(13, "Bombasto"),
      IHero(14, "Celeritas"),
      IHero(15, "Magneta"),
      IHero(16, "RubberMan"),
      IHero(17, "Dynama"),
      IHero(18, "Dr IQ"),
      IHero(19, "Magma"),
      IHero(20, "Tornado")
    ))
  }

}
