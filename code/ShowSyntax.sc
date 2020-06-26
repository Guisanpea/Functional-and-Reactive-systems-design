import scala.util.chaining._
import $file.Show, Show._

implicit class ShowOps[A](value: A) {
  def show(implicit evidence: Show[A]): String =
    evidence.show(value)
}

List(1,2,3).show tap println // List(1, 2, 3)

