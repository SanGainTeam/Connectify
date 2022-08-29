package dev.sangain.library.internal

import android.util.Log

internal class UnInitializeSanGainLibraryException(msg:String):Exception(msg){
    init {
        Log.e("EXCEPTION!!!", "SanGainConnectivity didn't initialize. It might be happen when you forget to call initSanGainConnectify() function in your application class or setup your application class or your field name in manifest is empty")
    }
}
