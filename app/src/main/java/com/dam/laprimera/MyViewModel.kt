package com.dam.laprimera

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel(){

    /*
    var ronda by mutableStateOf(0)
    var isPlaying by mutableStateOf(false)
    var name by mutableStateOf("")

    fun sumarRonda(){
        if(isPlaying){
            ronda++
        }
    }

    fun start(){
        isPlaying = true
        ronda = 0
    }

    fun reset(){
        isPlaying = false
    }

    */

    private val TAG_LOG: String = "Mensaje ViewModel"

    var data by mutableStateOf(AppData())

    /*
    var _numbers = mutableStateOf(0)
    val numbers = mutableStateListOf<Int>()
    var counter = mutableStateOf(0)
    var name = mutableStateOf("")
     */

    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    fun crearRandom(){
        val randomNumber = (0..3).random()
        //numbers.add(randomNumber)
        data = data.copy(numbers = data.numbers + randomNumber)
        Log.d(TAG_LOG, "creamos random $randomNumber")
        /*
        for(numero in numbers){
            Log.d(TAG_LOG, "numeros aleatorios: $numero")
        }
        */
    }

    fun getNumero(): Int{
        //return _numbers.value
        return data.numbers.lastOrNull() ?: 0
    }

    fun getListaRandom(): List<Int>{
        //return numbers.toList()
        return data.numbers
    }

    fun contadorClic(){
        //counter.value++
        data = data.copy(counter = data.counter + 1)
    }

    fun getContador():Int{
        //return counter.value
        return data.counter
    }

    fun getTexto():String{
        //return name.value
        return data.name
    }

    fun setTexto(texto: String){
        data = data.copy(name = texto)
    }
}