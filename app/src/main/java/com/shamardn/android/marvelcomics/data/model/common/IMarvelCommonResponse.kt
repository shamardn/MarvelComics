package com.shamardn.android.marvelcomics.data.model.common

interface IMarvelCommonResponse {
    fun isSuccess(): Boolean

    fun getErrorMessage(): String
}