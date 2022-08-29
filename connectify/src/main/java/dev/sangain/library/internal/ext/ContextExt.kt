package dev.sangain.library.internal.ext

import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build

internal fun ConnectivityManager.createNetworkRequest(): NetworkRequest = NetworkRequest.Builder()
    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
    .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
    .build()


internal fun ConnectivityManager.registerConnectivityObserver(callback:NetworkCallback){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.registerDefaultNetworkCallback(callback)
    }else{
        this.requestNetwork(this.createNetworkRequest(),callback)
    }
}




