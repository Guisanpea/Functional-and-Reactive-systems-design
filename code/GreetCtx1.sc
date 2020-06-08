var name = "Santi"

def greet() = s"Greeetings $name !"
def greetReversed(): Unit = {
  name = name.reverse
}

greetReversed()
println(
  greet()
)
