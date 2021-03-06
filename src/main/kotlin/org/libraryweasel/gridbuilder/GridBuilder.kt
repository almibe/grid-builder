package org.libraryweasel.gridbuilder

import javafx.scene.Node
import javafx.scene.layout.GridPane
import java.util.*

fun gridBuilder(init: GridBuilder.() -> Unit) : GridPane {
    val gridBuilder = GridBuilder()
    gridBuilder.init()
    return gridBuilder.pane
}

interface GridContainer
data class Span(val node: Node, val columns: Int = 1, val rows: Int = 1) : GridContainer
class Break() : GridContainer
data class Blank(val columns: Int = 1, val rows: Int = 1) : GridContainer
data class Coordinate(val x: Int, val y: Int)

class GridBuilder() {
    val pane = GridPane()
    private val coords = HashSet<Coordinate>()
    private var currentX = 0
    private var currentY = 0

    fun Node.plus() : Span {
        val single = Span(this)
        handleSpan(single)
        return single
    }

    fun GridContainer.plus(node: Node) : GridContainer {
        val single = Span(node)
        handleSpan(single)
        return single
    }

    fun GridContainer.plus() : GridContainer {
        handleContainer(this)
        return this
    }

    fun GridContainer.plus(gridContainer: GridContainer) : GridContainer {
        handleContainer(gridContainer)
        return gridContainer
    }

    fun handleContainer(gridContainer: GridContainer) {
        when (gridContainer) {
            is Span -> handleSpan(gridContainer)
            is Break -> handleBreak(gridContainer)
            is Blank -> handleBlank(gridContainer)
        }
    }

    fun handleSpan(span: Span) {
        while (!Collections.disjoint(coords, parametersToCoordinates(currentX, currentY, span.columns, span.rows))) {
            currentX++
        }
        pane.add(span.node, currentX, currentY, span.columns, span.rows)
        coords.addAll(parametersToCoordinates(currentX, currentY, span.columns, span.rows))
        currentX++
    }

    fun handleBreak(b: Break) {
        currentX = 0
        currentY++
    }

    fun handleBlank(blank: Blank) {
        while (!Collections.disjoint(coords, parametersToCoordinates(currentX, currentX, blank.columns, blank.rows))) {
            currentX++
        }
        coords.addAll(parametersToCoordinates(currentX, currentX, blank.columns, blank.rows))
    }
}

fun parametersToCoordinates(x: Int, y: Int, length: Int, height: Int) : List<Coordinate> {
    var xCnt = x
    val result = ArrayList<Coordinate>();
    while (xCnt < x + length) {
        var yCnt = y
        while (yCnt < y + height) {
            result.add(Coordinate(xCnt, yCnt))
            yCnt++
        }
        xCnt++
    }
    return result
}