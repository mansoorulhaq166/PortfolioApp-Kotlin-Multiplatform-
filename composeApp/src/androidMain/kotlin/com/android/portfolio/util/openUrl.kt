package com.android.portfolio.util

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

actual fun openUrl(context: Any, url: String) {
    val ctx = context as Context
    val intent = if (url.startsWith("mailto:")) {
        Intent(Intent.ACTION_SENDTO).apply {
            data = url.toUri()
        }
    } else {
        Intent(Intent.ACTION_VIEW, url.toUri())
    }

    ctx.startActivity(Intent.createChooser(intent, "Open with"))
}