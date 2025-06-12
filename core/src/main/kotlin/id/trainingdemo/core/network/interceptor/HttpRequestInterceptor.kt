package id.trainingdemo.core.network.interceptor

import id.trainingdemo.core.util.UtilFunctions.logE
import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        logE("HttpRequestInterceptor : $request")
        return chain.proceed(request)
    }
}