# grid buidler
A layout builder for JavaFX's GridPane written for Kotlin.  See test folder for examples.

```kotlin
val hello = Text("Hello")
val world = Text("World")
val fromGridBuidler = Text("from grid builder")
val ex = Text("!!!")

val node = gridBuidler {
  +Blank(2,2) +hello +Break()
  +Span(world, 3) +Blank() +fromGridBuidler +Break()
  +ex
}
```
