package dev.sangain.library

import android.app.Application
import dev.sangain.library.internal.ConnectivityObserveImpl
import dev.sangain.library.internal.ConnectivityObserver
import dev.sangain.library.model.Status
import kotlinx.coroutines.flow.Flow

public object SanGainConnectify {
    private  lateinit var connectivityObserver: ConnectivityObserver
    public val observer: Flow<Status> by lazy { connectivityObserver.observe() }

    internal fun initObserver(application: Application) {
        connectivityObserver = ConnectivityObserveImpl(application)
    }
}


