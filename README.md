# minkfx
A layout builder for JavaFX's GridPane written for Kotlin.  See test folder for examples.

```kotlin
val hello = Text("Hello")
val world = Text("World")
val minkfx = Text("from minkfx")
val ex = Text("!!!")

val node = mink {
  +Blank(2,2) +hello +Break()
  +Span(world, 3) +Blank() +minkfx +Break()
  +ex
}
```
