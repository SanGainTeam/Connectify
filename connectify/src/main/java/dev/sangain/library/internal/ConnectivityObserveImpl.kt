package dev.sangain.library.internal

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import dev.sangain.library.internal.ext.registerConnectivityObserver
import dev.sangain.library.model.Status
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

internal class ConnectivityObserveImpl(application: Application) : ConnectivityObserver {
    private val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observe(): Flow<Status> {
        return callbackFlow {
            val callback = object :ConnectivityManager.NetworkCallback(){
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch {
                        send(Status.Available)
                    }
                }

                override fun onLosing(network: Network, maxMsToLive: Int) {
                    super.onLosing(network, maxMsToLive)
                    launch {
                        send(Status.Losing)
                    }

                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch {
                        send(Status.Lost)
                    }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch {
                        send(Status.Unavailable)
                    }
                }
            }
           connectivityManager.registerConnectivityObserver(callback)
            awaitClose {
                Log.d("SangainTest","AwaitClose")
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }
}