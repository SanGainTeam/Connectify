package dev.sangain.connectify.library

import android.app.Application
import dev.sangain.library.ext.initSanGainConnectify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class BaseApplication:Application() {
    private val appScope = CoroutineScope(SupervisorJob()+Dispatchers.Default)
    override fun onCreate() {
        super.onCreate()
        appScope.launch {
/*
            initSanGainConnectify()
*/
        }
    }
}