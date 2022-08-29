package dev.sangain.library.ext

import android.app.Application
import dev.sangain.library.SanGainConnectify

public fun Application.initSanGainConnectify(){
    SanGainConnectify.initObserver(this)
}
