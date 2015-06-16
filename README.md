# grid builder
A layout builder for JavaFX's GridPane written for Kotlin.  See test folder for examples.

```kotlin
val hello = Text("Hello")
val world = Text("World")
val fromGridBuilder = Text("from grid builder")
val ex = Text("!!!")

val node = gridBuilder {
  +Blank(2,2) +hello +Break()
  +Span(world, 3) +Blank() +fromGridBuilder +Break()
  +ex
}
```
