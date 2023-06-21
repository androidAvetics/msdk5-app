package com.example.myapplication

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        com.secneo.sdk.Helper.install(this)
    }
}
