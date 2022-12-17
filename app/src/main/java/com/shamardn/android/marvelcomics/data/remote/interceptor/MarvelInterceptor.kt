package com.shamardn.android.marvelcomics.data.remote.interceptor

import android.util.Log
import com.shamardn.android.marvelcomics.BuildConfig.API_KEY
import com.shamardn.android.marvelcomics.BuildConfig.PRIVATE_KEY
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject

class MarvelInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY)
            .addQueryParameter(HASH_QUERY, hash())
            .addQueryParameter(TS_QUERY, "1663167916755")
            .build()
        Log.i("wsh" , "hash = ${hash()}")
        return chain.proceed((chain.request().newBuilder().url(original).build()))
    }


    fun hash(): String{
//        val input = "$ts${PRIVATE_KEY}$API_KEY"
        val input = "1663167916755${PRIVATE_KEY}$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

    companion object{
        const val API_KEY_QUERY = "apikey"
        const val HASH_QUERY = "hash"
        const val TS_QUERY = "ts"
        val ts = Timestamp(System.currentTimeMillis()).time.toString()

//        const val PARAM_OFFSET = "offset"
//        const val PARAM_LIMIT = "limit"
//        const val PARAM_CHARACTER_ID = "characterId"
    }
}