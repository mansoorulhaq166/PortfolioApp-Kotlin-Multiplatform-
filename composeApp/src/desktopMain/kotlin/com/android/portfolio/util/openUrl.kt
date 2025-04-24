package com.android.portfolio.util

import java.awt.Desktop
import java.net.URI

actual fun openUrl(context: Any, url: String) {
    try {
        val uri = if (url.startsWith("mailto:", ignoreCase = true)) {
            URI(url)
        } else {
            URI.create(url)
        }

        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri)
            } else if (desktop.isSupported(Desktop.Action.MAIL) && url.startsWith("mailto:", ignoreCase = true)) {
                desktop.mail(uri)
            } else {
                println("Desktop doesn't support browsing or mailing: $url")
            }
        } else {
            println("Desktop not supported. Cannot open URL: $url")
        }
    } catch (e: Exception) {
        println("Failed to open URL: $url")
        e.printStackTrace()
    }
}