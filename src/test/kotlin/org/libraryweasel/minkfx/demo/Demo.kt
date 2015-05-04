package org.libraryweasel.minkfx.demo

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.text.Text
import javafx.stage.Stage
import org.libraryweasel.minkfx.Span
import org.libraryweasel.minkfx.mink


public fun main(args: Array<String>) {
    Application.launch(javaClass<Demo>())
}

public class Demo() : Application() {
    override fun start(stage: Stage) {
        val text = Text("Hey")
        val input = TextField("Shorter")
        val input2 = TextField("Longer")
        val mink = mink { +text +input +Span(input2, 3) }
        val scene = Scene(FlowPane(mink))

        stage.setScene(scene)
        stage.show()
    }
}