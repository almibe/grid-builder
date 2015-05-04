package org.libraryweasel.minkfx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet

fun mink(init: MinkFx.() -> Unit) : GridPane {
    val minkFx = MinkFx()
    minkFx.init()
    return minkFx.pane
}

private trait MinkContainer
data class Single(val node: Node) : MinkContainer
data class Span(val node: Node, val columns: Int, val rows: Int = 1) : MinkContainer
data class Break() : MinkContainer
data class Blank(val columns: Int, val rows: Int = 1) : MinkContainer
data class Coordinate(val x: Int, val y: Int)

class MinkFx() {
    val pane = GridPane()
    private val coords = HashSet<Coordinate>()
    private var currentX = 0
    private var currentY = 0

    fun Node.plus() : Single {
        pane.add(this, currentX, currentY)
        coords.add(Coordinate(currentX, currentY))
        currentX++
        currentY++
        return Single(this)
    }

    fun MinkContainer.plus() : MinkContainer {
        if (this is Span) {
            pane.add(this.node, 3, 3, 3, 3)
        }
        return this
    }

    fun MinkContainer.plus(node: Node) : MinkContainer {
        pane.add(node, 1, 1)
        return Single(node)
    }

    fun MinkContainer.plus(minkContainer: MinkContainer) : MinkContainer {
        if (minkContainer is Span) {
            pane.add(minkContainer.node, currentX, currentY, minkContainer.columns, minkContainer.rows)
            coords.add(Coordinate(currentX, currentY))
            currentX++
            currentY++
        }
        return minkContainer
    }
}

fun parametersToCoordinates(x: Int, y: Int, length: Int, height: Int) : List<Coordinate> {
    var xCnt = x
    var yCnt = y
    val result = ArrayList<Coordinate>();
    while (xCnt < x + length) {
        yCnt = y
        while (yCnt < y + height) {
            result.add(Coordinate(xCnt, yCnt))
            yCnt++
        }
        xCnt++
    }
    return result
}