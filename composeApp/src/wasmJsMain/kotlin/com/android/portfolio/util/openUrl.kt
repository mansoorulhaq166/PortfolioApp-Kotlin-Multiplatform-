package com.android.portfolio.util

import kotlinx.browser.window

actual fun openUrl(url: String) {
    window.open(url, "_blank")
}