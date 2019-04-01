package heroes

final case class IHero(id: Int, name: String) {
  def hero: Hero = new Hero(id, name)
}
