package com.android.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform