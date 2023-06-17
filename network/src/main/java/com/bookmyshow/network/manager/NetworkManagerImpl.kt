package com.bookmyshow.network.manager

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.IntRange

internal class NetworkManagerImpl constructor(
    private val context: Context
) : com.bookmyshow.core.NetworkManager {

    private val connectivityManager: ConnectivityManager?
        get() = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    override val isNetworkConnected: Boolean
        get() = getConnectionType() != 0

    @IntRange(from = 0, to = 3)
    private fun getConnectionType(): Int {
        return connectivityManager?.let {
            it.getNetworkCapabilities(it.activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> 2
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> 1
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> 3
                    else -> 0
                }
            }
        } ?: 0
    }
}