import $plugin.$ivy.`org.typelevel::kind-projector:0.10.3`
import $file.Monad, Monad._

implicit def eitherMonadInstance[Err]: Monad[Either[Err, *]] =
  new Monad[(Either[Err, *])] {
    override def unit[A](a: => A): Either[Err, A] = Right[Err, A](a)

    override def flatMap[A, B](ma: Either[Err, A])(f: A => Either[Err, B]): Either[Err, B] = ma match {
      case Right(value) => f(value)
      case Left(err) => Left[Err, B](err)
    }
  }