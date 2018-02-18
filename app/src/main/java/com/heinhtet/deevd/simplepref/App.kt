package com.heinhtet.deevd.simplepref

import android.app.Application
import com.heinhtet.deevd.p.P

/**
 * Created by heinhtet on 2/18/18.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        P.getInstance().init(this)
    }
}