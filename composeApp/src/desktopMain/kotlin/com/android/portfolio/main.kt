package com.android.portfolio

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.android.portfolio.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Mansoor Android Portfolio",
    ) {
        val context = "Context"
        App(context)
    }
}