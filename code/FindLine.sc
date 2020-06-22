import java.nio.file.Paths

import $ivy.`org.typelevel::cats-effect:2.1.3`, cats.effect.{Blocker, ExitCode, IO, ContextShift}
import $ivy.`co.fs2::fs2-io:2.4.0`, fs2.io.file, fs2.text
import scala.concurrent.ExecutionContext

implicit val contextShift: ContextShift[IO] = IO.contextShift(ExecutionContext.global)

def findLine(filename: String, predicate: String => Boolean): IO[Option[String]] = {
  Blocker[IO].use { blocker =>
    file.readAll[IO](Paths.get(filename), blocker, 4096)
      .through(text.utf8Decode)
      .through(text.lines)
      .find(predicate)
      .compile
      .fold(Option.empty[String])((_, s) =>
        Option(s))
  }
}
