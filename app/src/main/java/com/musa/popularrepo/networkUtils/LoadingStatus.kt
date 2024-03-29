package com.musa.popularrepo.networkUtils

sealed class LoadingStatus {
    object Success : LoadingStatus()
    class  Loading(val message:String) : LoadingStatus()
    data class Error(val errorCode :String? , val errorMessage : String?) : LoadingStatus()

    override fun toString(): String {
        return when(this){
            is Success -> "SUCCESS"
            is Loading -> "Loading[$message]"
            is Error -> "Error [$errorCode : $errorMessage]"
        }
    }
}