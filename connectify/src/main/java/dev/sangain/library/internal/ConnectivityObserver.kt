package dev.sangain.library.internal

import dev.sangain.library.model.Status
import kotlinx.coroutines.flow.Flow


internal interface ConnectivityObserver {
    fun observe (): Flow<Status>
}