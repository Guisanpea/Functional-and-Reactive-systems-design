import scala.util.chaining._

var name = "Foo"

def greet() = s"Greeetings $name!"
def greetReversed(): Unit = {
  name = name.reverse
}

def greetOther(whom: String): Unit = {
  name = whom
}

greetReversed()
greetOther("Bar")

greet() pipe println // Greeetings Bar!
