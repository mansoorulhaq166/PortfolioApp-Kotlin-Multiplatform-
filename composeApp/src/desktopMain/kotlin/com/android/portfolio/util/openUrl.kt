package com.android.portfolio.util

import java.awt.Desktop
import java.net.URI

actual fun openUrl(url: String) {
    try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(URI(url))
        } else {
            println("Desktop not supported. Cannot open URL: $url")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}