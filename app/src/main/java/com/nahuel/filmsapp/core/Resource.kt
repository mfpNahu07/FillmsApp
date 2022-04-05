package com.nahuel.filmsapp.core

import java.lang.Exception

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()                                 //estado de carga
    data class Success<out T>(val data: T) : Resource<T>()               //estado de èxito
    data class Failure(val exception: Exception) : Resource<Nothing>()   //estado de falla

}


/**
 * Para retornar estados podemos utilizar sealed classes
 */