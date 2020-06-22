val prependGreeting: String => String = name => s"Greetings $name!"
val capitalize: String => String = _.capitalize

val greetCapitalized: String => String = capitalize andThen prependGreeting
