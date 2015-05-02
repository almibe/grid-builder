package org.libraryweasel.minkfx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.text.Text
import kotlin.test.assertNotNull
import org.junit.Test as test

class MinkTest {
    test fun emptyTest() {
        val node: Node = mink {}
        assertNotNull(node)
    }
}
