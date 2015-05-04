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
        val single = Single(this)
        handleSingle(single)
        return single
    }

    fun MinkContainer.plus(node: Node) : MinkContainer {
        val single = Single(node)
        handleSingle(single)
        return single
    }

    fun MinkContainer.plus() : MinkContainer {
        if (this is Span) {
            handleSpan(this)
        }
        return this
    }

    fun MinkContainer.plus(minkContainer: MinkContainer) : MinkContainer {
        if (minkContainer is Span) {
            handleSpan(minkContainer)
        }
        return minkContainer
    }

    fun handleSingle(single: Single) {
        while (coords.contains(Coordinate(currentX, currentY))) {
            currentX++
        }
        pane.add(single.node, currentX, currentY)
        coords.add(Coordinate(currentX, currentY))
        currentX++
    }

    fun handleSpan(span: Span) {
        pane.add(span.node, currentX, currentY, span.columns, span.rows)
        coords.addAll(parametersToCoordinates(currentX, currentY, span.columns, span.rows))
        currentX++
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