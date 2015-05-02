package org.libraryweasel.minkfx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import java.util.ArrayList
import java.util.HashMap

fun mink(init: MinkFx.() -> Unit): Node {
    val minkFx = MinkFx()
    minkFx.init()
    return minkFx.node
}

class MinkFx() {
    val node = GridPane()

    fun Node.plus() {
        node.add(this, 1, 1)
    }
}
