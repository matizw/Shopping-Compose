package id.trainingdemo.core.util

import android.util.Log
import id.trainingdemo.core.BuildConfig
import java.util.Locale

object UtilFunctions {
    private val localeID = Locale("in", "ID")

    fun logE(message: String) {
        if (BuildConfig.DEBUG) Log.e("ERROR_IMO", message)
    }
}