import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

val futureByVariable = {
  val random = new Random(0L)
  val x: Future[Int] = Future(random.nextInt)
  for {
    a: Int <- x
    b: Int <- x
  } yield (a, b)
}

val futureByComposition = {
  val random = new Random(0L)
  for {
    a: Int <- Future(random.nextInt)
    b: Int <- Future(random.nextInt)
  } yield (a, b)
}

futureByVariable.onComplete(println) // Success((-1155484576,-1155484576))
futureByComposition.onComplete(println) // Success((-1155484576,-723955400))