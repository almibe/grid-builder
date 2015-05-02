package org.libraryweasel.minkfx.demo

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.FlowPane
import javafx.stage.Stage
import org.libraryweasel.minkfx.mink

public fun main(args: Array<String>) {
    Application.launch(javaClass<Demo>())
}

public class Demo() : Application() {
    override fun start(stage: Stage) {
        val scene = Scene(FlowPane(mink {}))
        stage.setScene(scene)
        stage.show()
    }
}