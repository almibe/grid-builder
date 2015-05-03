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

        val children = node.getChildren()
        assertEquals(1, children.size())
        assertEquals(hello, children[0])
    }

    test fun addTwoTextNodeTest() {
        val hello = Text("Hello")
        val minkfx = Text("minkfx")
        val node = mink { +hello +minkfx }

        val children = node.getChildren()
        assertEquals(2, children.size())
        assertEquals(hello, children[0])
        assertEquals(minkfx, children[1])
    }

    test fun singleSpanTest() {
        val hello = Text("Hello")
        val node = mink { +Span(hello, 3) }

        assertEquals(3, GridPane.getColumnSpan(hello))
        assertEquals(1, node.getChildren().size())
    }

//    test fun nodeSpanTest() {
//        val hello = Text("Hello")
//        val world = Text("World")
//        val minkfx = Text("from minkfx")
//
//        val node = mink { +hello +span(world, 3) +minkfx }
//
//        val children = node.getChildren()
//        assertEquals(3, children.size())
//        assertEquals(3, GridPane.getColumnSpan(world))
//    }
}
