package com.android.portfolio.util

import kotlinx.browser.window

actual fun openUrl(context: Any, url: String) {
    window.open(url, "_blank")
}