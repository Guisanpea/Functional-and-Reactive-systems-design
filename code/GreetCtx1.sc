import scala.util.chaining._

var name = "Foo"

def greet(): String = s"Greeetings $name!"
def greetReversed(): Unit = {
  name = name.reverse
}

greetReversed()
greet() tap println // Greeetings ooF!
