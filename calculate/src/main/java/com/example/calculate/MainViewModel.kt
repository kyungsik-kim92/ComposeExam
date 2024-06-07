package com.example.calculate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _number1 = mutableStateOf("")
    val number1: State<String> = _number1

    private val _number2 = mutableStateOf("")
    val number2: State<String> = _number2

    private val _result = mutableStateOf("")
    val result: State<String> = _result

    fun onInput1Change(newInput: String) {
        _number1.value = newInput
    }

    fun onInput2Change(newInput: String) {
        _number2.value = newInput
    }

    fun calculate(operation: OperatorType) {
        val num1 = _number1.value.toIntOrNull()
        val num2 = _number2.value.toIntOrNull()

        if (num1 != null && num2 != null) {
            _result.value = when (operation) {
                OperatorType.PLUS -> (num1 + num2).toString()
                OperatorType.MINUS -> (num1 - num2).toString()
                OperatorType.MULTIPLY -> (num1 * num2).toString()
                OperatorType.DIVIDE -> if (num2 != 0) (num1 / num2).toString() else "Error"

            }
        } else {
            _result.value = "Invalid Input"
        }
    }


}

enum class OperatorType {
    PLUS, MINUS, MULTIPLY, DIVIDE
}