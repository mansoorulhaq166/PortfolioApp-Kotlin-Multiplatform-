package com.android.portfolio.util

actual fun openUrl(url: String) {
    // Intentionally left empty, should not be called directly on Android non-Compose context
    error("Call openUrlComposable() from a Composable context on Android")
}