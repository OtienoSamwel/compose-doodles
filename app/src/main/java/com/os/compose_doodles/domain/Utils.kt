package com.os.compose_doodles.domain

import android.annotation.SuppressLint
import android.app.Activity

object Utils {

    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(activity: Activity): Boolean {
        val connectivityManager =
            activity.getSystemService(Activity.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}