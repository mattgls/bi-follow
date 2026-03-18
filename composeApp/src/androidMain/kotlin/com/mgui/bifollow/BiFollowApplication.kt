package com.mgui.bifollow

import android.app.Application
import com.google.firebase.FirebaseApp

class BiFollowApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
