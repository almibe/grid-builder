package org.libraryweasel.minkfx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import java.util.ArrayList
import java.util.HashMap

fun mink(init: MinkFx.() -> Unit): Node {
    val minkFx = MinkFx()
    minkFx.init()
    return minkFx.pane
}

class MinkFx() {
    val pane = GridPane()

    fun Node.plus(): Node {
        pane.add(this, 1, 1)
        return this
    }

    fun Node.plus(node: Node) {
        pane.add(node, 1, 2)
    }
}
