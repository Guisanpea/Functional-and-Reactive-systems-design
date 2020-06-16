var name = "Santi"

def greet() = s"Greeetings $name !"
def greetReversed(): Unit = {
  name = name.reverse
}

def greetOther(whom: String): Unit = {
  name = whom
}

greetReversed()
greetOther("Pepe")

println(
  greet()
)
