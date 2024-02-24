package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    fun changeHeightInput(value: String){
        heightInput = value
        println("heightInput: $heightInput")
    }

    fun changeWeightInput(value: String){
        weightInput = value
        println("weightInput: $weightInput")
    }

    fun result(): Any{
        return calculation()
    }

    private  fun calculation(): Any{
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toIntOrNull() ?: 0

        val bmi = if (weight > 0 && height > 0 ) weight / (height * height) else 0.0
        return bmi
    }
}