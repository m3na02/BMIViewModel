package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// A ViewModel class for BMI calculation
class BMIViewModel: ViewModel() {

    // Variables to hold height and weight inputs by mutableStateOf
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    // Function to update the height input
    fun changeHeightInput(value: String){
        heightInput = value
        println("heightInput: $heightInput")
    }

    // Function to updatte the weight input
    fun changeWeightInput(value: String){
        weightInput = value
        println("weightInput: $weightInput")
    }

    // Function to calculate BMI and return the result
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