import $plugin.$ivy.`org.typelevel::kind-projector:0.10.3`
import $file.Monad, Monad._

case class State[S, +A](run: S => (A, S))

object State {
  def unit[S, A](a: A): State[S, A] =
    State(s => (a, s))
}

implicit def stateMonadInstance[S]: Monad[State[S, *]] =
  new Monad[(State[S, *])] {
    override def unit[A](a: => A): State[S, A] = State(s => (a, s))

    override def flatMap[A, B](ma: State[S, A])(f: A => State[S, B]): State[S, B] =
      State(s => {
        val (a, s1) = ma.run(s)
        f(a).run(s1)
      })
  }