import $file.Monad, Monad._

implicit val optionMonadInstance: Monad[Option] = new Monad[Option] {
  def unit[A](a: => A): Option[A] = Some(a)

  override def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] = ma match {
    case Some(value) => f(value)
    case _ => None
  }
}