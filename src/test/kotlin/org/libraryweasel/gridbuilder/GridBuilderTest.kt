package org.libraryweasel.gridbuilder

import org.junit.Test as test

class GridBuilderTest {
//    test fun emptyTest() {
//        val node: Node = gridBuilder {}
//        assertNotNull(node)
//    }
//
//    test fun addSingleTextNodeTest() {
//        val hello = Text("Hello gridBuilder")
//        val node = gridBuilder { +hello }
//
//        val children = node.getChildren()
//        assertEquals(1, children.size())
//        assertEquals(hello, children[0])
//    }
//
//    test fun addTwoTextNodeTest() {
//        val hello = Text("Hello")
//        val gridBuilder = Text("gridBuilder")
//        val node = gridBuilder { +hello +gridBuilder }
//
//        val children = node.getChildren()
//        assertEquals(2, children.size())
//        assertEquals(hello, children[0])
//        assertEquals(gridBuilder, children[1])
//    }
//
//    test fun singleSpanTest() {
//        val hello = Text("Hello")
//        val node = gridBuilder { +Span(hello, 3) }
//
//        assertEquals(3, GridPane.getColumnSpan(hello))
//        assertEquals(1, node.getChildren().size())
//    }
//
//    test fun parametersToCoordinatesTest() {
//        val result = parametersToCoordinates(3,4,5,7)
//
//        assertEquals(35, result.size())
//        assert(result.containsAll(listOf(Coordinate(3,4))));
//    }
//
//    test fun positionSpanTest() {
//        val hello = Text("Hello")
//        val world = Text("World")
//        val gridBuilder = Text("from gridBuilder")
//
//        val node = gridBuilder { +hello +Span(world, 3) +gridBuilder }
//
//        assertEquals(3, node.getChildren().size())
//        assertEquals(3, GridPane.getColumnSpan(world))
//        assertEquals(0, GridPane.getColumnIndex(hello))
//        assertEquals(1, GridPane.getColumnIndex(world))
//        assertEquals(4, GridPane.getColumnIndex(gridBuilder))
//    }
//
//    test fun breakTest() {
//        val hello = Text("Hello")
//        val world = Text("World")
//        val gridBuilder = Text("from gridBuilder")
//
//        val node = gridBuilder {
//            +hello +Break()
//            +Span(world, 3) +gridBuilder
//        }
//
//        assertEquals(3, node.getChildren().size())
//
//        assertEquals(0, GridPane.getColumnIndex(hello))
//        assertEquals(0, GridPane.getRowIndex(hello))
//
//        assertEquals(0, GridPane.getColumnIndex(world))
//        assertEquals(1, GridPane.getRowIndex(world))
//
//        assertEquals(3, GridPane.getColumnIndex(gridBuilder))
//        assertEquals(1, GridPane.getRowIndex(gridBuilder))
//    }
//
//    test fun blankTest() {
//        val hello = Text("Hello")
//        val world = Text("World")
//        val gridBuilder = Text("from gridBuilder")
//        val ex = Text("!!!")
//
//        val node = gridBuilder {
//            +Blank(2,2) +hello +Break()
//            +Span(world, 3) +Blank() +gridBuilder +Break()
//            +ex
//        }
//
//        assertEquals(4, node.getChildren().size())
//
//        assertEquals(2, GridPane.getColumnIndex(hello))
//        assertEquals(0, GridPane.getRowIndex(hello))
//
//        assertEquals(2, GridPane.getColumnIndex(world))
//        assertEquals(1, GridPane.getRowIndex(world))
//
//        assertEquals(5, GridPane.getColumnIndex(gridBuilder))
//        assertEquals(1, GridPane.getRowIndex(gridBuilder))
//
//        assertEquals(0, GridPane.getColumnIndex(ex))
//        assertEquals(2, GridPane.getRowIndex(ex))
//    }
//
//    test fun overlapTest() {
//        val hello = Text("Hello")
//        val world = Text("World")
//
//        val node = gridBuilder {
//            +Blank() +Span(hello, 2, 2) +Break()
//            +Span(world, 2, 2)
//        }
//
//        assertEquals(2, node.getChildren().size())
//
//        assertEquals(1, GridPane.getColumnIndex(hello))
//        assertEquals(0, GridPane.getRowIndex(hello))
//
//        assertEquals(3, GridPane.getColumnIndex(world))
//        assertEquals(1, GridPane.getRowIndex(world))
//    }
//
//    test fun spanRowTest() {
//
//    }
//
//    test fun spanColumnTest() {
//
//    }
}
