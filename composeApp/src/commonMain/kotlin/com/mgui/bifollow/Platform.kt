package com.mgui.bifollow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform