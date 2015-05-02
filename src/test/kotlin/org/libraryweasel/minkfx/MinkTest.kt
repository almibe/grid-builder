package org.libraryweasel.minkfx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.text.Text
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.Test as test

class MinkTest {
    test fun emptyTest() {
        val node: Node = mink {}
        assertNotNull(node)
    }

    test fun addSingleTextNodeTest() {
        val hello = Text("Hello minkfx")
        val node = mink { +hello }

        if (node is GridPane) {
            val children = node.getChildren()
            assertEquals(1, children.size())
            assertEquals(hello, children[0])
        } else {
            throw Exception("node isn't instance of GridPane")
        }
    }
}
