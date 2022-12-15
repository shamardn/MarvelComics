package com.shamardn.android.marvelcomics.utils

import com.shamardn.android.marvelcomics.BuildConfig
import com.shamardn.android.marvelcomics.data.remote.interceptor.MarvelInterceptor
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val API_KEY_QUERY = "apikey"
    const val HASH_QUERY = "hash"
    const val TS_QUERY = "ts"
    val ts = Timestamp(System.currentTimeMillis()).time.toString()


    fun hash(): String{
        val input = "${MarvelInterceptor.ts}${BuildConfig.PRIVATE_KEY}${BuildConfig.API_KEY}"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

}