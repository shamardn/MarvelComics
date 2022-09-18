package com.shamardn.android.marvelcomics.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val PRIVATE_KEY = "fdecd16813dea8c88451d0aa4cf91c7b42199bda"
    const val API_KEY = "129afb13b2c4375131e4c2554a4dc68b"
    val ts = Timestamp(System.currentTimeMillis()).time.toString()


    const val PARAM_OFFSET = "offset"
    const val PARAM_LIMIT = "limit"
    const val PARAM_CHARACTER_ID = "characterId"


    fun hash(): String{
        val input = "$ts$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }
}