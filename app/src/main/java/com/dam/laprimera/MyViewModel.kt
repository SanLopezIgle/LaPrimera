package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel(){
    private val TAG_LOG: String = "Mensaje ViewModel"
    var _numbers = mutableStateOf(0)
    val numbers = mutableStateListOf<Int>()
    var counter = mutableStateOf(0)
    var name = mutableStateOf("")

    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    fun crearRandom(){
        val randomNumber = (0..3).random()
        numbers.add(randomNumber)
        Log.d(TAG_LOG, "creamos random $randomNumber")

        for(numero in numbers){
            Log.d(TAG_LOG, "numeros aleatorios: $numero")
        }
    }

    fun getNumero(): Int{
        return _numbers.value
    }

    fun getListaRandom(): List<Int>{
        return numbers.toList()
    }

    fun contadorClic(){
        counter.value++
    }

    fun getContador():Int{
        return counter.value
    }

    fun getTexto():String{
        return name.value
    }
}